package fehead.im;

import java.io.File;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;

public class Song {
	static final private	String [] ksfFiles = {
			"crazy_2.ksf", "crazy_1.ksf", "hard_2.ksf", "hard_1.ksf", "easy_2.ksf", "easy_1.ksf", "double.ksf" };

	static final private	String [] stfFiles = {
			"crazy_2.stf", "crazy_1.stf", "hard_2.stf", "hard_1.stf", "easy_2.stf", "easy_1.stf", "double.stf" };

	public LPDIRECTSOUNDBUFFER Int_Song;

	private double	bpm;
	private double	bpm2;
	private double	bpm3;

	private	long	Bunki;
	private	long	Bunki2;
	private	String	songTitle;

	private	File TitleImgPath;
	private	File BgImgPath   ;
	private	File PlayWavPath ;
	private	File PlayMp3Path ;
	private	File PlayMpgPath ;
	private	File IntroWavPath;
	private	File IntroMp3Path;

	private Texture	DiskImage;

	private	boolean	haveCrazy;
	private	int	Crazy_Diff;
	private	int	Crazy_Start;
	private	int	Crazy_Start2;
	private	int	Crazy_Start3;
	private	int	Crazy_Tick;
	private	List<String>	Data_Crazy;

	private	boolean	haveEasy;
	private	int	Easy_Diff;
	private	int	Easy_Start;
	private	int	Easy_Start2;
	private	int	Easy_Start3;
	private	int	Easy_Tick;
	private	List<String>	Data_Easy;

	public void readStepFiles(File path) {
		for(File f : path.listFiles()) {
			if(f.isDirectory())
				continue;
			String fileName = f.getName().toLowerCase();
			if(fileName.equals("crazy_1.ksf")) {
				readCrazy1KSF(f);
			}
		}
	}

	private void readCrazy1KSF(File stepFile) {
		StepNew step = new StepNew();
		step.readKSF(stepFile);

		haveCrazy = true;
		bpm = step.bpm;
		bpm2 = step.bpm2;
		bpm3 = step.bpm3;

		Crazy_Diff = step._dummy;
		Crazy_Start = step.start;
		Crazy_Start2 = step.start2;
		Crazy_Start3 = step.start3;
		Crazy_Tick = step.tick;

		Bunki = step.bunki;
		Bunki2 = step.bunki2;

		songTitle = step.name;

		Data_Crazy = step.step;

		TitleImgPath = new File(stepFile.getParentFile(), "title.png");
		BgImgPath    = new File(stepFile.getParentFile(), "back.png");
		PlayWavPath  = new File(stepFile.getParentFile(), "song.wav");
		PlayMp3Path  = new File(stepFile.getParentFile(), "song.mp3");
		PlayMpgPath  = new File(stepFile.getParentFile(), "song.mpg");
		IntroWavPath = new File(stepFile.getParentFile(), "intro.wav");
		IntroMp3Path = new File(stepFile.getParentFile(), "intro.mp3");

		File disc = new File(stepFile.getParentFile(), "disc.png");
		if(disc.exists())
			DiskImage = new Texture(disc.getAbsolutePath());
		else
			DiskImage = KickItUpGame.NoDISC;
	}

	private void readEasy1KSF(File stepFile) {
		StepNew step = new StepNew();
		step.readKSF(stepFile);

		haveEasy = true;
		bpm = step.bpm;
		bpm2 = step.bpm2;
		bpm3 = step.bpm3;

		Easy_Diff = step._dummy;
		Easy_Start = step.start;
		Easy_Start2 = step.start2;
		Easy_Start3 = step.start3;
		Easy_Tick = step.tick;

		Bunki = step.bunki;
		Bunki2 = step.bunki2;

		songTitle = step.name;

		Data_Easy = step.step;

		TitleImgPath = new File(stepFile.getParentFile(), "title.png");
		BgImgPath    = new File(stepFile.getParentFile(), "back.png");
		PlayWavPath  = new File(stepFile.getParentFile(), "song.wav");
		PlayMp3Path  = new File(stepFile.getParentFile(), "song.mp3");
		PlayMpgPath  = new File(stepFile.getParentFile(), "song.mpg");
		IntroWavPath = new File(stepFile.getParentFile(), "intro.wav");
		IntroMp3Path = new File(stepFile.getParentFile(), "intro.mp3");

		File disc = new File(stepFile.getParentFile(), "disc.png");
		if(disc.exists())
			DiskImage = new Texture(disc.getAbsolutePath());
		else
			DiskImage = KickItUpGame.NoDISC;
	}

}
