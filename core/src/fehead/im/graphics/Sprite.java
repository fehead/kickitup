package fehead.im.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Sprite {
	private	com.badlogic.gdx.graphics.g2d.Sprite	sprite;
	private	Region	region;
	
	public Sprite(Texture texture, Point p, Dim d) {
		sprite = new com.badlogic.gdx.graphics.g2d.Sprite(texture
				, p.getX(), p.getY(), d.getW(), d.getH());
		region = Region.of(p,  d);
	}
	
	public static Sprite of(String imgFilePath, Point p, Dim d) {
		Texture texture = new Texture(imgFilePath);
		return new Sprite(texture, p, d);
	}
	
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}
}