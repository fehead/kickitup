package fehead.im.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fehead.im.KickItUpGame;
import fehead.im.audio.Sound;
import fehead.im.audio.SoundMgr;
import fehead.im.effect.BlinkAnimation;
import fehead.im.effect.BlinkBase;
import fehead.im.player.PlayerState;
import lombok.extern.java.Log;

@Log
public class TitleStage implements InputProcessor, IStage {
	private	SpriteBatch batch;
	private Texture titleImg = new Texture("images/title.png");
	private Texture cFontImg = new Texture("images/cfont.png");
	private Sound openingSnd;
	private	BlinkBase	blank = new BlinkBase();

	// Draw to screen "FREE PLAY!"
	private	BlinkAnimation freePlayImg;
	private	BlinkAnimation pressCenter1pImg;
	private	BlinkAnimation pressCenter2pImg;

	private	Stages	stages;

	private PlayerState playerState = PlayerState.getInstance();

	public TitleStage(SpriteBatch batch, Stages	stages) {
		this.batch = batch;
		this.stages = stages;


		freePlayImg = BlinkAnimation.of(new Sprite(cFontImg, 0, 48, 220, 23), blank);
		pressCenter1pImg = BlinkAnimation.of(new Sprite(cFontImg, 0, 0, 220, 23), blank);
		pressCenter2pImg = BlinkAnimation.of(new Sprite(cFontImg, 0, 0, 220, 23), blank);
		freePlayImg.setPosition(220, 30);
		pressCenter1pImg.setPosition(10, 30);
		pressCenter2pImg.setPosition(410, 30);
		openingSnd = SoundMgr.of("opening", "wave/opening.mp3");
	}

	@Override
	public void getIn() {
		Gdx.graphics.setTitle("KIUP stageTitle");
		openingSnd.loop();
		Gdx.input.setInputProcessor(this);

		playerState.resetStart();
	}

	@Override
	public void getOut() {
		openingSnd.stop();		
	}

	@Override
	public void render() {
		blank.update();

		batch.draw(titleImg, 0, 0); // 타이틀

		freePlayImg.draw(batch);

		// Draw to screen (10, 450) "PRESS CENTER BUTTON"
		if(!playerState.isStart1p()) {
			pressCenter1pImg.draw(batch);
		}

		// pressCenter2pImg.setSize(440, 46); zoom
		// Draw to screen (410, 450) "PRESS CENTER BUTTON"
		if(!playerState.isStart2p()) {
			pressCenter2pImg.draw(batch);
		}
	}

	@Override
	public boolean keyDown(int keycode) {
		log.info("keycode : " + keycode);
		switch(keycode) {
		case Input.Keys.S:
			if (playerState.isStart1p())
				gotoNextStage();
			else
				playerState.setStart1p(true);

			break;
		case Input.Keys.NUM_5:
			if (playerState.isStart2p())
				gotoNextStage();
			else
				playerState.setStart2p(true);
			break;

		case Input.Keys.ESCAPE:
			if(playerState.isStart())
				playerState.resetStart();
			else
				gotoPrevStage();
			break;
		}
		return false;
	}

	@Override
	public void gotoNextStage() {
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
