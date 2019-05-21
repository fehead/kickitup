package fehead.im.song;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PlayMode {
	EASY("easy", 2)
	, HARD("hard", 2)
	, CRAZY("crazy", 2)
	, DOUBLE("double", 1);
	
	private	String	name;
	private	int	stepCnt;
}
