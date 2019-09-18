package fehead.im.graphics;

import lombok.Getter;

@Getter
public class Position {
	private	final float	x;
	private	final float	y;
	
	private Position(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public static Position of(float x, float y) {
		return new Position(x, y);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(!(obj instanceof Position))
			return false;
		
		Position o = (Position)obj;
		return Float.compare(x, o.x) == 0 &&
				Float.compare(y,  o.y) == 0;  
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int ret = Float.floatToIntBits(x) * prime + Float.floatToIntBits(y);
		return ret;
	}
}
