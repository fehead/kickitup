package fehead.im;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor {
	private	Sprite	characterSprite;
	
	Player() {
		this.characterSprite = new Sprite(new Texture("player.png"));
		getCharacterSprite().setBounds(Gdx.graphics.getWidth()/2-100, 100, Gdx.graphics.getWidth()/10,  Gdx.graphics.getHeight()/5);
	}

	public Sprite getCharacterSprite() {
		return characterSprite;
	}
}
