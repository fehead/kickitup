package fehead.im.player;

import lombok.Getter;

@Getter
public class PlayerState {
	private	int	stepSpeed = 1;
	private	boolean	isStart1p = false;
	private	boolean	isStart2p = false;

	private	static class LazyHolder {
		public static final PlayerState INSTANCE = new PlayerState();
	}

	private	PlayerState() {}

	public static PlayerState getInstance() {
		return LazyHolder.INSTANCE;
	}

	public boolean isStart() {
		if(isStart1p || isStart2p)
			return true;
		return false;
	}

	public void resetStart() {
		isStart1p = false;
		isStart2p = false;
	}

	public void setStart1p(boolean b) {
		isStart1p = b;
	}

	public void setStart2p(boolean b) {
		isStart2p = b;
	}

}
