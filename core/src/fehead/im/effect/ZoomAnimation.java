package fehead.im.effect;

public class ZoomAnimation extends Animation {
	private	float	minZoom;	// max zoom
	private	float	maxZoom;	// max zoom
	private	float	curZoom;	// current zoom.
	
	public ZoomAnimation() {
		this(1.0f, 1.0f);
	}
	
	public ZoomAnimation(float minZoom, float maxZoom) {
		this.minZoom = minZoom;
		this.maxZoom = maxZoom;
		curZoom = minZoom;
	}
	
	@Override
	public void render() {
	}
}
