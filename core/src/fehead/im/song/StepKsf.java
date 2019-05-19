package fehead.im.song;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import lombok.Getter;

public class StepKsf {
	public final int MAX_STEPS = 2048;

	@Getter
	private String name;
	@Getter
	private float[] bpm = new float[3]; // 1Hz = 60BPM, 60BPM = 1분
	@Getter
	private int madi;
	@Getter
	private int tick;
	private int _dummy;
	@Getter
	private int track;
	@Getter
	private int[] start = new int[3];
	@Getter
	private int bunki[] = new int[2];

	List<String>	step = new ArrayList<>(MAX_STEPS);
	
	public boolean readKSF(File stepFile) {
		List<String> tempStep = new ArrayList<>(MAX_STEPS);
		try(BufferedReader br = new BufferedReader(new FileReader(stepFile))) {
			String line;
			while((line = br.readLine()) != null) {
				line = line.trim();
				if(line.charAt(0) != '#')
					continue;

				String[] prop = line.split("[#:;]");

				final String key = prop[1].toUpperCase();
				final String value = prop.length < 3 ? null : prop[2];
				if(key.equals("TITLE")) {
					name = value;
				} else if(key.equals("TICKCOUNT")) {
					tick = Integer.parseInt(value);
				} else if(key.equals("BUNKI")) {
					bunki[0] = Integer.parseInt(value);
				} else if(key.equals("BUNKI2")) {
					bunki[1] = Integer.parseInt(value);
				} else if(key.equals("BPM")) {
					bpm[0] = Float.parseFloat(value);
				} else if(key.equals("BPM2")) {
					bpm[1] = Float.parseFloat(value);
				} else if(key.equals("BPM3")) {
					bpm[2] = Float.parseFloat(value);
				} else if(key.equals("DIFFCULTY")) {
					_dummy = Integer.parseInt(value);
				} else if(key.equals("MADI")) {
					madi = Integer.parseInt(value);
				} else if(key.equals("STARTTIME")) {
					start[0] = Integer.parseInt(value);
				} else if(key.equals("STARTTIME2")) {
					start[1] = Integer.parseInt(value);
				} else if(key.equals("STARTTIME3")) {
					start[2] = Integer.parseInt(value);
				} else if(key.equals("STEP")) {
					while((line = br.readLine()) != null) {
						if(line.startsWith("2222222222222"))
							break;
						tempStep.add(line.trim());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		final double bpmcount = 60.0 / bpm[0] * 100;
		double tempStart = start[0];
		if(tick == 2 || tick == 4) {
			while(bpmcount <= tempStart) {
				tempStart -= bpmcount;
				IntStream.range(0, tick)
					.forEach((i) -> step.add("0000000000000"));
			}
		}

		step.addAll(tempStep);
		start[0] = (int)tempStart;
		return true;
	}
}
