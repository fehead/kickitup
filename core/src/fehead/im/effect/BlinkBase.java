package fehead.im.effect;

import lombok.Getter;

public class BlinkBase {
	@Getter
	private	float	alpha = 1.0f;
	private	float	alphaDir = -1.0f;
	private	long	beforeTime = System.currentTimeMillis();
	
	public void update() {		
		long curTime = System.currentTimeMillis();
		long deltaTime = curTime - beforeTime;
		beforeTime = curTime;
		
		float alphaInc = deltaTime / 500.0f;
		alpha += (alphaDir * alphaInc);
		if(alpha < 0.0f) {
			alpha = 0.0f;
			alphaDir = 1.0f;
		} else if (1.0f < alpha) {
			alpha = 1.0f;
			alphaDir = -1.0f;
		}
	}
}
