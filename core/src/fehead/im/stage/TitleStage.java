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
import lombok.extern.java.Log;

@Log
public class TitleStage implements InputProcessor, IStage {
	private	SpriteBatch batch;
	private Texture titleImg = new Texture("images/title.png");
	private Texture cFontImg = new Texture("images/cfont.png");
	private Sound openingSnd;
	
	private	float alpha = 0.5f;
	
	public TitleStage(SpriteBatch batch) {
		this.batch = batch;
	}
	
	@Override
	public void getIn() {
		openingSnd = Gdx.audio.newSound(Gdx.files.internal("wave/opening.mp3"));
		openingSnd.loop();
	}
	
	@Override
	public void getOut() {
		openingSnd.stop();
		openingSnd.dispose();
	}
	
	@Override
	public void render() {
		Gdx.graphics.setTitle("KIUP stageTitle");
		batch.draw(titleImg, 0, 0); // 타이틀

		// Draw to screen "FREE PLAY!"
		Sprite sprite = new Sprite(cFontImg, 0, 48, 220, 23);
		sprite.setPosition(220, 30);
		sprite.draw(batch, alpha);

		// Draw to screen (10, 450) "PRESS CENTER BUTTON"
		Sprite pressCenter = new Sprite(cFontImg, 0, 0, 220, 23);
		pressCenter.setPosition(10, 30);
		pressCenter.draw(batch, alpha);
		
		// Draw to screen (410, 450) "PRESS CENTER BUTTON"
		pressCenter.setPosition(410, 30);
		pressCenter.draw(batch, alpha);
	}

	@Override
	public boolean keyDown(int keycode) {		
		log.info("keycode : " + keycode);
		switch(keycode) {
		case Input.Keys.S:
			if (KickItUpGame.playerState.isStart1p())
				gotoNextStage();
			break;
		case Input.Keys.NUM_5:
			if (KickItUpGame.playerState.isStart2p())
				gotoNextStage();
			break;
		case Input.Keys.ESCAPE:
			if(KickItUpGame.playerState.isStart())
				KickItUpGame.playerState.resetStart(false);
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
