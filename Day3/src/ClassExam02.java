package src;

public class ClassExam02 {

	// field
	private int a;

	// constructor
	public ClassExam02() { // 디폴트생성자
		System.out.println("디폴트생성자");
	}

	public ClassExam02(int aa) { // 디폴트생성자 정수를 넣을 경우 필드를 초기화 하는 사용자 지정 옵션 적용 / 객체 생성시 원하는 값을 넣을 수 있음
		a = aa;
	}

	// method : setter(외부에서 주는 데이터를 입력하는 함수), getter(외부에서 필드 값을 얻어가는 함수) - 문법처럼 쓰이지만 문법은 아님
	
	public void setA(int num) {		//이건 걍 규칙처럼 외우기 / set+내가 입력할 필드이름 -> setA=아 a를 입력하는 함수구나 !
		a = num;
	}
	public int getA() {
		return a;
	}
	
	public static void main(String[] args) {

		ClassExam02 ce2 = new ClassExam02(); // 생성자호출
		ClassExam02 ce3 = new ClassExam02(); // 생성자호출
		ClassExam02 ce4 = new ClassExam02(); // 생성자호출
		
		//ce2.a = 500;  =>얘는 내부라서 가능한 코딩, 실제로 외부에서 하려면 setter를 만들어야 함.
		ce2.setA(0);
		ce3.setA(100);
		ce4.setA(500);
		
		System.out.println(ce2.getA());
		System.out.println(ce3.getA());
		System.out.println(ce4.getA());
	}
}

//객체가 새로 만들어졌기 때문에 생성자도 세개 만들어짐.
//main을 외부라고 생각하고 코딩하기 -> 그래야 외부에서 사용할 때도 오류가 안남. 
