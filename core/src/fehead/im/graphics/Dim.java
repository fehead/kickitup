package fehead.im.graphics;

import lombok.Getter;

/**
 * Dimension class.
 */
@Getter
public class Dim {
	private	final	int w;	// width
	private	final	int	h;	// height

	private Dim(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	public static Dim of(int w, int h) {
		return new Dim(w, h);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(!(obj instanceof Dim))
			return false;
		Dim o = (Dim)obj;
		return w == o.w && h == o.h;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + h;
		result = prime * result + w;
		return result;
	}

}
