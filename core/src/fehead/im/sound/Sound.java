package fehead.im.sound;

public interface Sound {
	boolean	load(String fileName);
	boolean free();
	
	boolean isLoaded();
	void play();
	void loop();
	void stop();
	void pause();
	void resume();
	
	long getPosition();
	
	boolean isPlaying();
	boolean isPause();
}
