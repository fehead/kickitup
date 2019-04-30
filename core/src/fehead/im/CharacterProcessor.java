package fehead.im;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class CharacterProcessor implements InputProcessor {
	private Player player = new Player();

	public Player getPlayer() {
		return this.player;
	}

	@Override
	public boolean keyDown(int keycode) {
		System.out.println("keycode : " + keycode);
		switch(keycode) {
		case Input.Keys.LEFT:
			if(player.getCharacterSprite().getX() > 0)
				player.getCharacterSprite().setX(player.getCharacterSprite().getX() - 10);
			break;
		case Input.Keys.RIGHT:
			if(player.getCharacterSprite().getX() < Gdx.graphics.getWidth())
				player.getCharacterSprite().setX(player.getCharacterSprite().getX() + 10);
			break;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
