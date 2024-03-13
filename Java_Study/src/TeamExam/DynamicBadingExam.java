package TeamExam;


class Halbe{
	public void disp() {
		System.out.println("Halbe");
	}
	
}

class Abe extends Halbe{
	public void disp() {
		System.out.println("Abe");
	}
	public void dispAbe() {
		System.out.println("dispAbe");
	}
}

class Me extends Abe{
	public void disp() {
		System.out.println("Me");
	}
	public void dispAbe() {
		System.out.println("dispMe");
	}
}






public class DynamicBadingExam {
	public static void main (String [] args) {
		
		Me me = new Me();
		me.disp();
		
		Abe abe = new Abe();
		abe.disp();
		
		Halbe halbe = new Halbe();
		halbe.disp();
		
		halbe = abe ; // 동적바인딩
		halbe.disp();
		
		halbe = me;  //동적바인딩
		halbe.disp();
		
	//	halbe.dispAbe(); 수퍼클래스가 모르는 메소드는 실행 불가.
		
		abe.dispAbe();
		abe = me;
		abe.dispAbe();
		
		
	}
}
