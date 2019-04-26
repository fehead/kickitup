package fehead.im;

import java.io.File;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;

import lombok.Getter;

@Getter
public class Song {
	public LPDIRECTSOUNDBUFFER Int_Song;

	private double	bpm;
	private double	bpm2;
	private double	bpm3;

	private	long	bunki;
	private	long	bunki2;
	private	String	songTitle;

	private	File titleImgPath;
	private	File bgImgPath   ;
	private	File playWavPath ;
	private	File playMp3Path ;
	private	File playMpgPath ;
	private	File introWavPath;
	private	File introMp3Path;

	private Texture	diskImage;

	private	boolean	haveCrazy;
	private	int	crazyDiff;
	private	int	crazyStart;
	private	int	crazyStart2;
	private	int	crazyStart3;
	private	int	crazyTick;
	private	List<String>	dataCrazy;		// Crazy single step

	private	List<String>	dataCrazy1;	// Crazy couple step

	private	boolean	haveEasy;
	private	int	easyDiff;
	private	int	easyStart;
	private	int	easyStart2;
	private	int	easyStart3;
	private	int	easyTick;
	private	List<String>	dataEasy;		// Easy single step

	private	boolean	haveCouple;
	private	List<String>	dataEasy1;		// Easy couple step

	private	int	hardDiff;
	private	int	hardStart;
	private	int	hardStart2;
	private	int	hardStart3;
	private	int	hardTick;

	private	boolean	haveHard;
	private	List<String>	dataHard;
	private	List<String>	dataHard1;

	private	boolean	haveDouble;

	private	int	doubleDiff;
	private	int	doubleStart;
	private	int	doubleStart2;
	private	int	doubleStart3;
	private	int	doubleTick;

	private	List<String>	dataDouble;

	public void readStepFiles(File path) {
		for(File f : path.listFiles()) {
			if(f.isDirectory())
				continue;
			String fileName = f.getName().toLowerCase();
			if(fileName.equals("easy_1.ksf")) {
				readEasy1KSF(f);
			} else if(fileName.equals("easy_2.ksf")) {
				readEasy2KSF(f);
			} else if(fileName.equals("hard_1.ksf")) {
				readHard1KSF(f);
			} else if(fileName.equals("hard_2.ksf")) {
				readHard2KSF(f);
			} else if(fileName.equals("crazy_1.ksf")) {
				readCrazy1KSF(f);
			} else if(fileName.equals("crazy_2.ksf")) {
				readCrazy2KSF(f);
			} else if(fileName.equals("double.ksf")) {
				readDoubleKSF(f);
			}
		}
	}

	private void readCrazy1KSF(File stepFile) {
		StepNew step = new StepNew();
		step.readKSF(stepFile);

		bpm = step.bpm;
		bpm2 = step.bpm2;
		bpm3 = step.bpm3;
		bunki = step.bunki;
		bunki2 = step.bunki2;
		songTitle = step.name;

		crazyDiff = step._dummy;
		crazyStart = step.start;
		crazyStart2 = step.start2;
		crazyStart3 = step.start3;
		crazyTick = step.tick;

		haveCrazy = true;
		dataCrazy = step.step;

		titleImgPath = new File(stepFile.getParentFile(), "title.png");
		bgImgPath    = new File(stepFile.getParentFile(), "back.png");
		playWavPath  = new File(stepFile.getParentFile(), "song.wav");
		playMp3Path  = new File(stepFile.getParentFile(), "song.mp3");
		playMpgPath  = new File(stepFile.getParentFile(), "song.mpg");
		introWavPath = new File(stepFile.getParentFile(), "intro.wav");
		introMp3Path = new File(stepFile.getParentFile(), "intro.mp3");

		File disc = new File(stepFile.getParentFile(), "disc.png");
		if(disc.exists())
			diskImage = new Texture(disc.getAbsolutePath());
		else
			diskImage = KickItUpGame.NoDISC;
	}

	private void readCrazy2KSF(File stepFile) {
		StepNew step = new StepNew();
		step.readKSF(stepFile);

		bpm = step.bpm;
		bpm2 = step.bpm2;
		bpm3 = step.bpm3;
		bunki = step.bunki;
		bunki2 = step.bunki2;
		songTitle = step.name;

		crazyDiff = step._dummy;
		crazyStart = step.start;
		crazyStart2 = step.start2;
		crazyStart3 = step.start3;
		crazyTick = step.tick;

		haveCouple = true;
		dataCrazy1 = step.step;

		titleImgPath = new File(stepFile.getParentFile(), "title.png");
		bgImgPath    = new File(stepFile.getParentFile(), "back.png");
		playWavPath  = new File(stepFile.getParentFile(), "song.wav");
		playMp3Path  = new File(stepFile.getParentFile(), "song.mp3");
		playMpgPath  = new File(stepFile.getParentFile(), "song.mpg");
		introWavPath = new File(stepFile.getParentFile(), "intro.wav");
		introMp3Path = new File(stepFile.getParentFile(), "intro.mp3");

		File disc = new File(stepFile.getParentFile(), "disc.png");
		if(disc.exists())
			diskImage = new Texture(disc.getAbsolutePath());
		else
			diskImage = KickItUpGame.NoDISC;
	}

	private void readEasy1KSF(File stepFile) {
		StepNew step = new StepNew();
		step.readKSF(stepFile);

		bpm = step.bpm;
		bpm2 = step.bpm2;
		bpm3 = step.bpm3;
		bunki = step.bunki;
		bunki2 = step.bunki2;
		songTitle = step.name;

		easyDiff = step._dummy;
		easyStart = step.start;
		easyStart2 = step.start2;
		easyStart3 = step.start3;
		easyTick = step.tick;

		haveEasy = true;
		dataEasy = step.step;

		titleImgPath = new File(stepFile.getParentFile(), "title.png");
		bgImgPath    = new File(stepFile.getParentFile(), "back.png");
		playWavPath  = new File(stepFile.getParentFile(), "song.wav");
		playMp3Path  = new File(stepFile.getParentFile(), "song.mp3");
		playMpgPath  = new File(stepFile.getParentFile(), "song.mpg");
		introWavPath = new File(stepFile.getParentFile(), "intro.wav");
		introMp3Path = new File(stepFile.getParentFile(), "intro.mp3");

		File disc = new File(stepFile.getParentFile(), "disc.png");
		if(disc.exists())
			diskImage = new Texture(disc.getAbsolutePath());
		else
			diskImage = KickItUpGame.NoDISC;
	}

	private void readEasy2KSF(File stepFile) {
		StepNew step = new StepNew();
		step.readKSF(stepFile);

		bpm = step.bpm;
		bpm2 = step.bpm2;
		bpm3 = step.bpm3;
		bunki = step.bunki;
		bunki2 = step.bunki2;
		songTitle = step.name;

		easyDiff = step._dummy;
		easyStart = step.start;
		easyStart2 = step.start2;
		easyStart3 = step.start3;
		easyTick = step.tick;

		haveCouple = true;
		dataEasy1 = step.step;

		titleImgPath = new File(stepFile.getParentFile(), "title.png");
		bgImgPath    = new File(stepFile.getParentFile(), "back.png");
		playWavPath  = new File(stepFile.getParentFile(), "song.wav");
		playMp3Path  = new File(stepFile.getParentFile(), "song.mp3");
		playMpgPath  = new File(stepFile.getParentFile(), "song.mpg");
		introWavPath = new File(stepFile.getParentFile(), "intro.wav");
		introMp3Path = new File(stepFile.getParentFile(), "intro.mp3");

		File disc = new File(stepFile.getParentFile(), "disc.png");
		if(disc.exists())
			diskImage = new Texture(disc.getAbsolutePath());
		else
			diskImage = KickItUpGame.NoDISC;
	}


	private void readHard1KSF(File stepFile) {
		StepNew step = new StepNew();
		step.readKSF(stepFile);

		bpm = step.bpm;
		bpm2 = step.bpm2;
		bpm3 = step.bpm3;
		bunki = step.bunki;
		bunki2 = step.bunki2;
		songTitle = step.name;

		hardDiff = step._dummy;
		hardStart = step.start;
		hardStart2 = step.start2;
		hardStart3 = step.start3;
		hardTick = step.tick;

		haveHard = true;
		dataHard = step.step;

		titleImgPath = new File(stepFile.getParentFile(), "title.png");
		bgImgPath    = new File(stepFile.getParentFile(), "back.png");
		playWavPath  = new File(stepFile.getParentFile(), "song.wav");
		playMp3Path  = new File(stepFile.getParentFile(), "song.mp3");
		playMpgPath  = new File(stepFile.getParentFile(), "song.mpg");
		introWavPath = new File(stepFile.getParentFile(), "intro.wav");
		introMp3Path = new File(stepFile.getParentFile(), "intro.mp3");

		File disc = new File(stepFile.getParentFile(), "disc.png");
		if(disc.exists())
			diskImage = new Texture(disc.getAbsolutePath());
		else
			diskImage = KickItUpGame.NoDISC;
	}

	private void readHard2KSF(File stepFile) {
		StepNew step = new StepNew();
		step.readKSF(stepFile);

		bpm = step.bpm;
		bpm2 = step.bpm2;
		bpm3 = step.bpm3;
		bunki = step.bunki;
		bunki2 = step.bunki2;
		songTitle = step.name;

		hardDiff = step._dummy;
		hardStart = step.start;
		hardStart2 = step.start2;
		hardStart3 = step.start3;
		hardTick = step.tick;

		haveCouple = true;
		dataHard1 = step.step;

		titleImgPath = new File(stepFile.getParentFile(), "title.png");
		bgImgPath    = new File(stepFile.getParentFile(), "back.png");
		playWavPath  = new File(stepFile.getParentFile(), "song.wav");
		playMp3Path  = new File(stepFile.getParentFile(), "song.mp3");
		playMpgPath  = new File(stepFile.getParentFile(), "song.mpg");
		introWavPath = new File(stepFile.getParentFile(), "intro.wav");
		introMp3Path = new File(stepFile.getParentFile(), "intro.mp3");

		File disc = new File(stepFile.getParentFile(), "disc.png");
		if(disc.exists())
			diskImage = new Texture(disc.getAbsolutePath());
		else
			diskImage = KickItUpGame.NoDISC;
	}

	private void readDoubleKSF(File stepFile) {
		StepNew step = new StepNew();
		step.readKSF(stepFile);

		bpm = step.bpm;
		bpm2 = step.bpm2;
		bpm3 = step.bpm3;
		bunki = step.bunki;
		bunki2 = step.bunki2;
		songTitle = step.name;

		doubleDiff = step._dummy;
		doubleStart = step.start;
		doubleStart2 = step.start2;
		doubleStart3 = step.start3;
		doubleTick = step.tick;

		haveDouble = true;
		dataDouble = step.step;

		titleImgPath = new File(stepFile.getParentFile(), "title.png");
		bgImgPath    = new File(stepFile.getParentFile(), "back.png");
		playWavPath  = new File(stepFile.getParentFile(), "song.wav");
		playMp3Path  = new File(stepFile.getParentFile(), "song.mp3");
		playMpgPath  = new File(stepFile.getParentFile(), "song.mpg");
		introWavPath = new File(stepFile.getParentFile(), "intro.wav");
		introMp3Path = new File(stepFile.getParentFile(), "intro.mp3");

		File disc = new File(stepFile.getParentFile(), "disc.png");
		if(disc.exists())
			diskImage = new Texture(disc.getAbsolutePath());
		else
			diskImage = KickItUpGame.NoDISC;
	}
}
