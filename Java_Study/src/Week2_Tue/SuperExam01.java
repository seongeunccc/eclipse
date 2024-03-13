package Week2_Tue;

/*
//상속은 공통정보를 부모가 가지고 있고 자식이 받아서 씀
 * 공통된 내용이긴 한데 자식마다 내용이 좀 다를 떄
//맘에 안들면 자식이 오버라이딩
//강제성 부여 가능 (이 메소드는 받으면 무조건 오버라이딩 해야한다.(superclass에서 강제성 부여할 수 있음.)
// = 추상메소드( superclass 에서 가지고 있음)
//추상클래스 == 추상 메소드를 한개 이상 가지고 있는 클래스 / 상속을 목적으로 하는 클래스(superclass)
 * superclass : 내가 껍데기 만들테니까 너네가 오버라이딩해서 사용해라..! 
 * : 오버라이딩을 안하면 상속받은 클래스도 추상클래스가 되버림. : 꼭 오버라이딩 해야하는 강제성 부여됨. 
 * "추상클래스는 객체 생성 불가" : 직접적으로 클래스 사용 불가
 * 사용방법 1 : 상속받기
 * 사용방법 2 : 이너클래스(어나니머스 이너클래스 : 익명 내부클래스)에서 사용 : 이번주에 곧 배운다고 하심.
*/

//접근지정자 따로 지정 안하면 default : 같은 패키지 까지만 사용가능
class AA {

	private int a; // 10

	public AA(int num1) {
		a = num1;
	}
	
	public int getA() {
		return a;
	}

}

class BB extends AA {

	private int b; // 20

	public BB(int num1, int num2) {
		super(num1);
		this.b = num2;
	}
	public int getB() {
		return b;
	}
}

class CC extends BB {
	private int c; // 30

	public CC(int num1, int num2, int num3) {  //자식의 생성자함수 첫 줄에는 부모의 디폴트 생성자를 호출하는 내용이 생략되어 있음.
		//super 호출로 생성자 컨트롤 가능하다.
		super(num1, num2);
		this.c = num3;
	}

	public int getC() {
		return c;
	}
}

public class SuperExam01 {
	public static void main(String[] args) {

		CC cc = new CC(10, 20, 30);
		System.out.println(cc.getA());
		System.out.println(cc.getB());
		System.out.println(cc.getC());
		
	}
}