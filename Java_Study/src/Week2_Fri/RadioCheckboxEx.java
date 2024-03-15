package Week2_Fri;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.Panel;

public class RadioCheckboxEx {

	public static void main (String []args) {
		Frame f = new Frame("ㅎㅎ");
		Panel p = new Panel();
		
		CheckboxGroup group = new CheckboxGroup();
		Checkbox ck1  = new Checkbox("1",group, false);
		Checkbox ck2  = new Checkbox("2",group, false);
		Checkbox ck3  = new Checkbox("3",group, true);
		
		
		p.add(ck1);
		p.add(ck2);
		p.add(ck3);
		
		f.add(p);
	
		f.setSize(300,100);
		f.setVisible(true);
		
		
		
	}
	
	
}
