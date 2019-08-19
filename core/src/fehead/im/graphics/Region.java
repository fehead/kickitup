package fehead.im.graphics;

import lombok.Getter;

@Getter
public class Region {
	private	Point	point;
	private	Dimension dim;	// width , height
	
	private Region(Point point, Dimension dim) {
		this.point = point;
		this.dim = dim;
	}
	
	public static Region of(int x, int y, int w, int h) {
		return new Region(Point.of(x, y), Dimension.of(w, h));
	}
}
