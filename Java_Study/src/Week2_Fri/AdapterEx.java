package Week2_Fri;

/*
//header - edit "Data/yourJavaHeader" to customize
//contents - edit "EventHandlers/Java file/onCreate" to customize
//
*/

import java.awt.*;
import java.awt.event.*;

import Week2_Wed.AAA;

public class AdapterEx extends Frame implements ActionListener {

	Panel p1, p2, p3;

	TextField tf;
	TextArea ta;

	Button b1, b2;

	public AdapterEx() {

		super("Adapter Exam"); // 상속받은 프레임 호출 프레임 이름 "Adapter Exam"

		p1 = new Panel(); // 판넬 3개 생성 p1 은 텍스트 필드(입력하는 곳)
		p2 = new Panel(); // p2는입력한 텍스트가 표출되는 텍스트 area
		p3 = new Panel(); // p3는 버튼 두개를 묶어서 관리하는 판넬.

		tf = new TextField(35); // textField 사이즈 35로 지정
		ta = new TextArea(10, 35); // textArea 사이즈10,35로 지정

		b1 = new Button("Clear"); // Clear 라고 써있는 버튼 생성(TextArea 초기화 하는 기능 수행)
		b2 = new Button("Exit"); // exit 버튼 생성 (종료 기능 수행)

		p1.add(tf);
		p2.add(ta);
		p3.add(b1);
		p3.add(b2);

		add("North", p1); // 프레임 위에 텍스트 필드 추가
		add("Center", p2); // 프레임 가운데에 텍스트 저장소 추가
		add("South", p3); // 프레임 아래쪽에 버튼 추가.

		setBounds(300, 200, 300, 300); // 사이즈 만듬
		setVisible(true); // 화면에 프레임 호출

		b1.addActionListener(this); // 버튼 1을 누르면 동작하는 액션리스너 붙여주기.
		b2.addActionListener(this); // 버튼 2를 누르면 동작하는 액션리스너 붙여줌.

		tf.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					ta.append(tf.getText() + "\n");
					tf.setText("");
				}
			}

		}); 

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("Clear")) {
			ta.setText("");
			tf.setText("");
			tf.requestFocus();
		} else if (str.equals("Exit")) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new AdapterEx();
	}
// 얘네를 이벤트 안에 넣어버리는게 이너클래스로 만드는 것..! => 리스너랑 핸들러랑 연결해서 가독성도 좋아짐... 
//	class KeyEventHandler extends KeyAdapter {
//
//		public void keyTyped(KeyEvent e) {
//			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
//				ta.append(tf.getText() + "\n");
//				tf.setText("");
//			}
//		}
//	}

}

//
//public void dispInter() {
//	new AAA() { // 얘가 anonymous inner class : 추상 클래스 또는 인터페이스는 원래 객체 생성불가
//				// => 그걸 객체로 만들 수 있게 하는게 anonymous inner class / 대신 이너클래스만 가능.
//				// 여기 AAA가 인터페이스일 수도 있고 추상 클래스일수도 있음.
//
//		@Override // AAA안에 있는 추상적인 부분을 구체화(오버라이딩) 함.
//		public void disp() {
//			System.out.println(a);
//		}
//		// }; //이렇게 닫고 밑에서 호출해도 되고~ 밑처럼 이너클래스 만들고 바로 실행도 함.
//	}.disp(); // 여기까지 이렇게 해서 일회성으로 사용할거야.
//	
//}
//
