package fehead.im.effect;

import java.util.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import lombok.Setter;

public class FrameAnimation {
	private Sprite sprite;
	private	int	currentFrame = 0;
	private	int	maxFrames;
	private	boolean	isLoop = false;
	private	long	beforeTime;
	@Setter
	private	int frameRate;

	public FrameAnimation(Texture texture, int w, int h) {
		this.sprite = new Sprite(texture, w, h);
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

		sprite.draw(batch);
	}
}
