package Week2_Tue;
//추상클래스보다 더 추상화된 게 인터페이스.
//인터페이스는 추상메소드만 가지고 있음
//인터페이스는 자바의 꽃 ..?  

/*
 * 	추상클래스는 추상메소드를 하나 이상 가지고 있는 클래스이다.
 * 	추상클래스는 객체 생성을 할 수 없고, 상속을 해주는 목적으로 사용한다.
 * 	추상메소드는 서브클래스에 강제성을 부여(오버라이딩)
 * 	오버라이딩을 하지 않을 경우 서브 클래스도 추상클래스화 되서 객체를 생성할 수 없다. 
 * 
 * 	상속관계시 항상 공통된 것은 수퍼클래스에 정의
 * 	개념적으로는 수퍼에 있어야 하지만, 기능적으로는 수퍼클래스에 정의할 수 없을 때 만든다.
 * 
 */

abstract class Area{
	//  추상메소드/클래스임을 명시하는 키워드 : abstract
	public abstract void draw() ; //일반 인스턴스 메소드 만들듯이 하고 뒤에 그냥 괄호닫고 세미콜론
}

class Rect extends Area{
	public void draw() {
		System.out.println("Rect");
	}
}

class Circle extends Area{
	public void draw() {
		System.out.println("Circle");
	}
}
class Tri extends Area{

	@Override  // 에러 떠있는 거 눌러서 만들면 이런 표시 생김
	public void draw() {
		System.out.println("Tri");	
	}
}

public class AbsClassExam {

	public static void main(String[] args) {
		Tri tri = new Tri();
		tri.draw();
		
		Rect rect = new Rect();
		rect.draw();
		
		Circle cir = new Circle();
		cir.draw();

	}

}
