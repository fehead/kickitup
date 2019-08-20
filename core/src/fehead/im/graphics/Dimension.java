package fehead.im.graphics;

public class Dimension {
	private	final	int w;	// width
	private	final	int	h;	// height

	private Dimension(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	public static Dimension of(int w, int h) {
		return new Dimension(w, h);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(!(obj instanceof Dimension))
			return false;
		Dimension o = (Dimension)obj;
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
