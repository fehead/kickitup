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
import lombok.extern.java.Log;



@Log
public class NormalStage implements IStage, InputProcessor {
	static final Double    BACK_ARROW_Y    = 55.0;
	static final Integer    SCREEN_HEIGHT	= 480;
	
	private	long	startPosition;		// ksf start[0]
	private	int 	addedStep; // The number of steps that the Step Arrow is added to the screen.
	private	int		y;	// Y reference value.
	private	long	tick;
	private	int[]	start;

	private	Long	plaingPosition;
	private	Double	bpm;
	private	Double	stepGapTime;	//  1step time(ms)
	private	Double	detailStepIdx;
	private	Integer	stepIdx;
	private	Double	stepSpeed = 1.0; // 1x, 2x, 4x
	private	Double	distancePerStep; // distance(pixel) per one step.
	private	Long	oldTime;

	private	Music	bgm;
	private	Song	song;
	private	StepKsf	stepKsf;
	private	Stages stages;

	private	SpriteBatch batch;
	private Texture titleImg;
	private	Texture	stepArrows;
	private	Texture	gaugeWaku;
	private	Texture	gauge;
	private	Texture	smallFont;

	private List<Texture> backArrows = new ArrayList<>(2);
	private	EnumMap<EButton, FrameAnimation>	aniPushArrows = new EnumMap<>(EButton.class);
	private	EnumMap<EButton, FrameAnimation>	aniCrashArrows = new EnumMap<>(EButton.class);
	private	EnumMap<EButton, FrameAnimation>	aniStepArraws = new EnumMap<>(EButton.class);

	public NormalStage(SpriteBatch batch, Stages stages) {
		this.batch = batch;
		this.stages = stages;
		
		backArrows.add(new Texture("images/arrow1.png"));
		backArrows.add(new Texture("images/arrow2.png"));
		stepArrows = new Texture("images/arrow.png");
		gaugeWaku = new Texture("images/gaugewaku.png");
		gauge = new Texture("images/gauge.png");
		stepArrows = new Texture("images/arrow.png");
		smallFont = new Texture("images/sfont.png");
		
		for(EButton b : EButton.values()) {
			final Integer	PUSH_ARROW_WIDTH = 72;
			final Integer	PUSH_ARROW_HEIGHT = 70;
			final Integer	PUSH_ARROW_POSITION_Y = SCREEN_HEIGHT - PUSH_ARROW_HEIGHT -45;
			final Integer	PUSH_ARROW_FRAME_CNT = 9;
			final Integer	ARROW_FRAME_RATE = 30;
			FrameAnimation aniPushArrow = FrameAnimation.of(new Texture(b.getPushFileName()), PUSH_ARROW_WIDTH, PUSH_ARROW_HEIGHT);
			aniPushArrow.setPosition(b.getX(), PUSH_ARROW_POSITION_Y);
			aniPushArrow.setMaxFrame(PUSH_ARROW_FRAME_CNT);
			aniPushArrow.setCurrentFrame(PUSH_ARROW_FRAME_CNT);
			aniPushArrow.setFrameRate(ARROW_FRAME_RATE);
			aniPushArrows.put(b, aniPushArrow);

			final Integer	CRASH_ARROW_WIDTH = 80;
			final Integer	CRASH_ARROW_HEIGHT = 80;
			final Integer	CRASH_ARROW_POSITION_Y = SCREEN_HEIGHT - CRASH_ARROW_HEIGHT - 43;
			final Integer	CRASH_ARROW_FRAME_CNT = 9;
			
			FrameAnimation aniCrashArrow = FrameAnimation.of(new Texture(b.getCrashFileName()), CRASH_ARROW_WIDTH, CRASH_ARROW_HEIGHT);
			aniCrashArrow.setPosition(b.getX()-2, CRASH_ARROW_POSITION_Y);
			aniCrashArrow.setMaxFrame(CRASH_ARROW_FRAME_CNT);
			aniCrashArrow.setCurrentFrame(CRASH_ARROW_FRAME_CNT);
			aniCrashArrow.setFrameRate(ARROW_FRAME_RATE);
			aniCrashArrows.put(b, aniCrashArrow);

			final Integer	STEP_ARROW_WIDTH = 60;
			final Integer	STEP_ARROW_HEIGHT = 60;
			final Integer	STEP_ARROW_POSITION_Y = -80;
			final Integer	STEP_ARROW_FRAME_CNT = 6;
			final Integer	STEP_ARROW_FRAME_RATE = 100;
			FrameAnimation aniStepArrow = FrameAnimation.of(stepArrows, STEP_ARROW_WIDTH, STEP_ARROW_HEIGHT);
			aniStepArrow.setPosition(b.getX(), STEP_ARROW_POSITION_Y);
			aniStepArrow.setY(b.getStepArrowIdx() * STEP_ARROW_HEIGHT);
			aniStepArrow.setMaxFrame(STEP_ARROW_FRAME_CNT);
			aniStepArrow.setCurrentFrame(0);
			aniStepArrow.setFrameRate(STEP_ARROW_FRAME_RATE);
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

		// 추가되는 step개수는 가려서 잘 보이지 않는 스탭개수에서부터 스탭 백패널 까지의 개수이다. -60 ~ 55pixel 위치까지 step개수.
	    addedStep = (int)((60.0 + BACK_ARROW_Y) / distancePerStep);

	    Gdx.input.setInputProcessor(this);
		
		titleImg = new Texture(song.getTitleImgPath().getAbsolutePath());
		
		oldTime = System.currentTimeMillis();
		bgm.play();
	}

	@Override
	public void getOut() {
		log.info("getPosition : " + bgm.getPosition());
		bgm.stop();
		titleImg.dispose();
	}
	
	@Override
	public void render() {
		drawBackGround();
		drawBackArrow();	
		
		drawPushArraw();
		drawStepArrow();

		drawGauge();
		
		long curTime = System.currentTimeMillis() - oldTime;
		displayMessage(0, 463, String.format("S:%6d M:%5d DIFF:%5d", curTime, bgm.getPosition()
				, curTime - bgm.getPosition()));
	}

	private void drawPushArraw() {
		aniPushArrows.values().stream()
			.filter(f -> !f.isEnd())
			.forEach(f -> f.draw(batch));

		aniCrashArrows.values().stream()
			.filter(f -> !f.isEnd())
			.forEach(f -> f.draw(batch));
			
		aniStepArraws.values().stream()
			.filter(f -> !f.isEnd())
			.forEach(f -> f.draw(batch));
	}

	@Override
	public void think() {
		plaingPosition = Math.max(bgm.getPosition() - startPosition, 0);
		detailStepIdx = getIndexByTime(plaingPosition);
		stepIdx = detailStepIdx.intValue() + 1;
		
	   // 기준 y값 - back arrow 위에서 끝이 나게 되어있다.
	    y = (int)(BACK_ARROW_Y + (stepIdx.doubleValue() - detailStepIdx) * distancePerStep );
	    
	    // 화면 전체에 출력하기 위해 추가되는 Step개수만큼 화면에서 빼준다.
	    y -= (BACK_ARROW_Y * addedStep * stepSpeed);
	    
		if (!bgm.isPlaying())
			gotoPrevStage();
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
	        if(i + stepIndex < 0)
	        	continue;

	        if( stepKsf.isEndStep( i + stepIndex ) )
	            break;

	        String stepData = stepKsf.getStep(i + stepIndex);
//	        if( i == 0 && stepData.charAt(0) == '2' )
//	            SetQuitStage( true );
	        
			for (EButton key : aniStepArraws.keySet()) {
				if (stepData.charAt(key.getKsfIdx()) == '1') {
					FrameAnimation f = aniStepArraws.get(key);

					final int stepArrowX[] = { 30, 80, 132, 185, 235};
					Double y1 = SCREEN_HEIGHT - 60 - (distancePerStep * i + y);
					f.setPosition(stepArrowX[key.getKsfIdx()], y1.floatValue());
					f.draw(batch);
				}
			}
		}
	}
	
	/// 판정관련 데이터를 화면에 뿌린다.
	void drawGauge() {
		final int	GAUGEWAKU_1P_X = 32;
		final int	GAUGEWAKU_1P_Y = 430;
		final int	GAUGEWAKU_2P_X = 352;
		final int	GAUGEWAKU_2P_Y = 430;
		final int	GAUGE_1P_X = 268;
		final int	GAUGE_1P_Y = 440;
		final int	GAUGE_2P_X = 252;
		final int	GAUGE_2P_Y = 440;
		batch.draw(gaugeWaku, GAUGEWAKU_1P_X, GAUGEWAKU_1P_Y);
		batch.draw(gaugeWaku, GAUGEWAKU_2P_X, GAUGEWAKU_2P_Y);
		batch.draw(gauge, GAUGE_1P_X, GAUGE_1P_Y);
		batch.draw(gauge, GAUGE_2P_X, GAUGE_2P_Y);
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

	private void displayMessage(int x, int y, String msg) {
		final int FONT_WIDTH = 8;
		final int FONT_HEIGHT = 16;

		String upppercaseMsg = msg.toUpperCase();
		for (int i = 0; i < upppercaseMsg.length(); ++i) {
			int fontIndex = upppercaseMsg.charAt(i) - ' ';
			batch.draw(smallFont, x + i * FONT_WIDTH, y, FONT_WIDTH * fontIndex, 0, FONT_WIDTH, FONT_HEIGHT);
		}
	}
}
