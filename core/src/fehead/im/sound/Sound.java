package fehead.im.sound;

public interface Sound {
	boolean free();
	boolean isLoaded();
	void play();
	void loop();
	void stop();
	void pause();
	void resume();
}
