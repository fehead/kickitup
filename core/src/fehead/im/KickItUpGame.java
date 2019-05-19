package fehead.im;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import fehead.im.player.PlayerState;
import fehead.im.song.Song;
import fehead.im.song.SongMgr;
import fehead.im.stage.IStage;
import fehead.im.stage.Stages;
import fehead.im.stage.TitleStage;
import lombok.extern.java.Log;

@Log
public class KickItUpGame extends ApplicationAdapter {

	static public PlayerState	playerState = new PlayerState();
	private	Stages	stages;

	SpriteBatch batch;
	Texture img;
	// Texture background;
	Texture terrain;
	TextureRegion groundTextureRegion;
	float backgroundPos = 0;
	CharacterProcessor inputProcessor;

	private Texture background = null;
	private Texture songTitle = null;
	private Texture songBack = null;
	private Texture selectBack = null;
	private Texture judgeFont = null;
	private Texture nmberFont = null;
	private Texture comboFont = null;
	public static Texture noDisc = null;
	private Texture shiftLeft = null;
	private Texture shiftRight = null;
	private Texture gaugeWaku = null;
	private Texture gauge = null;
	private Texture score = null;
	private Texture deadScreen = null;
	private Texture gameOver = null;
	private Texture logo = null;
	private Texture diff = null;
	private Texture doubleIcon = null;
	private Texture crazyIcon = null;
	private Texture easyIcon = null;
	private Texture hardIcon = null;

	private Texture smallFont = null;
	private Texture arrow1 = null;
	private Texture arrow2 = null;
	private Texture wArrow = null;

	private Texture pArrow1 = null;
	private Texture pArrow3 = null;
	private Texture pArrow5 = null;
	private Texture pArrow7 = null;
	private Texture pArrow9 = null;

	private Texture cArrow1 = null;
	private Texture cArrow3 = null;
	private Texture cArrow5 = null;
	private Texture cArrow7 = null;
	private Texture cArrow9 = null;

	private Texture modeIcon = null;
	private Texture g_cFont = null;

	private Texture resultFont = null;
	private Texture resultBack = null;
	private Texture stageCount = null;

	private Sound g_dsDead;
	private Sound g_dsMode;
	private Sound g_dsCancel;
	private Sound g_dsMove;
	private Sound g_dsBeat;
	private Sound g_dsSelectSong;

	private KIUConfig kcfg;

	public static GameStage g_programState = GameStage.GAMETITLE;


	private boolean	songFlag;
	private boolean	introFlag;

	private int		highSpeed1p=1;
	private int		highSpeed2p=1;

	private int		highSpeed1p_1;
	private int		highSpeed1p_3;
	private int		highSpeed1p_5;
	private int		highSpeed1p_7;
	private int		highSpeed1p_9;

	private int		highSpeed2p_1;
	private int		highSpeed2p_3;
	private int		highSpeed2p_5;
	private int		highSpeed2p_7;
	private int		highSpeed2p_9;

	private int		MaxSpeed;
	private int		MinSpeed;

	private boolean	bModeMirror1p;
	private boolean	bModeNonstep1p;
	private boolean	bModeSynchro;
	private boolean	bModeUnion1p;
	private boolean	bModeRandom1p;
	private boolean	b4dMix1p;			// 1p 4DMIX mode.
	private boolean	bModeVanish1p;
	private boolean	bModeCrazy1p;
	private boolean	bModeSuddenR1p;
	private boolean	bModeRandomS1p;

	private boolean	bModeMirror2p;
	private boolean	bModeNonstep2p;
	private boolean	bModeUnion2p;
	private boolean	bModeRandom2p;
	private boolean	b4dMix2p;
	private boolean	bModeVanish2p;
	private boolean	bModeCrazy2p;
	private boolean	bModeSuddenR2p;
	private boolean	bModeRandomS2p;

	private boolean Couple = false;
	private boolean bDouble = false;

	private boolean Start1p = false;
	private boolean Start2p = false;
	
	private	float	alpha = 1.0f;
	private	float	alphaDir = -1.0f;

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
		background = new Texture("images/back.png");
		selectBack = new Texture("images/selectback.png");
		judgeFont = new Texture("images/judgement.png");
		nmberFont = new Texture("images/number.png");
		comboFont = new Texture("images/combo.png");
		noDisc = new Texture("images/nodisc.png");
		shiftLeft = new Texture("images/shiftl.png");
		shiftRight = new Texture("images/shiftr.png");
		gaugeWaku = new Texture("images/gaugewaku.png");
		gauge = new Texture("images/gauge.png");
		arrow2 = new Texture("images/arrow2.png");
		wArrow = new Texture("images/arrow.png");
		pArrow1 = new Texture("images/parrow1.png");
		pArrow3 = new Texture("images/parrow3.png");
		pArrow5 = new Texture("images/parrow5.png");
		pArrow7 = new Texture("images/parrow7.png");
		pArrow9 = new Texture("images/parrow9.png");
		cArrow1 = new Texture("images/carrow1.png");
		cArrow3 = new Texture("images/carrow3.png");
		cArrow5 = new Texture("images/carrow5.png");
		cArrow7 = new Texture("images/carrow7.png");
		cArrow9 = new Texture("images/carrow9.png");
		modeIcon = new Texture("images/modeicon.png");
		g_cFont = new Texture("images/cfont.png");
		resultFont = new Texture("images/resfont.png");
		resultBack = new Texture("images/resback.png");
		stageCount = new Texture("images/stagecount.png");
		score = new Texture("images/score.png");
		deadScreen = new Texture("images/dead.png");
		gameOver = new Texture("images/gameover.png");
		logo = new Texture("images/logo.png");
		diff = new Texture("images/diff.png");
		doubleIcon = new Texture("images/doubleicon.png");
		crazyIcon = new Texture("images/crazyicon.png");
		easyIcon = new Texture("images/easyicon.png");
		hardIcon = new Texture("images/hardicon.png");
	}

	@Override
	public void create () {		
		batch = new SpriteBatch();
		background = new Texture("sky2.jpg");
		terrain = new Texture("grey_stone_1.png");
		terrain.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
		groundTextureRegion = new TextureRegion(terrain);
		inputProcessor = new CharacterProcessor();
		// Gdx.input.setInputProcessor(inputProcessor);

		kloadImage();
		SongMgr.getInstace().load();
		soundSetLoading();
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

	private void soundSetLoading() {
		g_dsDead = Gdx.audio.newSound(Gdx.files.internal("wave/dead.mp3"));
		g_dsMode = Gdx.audio.newSound(Gdx.files.internal("wave/mode.mp3"));
		g_dsCancel = Gdx.audio.newSound(Gdx.files.internal("wave/cancel.mp3"));
		g_dsMove = Gdx.audio.newSound(Gdx.files.internal("wave/move.mp3"));
		g_dsBeat = Gdx.audio.newSound(Gdx.files.internal("wave/select_eff.mp3"));
		g_dsSelectSong = Gdx.audio.newSound(Gdx.files.internal("wave/music_select.mp3"));
	}

	private void waveSetUnLoading() {
		g_dsDead.dispose();
		g_dsMode.dispose();
		g_dsCancel.dispose();
		g_dsMove.dispose();
		g_dsBeat.dispose();
		g_dsSelectSong.dispose();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// batch.draw(img, 0, 0);
		batch.enableBlending();

		batch.begin();
		// draw ground image
		batch.draw(groundTextureRegion, backgroundPos, 0, 800, 100);
		if (backgroundPos + 800 > 0 && backgroundPos + 800 < 800)
			batch.draw(groundTextureRegion, backgroundPos + 800, 0, 800, 100);
		// draw player
		// batch.draw(smallFont, 0, 0);
		displayMessage(0, 0, "Loading Image....");
		inputProcessor.getPlayer().getCharacterSprite().draw(batch);
		// kiu code
		// updateFrame();
		stages.render();

		batch.end();
		updateScene();

	}


	private void updateScene() {
		float deltaTime = Gdx.graphics.getDeltaTime();
		backgroundPos -= 200 * deltaTime;
		if (backgroundPos <= -800)
			backgroundPos = 0;
	}

	@Override
	public void dispose() {
		batch.dispose();
		// img.dispose();
		waveSetUnLoading();
	}


	// private static long lastTime, fpsTime, framesRendered, fps;
	private void updateFrame() {
		/*
		// FPS count start
		long	cur = System.currentTimeMillis();
		long	deltaTime = cur - lastTime;
		lastTime = cur;

		fpsTime += deltaTime;

		++framesRendered;

		if(fpsTime > 1000) {
			fps = framesRendered;
			framesRendered = 0;
			fpsTime = 0;

		}
		*/

		updateAlpha();
		switch (g_programState) {
		/*
		case GAMETITLE:
			stageTitle();
			break;
			case SELECTSONG:
				SelectSong();
				break;
			case STAGE1:
				KIU_STAGE();
				break;
			case DOUBLE:
				KIU_STAGE_DOUBLE();
				break;
			case COUPLE:
				KIU_STAGE();
				break;
			case DEAD:
				Dead();
				break;
			case CONFIG:
				Configuration();
				break;
			case RESULT:
				Result();
				break;
			case GAMEOVER:
				GameOver1();
				break;
			case END:
				PostMessage(hWnd, WM_CLOSE, 0, 0);
				break;
		*/
		default:
			break;
		}

		// FPS count & print end
		displayMessage(583, 463, String.format("FPS:%3d", Gdx.graphics.getFramesPerSecond()));
	}

	private void clearMode() {
		highSpeed1p = 1;
		bModeMirror1p = false;
		bModeNonstep1p = false;
		bModeSynchro = false;
		bModeUnion1p = false;
		bModeRandom1p = false;
		b4dMix1p = false;
		highSpeed1p_1 = 1;
		highSpeed1p_3 = 1;
		highSpeed1p_5 = 1;
		highSpeed1p_7 = 1;
		highSpeed1p_9 = 1;
		bModeVanish1p = false;
		bModeRandomS1p = false;
		bModeSuddenR1p = false;

		highSpeed2p = 1;
		bModeMirror2p = false;
		bModeNonstep2p = false;
		bModeUnion2p = false;
		bModeRandom2p = false;
		b4dMix2p = false;
		highSpeed2p_1 = 1;
		highSpeed2p_3 = 1;
		highSpeed2p_5 = 1;
		highSpeed2p_7 = 1;
		highSpeed2p_9 = 1;
		bModeVanish2p = false;
		bDouble = false;
		bModeRandomS2p = false;
		bModeSuddenR2p = false;
	}
	
	private void updateAlpha() {
		int fps = Math.max(Gdx.graphics.getFramesPerSecond(), 20);
		float alphaInc = 2.0f / fps;	// 2초에 한번씩
		alpha += (alphaDir * alphaInc);
		if(alpha < 0.0f) {
			alpha = 0.0f;
			alphaDir = 1.0f;
		} else if (1.0f < alpha) {
			alpha = 1.0f;
			alphaDir = -1.0f;
		}
	}

	public static void quit() {
		Gdx.app.exit();
	}
}
