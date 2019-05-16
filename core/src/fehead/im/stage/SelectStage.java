package fehead.im.stage;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fehead.im.BlinkAnimation;

public class SelectStage implements InputProcessor, IStage {
	private	SpriteBatch batch;
	private Texture titleImg = new Texture("images/title.png");
	private Texture cFontImg = new Texture("images/cfont.png");
	private Sound openingSnd;
	private	BlinkAnimation	blank = new BlinkAnimation();

	// Draw to screen "FREE PLAY!"
	private	Sprite freePlayImg= new Sprite(cFontImg, 0, 48, 220, 23);	
	private	Sprite pressCenter1pImg = new Sprite(cFontImg, 0, 0, 220, 23);
	private	Sprite pressCenter2pImg = new Sprite(cFontImg, 0, 0, 220, 23);

	private Texture stateCommentImg;	// 하단 상태 표시
	private Texture shiftLeftImg;		// 하단 왼쪽 버튼(다른곡선택버튼)
	private Texture shiftRightImg;		// 하단 오른쪽 버튼(다른곡선택버튼)
    private Texture modeIcon;        // easy, hard, double crazy icon
	private Sound bgmSnd;				// BackGround Music
    private Sound shiftMoveSnd;            // shiftRight ShiftLeft Button을 눌렀을때 나는 소리.
    
    
	public SelectStage(SpriteBatch batch) {
		this.batch = batch;
	}
	
	@Override
	public void gotoPrevStage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotoNextStage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getIn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getOut() {
		// TODO Auto-generated method stub
		
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

    //  왼쪽으로 화면이동
    private void   turnLeft() {
    	
    }
    
    // 오른쪽으로 화면이동
    private void   turnRight() {
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
