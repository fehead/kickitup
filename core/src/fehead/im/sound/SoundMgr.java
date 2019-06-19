package fehead.im.sound;

import java.util.Map;

public class SoundMgr {

	private	Map<String, Sound>	soundMap;
	
	private	static class LazyHolder {
		public static final SoundMgr INSTANCE = new SoundMgr();
	}

	private	SoundMgr() {}

	public static SoundMgr getInstance() {
		return LazyHolder.INSTANCE;
	}
	
	public boolean initialize() {
		return false;
	}
	
	public boolean destroy() {
		return true;
	}
	
	public static Sound of(String soundName) {
		Sound ret = getInstance().soundMap.get(soundName);
		return ret;
	}
	
//	public static Sound of(String soundName, String soundFileName) {
//		Sound snd = Sound.of(soundFileName);
//		if(snd == null)
//			throw new IllegalArgumentException(soundFileName + " is not exists");
//		getInstance().soundMap.put(soundName, snd);
//		return snd;
//	}
}
