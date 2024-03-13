package Week2_Wed;

class InterExam01 implements CCC{
	int a = 10;
	
	
 public void disp() { //추상메소드지만 abstract 생략가능 : 어차피 추상메소드밖에 못쓰니까
	 System.out.println("disp");
 }


@Override
public void disp2() {
	 System.out.println("disp2");
	
}
	
	public static void main(String [] args) {
		InterExam01 inf = new InterExam01();
		CCC inter = new InterExam01();
		
		
		inter.disp();  //동적바인딩  //interface AAA가 가지고 있어서 그걸 상속받는 ccc를 만들면 동적바인딩 가능.
		inter.disp2(); //동적바인딩 //interface CCC가 가지고 있어서 그걸 상속받는 ccc를 만들면 동적바인딩 가능.
		// inter.disp3();  // 얘는 동적바인딩 불가.  왜냐면 CCC는 disp3을 몰라서.
		inf.disp3(); //정적바인딩
	}
	
	
	public void disp3() {
		 System.out.println("disp3");
		}
}
