package fehead.im.song;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SongMgr {	
	private	List<Song> songList = new ArrayList<>();

	private int leftIndex;
	private int rightIndex;
	private Song curSong;
	
	private	static class LazyHolder {
		public static final SongMgr INSTANCE = new SongMgr();
	}
	
	public static SongMgr getInstace() {
		return LazyHolder.INSTANCE;
	}
	
	public void add(Song song) {
		songList.add(song);
	}
	
	public void load() {
		final String songPath="song";
		File songDir = new File(songPath);
		for(File f : songDir.listFiles()) {
			if(f.isFile())
				continue;
			readSongs(f);
		}
		
		if(!songList.isEmpty()) {
			leftIndex = 0;
			rightIndex = 1;
		}
	}
	
	public void readSongs(File songDir) {
		for(PlayMode pm : PlayMode.values()) {
			List<StepKsf>	stepList = new ArrayList<>(pm.getStepCnt());
			for(int i = 0 ; i < pm.getStepCnt(); ++i) {
				String stepFileName; 
				if(pm.getStepCnt() == 1) {
					stepFileName = String.format("%s.ksf", pm.getName());
				} else {
					stepFileName = String.format("%s_%d.ksf", pm.getName(), i + 1);
				}
					
				File stepFile = new File(songDir, stepFileName); 
				StepKsf step = StepKsf.OfFile(stepFile);
				if(step == null) {
					stepList.clear();
					break;
				}
				stepList.add(step);
			}
			
			if(!stepList.isEmpty()) {
				songList.add(Song.of(songDir, pm, stepList));
			}
		}
	}
}
