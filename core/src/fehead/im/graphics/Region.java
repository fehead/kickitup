package fehead.im.graphics;

import lombok.Getter;

@Getter
public class Region {
	private	Point	point;
	private	Dim dim;	// width , height
	
	private Region(Point point, Dim dim) {
		this.point = point;
		this.dim = dim;
	}
	
	public static Region of(int x, int y, int w, int h) {
		return new Region(Point.of(x, y), Dim.of(w, h));
	}

	public static Region of(Point p, Dim d) {
		return new Region(p, d);
	}
}
