package fehead.im.graphics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class Region {
	int	x, y;	// x, y
	int w, h;	// width , height
	
	private Region(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public static Region of(int x, int y, int w, int h) {
		return new Region(x, y, w, h);
	}
}
