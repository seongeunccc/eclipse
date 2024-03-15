package Week2_Fri;

import java.awt.CardLayout;
import java.awt.Frame;

public class CardLayoutEx extends Frame {

	CardLayout card;
	PanelEx1 first_panel, second_panel, third_panel;
	
	public CardLayoutEx() {
		super("CardLayout  11");
		CardLayout card=  new CardLayout();
		
		setLayout(card);
		
		first_panel = new Panel();
		  
	
	}
	
	
	
	

}
