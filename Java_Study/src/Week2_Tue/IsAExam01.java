package Week2_Tue;
//슈퍼클래스와 서브클래스가 관계를 맺고 있음
//subclass 는 superclass 의 한 파트가 됨
//토끼<포요류<동물  : 단계가 내려갈수록 구체화/세분화 됨
//superclass 는 subclass 의 공통된 특징을 넣음 있음 =>코드의 양이 줄어듬
//공통된 것을 슈퍼클래스에 넣어야함. 지금 당장은 공통된 게 없더라도 확장성을 고려해서 만들기.
//자바 = 객체(클래스)간에는 다중상속 불가 /but, 인터페이스는 다중상속 가능
//오버라이딩 : 부모와 자식이 같은 것을 가지고 있는 것(같은 모양으로)
/*
 * is ~ a 관계 : 상속관계
 * extends : 상속 표현 
 * 객체(클래스)끼리는 단일 상속만 허용한다.(모호성)
 * 문법 : 서브클래스명 뒤에 상속받을 슈퍼클래스 이름을 명시
 * 상속을 받았다고 해도 부모의 private 은 접근 불가 (캡술화) / 대신 setter, getter 를 만들어서 줌.
 * 자식 레퍼런스 변수명.뒤에 메소드 할필요 없이(hasA 관계) 이름쓰고 쓰면 됨.
 * 상속의 장점 : 
 * 상속의 단점 : 있는 그대로만 사용 가능. (HasA -> 학생 한명의 데이터 입력칸을 만들어 놓은 것을 배열로도 사용가능)
 */

/*
 * 오버라이딩(다형성) : 부모의 메소드와 '똑같은' 형태로 제공 / 오버로딩은 구분을 위해 다른 형태여야 함
 * 부모의 내용을 수정해서, 가공해서 제공하고자 할 경우 
 * 동적바인딩 할 때 오버라이딩을 무조건 써야함. 
 */

/*
 * 	super, super()
 * 
 * 	1. super : 	부모의 멤버를 사용하고자 할 때 사용
 * 				오버라이딩 된 멤버를 사용할 때 부모를 명시적으로 적용하기 위해서 사용
 * 	2. super() :	부모의 생성자를 호출
 * 					항상 sub class의 생성자 첫번째 라인에 존재하고
 * 					명시적으로 사용이 가능하나 위치는 변경할 수 없다. 
 */

class A{
	public A() {
		//super(); //생략되어있음~~ 내부적으로 알아서 처리
		System.out.println("super class");
		
	}
	
	public String toString() {		//A에서 오버라이딩
	return super.toString()+" Superman";        
	}
	public void disp() {
		System.out.println("A");
	}
}


public class IsAExam01 extends A {  //모든 클래스명 뒤에 extends Object  이게 생략되어있음.
	
	
//	public String toString() {		//부모(Object)에 있던 toString 메소드의 형태를 가져와서 내꺼에서 새로 코딩시 내꺼가 우선.
//	        return super.toString()+" Superman"; //super를 붙이면 superclass의 메소드를 접근함.       
//	    }
	
	public IsAExam01() {
		//부모의 생성자를 호출
		super(); //생략되어 있는 문구(부모의 디폴트 생성자를 호출하겠다.) -> 생략되어 있는 것을 표현해도 문제 없지만
		// 다른 동작을 먼저 실행하고 부모 호출은 불가(오류발생)
		System.out.println("sub class");
	}
	 
	public static void main(String[] args) {
		IsAExam01 isa = new IsAExam01();
		System.out.println(isa); //객체가 가지고 있는 게 많은데 출력하라고 입력하면 원래는 오류나는 게 맞지만 레퍼런스 주소가 출력됨.
		System.out.println(isa.toString()); //생략되어있는 문구, 이 부분은 object가 가지고 있는 함수임. (내부적으로 처리)
		
		isa.disp(); //상속받으면 외부 클래스 명 . 이렇게 할 필요 없이 내꺼처럼 쓸 수 있음.
		isa.toString();
		
	}
}
