package fehead.im;

public class RECT {

	public RECT() {
	}
	
	public RECT(RECT rect) {
		this.top = rect.top;
		this.left = rect.left;
		this.right = rect.right;
		this.bottom = rect.bottom;
	}
	
	public long top = 0;
	public long left = 0;
	public long right = 0;
	public long bottom = 0;

}
