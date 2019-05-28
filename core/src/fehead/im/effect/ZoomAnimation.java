package fehead.im.effect;

import java.util.Objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ZoomAnimation {
	private	float	minZoom;	// max zoom
	private	float	maxZoom;	// max zoom
	private	float	curZoom;	// current zoom.
	
	private	boolean	oscillate = false;
	
	private BlinkBase blinkBase;
	private Sprite sprite;

	private	ZoomAnimation(Sprite sprite, float minZoom, float maxZoom, BlinkBase blinkBase) {
		this.sprite = sprite;
		this.minZoom = minZoom;
		this.maxZoom = maxZoom;
		curZoom = minZoom;
		this.blinkBase = blinkBase;
	}
	
	public static ZoomAnimation of(Sprite sprite, float minZoom, float maxZoom, BlinkBase blinkBase) {
		Objects.requireNonNull(sprite, "sprite is require Not Null");
		if(maxZoom < minZoom)
			throw new IllegalArgumentException("maxZoom < minZoom");
		Objects.requireNonNull(blinkBase, "blinkBase is require Not Null");
		
		return new ZoomAnimation(sprite, minZoom, maxZoom, blinkBase);
	}

	public static ZoomAnimation of(Sprite sprite, float minZoom, float maxZoom) {
		return of(sprite, minZoom, maxZoom, new BlinkBase());
	}
	
	public void setPosition(float x, float y) {
		this.sprite.setPosition(x, y);
	}
	
	public void draw(Batch batch) {
		update();
		sprite.draw(batch);
	}

	public void start() {
		oscillate = true;
	}
	
	public void stop() {
		sprite.setScale(1.0f);
		oscillate = false;
	}
	
	public boolean isStarted() {
		return oscillate;
	}
	
	private void update() {
		if(!oscillate)
			return;
		blinkBase.update();
		curZoom = (maxZoom - minZoom) * blinkBase.getValue() + minZoom;
		sprite.setScale(curZoom);
	}
	
}
