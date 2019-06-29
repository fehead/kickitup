package fehead.im.song;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class SongMgr {
	private	List<Song> songList = new ArrayList<>();

	private int leftIndex;
	private int rightIndex;
	@Setter @Getter
	private Song selectedSong;

	private SongMgr() {
	}
	
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

		if(songList.isEmpty())
			throw new IllegalStateException("song is empty");

		leftIndex = 0;
		rightIndex = 1;
	}

	public void readSongs(File songDir) {
		for(PlayMode pm : PlayMode.values()) {
			List<StepKsf>	stepList = new ArrayList<>(pm.getStepCnt());
			for(String stepFileName : pm.stepFileNames()) {
				File stepFile = new File(songDir, stepFileName);
				StepKsf step = StepKsf.fileOf(stepFile);
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

	public void turnLeft() {
		if(songList.isEmpty())
			return;
		
		leftIndex -= 2;
		if(leftIndex < 0)
			leftIndex += songList.size();
		rightIndex -= 2;
		if(rightIndex < 0)
			rightIndex += songList.size();
		
    	leftIndex = leftIndex % songList.size();
        rightIndex = rightIndex % songList.size();
	    selectedSong = null;
	}

	public void turnRight() {
		if(songList.isEmpty())
			return;
		
		leftIndex += 2;
		if(leftIndex < 0)
			leftIndex += songList.size();
		rightIndex += 2;
		if(rightIndex < 0)
			rightIndex += songList.size();
		
	   	leftIndex = leftIndex % songList.size();
        rightIndex = rightIndex % songList.size();
	    selectedSong = null;
	}

	public Song getLeftSong() {
		  Song ret = null;
		    if( leftIndex != -1 )
		        ret = songList.get(leftIndex);
		    return ret;
	}

	public Song getRightSong() {
		Song ret = null;
	    if( rightIndex != -1 )
	        ret = songList.get(rightIndex);
	    return ret;
	}

	public void reset() {
		leftIndex = 0;
		if(songList.size() > 1)
			rightIndex = 1;
		else
			rightIndex = 0;
		selectedSong = null;
	}
}
