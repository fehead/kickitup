package fehead.im.stage;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fehead.im.audio.GdxMusic;
import fehead.im.audio.Music;
import fehead.im.song.Song;
import fehead.im.song.SongMgr;

public class NormalStage implements IStage, InputProcessor {
	private	SpriteBatch batch;
	private	Stages stages;
	private	Music	bgm;
	private	Song	song;
	private Texture titleImg;
	
	public NormalStage(SpriteBatch batch, Stages stages) {
		this.batch = batch;
		this.stages = stages;		
				
	}

	@Override
	public void getIn() {
		song = SongMgr.getInstace().getSelectedSong();
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
		batch.draw(titleImg, 0, 0);
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
		// TODO Auto-generated method stub

	}

	@Override
	public void gotoNextStage() {
		// TODO Auto-generated method stub

	}

}
