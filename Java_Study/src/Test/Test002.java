package Test;
import java.util.Scanner;

//상속스텍큐+유효성검사//
//front top 으로 유효성 검사하기//


//SuperClass
abstract class Memory1 {
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
class MyStack1 extends Memory1 {
	int pop() {
		index--;
		int r = arr[index];
		arr[index] = 0;
		return r;
	}
}

//Queue 클래스 => 제일 먼저 입력한 값 출력 (pop 할 때)
class MyQueue1 extends Memory1 { // 선입선출 Queue 클래스
	int front=0;
	
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

public class Test002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyStack1 ms = new MyStack1(); // 내꺼 타입으로 내꺼 접근 : 정적 바인딩 (myStack 형태로 myStack 만듬)
		MyQueue1 mq = new MyQueue1();
		Memory1 m; //동적바인딩(슈퍼클래스에서 서브클래스 접근)

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
