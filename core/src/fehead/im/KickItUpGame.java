package fehead.im;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import lombok.extern.java.Log;

@Log
public class KickItUpGame extends ApplicationAdapter {

	List<Song> songList = new ArrayList<Song>();

	SpriteBatch batch;
	Texture img;
	// Texture background;
	Texture terrain;
	TextureRegion groundTextureRegion;
	float backgroundPos = 0;
	CharacterProcessor inputProcessor;

	private Texture gameTitle = null;
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

	private Sound g_dsOpening;
	private Sound g_dsDead;
	private Sound g_dsMode;
	private Sound g_dsCancel;
	private Sound g_dsMove;
	private Sound g_dsBeat;
	private Sound g_dsSelectSong;

	private KIUConfig kcfg;

	private GameStage g_programState = GameStage.GAMETITLE;

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
		gameTitle = new Texture("images/title.png");
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
		Gdx.input.setInputProcessor(inputProcessor);

		kloadImage();
		readSongs();
		soundSetLoading();
		configLoading();
	}

	private void configLoading() {
		final String configPath = "kiu.cfg";
		File configFile = new File(configPath);
		kcfg = KIUConfig.of(configFile);
	}

	// C void Read()
	private void readSongs() {
		final String songPath="song";
		File songDir = new File(songPath);
		for(File f : songDir.listFiles()) {
			if(f.isDirectory()) {
				Song song = new Song();
				song.readStepFiles(f);
				songList.add(song);
			}
		}
	}

	private void soundSetLoading() {
		g_dsOpening = Gdx.audio.newSound(Gdx.files.internal("wave/opening.mp3"));
		g_dsDead = Gdx.audio.newSound(Gdx.files.internal("wave/dead.mp3"));
		g_dsMode = Gdx.audio.newSound(Gdx.files.internal("wave/mode.mp3"));
		g_dsCancel = Gdx.audio.newSound(Gdx.files.internal("wave/cancel.mp3"));
		g_dsMove = Gdx.audio.newSound(Gdx.files.internal("wave/move.mp3"));
		g_dsBeat = Gdx.audio.newSound(Gdx.files.internal("wave/select_eff.mp3"));
		g_dsSelectSong = Gdx.audio.newSound(Gdx.files.internal("wave/music_select.mp3"));
	}

	private void waveSetUnLoading() {
		g_dsOpening.dispose();
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
		batch.begin();
		// batch.draw(img, 0, 0);
		batch.disableBlending();
		batch.draw(background, 0, 0, 800, 400);
		batch.enableBlending();
		// draw ground image
		batch.draw(groundTextureRegion, backgroundPos, 0, 800, 100);
		if (backgroundPos + 800 > 0 && backgroundPos + 800 < 800)
			batch.draw(groundTextureRegion, backgroundPos + 800, 0, 800, 100);
		// draw player
		// batch.draw(smallFont, 0, 0);
		displayMessage(0, 0, "Loading Image....");
		inputProcessor.getPlayer().getCharacterSprite().draw(batch);
		// kiu code
		updateFrame();

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

		// FPS count & print end
		displayMessage(583, 463, String.format("FPS:%3d", Gdx.graphics.getFramesPerSecond()));

		switch (g_programState) {
		case GAMETITLE:
			stageTitle();
			break;
		/*
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
	}

	private void stageTitle() {
		Gdx.graphics.setTitle("KIUP stageTitle");
		batch.draw(gameTitle, 0, 0); // 타이틀
	}
}
