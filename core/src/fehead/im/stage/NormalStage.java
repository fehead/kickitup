package fehead.im.stage;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fehead.im.audio.GdxMusic;
import fehead.im.audio.Music;
import fehead.im.effect.FrameAnimation;
import fehead.im.song.Song;
import fehead.im.song.SongMgr;
import fehead.im.song.StepKsf;
import lombok.Getter;
import lombok.extern.java.Log;

enum EButton {
	// 1	7	5	9	3
	// 25, 75, 125, 175, 225
	KEY1(1, 27, 4, 80),
	KEY3(3, 227, 3, 80),
	KEY5(5, 127, 2, 80),
	KEY7(7, 77, 0, 80),
	KEY9(9, 177, 1, 80);
	
	@Getter
	private	int	key;	// keyboard key (1 3 5 7 9)
	@Getter
	private	int	x;		// pushStepArrow(parrow.png, carrow.png)start x
	@Getter
	private	int	stepArrowIdx;	// stepArrow arrow.png
	@Getter
	private	int	stepArrowWith;	// stepArrow arrow.png width
	
	EButton(int key, int x) {
		this(key, x, 0, 0);
	}
	
	EButton(int key, int x, int stepArrowIdx, int stepArrowWith) {
		this.key = key;
		this.x = x;
		this.stepArrowIdx = stepArrowIdx;
		this.stepArrowWith = stepArrowWith;
		
	}
	
	String getPushFileName() {
		return "images/parrow" + key + ".png";
	}
	
	String getCrashFileName() {
		return "images/carrow" + key + ".png";
	}
}

@Log
public class NormalStage implements IStage, InputProcessor {
	static final int    BACK_ARROW_Y    = 55;
	private	SpriteBatch batch;
	private	Stages stages;
	private	Music	bgm;
	private	Song	song;
	private Texture titleImg;
	private List<Texture> backArrows;
	private	Texture	stepArrows;
	private	Texture	gaugeWaku;
	private	Texture	gauge;
	private	StepKsf	stepKsf;
	private	long	startPosition;		// ksf start[0]
	private	Long	plaingPosition;
	private	long	tick;
	private	Double	bpm;
	private	Double	stepGapTime;	//  1step time(ms)
	private	EnumMap<EButton, FrameAnimation>	aniPushArrows;
	private	EnumMap<EButton, FrameAnimation>	aniCrashArrows;
	private	EnumMap<EButton, FrameAnimation>	aniStepArraws;
	
	private	int[]	start;
	private	Double	detailStepIdx;
	private	Integer	stepIdx;
	private	Double	stepSpeed = 1.0; // 1x, 2x, 4x
	private	Double	distancePerStep; // distance(pixel) per one step.
	private	int 	addedStep; // The number of steps that the Step Arrow is added to the screen.
	private	int		y;	// Y reference value.

	public NormalStage(SpriteBatch batch, Stages stages) {
		this.batch = batch;
		this.stages = stages;
		
		backArrows = new ArrayList<>(2);
		backArrows.add(new Texture("images/arrow1.png"));
		backArrows.add(new Texture("images/arrow2.png"));
		stepArrows = new Texture("images/arrow.png");
		gaugeWaku = new Texture("images/gaugewaku.png");
		gauge = new Texture("images/gauge.png");
		stepArrows = new Texture("images/arrow.png");
		
		aniPushArrows = new EnumMap<>(EButton.class);
		aniCrashArrows = new EnumMap<>(EButton.class);
		aniStepArraws = new EnumMap<>(EButton.class);
		for(EButton b : EButton.values()) {
			FrameAnimation aniPushArrow = FrameAnimation.of(new Texture(b.getPushFileName()), 72, 70);
			aniPushArrow.setPosition(b.getX(), 480-45-70);
			aniPushArrow.setMaxFrame(9);
			aniPushArrow.setCurrentFrame(9);
			aniPushArrow.setFrameRate(30);
			aniPushArrows.put(b, aniPushArrow);

			FrameAnimation aniCrashArrow = FrameAnimation.of(new Texture(b.getCrashFileName()), 80, 80);
			aniCrashArrow.setPosition(b.getX()-2, 480-43-80);
			aniCrashArrow.setMaxFrame(9);
			aniCrashArrow.setCurrentFrame(9);
			aniCrashArrow.setFrameRate(30);
			aniCrashArrows.put(b, aniCrashArrow);
			
			// TODO: fixit.
			FrameAnimation aniStepArrow = FrameAnimation.of(stepArrows, 60, 60);
			aniStepArrow.setPosition(b.getX(), -80);
			aniStepArrow.setY(b.getStepArrowIdx() * 60);
			aniStepArrow.setMaxFrame(6);
			aniStepArrow.setCurrentFrame(0);
			aniStepArrow.setFrameRate(100);
			aniStepArrow.setLoop(true);
			aniStepArraws.put(b, aniStepArrow);
		}
		
	}

	@Override
	public void getIn() {
		song = SongMgr.getInstace().getSelectedSong();
		stepKsf = song.getStepList().get(0);
		startPosition = stepKsf.getStart()[0];
		tick = stepKsf.getTick();
		start = stepKsf.getStart();
		bpm = new Double(stepKsf.getBpm()[0]);
		stepGapTime = 60000.0/(bpm * tick);
		bgm = GdxMusic.of(song.getPlayMp3Path().getAbsolutePath());
		distancePerStep = BACK_ARROW_Y * stepSpeed; 
		
		Gdx.input.setInputProcessor(this);
		
		titleImg = new Texture(song.getTitleImgPath().getAbsolutePath());
		bgm.play();
	}

	@Override
	public void getOut() {
		bgm.stop();
	}
	
	@Override
	public void render() {
		think();
		
		drawBackGround();
		drawBackArrow();	
		
		drawPushArraw();
		drawStepArrow();

		drawGauge();
	}

	private void drawPushArraw() {
		for (FrameAnimation f : aniPushArrows.values()) {
			if (!f.isEnd())
				f.draw(batch);
		}

		for (FrameAnimation f : aniCrashArrows.values()) {
			if (!f.isEnd())
				f.draw(batch);
		}
		
		for (FrameAnimation f : aniStepArraws.values()) {
			if (!f.isEnd())
				f.draw(batch);
		}
	}

	private void think() {
		plaingPosition = Math.max(bgm.getPosition() - startPosition, 0);
		detailStepIdx = getIndexByTime(plaingPosition);
		stepIdx = detailStepIdx.intValue() + 1;
		
	   // 기준 y값 - back arrow 위에서 끝이 나게 되어있다.
	    y = (int)(BACK_ARROW_Y + (stepIdx.doubleValue() - detailStepIdx) * distancePerStep );
	    
	    // 화면 전체에 출력하기 위해 추가되는 Step개수만큼 화면에서 빼준다.
	    y -= (BACK_ARROW_Y * addedStep * stepSpeed);
	}
	
	void drawBackGround() {
		batch.draw(titleImg, 0, 0);
	}
	
	// 화살표 백패널를 그린다.
	void drawBackArrow() {
		// 백패널의 반짝임을 계산 각 tick 마다 60ms시간만끔 반짝임을 준다.
		Double oneSecound = bpm * tick;
		long tmp = plaingPosition % oneSecound.longValue();
		Texture backArrow;
		if (0 <= tmp && tmp <= 60)
			backArrow = backArrows.get(1);
		else
			backArrow = backArrows.get(0);

		batch.draw(backArrow, 32, 370);
		batch.draw(backArrow, 352, 370);
	}

	void drawStepArrow() {
	    int stepIndex = stepIdx - addedStep;
		for( Integer i = 0 ;  i < 48 ; ++i ) {
	        final int arrowX[] = { 30, 80, 132, 185, 235};

	        if( stepKsf.isEndStep( i + stepIndex ) )
	            break;

	        String stepData = stepKsf.getStep(i + stepIndex);
//	        if( i == 0 && stepData.charAt(0) == '2' )
//	            SetQuitStage( true );

	        
	        for (EButton key : aniStepArraws.keySet()) {
			    if( stepData.charAt(key.getKey()) == '1' ) {
			    	FrameAnimation f = aniStepArraws.get(key);
			    	// f.setCurrentFrame(0);
			    	f.setPosition(key.getX(), 480 - (i.floatValue() * distancePerStep.floatValue()));
			    	f.draw(batch);
			    }
	        }
		}
	}
	
	/// 판정관련 데이터를 화면에 뿌린다.
	void drawGauge() {
		batch.draw(gaugeWaku, 32, 430);
		batch.draw(gaugeWaku, 352, 430);
		batch.draw(gauge, 268, 440);
		batch.draw(gauge, 352, 440);
	}

	// plaing time to index
	Double getIndexByTime(Long playTime) {
		if (playTime.compareTo(0L) <= 0)
			return 0.0;
		return playTime.doubleValue() / stepGapTime;
	}

	// index to plaingPosition
	Long getTimeByIndex(int stepIndex) {
		if (plaingPosition.compareTo(0L) <= 0)
			return 0L;
		return (long) (stepIndex * stepGapTime);
	}

	
	@Override
	public boolean keyDown(int keycode) {
		switch(keycode) {
		case Input.Keys.Z:
			aniPushArrows.get(EButton.KEY1).setCurrentFrame(0);
			aniCrashArrows.get(EButton.KEY1).setCurrentFrame(0);
			aniStepArraws.get(EButton.KEY1).setCurrentFrame(0);
			break;
		case Input.Keys.C:
			aniPushArrows.get(EButton.KEY3).setCurrentFrame(0);
			aniCrashArrows.get(EButton.KEY3).setCurrentFrame(0);
			break;
		case Input.Keys.S:
			aniPushArrows.get(EButton.KEY5).setCurrentFrame(0);
			aniCrashArrows.get(EButton.KEY5).setCurrentFrame(0);
			break;
		case Input.Keys.Q:
			aniPushArrows.get(EButton.KEY7).setCurrentFrame(0);
			aniCrashArrows.get(EButton.KEY7).setCurrentFrame(0);
			break;
		case Input.Keys.E:
			aniPushArrows.get(EButton.KEY9).setCurrentFrame(0);
			aniCrashArrows.get(EButton.KEY9).setCurrentFrame(0);
			break;
			
		case Input.Keys.ESCAPE:
			gotoPrevStage();
			break;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void gotoPrevStage() {
		stages.setStage("select");
	}

	@Override
	public void gotoNextStage() {
		// stages.setStage("resultStage");
	}

}
