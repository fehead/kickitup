package fehead.im;

import java.io.File;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import fehead.im.player.PlayerState;
import fehead.im.song.SongMgr;
import fehead.im.stage.Stages;

public class KickItUpGame extends ApplicationAdapter {

	static public PlayerState	playerState = new PlayerState();
	private	Stages	stages;

	SpriteBatch batch;
	Texture img;
	public static Texture noDisc = null;
	private Texture smallFont = null;

	@SuppressWarnings("unused")
	private KIUConfig kcfg;

	public static GameStage g_programState = GameStage.GAMETITLE;

	//////////////////////////////////
	// test code
	// Texture background;
	Texture terrain;
	TextureRegion groundTextureRegion;
	float backgroundPos = 0;
	//////////////////////////////////

	private void displayMessage(int x, int y, String msg) {
		final int FONT_WIDTH = 8;
		final int FONT_HEIGHT = 16;

		String upppercaseMsg = msg.toUpperCase();
		for (int i = 0; i < upppercaseMsg.length(); ++i) {
			int fontIndex = upppercaseMsg.charAt(i) - ' ';
			batch.draw(smallFont, x + i * FONT_WIDTH, y, FONT_WIDTH * fontIndex, 0, FONT_WIDTH, FONT_HEIGHT);
		}
	}

	private void kloadImage() {
		smallFont = new Texture("images/sfont.png");
		noDisc = new Texture("images/nodisc.png");
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		terrain = new Texture("grey_stone_1.png");
		terrain.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
		groundTextureRegion = new TextureRegion(terrain);

		kloadImage();
		SongMgr.getInstace().load();
		configLoading();
		clearMode();
		stages = new Stages(batch);
		stages.setStage("title");
	}

	private void configLoading() {
		final String configPath = "kiu.cfg";
		File configFile = new File(configPath);
		kcfg = KIUConfig.of(configFile);
	}


	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.enableBlending();

		batch.begin();

		stages.render();

		printDebugInfo();

		// updateScene();
		batch.end();
	}

	private void printDebugInfo() {
		// FPS count & print end
		displayMessage(583, 463, String.format("FPS:%3d", Gdx.graphics.getFramesPerSecond()));
	}

	// test code.
	@SuppressWarnings("unused")
	private void updateScene() {
		// draw ground image

		float deltaTime = Gdx.graphics.getDeltaTime();
		backgroundPos -= 200 * deltaTime;
		if (backgroundPos <= -800)
			backgroundPos = 0;

		batch.draw(groundTextureRegion, backgroundPos, 0, 800, 100);
		if (backgroundPos + 800 > 0 && backgroundPos + 800 < 800)
			batch.draw(groundTextureRegion, backgroundPos + 800, 0, 800, 100);
		displayMessage(0, 0, "Loading Image....");
	}

	@Override
	public void dispose() {
		batch.dispose();
		// img.dispose();
	}

	private void clearMode() {
	}

	public static void quit() {
		Gdx.app.exit();
	}
}
