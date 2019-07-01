package fehead.im.stage;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fehead.im.audio.GdxMusic;
import fehead.im.audio.Music;
import fehead.im.song.Song;
import fehead.im.song.SongMgr;
import fehead.im.song.StepKsf;

public class NormalStage implements IStage, InputProcessor {
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
	private	long	plaingPosition;
	private	long	tick;
	private	Double	bpm;
	private	Double	stepGapTime;	//  1step time(ms)
	
	public NormalStage(SpriteBatch batch, Stages stages) {
		this.batch = batch;
		this.stages = stages;
		
		backArrows = new ArrayList<>(2);
		backArrows.add(new Texture("images/arrow1.png"));
		backArrows.add(new Texture("images/arrow2.png"));
		stepArrows = new Texture("images/arrow.png");
		gaugeWaku = new Texture("images/gaugewaku.png");
		gauge = new Texture("images/gauge.png");
	}

	@Override
	public void getIn() {
		song = SongMgr.getInstace().getSelectedSong();
		stepKsf = song.getStepList().get(0);
		startPosition = stepKsf.getStart()[0];
		tick = stepKsf.getTick();
		bpm = new Double(stepKsf.getBpm()[0]);
		stepGapTime = 60000.0/(bpm * tick);
		bgm = GdxMusic.of(song.getPlayMp3Path().getAbsolutePath());
		
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
		
		drawGauge();
	}

	private void think() {
		plaingPosition = Math.max(bgm.getPosition() - startPosition, 0);
	}
	
	void drawBackGround() {
		batch.draw(titleImg, 0, 0);
	}
	
	// 화살표 백패널를 그린다.
	void drawBackArrow() {
		// 백패널의 반짝임을 계산 각 tick 마다 60ms시간만끔 반짝임을 준다.
		Double oneSecound = bpm*tick;
	    long tmp = plaingPosition % oneSecound.longValue();
	    if( 0 < tmp && tmp < 60 ) {
			batch.draw(backArrows.get(1), 32, 370);
			batch.draw(backArrows.get(1), 352, 370);
	    }
	    else {
			batch.draw(backArrows.get(0), 32, 370);
			batch.draw(backArrows.get(0), 352, 370);
	    }
	}
	

	/// 판정관련 데이터를 화면에 뿌린다.
	void drawGauge() {
		batch.draw(gaugeWaku, 32, 430);
		batch.draw(gaugeWaku, 352, 430);
		batch.draw(gauge, 268, 440);
		batch.draw(gauge, 352, 440);
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
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
		stages.setStage("selectStage");
	}

	@Override
	public void gotoNextStage() {
		stages.setStage("resultStage");
	}

}
