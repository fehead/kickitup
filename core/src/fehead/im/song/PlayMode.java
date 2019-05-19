package fehead.im.song;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PlayMode {
	EASY("easy", true)
	, HARD("hard", true)
	, CRAZY("crazy", true)
	, DOUBLE("double", false);
	
	private	String	name;
	private	boolean	couple;
}
