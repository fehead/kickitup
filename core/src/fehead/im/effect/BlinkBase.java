package fehead.im.effect;

import lombok.Getter;

public class BlinkBase {
	@Getter
	private	float	value = 1.0f;

	private	float	valueDirection = -1.0f;
	private	long	beforeTime = System.currentTimeMillis();

	public void update() {
		long curTime = System.currentTimeMillis();
		long deltaTime = curTime - beforeTime;
		beforeTime = curTime;

		float alphaInc = deltaTime / 500.0f;
		value += (valueDirection * alphaInc);
		if(value < 0.0f) {
			value = 0.0f;
			valueDirection = 1.0f;
		} else if (1.0f < value) {
			value = 1.0f;
			valueDirection = -1.0f;
		}
	}
}
