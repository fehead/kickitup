package fehead.im;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Song {
	static final private	String [] ksfFiles = {
			"crazy_2.ksf", "crazy_1.ksf", "hard_2.ksf", "hard_1.ksf", "easy_2.ksf", "easy_1.ksf", "double.ksf" };

	static final private	String [] stfFiles = {
			"crazy_2.stf", "crazy_1.stf", "hard_2.stf", "hard_1.stf", "easy_2.stf", "easy_1.stf", "double.stf" };

	public LPDIRECTSOUNDBUFFER Int_Song;

	public void readStepFiles(File path) {
		for(File f : path.listFiles()) {
			if(f.isDirectory())
				continue;
			String fileName = f.getName().toLowerCase();
			if(fileName.equals("crazy_2.ksf")) {
				readCrazy2KSF(f);
			}
		}
	}

	private void readCrazy2KSF(File stfFile) {
		StepNew step = new StepNew();
		step.readKSF(stfFile);
		/*
		HaveCouple=TRUE;
		bpm=STP.BPM;

		Crazy_Start=STP.start;
		Crazy_Tick=STP.tick;

		sprintf(SongTitle,"%s",STP.name);
		memcpy(&Data_Crazy1,&STP.step,sizeof(STP.step));

		GetFullPathName("Title.bmp",MAX_PATH,TitleImgPath,&lpPart);
		GetFullPathName("Back.bmp",MAX_PATH,BgImgPath,&lpPart);
		GetFullPathName("Song.wav",MAX_PATH,PlayWavPath,&lpPart);
		GetFullPathName("Song.mp3",MAX_PATH,PlayMp3Path,&lpPart);
		GetFullPathName("Song.mpg",MAX_PATH,PlayMpgPath,&lpPart);
		GetFullPathName("Intro.wav",MAX_PATH,IntroWavPath,&lpPart);
		GetFullPathName("Intro.mp3",MAX_PATH,IntroMp3Path,&lpPart);
		DiskImage=DDLoadBitmap(g_pDD,"Disc.bmp",0,0);
		if(DiskImage!=NULL)DDSetColorKey(DiskImage,CLR_INVALID);
		else DiskImage=NoDISC;
		*/
	}

}
