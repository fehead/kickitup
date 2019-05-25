package fehead.im.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fehead.im.GameStage;
import fehead.im.KickItUpGame;
import fehead.im.effect.BlinkBase;
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
	
	private	Sprite freePlayImg= new Sprite(cFontImg, 0, 48, 220, 23);
	private	Sprite pressCenter1pImg = new Sprite(cFontImg, 0, 0, 220, 23);
	private	Sprite pressCenter2pImg = new Sprite(cFontImg, 0, 0, 220, 23);

	private	BlinkBase	blank = new BlinkBase();

	private Sound bgmSnd;				// BackGround Music
    private Sound shiftMoveSnd;            // shiftRight ShiftLeft Button을 눌렀을때 나는 소리.
	private Song leftSong;
	private Song rightSong;
	private Song selectedSong;
    private	Stages stages;
    
	public SelectStage(SpriteBatch batch, Stages stages) {
		this.batch = batch;
		this.stages = stages;
	}

	@Override
	public void getIn() {
		freePlayImg.setPosition(220, 30);
		pressCenter1pImg.setPosition(10, 30);
		pressCenter2pImg.setPosition(410, 30);

		bgmSnd = Gdx.audio.newSound(Gdx.files.internal("wave/music_select.mp3"));
		bgmSnd.loop();
		
		shiftMoveSnd = Gdx.audio.newSound(Gdx.files.internal("wave/move.mp3"));
		Gdx.input.setInputProcessor(this);
		
	    leftSong = SongMgr.getInstace().getLeftSong();
	    rightSong = SongMgr.getInstace().getRightSong();
	}
	
	@Override
	public void render() {
		blank.update();
		batch.draw(titleImg, 0, 0);
		
		// Draw Left top Song
		if(leftSong != null ) {
			batch.draw(leftSong.getDiskImage(), 10, 250);
		}
		
		// Draw Right top Song
		if(rightSong != null ) {
			batch.draw(rightSong.getDiskImage(), 320, 250);
		}
		
		// shift left button.
		batch.draw(shiftLImg, 10, 50);
		
		// shift right button.
		batch.draw(shiftRImg, 320, 50);
		
		
		freePlayImg.draw(batch, blank.getValue());
		
		// Draw to screen (10, 450) "PRESS CENTER BUTTON"
		if(!KickItUpGame.playerState.isStart1p()) {			
			pressCenter1pImg.draw(batch, blank.getValue());
		}
		
		// pressCenter2pImg.setSize(440, 46); zoom
		// Draw to screen (410, 450) "PRESS CENTER BUTTON"
		if(!KickItUpGame.playerState.isStart2p()) {
			pressCenter2pImg.draw(batch, blank.getValue());
		}

	}

	@Override
	public void getOut() {
		shiftMoveSnd.dispose();
		bgmSnd.dispose();
		SongMgr.getInstace().reset();
	}

	@Override
	public void gotoPrevStage() {
		KickItUpGame.g_programState = GameStage.GAMETITLE;
		stages.setStage("title");
	}

	@Override
	public void gotoNextStage() {
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
		case Input.Keys.NUM_5:
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

    //  왼쪽으로 화면이동
    private void   turnLeft() {
    	SongMgr.getInstace().turnLeft();
    	shiftMoveSnd.play();
    }
    
    // 오른쪽으로 화면이동
    private void   turnRight() {
    	SongMgr.getInstace().turnRight();
    	shiftMoveSnd.play();
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
