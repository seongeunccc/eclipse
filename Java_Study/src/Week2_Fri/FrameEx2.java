package Week2_Fri;

import java.awt.Frame;

public class FrameEx2 extends Frame {
	
	public FrameEx2() {
		super("Frame Test");
		
		setSize(300, 300);
		setVisible(true);
		
	}
	
	
	public static void main (String []args) {

		FrameEx2 feEx2 = new FrameEx2();
	}
}
