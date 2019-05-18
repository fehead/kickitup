package fehead.im.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fehead.im.BlinkAnimation;
import fehead.im.GameStage;
import fehead.im.KickItUpGame;
import lombok.extern.java.Log;

@Log
public class SelectStage implements InputProcessor, IStage {
	private	SpriteBatch batch;
	private Texture titleImg = new Texture("images/selectback.png");
	private Texture shiftLImg = new Texture("images/shiftl.png");
	private Texture shiftRImg = new Texture("images/shiftr.png");
	private	BlinkAnimation	blank = new BlinkAnimation();

	private Sound bgmSnd;				// BackGround Music
    private Sound shiftMoveSnd;            // shiftRight ShiftLeft Button을 눌렀을때 나는 소리.
    
    private	Stages stages;
    
	public SelectStage(SpriteBatch batch, Stages stages) {
		this.batch = batch;
		this.stages = stages;
	}

	@Override
	public void getIn() {
		bgmSnd = Gdx.audio.newSound(Gdx.files.internal("wave/music_select.mp3"));
		bgmSnd.loop();
		
		shiftMoveSnd = Gdx.audio.newSound(Gdx.files.internal("wave/move.mp3"));
		Gdx.input.setInputProcessor(this);
	}
	
	@Override
	public void render() {
		blank.update();
		batch.draw(titleImg, 0, 0);
		
		// shift left button.
		batch.draw(shiftLImg, 10, 50);
		
		// shift right button.
		batch.draw(shiftRImg, 320, 50);
	}

	@Override
	public void getOut() {
		shiftMoveSnd.dispose();
		bgmSnd.dispose();
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
    	shiftMoveSnd.play();
    }
    
    // 오른쪽으로 화면이동
    private void   turnRight() {
    	shiftMoveSnd.play();
    }
    
    // 선택된곡 리셀
    private void   resetSelectSong() {
    	
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
