package Test;
import java.util.Scanner;

//상속스텍큐+유효성검사//

/*
//동적 바인딩 : '상속관계'일 때 부모 클래스에서 자식 클래스에 접근할 수 있게 하는.
 * 부모의 레퍼런스로 자식에 접근하는 것.
 * 상위클래스가 하위클래스에 접근할 수 있는 것 
 * 단 부모가 알고있는 범위까지만 접근이 가능.
 * 자식 클래스 : 부모 클래스 + a => 부모 클래스에서 자식클래스 접근 허용
 * 클래스 이름 앞에 Final 을 붙이면 상속이 불가능한 클래스
 * 메소드에 final 을 붙이면 오버라이딩이 불가
 * 변수에 붙이면 상수화됨.
 * 수퍼클래스를 잘 만들어야 상속받을 때 좋음 => 객체를 만들 때 잘 만들어라.
 * this. / super. => 상속시 부모의 객체(?)에 접근하고 싶을 때 (오버라이딩으로 내께 달라졌을 때)super.을 붙여서 사용
*/

//SuperClass
abstract class Memory {
	// 상속해줄 멤버들
	int[] arr = new int[5]; // 5칸짜리 배열
	int index = 0; // 입력할 위치를 찾는 인덱스

	void push(int a) { // 입력하는 방법은 같음.
		arr[index] = a;
		index++;
	}

	abstract int pop(); // 추상 메소드 pop(꺼내는 방법이 다름, 수퍼클래스에서는 틀만 정의함)
}

//SubClass
//stack 클래스 => 마지막에 입력한 값 출력 (pop 할 때)
class MyStack extends Memory {
	int pop() {
		index--;
		int r = arr[index];
		arr[index] = 0;
		return r;
	}
}

//Queue 클래스 => 제일 먼저 입력한 값 출력 (pop 할 때)
class MyQueue extends Memory { // 선입선출 Queue 클래스
	int pop() {
		int r = arr[0];//pop실행시 배열의 첫칸을 반환
		for (int i = 0; i < index; i++) { //한칸 반환 후 배열의 정보를 앞으로 한칸씩 당김.
			if(index==5) {  //5번칸까지 찼을 경우 6번칸이 없기 때문에 에러 발생, 예외처리.
				arr[4]=0; // 배열이 꽉 찬 상태에서 맨 앞칸 배출하면 마지막 칸은 0으로 초기화함.
			}else {
			arr[i] = arr[i + 1];//배열의 정보를 한칸씩 당김
			}
		}
		arr[--index] = 0;
		return r;
	}
}

public class Test001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyStack ms = new MyStack(); // 내꺼 타입으로 내꺼 접근 : 정적 바인딩 (myStack 형태로 myStack 만듬)
		MyQueue mq = new MyQueue();
		Memory m; //동적바인딩(슈퍼클래스에서 서브클래스 접근)

		char an;

		do {
			System.out.println("어떤 것을 선택하시겠습니까?");
			System.out.println("1.Stack  2.Queue ");
			int answer = sc.nextInt();
			if (answer == 1) {
				m = ms;
			} else  {
				m = mq;
			}
			System.out.println("어떤 메소드를 실행하시겠습니까?");
			System.out.println("1.push  2.pop 3.현재 정보 출력");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("push 할 값을 입력해주세요.(정수로 입력)");
				m.push(sc.nextInt());
				break;
			case 2:
				System.out.println(m.pop());
				break;
			case 3 :
					System.out.println("=============================");
					for (int i = 0; i < 5; i++) {
						System.out.println(m.arr[i]);
					}break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
			System.out.println("계속하시겠습니까?(Y/N)");
			an = sc.next().charAt(0);
		} while (an == 'y' || an == 'Y');
		System.out.println("고생하셨습니다.");
	}
}
