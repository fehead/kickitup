package fehead.im.effect;

import java.util.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import lombok.Setter;

public class FrameAnimation {
	private Sprite sprite;
	private int currentFrame = 0;
	private int maxFrames;
	private long beforeTime = 0;
	private int width;
	private int height;
	@Setter
	private	boolean	isLoop = false;
	@Setter
	private long frameRate;

	public FrameAnimation(Texture texture, int w, int h) {
		this.sprite = new Sprite(texture, w, h);
		this.width = w;
		this.height = w;
	}

	public static FrameAnimation of(Texture texture, int w, int h) {
		Objects.requireNonNull(texture, "texture is require Not null");
		return new FrameAnimation(texture, w , h);
	}

	public void setMaxFrame(int maxFrames) {
		this.maxFrames = maxFrames;
		currentFrame = 0;
	}

	public void setPosition(float x, float y) {
		this.sprite.setPosition(x, y);
	}

	public void draw(Batch batch) {
		if(beforeTime == 0)
			beforeTime = System.currentTimeMillis();

		long curTime = System.currentTimeMillis();
		long delta = curTime - beforeTime;
		if(frameRate <= delta) {
			++currentFrame;
			beforeTime = curTime;
			if(!isEnd()) {
				sprite.setRegion(this.width * currentFrame, 0, width, height);
			}
		}
		sprite.draw(batch);
	}

	public void setCurrentFrame(int frame) {		
		if (frame < 0 || maxFrames <= frame)
			return;
		currentFrame = frame;
	}

	public boolean isEnd() {
		return maxFrames <= currentFrame;
	}
}
