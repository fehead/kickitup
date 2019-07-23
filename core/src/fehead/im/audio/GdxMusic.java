package fehead.im.audio;

import com.badlogic.gdx.Gdx;

public class GdxMusic implements Music {

	private com.badlogic.gdx.audio.Music	music;

	public static Music of(String soundFileName) {
		com.badlogic.gdx.audio.Music	music = Gdx.audio.newMusic(Gdx.files.internal(soundFileName));
		if (music == null)
			throw new IllegalArgumentException(soundFileName + " file is not exists");
		return new GdxMusic(music);
	}

	private	GdxMusic(com.badlogic.gdx.audio.Music music) {
		this.music = music;
	}

	@Override
	public boolean free() {
		music.dispose();
		return true;
	}

	@Override
	public boolean isLoaded() {
		return music != null;
	}

	@Override
	public void play() {
		music.play();
	}

	@Override
	public void loop() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void stop() {
		music.stop();
	}

	@Override
	public void pause() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void resume() {
		throw new UnsupportedOperationException();
	}

	@Override
	public long getPosition() {
		return (long)(music.getPosition() * 1000.0f);
	}
	
	@Override
	public boolean isPlaying() {
		return music.isPlaying();
	}
}
