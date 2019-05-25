package fehead.im.effect;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

abstract class Animation {
	private long ticks;
	private int currentFrame;
	private int frameInc;
	
	private long beforeTime; // System.currentTimeMillis();

	private int frameRate; // Milliseconds
	private long oldTime;

	private int maxFrames;
	private boolean oscillate;
	private boolean isLoop; // 애니메이션을 계속 할것인지 판단.
	private boolean isPause = false; // 일시 정지 여부.
	
	private	Texture	texture;
	private	Sprite sprite;
	
	private	int	x;
	private	int	y;
	
	public Animation() {		
		beforeTime = System.currentTimeMillis();
	}
	
	abstract public void render();
}
