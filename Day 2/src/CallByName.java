/*
 * Instance method
 * -객체 생성 후 사용할 수 있는 매소드
 * Static method
 * -객체 유무와 상관 없이ㅏ 사용할 수 있는 매소드
 * 
 * 주로 인스턴스 함수를 쓰고 static 함수는 필요할 때 불러와서 사용한다.
 * 메소드의 특징 => 처리가 끝나면 호출한 곳으로 돌아간다. 
 * 돌아가서 값을 받을지 줄지 주고받을지 주지않을 지는 판단해서 결정하기~
 * 
 */

public class CallByName {

	public static void main(String[] args) {

		CallByName.disp2();
		CallByName cbn = new CallByName();

		cbn.disp1();
		cbn.disp2();

		int num = 100;

		num = cbn.disp3(num); // 리턴 값 받으려면 '=' 을 써야 함.
		System.out.println(num);

		String str = new String("Superman"); // 얘는 객체라서 이걸 호출하려면 레퍼런스를 호출해야함(?)
		// System.out.println(str);

		cbn.disp4(str); // call by reference
	}

	public void disp4(String s) {
		System.out.println(s);
	}

	public int disp3(int num) { // 값을 주려면 void가 아니라 int 등 반환할 리턴 타입을 넣어야 함.
		System.out.println(num); // 1
		num++;
		System.out.println(num); // 2 disp3는 call by value

		return num; // 지역함수에서 계산한 num 값을 main으로 반환하려면 return을 써야 함.
	}

	public void disp1() { // call by name}
		System.out.println("call by name1");

	}

	public static void disp2() { // call by name}
		System.out.println("call by name2");
	}

}
