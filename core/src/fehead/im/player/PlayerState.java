package fehead.im.player;

import lombok.Getter;

@Getter
public class PlayerState {
	private	int	stepSpeed = 1;
	private	boolean	isStart1p = false;
	private	boolean	isStart2p = false;
	
	public boolean isStart() {
		if(isStart1p || isStart2p)
			return true;
		return false;
	}

	public void resetStart(boolean b) {
		isStart1p = false;
		isStart2p = false;
	}
	
}
