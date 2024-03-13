package Week2_Wed;

public class InnerClassExam01 {

	private int a;


	
	
	public void dispInter() {
		new AAA() { // 얘가 anonymous inner class : 추상 클래스 또는 인터페이스는 원래 객체 생성불가
					// => 그걸 객체로 만들 수 있게 하는게 anonymous inner class / 대신 이너클래스만 가능.
					// 여기 AAA가 인터페이스일 수도 있고 추상 클래스일수도 있음.

			@Override // AAA안에 있는 추상적인 부분을 구체화(오버라이딩) 함.
			public void disp() {
				System.out.println(a);
			}
			// }; //이렇게 닫고 밑에서 호출해도 되고~ 밑처럼 이너클래스 만들고 바로 실행도 함.
		}.disp(); // 여기까지 이렇게 해서 일회성으로 사용할거야.
		
	}

	// 어나니머스는 일회성 작업을 할 때 사용 / 레퍼런스를 가지고 있을 필요가 없을 때
	// 필요할 때만 호출, 사용 후 가비지 콜렉터에 들어감.
	// 이너클래스는 아우터클래스를 직접 사용 : setter getter 를 사용하지 않음.

	public static void main(String[] args) {
		InnerClassExam01 inter = new InnerClassExam01();
		inter.dispInter();
	}

}
