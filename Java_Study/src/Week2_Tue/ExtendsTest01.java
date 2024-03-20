package Week2_Tue;

import java.util.Scanner;
/*
//동적 바인딩 : '상속관계'일 때 부모 클래스에서 자식 클래스에 접근할 수 있게 하는.
 * 상위클래스가 하위클래스에 접근할 수 있는 것 
 * 단 부모가 알고있는 범위까지만 접근이 가능.
 * 자식 클래스 : 부모 클래스 + a => 부모 클래스에서 자식클래스 접근 허용
 * 
*/

abstract class Memory {

	// 상속해줄 멤버들
	int[] arr = new int[5]; // 5칸짜리 배열

	void push(int a) { //입력하는 방법은 같음.
		arr[index] = a;
		index++;
	} 
	abstract int pop(); // 추상 메소드 pop(꺼내는 방법이 다름)

	int index = 0; // 입력할 위치를 찾는 인덱스
}

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
		int r = arr[0];
		for (int i = 0; i < index; i++) {
			arr[i] = arr[i + 1];
		}
		arr[--index] = 0;

		return r;
	}
}

public class ExtendsTest01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyStack ms = new MyStack();	//내꺼 타입으로 내꺼 접근  : 정적 바인딩 (myStack 형태로 myStack 만듬)
		MyQueue mq = new MyQueue();

		
		char an;

		do {
			System.out.println("어떤 것을 선택하시겠습니까?");
			System.out.println("1.Stack  2.Queue 3.현재 정보 출력");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("어떤 메소드를 실행하시겠습니까?");
				System.out.println("1.push  2.pop");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("push 할 값을 입력해주세요.(정수로 입력)");
					ms.push(sc.nextInt());
					break;
				case 2:
					System.out.println(ms.pop());
					break;
				}
				break;
			case 2:
				System.out.println("어떤 메소드를 실행하시겠습니까?");
				System.out.println("1.push  2.pop");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("push 할 값을 입력해주세요.(정수로 입력)");
					mq.push(sc.nextInt());
					break;
				case 2:
					System.out.println(mq.pop());
					break;
				}
				break;
			case 3:
				System.out.println("============================= stack");
				for (int i = 0; i < 5; i++) {
					System.out.println(ms.arr[i]);
				}
				System.out.println("============================= queue");
				for (int i = 0; i < 5; i++) {
					System.out.println(mq.arr[i]);
				}
				;
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			}
			System.out.println("계속하시겠습니까?(Y/N)");
			an = sc.next().charAt(0);
		} while (an == 'y' || an == 'Y');
		System.out.println("고생하셨습니다.");

	}

}
