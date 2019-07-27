package fehead.im.player;

import lombok.Getter;

public enum EPlayer {
	Player1(1),
	Player2(2);

	@Getter
	private	Integer	p;
	
	EPlayer(Integer p) {
		this.p = p;
	}
	
}
