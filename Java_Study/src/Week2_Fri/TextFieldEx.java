package Week2_Fri;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;


public class TextFieldEx {

	public static void main (String []args) {
		Frame f = new Frame();
		Panel p = new Panel();
		
		TextField tf1 = new TextField("name input :",12);
		TextField tf2 = new TextField("password input :",10);
		
		tf1.selectAll();
		tf2.selectAll();
		
		p.add(tf1);
		p.add(tf2);
		
		f.add(p);
		
		
	}
}
