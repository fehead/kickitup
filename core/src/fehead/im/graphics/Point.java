package fehead.im.graphics;

import lombok.Getter;

@Getter
public class Point {
	private	final	int x;
	private	final	int	y;

	private Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static Point of(int x, int y) {
		return new Point(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(!(obj instanceof Point))
			return false;
		Point o = (Point)obj;
		return x == o.x && y == o.y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
}
