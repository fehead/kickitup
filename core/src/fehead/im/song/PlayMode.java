package fehead.im.song;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import fehead.im.player.EPlayer;
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

	public List<String> stepFileNames() {
		// exam) DOUBLE -> ["double.ksf"]
		if(stepCnt == 1)
			return Arrays.asList(name + ".ksf");

		// exam) EASY -> ["easy_1.ksf", "easy_2.ksf"]
		// 	HARD -> ["hard_1.ksf", "hard_2.ksf"]
		return IntStream.rangeClosed(1, stepCnt)
			.mapToObj(i -> String.format("%s_%d.ksf", name, i))
			.collect(Collectors.toList());
	}

	public String iconFileName() {
		return "images/" + name + "icon.png";
	}
	
	public List<EPlayer> getPlayers() {
		if(stepCnt == 1)
			return Arrays.asList(EPlayer.Player1);
		
		return Arrays.asList(EPlayer.values()); 
	}
}
