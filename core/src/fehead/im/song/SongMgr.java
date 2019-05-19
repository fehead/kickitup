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
			if(f.isDirectory()) {
				Song song = new Song();
				song.readStepFiles(f);
				SongMgr.getInstace().add(song);
			}
		}
		
		if(!songList.isEmpty()) {
			leftIndex = 0;
			rightIndex = 1;
		}
	}
}
