package Day4;

class AA{
	int aa;
	
	public int getAa() {
		return aa;
	}
	public void setAa(int aa) {
		this.aa = aa;
	}
}


class BB{
	int aa;
	
	public int getAa() {
		return aa;
	}
	public void setAa(int aa) {
		this.aa=aa;
	}
}

class CC{
	int aa;
	
	public int getAa() {
		return aa;
	}
	public void setAa(int aa) {
		this.aa=aa;
	}
}



public class HasA2 {
	
	private AA aa;
	private BB bb;
	private CC cc;
	
	void setAA(AA aa) {
		this.aa = aa;  //외부에서 만듬 aa에 접근하는 변수
		bb = new BB();
		cc = new CC();
	}
	
	public static void main(String [] args) {
		
		HasA2 hasa2 = new HasA2();
		AA a = new AA();  // AA클래스를 불러옴
		//설계할 때 나만 쓸건지 같이 쓸건지 생각해서 객체를 사용하기도 함.  / 외부에서 만들어서 주입도 가능.
		
		hasa2.setAA(a);	//	hasa2.aa = a; 이렇게 써도 되지만 별로 좋은 코드가 아님
		
	}
}
