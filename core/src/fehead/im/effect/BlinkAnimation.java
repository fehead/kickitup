package fehead.im.effect;

import java.util.Objects;
import java.util.Optional;

import com.badlogic.gdx.graphics.g2d.Batch;

import fehead.im.graphics.Position;
import fehead.im.graphics.Sprite;

public class BlinkAnimation {
	private BlinkBase blinkBase;
	private Sprite sprite;

	public BlinkAnimation(Sprite sprite, BlinkBase blinkBase) {
		this.sprite = sprite;
		this.blinkBase = blinkBase;
	}
	
	public static BlinkAnimation of(Sprite sprite, BlinkBase blinkBase) {
		Objects.requireNonNull(sprite, "sprite is require Not null");
		Objects.requireNonNull(blinkBase, "blinkBase is require Not null");

		return new BlinkAnimation(sprite, blinkBase);
	}

	public static BlinkAnimation of(Sprite sprite) {
		return of(sprite, new BlinkBase());
	}

	
	public void setPosition(float x, float y) {
		sprite.setPosition(Position.of(x, y));
	}
	
	public void draw(Batch batch) {
		blinkBase.update();
		sprite.draw(batch, blinkBase.getValue());
	}
}
