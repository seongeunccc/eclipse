package Week2_Wed;
/*
 * 	inner class : outer class의 멤버를 내 것처럼 사용할 수 있게 해주는 클래스. 
 * 				/ 관계를 가지고 있는 outer class가 private이어도 사용가능
 * 				: 특정 목적 : outer class 에 맞는 목적
 *				: event 처리시 주로 사용. 	빠르게 처리하기 위해서 만듬.			
 * 
 * 	1. member inner class
 * 	2. static inner class
 * 	3. local inner class
 * 	4. anonymous inner class // 익명의(이름이 없는)
 * 
 * 	[문법]
 *	
 * 
 * 	outer class
 * 	inner class
 * 
 */

public class InnerClassExam {
	
	private int a;
	private static int b;
	
	//얘는 1번 문법
	//클래스 안 에 있는게 멤버. 멤버로 클래스를 하나 더 만듬.
	class Test{
		public void disp() {
			System.out.println(a);		//private 인데 이너클래스로 작성하면 a, b 접근가능(getter/setter 없이)
			System.out.println(b);
		}
	}
	
	
	// 얘는 2번 이너클래스 2. static inner class  
	// static 으로 정의하면 프로그램 시작할 때 생성되어 있음. outer 없이 inner 만 정의되어있으면 오류남 
	// 아우터 클래스 중에 static 으로 정의되어 있는 것만 사용할 예정일 때 (이 경우에는 static 으로 정의되어있는 b만 사용할 때)
	// 	static inner class 은 위의 번거로움 때문에 잘 안씀. 주로 멤버 + 어나니머스 이너클래스를 자주 씀.
	static class Test1{
		public void disp() {
			// System.out.println(a);		//a는 static 이 아니라서 오류
			System.out.println(b);
		}
	}
	
	
	void dispTest() {
		// 3번 local inner class(지역 이너클래스)
		//dispTest()  이라는 메소드가 실행되어야만 호출가능
		class Test2{
			public void disp1() {
				System.out.println(a);	
				System.out.println(b);
			}
		}
		
		Test2 t2 = new Test2();		//local inner class 는 함수안에서 객체 생성을 해줘야 아우터에 접근 가능(지역에서 호출+사용)
		t2.disp1();
	}
	
	
	
	
	
	public static void main(String[] args) {
		InnerClassExam in = new InnerClassExam();
		Test t = in.new Test(); //member
		InnerClassExam.Test tt = new InnerClassExam().new Test();//위에 두줄을 이렇게 한줄로도 작성 가능. //member 이너클래스 호출
		Test1 t1 = new Test1(); //static
		
		t.disp();  //member
		tt.disp(); //member, 이렇게 써도 위와 같은 값 나옴.
		t1.disp(); //static
		in.dispTest(); //local
		
		

	}
}
