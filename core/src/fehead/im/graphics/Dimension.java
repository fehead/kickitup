package fehead.im.graphics;

public class Dimension {
	private	final	int w;
	private	final	int	h;

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

}
