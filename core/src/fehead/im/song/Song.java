package fehead.im.song;

import java.io.File;

import com.badlogic.gdx.graphics.Texture;

import fehead.im.KickItUpGame;
import lombok.Getter;

@Getter
public class Song {
	private	String	songTitle;

	private	File titleImgPath;
	private	File bgImgPath   ;
	private	File playMp3Path ;
	private	File playMpgPath ;
	private	File introMp3Path;

	private Texture	diskImage;
	private	PlayMode playMode;
	private	StepKsf[] stepKsf = new StepKsf[2];

	public void readKsf(PlayMode playMode, File path) {
		this.playMode = playMode;
		for(File f : path.listFiles()) {
			if(f.isDirectory())
				continue;
			String fileName = f.getName().toLowerCase();
			if(playMode.isCouple()) {
				for(int i = 0 ; i <= stepKsf.length; ++i) {
					String ksfFileName = String.format("%s_%d.ksf", playMode.getName(), i+1);
					if(fileName.equals(ksfFileName)) {
						readKsf(i, f);
					}
				}
			} else {
				String ksfFileName = String.format("%s.ksf", playMode.getName());
				if(fileName.equals(ksfFileName)) {
					readKsf(0, f);
				}
			}				
		}
	}
	
	private void readKsf(int i, File f) {
		stepKsf[i].readKSF(f);
	}
	
	/*
	public void readStepFiles(File path) {
		for(File f : path.listFiles()) {
			if(f.isDirectory())
				continue;
			String fileName = f.getName().toLowerCase();
			for(PlayMode pm : PlayMode.values()) {
				if(pm.isCouple()) {
					StepKsf step = new StepKsf();
					for(int i = 1 ; i <= 2; ++i) {
						step.readKSF(f);
					}					
				}
			}
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
		playMp3Path  = new File(stepFile.getParentFile(), "song.mp3");
		playMpgPath  = new File(stepFile.getParentFile(), "song.mpg");
		introMp3Path = new File(stepFile.getParentFile(), "intro.mp3");

		File disc = new File(stepFile.getParentFile(), "disc.png");
		if(disc.exists())
			diskImage = new Texture(disc.getAbsolutePath());
		else
			diskImage = KickItUpGame.noDisc;
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
		playMp3Path  = new File(stepFile.getParentFile(), "song.mp3");
		playMpgPath  = new File(stepFile.getParentFile(), "song.mpg");
		introMp3Path = new File(stepFile.getParentFile(), "intro.mp3");

		File disc = new File(stepFile.getParentFile(), "disc.png");
		if(disc.exists())
			diskImage = new Texture(disc.getAbsolutePath());
		else
			diskImage = KickItUpGame.noDisc;
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
		playMp3Path  = new File(stepFile.getParentFile(), "song.mp3");
		playMpgPath  = new File(stepFile.getParentFile(), "song.mpg");
		introMp3Path = new File(stepFile.getParentFile(), "intro.mp3");

		File disc = new File(stepFile.getParentFile(), "disc.png");
		if(disc.exists())
			diskImage = new Texture(disc.getAbsolutePath());
		else
			diskImage = KickItUpGame.noDisc;
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
		playMp3Path  = new File(stepFile.getParentFile(), "song.mp3");
		playMpgPath  = new File(stepFile.getParentFile(), "song.mpg");
		introMp3Path = new File(stepFile.getParentFile(), "intro.mp3");

		File disc = new File(stepFile.getParentFile(), "disc.png");
		if(disc.exists())
			diskImage = new Texture(disc.getAbsolutePath());
		else
			diskImage = KickItUpGame.noDisc;
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
		playMp3Path  = new File(stepFile.getParentFile(), "song.mp3");
		playMpgPath  = new File(stepFile.getParentFile(), "song.mpg");
		introMp3Path = new File(stepFile.getParentFile(), "intro.mp3");

		File disc = new File(stepFile.getParentFile(), "disc.png");
		if(disc.exists())
			diskImage = new Texture(disc.getAbsolutePath());
		else
			diskImage = KickItUpGame.noDisc;
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
		playMp3Path  = new File(stepFile.getParentFile(), "song.mp3");
		playMpgPath  = new File(stepFile.getParentFile(), "song.mpg");
		introMp3Path = new File(stepFile.getParentFile(), "intro.mp3");

		File disc = new File(stepFile.getParentFile(), "disc.png");
		if(disc.exists())
			diskImage = new Texture(disc.getAbsolutePath());
		else
			diskImage = KickItUpGame.noDisc;
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
		playMp3Path  = new File(stepFile.getParentFile(), "song.mp3");
		playMpgPath  = new File(stepFile.getParentFile(), "song.mpg");
		introMp3Path = new File(stepFile.getParentFile(), "intro.mp3");

		File disc = new File(stepFile.getParentFile(), "disc.png");
		if(disc.exists())
			diskImage = new Texture(disc.getAbsolutePath());
		else
			diskImage = KickItUpGame.noDisc;
	}
	*/
}
