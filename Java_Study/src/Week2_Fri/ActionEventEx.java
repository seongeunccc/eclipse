package Week2_Fri;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


class Exit extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}



public class ActionEventEx extends Frame implements ActionListener {

	Panel p;
	Button input, exit;
	TextArea ta;
	
	
	
	public ActionEventEx() {
		super("ActionEvent Test"); 
//		super("windowEvent 테스트")
		p = new Panel();
		input = new Button("input");
		exit = new Button("exit");
		ta = new TextArea();

		input.addActionListener(this);
		exit.addActionListener(this);// this는 이 클래스 안에 엑션 퍼폼드가 있기 때문ㅇ

		p.add(input);
		p.add(exit);
		add(p, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);

		Label exit = new Label("프로그램 종료");
		add(exit);
		
		setBounds(300, 300, 300, 200);
		setVisible(true);
		
		addWindowListener(new Exit());  //어댑터 클래스 쓰게 되면 이렇게 하면됨
		//장점 = 안쓰는 핸들러 만들 필요 없음. 외부 클래스 호출해서 사용

	}

	public void actionPerformed(ActionEvent e) {
		String name;
		name = e.getActionCommand();

		if (name.equals("input")) {
			ta.append("button input. \n");
		} else {
			ta.append("exit. \n");
			try {
				Thread.sleep(2000);
			} catch (Exception ee) {
			}
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new ActionEventEx();
	}

	

}
