package fehead.im.stage;

import java.util.EnumMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fehead.im.audio.Sound;
import fehead.im.audio.SoundMgr;
import fehead.im.effect.BlinkAnimation;
import fehead.im.effect.BlinkBase;
import fehead.im.effect.ZoomAnimation;
import fehead.im.graphics.Dim;
import fehead.im.graphics.Point;
import fehead.im.graphics.Region;
import fehead.im.graphics.Sprite;
import fehead.im.player.PlayerState;
import fehead.im.song.PlayMode;
import fehead.im.song.Song;
import fehead.im.song.SongMgr;
import lombok.extern.java.Log;

@Log
public class SelectStage implements InputProcessor, IStage {
	private	SpriteBatch batch;
	private Texture titleImg = new Texture("images/selectback.png");
	private Texture shiftLImg = new Texture("images/shiftl.png");
	private Texture shiftRImg = new Texture("images/shiftr.png");
	private Texture cFontImg = new Texture("images/cfont.png");
	private	Map<PlayMode, Texture>	modeIcon;

	private	BlinkBase	blank = new BlinkBase();
	private BlinkAnimation freePlayBlink = BlinkAnimation.of(new Sprite(cFontImg, Region.of(0, 48, 220, 23)), blank);
	private	BlinkAnimation pressCenter1pBlink = BlinkAnimation.of(new Sprite(cFontImg, Region.of(0, 0, 220, 23)), blank);
	private	BlinkAnimation pressCenter2pBlink = BlinkAnimation.of(new Sprite(cFontImg, Region.of(0, 0, 220, 23)), blank);
	private	ZoomAnimation leftZoomAni;
	private	ZoomAnimation rightZoomAni;

	private Sound bgmSnd;				// BackGround Music
    private Sound shiftMoveSnd;         // shiftRight ShiftLeft Button을 눌렀을때 나는 소리.
    private Sound introSnd;
	private Song leftSong;
	private Song rightSong;
	private Song selectedSong;
    private	Stages stages;

    private PlayerState playerState = PlayerState.getInstance();

	public SelectStage(SpriteBatch batch, Stages stages) {
		this.batch = batch;
		this.stages = stages;
		modeIcon = new EnumMap<>(PlayMode.class);
		for(PlayMode pm : PlayMode.values())
			modeIcon.put(pm, new Texture(pm.iconFileName()));

		bgmSnd = SoundMgr.of("music_select", "wave/music_select.mp3");
		shiftMoveSnd = SoundMgr.of("move", "wave/move.mp3");
	}

	@Override
	public void getIn() {
		freePlayBlink.setPosition(220, 30);
		pressCenter1pBlink.setPosition(10, 30);
		pressCenter2pBlink.setPosition(410, 30);

		bgmSnd.loop();

		Gdx.input.setInputProcessor(this);

	    leftSong = SongMgr.getInstace().getLeftSong();
	    rightSong = SongMgr.getInstace().getRightSong();
	    leftZoomAni = ZoomAnimation.of(leftSong.getDiskImage(), 1.0f, 1.5f);
	    leftZoomAni.setPosition(10,  250);
	    rightZoomAni = ZoomAnimation.of(rightSong.getDiskImage(), 1.0f, 1.5f);
	    rightZoomAni.setPosition(320,  250);
	}

	@Override
	public void think() {
	}
	
	@Override
	public void render() {
		blank.update();
		batch.draw(titleImg, 0, 0);

		// shift left button.
		batch.draw(shiftLImg, 10, 50);

		// shift right button.
		batch.draw(shiftRImg, 320, 50);

		// Draw Left top Song
		if(leftSong != null ) {
			// batch.draw(leftSong.getDiskImage(), 10, 250);
			leftZoomAni.draw(batch);
			Texture t = modeIcon.get(leftSong.getPlayMode());
			batch.draw(t, 0, 366);
		}

		// Draw Right top Song
		if(rightSong != null ) {
			// batch.draw(rightSong.getDiskImage(), 320, 250);
			rightZoomAni.draw(batch);
			Texture t = modeIcon.get(rightSong.getPlayMode());
			batch.draw(t, 320, 366);
		}

		freePlayBlink.draw(batch);

		// Draw to screen (10, 450) "PRESS CENTER BUTTON"
		if(!playerState.isStart1p()) {
			pressCenter1pBlink.draw(batch);
		}

		// pressCenter2pImg.setSize(440, 46); zoom
		// Draw to screen (410, 450) "PRESS CENTER BUTTON"
		if(!playerState.isStart2p()) {
			pressCenter2pBlink.draw(batch);
		}

	}

	@Override
	public void getOut() {
		if(introSnd != null) {
			introSnd.stop();
			introSnd.free();
		}
		selectedSong = null;
		shiftMoveSnd.stop();
		bgmSnd.stop();
	}

	@Override
	public void gotoPrevStage() {
		stages.setStage("title");
	}

	@Override
	public void gotoNextStage() {
		SongMgr.getInstace().setSelectedSong(selectedSong);
		stages.setStage("normal");
	}

	@Override
	public boolean keyDown(int keycode) {
		log.info("keycode : " + keycode);
		switch(keycode) {
		case Input.Keys.Z:
			turnLeft();
			break;
		case Input.Keys.C:
			turnRight();
			break;
		case Input.Keys.Q:
			selectLeft();
			break;
		case Input.Keys.E:
			selectRight();
			break;

		case Input.Keys.ESCAPE:
			gotoPrevStage();
			break;
		}
		return false;
	}

	private void selectRight() {
		bgmSnd.stop();
		if(rightZoomAni.isStarted()) {
			// TODO: next stage.
			gotoNextStage();
		} else {
			leftZoomAni.stop();
			rightZoomAni.start();
			if(introSnd != null)
				introSnd.stop();
			selectedSong = leftSong;
			introSnd = selectedSong.getIntroSnd();
			introSnd.loop();
		}
	}

	private void selectLeft() {
		bgmSnd.stop();
		if(leftZoomAni.isStarted()) {
			// TODO: next stage.
			gotoNextStage();
		} else {
			rightZoomAni.stop();
			leftZoomAni.start();
			if(introSnd != null)
				introSnd.stop();
			selectedSong = leftSong;
			introSnd = selectedSong.getIntroSnd();
			introSnd.loop();
		}
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

    //  왼쪽으로 화면이동
    private void   turnLeft() {
		if(introSnd != null) {
			introSnd.stop();
			introSnd = null;
			bgmSnd.loop();
		}
    	SongMgr.getInstace().turnLeft();
    	shiftMoveSnd.play();
    	setSongs();
    }

    // 오른쪽으로 화면이동
    private void   turnRight() {
		if(introSnd != null) {
			introSnd.stop();
			introSnd = null;
			bgmSnd.loop();
		}

    	SongMgr.getInstace().turnRight();
    	shiftMoveSnd.play();
    	setSongs();
    }

    private void setSongs() {
    	leftZoomAni.stop();
		rightZoomAni.stop();
    	leftSong = SongMgr.getInstace().getLeftSong();
	    rightSong = SongMgr.getInstace().getRightSong();
	    leftZoomAni = ZoomAnimation.of(leftSong.getDiskImage(), 1.0f, 1.5f);
	    leftZoomAni.setPosition(10,  250);
	    rightZoomAni = ZoomAnimation.of(rightSong.getDiskImage(), 1.0f, 1.5f);
	    rightZoomAni.setPosition(320,  250);
    }

    // 선택된곡 reset
    private void   resetSelectSong() {
    	if(selectedSong != null) {
    	}

    	leftSong = SongMgr.getInstace().getLeftSong();
	    rightSong = SongMgr.getInstace().getRightSong();
        bgmSnd.loop();
    }

    // 곡 선택
    private void   selectSong( int direction ) {
    }

    // 오른쪽 곡 선택
    private void   selectRightSong() {

    }

    // check hidden mode.
    private void   checkHiddenMode() {
    }


}
