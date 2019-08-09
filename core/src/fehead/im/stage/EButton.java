package fehead.im.stage;

import lombok.Getter;

public enum EButton {
	// 1 7 5 9 3
	// 25, 75, 125, 175, 225
	KEY1(1, 27, 4, 60, 0), KEY3(3, 227, 3, 60, 4), KEY5(5, 127, 2, 60, 2), KEY7(7, 77, 0, 60, 1),
	KEY9(9, 177, 1, 60, 3);

	@Getter
	private int key; // keyboard key (1 3 5 7 9)
	@Getter
	private int x; // pushStepArrow(parrow.png, carrow.png)start x
	@Getter
	private int stepArrowIdx; // stepArrow arrow.png
	@Getter
	private int stepArrowWith; // stepArrow arrow.png width
	@Getter
	private int ksfIdx; // ksfKey 17593

	EButton(int key, int x, int stepArrowIdx, int stepArrowWith, int ksfIdx) {
		this.key = key;
		this.x = x;
		this.stepArrowIdx = stepArrowIdx;
		this.stepArrowWith = stepArrowWith;
		this.ksfIdx = ksfIdx;
	}

	String getPushFileName() {
		return "images/parrow" + key + ".png";
	}

	String getCrashFileName() {
		return "images/carrow" + key + ".png";
	}
}
