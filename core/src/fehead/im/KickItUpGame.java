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

import lombok.extern.java.Log;

@Log
public class KickItUpGame extends ApplicationAdapter {

	List<Song>	songList = new ArrayList<Song>();

	SpriteBatch batch;
	Texture img;
	Texture background;
	Texture terrain;
	TextureRegion groundTextureRegion;
	float backgroundPos = 0;
	CharacterProcessor inputProcessor;

	private Texture	GameTITLE		= null;
	private Texture	Background		= null;
	private Texture	SongTitle 		= null;
	private Texture	SongBack 		= null;
	private Texture	SelectBack		= null;
	private Texture	JudgeFont		= null;
	private Texture	NumberFont		= null;
	private Texture	ComboFont		= null;
	public static Texture NoDISC			= null;
	private Texture	ShiftLeft		= null;
	private Texture	ShiftRight		= null;
	private Texture	GaugeWaku		= null;
	private Texture Gauge			= null;
	private Texture Score			= null;
	private Texture DeadScreen		= null;
	private Texture GameOver		= null;
	private Texture Logo			= null;
	private Texture	Diff			= null;
	private Texture	DoubleIcon		= null;
	private Texture	CrazyIcon		= null;
	private Texture	EasyIcon		= null;
	private Texture	HardIcon		= null;

	private Texture	SmallFont		= null;
	private Texture	Arrow1			= null;
	private Texture	Arrow2			= null;
	private Texture	wArrow			= null;

	private Texture	pArrow1			= null;
	private Texture	pArrow3			= null;
	private Texture	pArrow5			= null;
	private Texture	pArrow7			= null;
	private Texture	pArrow9			= null;

	private Texture	cArrow1			= null;
	private Texture	cArrow3			= null;
	private Texture	cArrow5			= null;
	private Texture	cArrow7			= null;
	private Texture	cArrow9			= null;

	private Texture	ModeIcon		= null;
	private Texture	g_cFont			= null;

	private Texture	ResultFont		= null;
	private Texture	ResultBack		= null;
	private Texture	StageCount		= null;

	private	Sound	g_dsOpening;
	private	Sound	g_dsDead;
	private	Sound	g_dsMode;
	private	Sound	g_dsCancel;
	private	Sound	g_dsMove;
	private	Sound	g_dsBeat;
	private	Sound	g_dsSelectSong;

	private	KIUConfig	kcfg;

	private	GameStage	g_ProgramState = GameStage.GAMETITLE;

	private void displayMessage(int x, int y, String msg) {
		final int FONT_WIDTH	= 8;
		final int FONT_HEIGHT	= 16;

		String	upppercaseMsg = msg.toUpperCase();
		for(int i = 0 ; i < upppercaseMsg.length() ; ++i) {
			int fontIndex = upppercaseMsg.charAt(i) -' ';
			batch.draw(SmallFont, x+i*FONT_WIDTH, y, FONT_WIDTH * fontIndex, 0, FONT_WIDTH, FONT_HEIGHT);
		}
	}

	private void kloadImage() {
		SmallFont = new Texture("images/sfont.png");
		GameTITLE = new Texture("images/title.png");
		Background = new Texture("images/back.png");
		SelectBack = new Texture("images/selectback.png");
		JudgeFont = new Texture("images/judgement.png");
		NumberFont = new Texture("images/number.png");
		ComboFont = new Texture("images/combo.png");
		NoDISC=new Texture("images/nodisc.png");
		ShiftLeft=new Texture("images/shiftl.png");
		ShiftRight=new Texture("images/shiftr.png");
		GaugeWaku=new Texture("images/gaugewaku.png");
		Gauge=new Texture("images/gauge.png");
		Arrow2=new Texture("images/arrow2.png");
		wArrow=new Texture("images/arrow.png");
		pArrow1=new Texture("images/parrow1.png");
		pArrow3=new Texture("images/parrow3.png");
		pArrow5=new Texture("images/parrow5.png");
		pArrow7=new Texture("images/parrow7.png");
		pArrow9=new Texture("images/parrow9.png");
		cArrow1=new Texture("images/carrow1.png");
		cArrow3=new Texture("images/carrow3.png");
		cArrow5=new Texture("images/carrow5.png");
		cArrow7=new Texture("images/carrow7.png");
		cArrow9=new Texture("images/carrow9.png");
		ModeIcon=new Texture("images/modeicon.png");
		g_cFont=new Texture("images/cfont.png");
		ResultFont=new Texture("images/resfont.png");
		ResultBack=new Texture("images/resback.png");
		StageCount=new Texture("images/stagecount.png");
		Score=new Texture("images/score.png");
		DeadScreen=new Texture("images/dead.png");
		GameOver=new Texture("images/gameover.png");
		Logo=new Texture("images/Logo.png");
		Diff=new Texture("images/diff.png");
		DoubleIcon=new Texture("images/doubleicon.png");
		CrazyIcon=new Texture("images/crazyicon.png");
		EasyIcon=new Texture("images/easyicon.png");
		HardIcon=new Texture("images/hardicon.png");
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
		waveSetLoading();
		cfgInitialize();
	}

	private void cfgInitialize() {
		final String configPath = "kiu.cfg";
		File configFile = new File(configPath);
		kcfg = KIUConfig.of(configFile);
	}

	// C void Read()
	private void readSongs() {
		final String songPath="assets/song";
		File songDir = new File(songPath);
		for(File f : songDir.listFiles()) {
			if(f.isDirectory()) {
				Song song = new Song();
				song.readStepFiles(f);
				songList.add(song);
			}
		}
	}

	private void waveSetLoading() {
		g_dsOpening = Gdx.audio.newSound(Gdx.files.internal("wave/Opening.wav"));
		g_dsDead = Gdx.audio.newSound(Gdx.files.internal("wave/Dead.wav"));
		g_dsMode = Gdx.audio.newSound(Gdx.files.internal("wave/Mode.wav"));
		g_dsCancel = Gdx.audio.newSound(Gdx.files.internal("wave/Cancel.wav"));
		g_dsMove = Gdx.audio.newSound(Gdx.files.internal("wave/Move.wav"));
		g_dsBeat = Gdx.audio.newSound(Gdx.files.internal("wave/Beat.wav"));
		g_dsSelectSong = Gdx.audio.newSound(Gdx.files.internal("wave/MusicSelect.wav"));
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
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		// batch.draw(img, 0, 0);
		batch.disableBlending();
		batch.draw(background, 0, 0, 800, 400);
		batch.enableBlending();
		// draw ground image
		batch.draw(groundTextureRegion, backgroundPos, 0, 800, 100);
		if(backgroundPos + 800 > 0 && backgroundPos + 800 < 800)
			batch.draw(groundTextureRegion, backgroundPos + 800, 0, 800, 100);
		// draw player
		// batch.draw(smallFont, 0, 0);
		displayMessage(0,0,"Loading Image....");
		inputProcessor.getPlayer().getCharacterSprite().draw(batch);
		batch.end();
		updateScene();

		// kiu code
		updateFrame();
	}


	private void updateScene() {
		float deltaTime = Gdx.graphics.getDeltaTime();
		backgroundPos -= 200 * deltaTime;
		if(backgroundPos <= -800)
			backgroundPos = 0;
	}

	@Override
	public void dispose () {
		batch.dispose();
		// img.dispose();
		waveSetUnLoading();
	}


	private static long lastTime, fpsTime, framesRendered, fps;
	private void updateFrame() {
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

		// FPS count & print end
		displayMessage(583, 463, String.format("FPS:%3d", fps));

		switch(g_ProgramState) {
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
		batch.draw(GameTITLE, 0, 0);		// 타이틀
	}

}
