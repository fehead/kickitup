package fehead.im;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Song {
	static final private	String [] ksfFiles = {
			"Crazy_2.ksf", "Crazy_1.ksf", "Hard_2.ksf", "Hard_1.ksf", "Easy_2.ksf", "Easy_1.ksf", "Double.ksf" };

	static final private	String [] stfFiles = {
			"Crazy_2.stf", "Crazy_1.stf", "Hard_2.stf", "Hard_1.stf", "Easy_2.stf", "Easy_1.stf", "Double.stf" };

	public LPDIRECTSOUNDBUFFER Int_Song;
	
	public void readStepFiles(String path) {
		if(Files.exists(Paths.get(path, "crazy_2.stf"))) {
			readCrazy2STF(Paths.get(path, "crazy_2.stf"));
		}
	}

	private void readCrazy2STF(Path path) {
		Step stp = Step.readSTF(path);
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
