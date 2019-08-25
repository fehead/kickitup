package fehead.im.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Sprite {
	private	com.badlogic.gdx.graphics.g2d.Sprite	sprite;
	private	Region	region;
	private	Position	position;
	
	public Sprite(Texture texture, Point p, Dim d) {
		sprite = new com.badlogic.gdx.graphics.g2d.Sprite(texture
				, p.getX(), p.getY(), d.getW(), d.getH());
		region = Region.of(p,  d);
	}
	
	public Sprite(Texture texture, Region region) {
		sprite = new com.badlogic.gdx.graphics.g2d.Sprite(texture
				, region.getPoint().getX(), region.getPoint().getY()
				, region.getDim().getW(), region.getDim().getH());
		this.region = region;
	}

	public static Sprite of(String imgFilePath, Point p, Dim d) {
		Texture texture = new Texture(imgFilePath);
		return new Sprite(texture, p, d);
	}
	
	public static Sprite of(String imgFilePath, Region	region) {
		Texture texture = new Texture(imgFilePath);
		return new Sprite(texture, region);
	}

	public static Sprite of(String imgFilePath) {
		Texture texture = new Texture(imgFilePath);
		return new Sprite(texture, Point.of(0, 0), Dim.of(texture.getWidth(), texture.getHeight()));
	}

	public static Sprite of(Texture texture) {
		return new Sprite(texture, Point.of(0, 0), Dim.of(texture.getWidth(), texture.getHeight()));
	}
	
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}
	
	public void setPosition(Position pos) {
		position = pos;
		sprite.setPosition(pos.getX(), pos.getY());
	}
}