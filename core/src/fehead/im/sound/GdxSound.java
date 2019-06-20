package fehead.im.sound;

import com.badlogic.gdx.Gdx;

public class GdxSound implements Sound {
	private com.badlogic.gdx.audio.Sound sound;

	public static Sound of(String soundFileName) {
		com.badlogic.gdx.audio.Sound snd = Gdx.audio.newSound(Gdx.files.internal(soundFileName));
		if (snd == null)
			throw new IllegalArgumentException(soundFileName + " file is not exists");
		return new GdxSound(snd);
	}

	private	GdxSound(com.badlogic.gdx.audio.Sound sound) {
		this.sound = sound;
	}

	@Override
	public boolean free() {
		sound.dispose();
		return false;
	}

	@Override
	public boolean isLoaded() {
		return sound != null;
	}

	@Override
	public void play() {
		sound.play();

	}

	@Override
	public void loop() {
		sound.loop();
	}

	@Override
	public void stop() {
		sound.stop();
	}

	@Override
	public void pause() {
		sound.pause();
	}

	@Override
	public void resume() {
		sound.resume();
	}
}
