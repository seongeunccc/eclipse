// 내 자신의 생성자를 생성자에서 호출하는 방법. -> 생성자는 객체 생성될 때 한번 생성 +객체 생성되며 또 다른 다른 생성자를 만들 수 있음.
package src;

public class ThisCall {
	//field
	int a;
	int b;
	
	
	//setter, getter
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	// constructor
	public ThisCall() {
		this(0,0);
	}

	public ThisCall(int a) {
	//	this.a = a;
		this(a,0); //=>얘를 불러서 정수 두개 받는 생성자로 자동 호출됨..!! 
	}

	public ThisCall(int a, int b) {
		this.a = a;
		this.b = b;
	}//이 괄호 닫히기 전에 this 호출 해서 다른 생성자 호출 가능

	public static void main(String[] args) {

		ThisCall th = new ThisCall();
		ThisCall th2 = new ThisCall(10);
		ThisCall th3 = new ThisCall(20, 30);

		System.out.println(th.getA() + "," + th.getB());
		System.out.println(th2.getA() + "," + th2.getB());
		System.out.println(th3.getA() + "," + th3.getB());
	}

}
