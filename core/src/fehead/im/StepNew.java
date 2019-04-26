package fehead.im;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import lombok.ToString;

@ToString
public class StepNew {
	public final int	MAX_STEPS = 2048;

	String	name;
	float	bpm;
	float	bpm2;
	float	bpm3;
	int		madi;
	int		tick;
	int		_dummy;
	int		track;
	int		start;
	int		start2 = 0;
	int		start3 = 0;
	int		bunki = 0;
	int		bunki2 = 0;

	List<String>	step = new ArrayList<>(MAX_STEPS);

	public boolean readKSF(File stepFile) {
		List<String> tempStep = new ArrayList<>(MAX_STEPS);
		try(BufferedReader br = new BufferedReader(new FileReader(stepFile))) {
			String line;
			while((line = br.readLine()) != null) {
				line = line.trim();
				if(line.charAt(0) == '#') {
					String[] prop = line.split("[#:;]");

					String key = prop[1].toUpperCase();
					if(key.equals("TITLE")) {
						name = prop[2];
					} else if(key.equals("TICKCOUNT")) {
						tick = Integer.parseInt(prop[2]);
					} else if(key.equals("BUNKI")) {
						bunki = Integer.parseInt(prop[2]);
					} else if(key.equals("BUNKI2")) {
						bunki2 = Integer.parseInt(prop[2]);
					} else if(key.equals("BPM")) {
						bpm = Float.parseFloat(prop[2]);
					} else if(key.equals("BPM2")) {
						bpm2 = Float.parseFloat(prop[2]);
					} else if(key.equals("BPM3")) {
						bpm3 = Float.parseFloat(prop[2]);
					} else if(key.equals("DIFFCULTY")) {
						_dummy = Integer.parseInt(prop[2]);
					} else if(key.equals("MADI")) {
						madi = Integer.parseInt(prop[2]);
					} else if(key.equals("STARTTIME")) {
						start = Integer.parseInt(prop[2]);
					} else if(key.equals("STARTTIME2")) {
						start2 = Integer.parseInt(prop[2]);
					} else if(key.equals("STARTTIME3")) {
						start3 = Integer.parseInt(prop[2]);
					} else if(key.equals("STEP")) {
						while((line = br.readLine()) != null) {
							tempStep.add(line.trim());
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		double bpmcount = 60.0 / bpm * 100;
		double tempStart = start;
		if(tick == 2 || tick == 4) {
			while(tempStart >= bpmcount) {
				tempStart -= bpmcount;
				IntStream.range(0, tick)
					.forEach((i) -> step.add("0000000000000"));
			}
		}

		step.addAll(tempStep);
		start = (int)tempStart;
		return true;
	}
}
