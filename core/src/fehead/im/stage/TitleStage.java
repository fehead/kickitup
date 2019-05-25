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
import lombok.extern.java.Log;

@Log
public class TitleStage implements InputProcessor, IStage {
	private	SpriteBatch batch;
	private Texture titleImg = new Texture("images/title.png");
	private Texture cFontImg = new Texture("images/cfont.png");
	private Sound openingSnd;
	private	BlinkBase	blank = new BlinkBase();

	// Draw to screen "FREE PLAY!"
	private	Sprite freePlayImg= new Sprite(cFontImg, 0, 48, 220, 23);	
	private	Sprite pressCenter1pImg = new Sprite(cFontImg, 0, 0, 220, 23);
	private	Sprite pressCenter2pImg = new Sprite(cFontImg, 0, 0, 220, 23);

	private	Stages	stages;
	public TitleStage(SpriteBatch batch, Stages	stages) {
		this.batch = batch;
		this.stages = stages;
	}
	
	@Override
	public void getIn() {
		Gdx.graphics.setTitle("KIUP stageTitle");
		freePlayImg.setPosition(220, 30);
		pressCenter1pImg.setPosition(10, 30);
		pressCenter2pImg.setPosition(410, 30);
		openingSnd = Gdx.audio.newSound(Gdx.files.internal("wave/opening.mp3"));
		openingSnd.loop();
		Gdx.input.setInputProcessor(this);
		
		KickItUpGame.playerState.resetStart();
	}
	
	@Override
	public void getOut() {
		openingSnd.stop();
		openingSnd.dispose();
	}
	
	@Override
	public void render() {
		blank.update();
		
		batch.draw(titleImg, 0, 0); // 타이틀

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
	public boolean keyDown(int keycode) {		
		log.info("keycode : " + keycode);
		switch(keycode) {
		case Input.Keys.S:
			if (KickItUpGame.playerState.isStart1p())
				gotoNextStage();
			else
				KickItUpGame.playerState.setStart1p(true);
			
			break;
		case Input.Keys.NUM_5:
			if (KickItUpGame.playerState.isStart2p())
				gotoNextStage();
			else
				KickItUpGame.playerState.setStart2p(true);
			break;
			
		case Input.Keys.ESCAPE:
			if(KickItUpGame.playerState.isStart())
				KickItUpGame.playerState.resetStart();
			else
				gotoPrevStage();
			break;
		}
		return false;
	}

	@Override
	public void gotoNextStage() {
		getOut();
		KickItUpGame.g_programState = GameStage.SELECTSONG;
		stages.setStage("select");
	}
	
	@Override
	public void gotoPrevStage() {
		getOut();
		KickItUpGame.quit();
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

}
