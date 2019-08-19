package fehead.im.graphics;

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
	
}
