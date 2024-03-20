package Week3_Wed;

import java.util.Scanner;

public class QueueArray {
	int queue[];
	int front;
	int rear;

	// 생성자함수 Constructor
	public QueueArray() {
		queue = new int[5];
		front = 0;
		rear = 0;
	}

	void enQueue(int i) {
		shift();
		queue[rear] = i;
		rear++;
	}

	int deQueue() {
		int a;
		a = queue[front];
		queue[front] = 0;
		front++;
		return a;
	}

	void shift() {
		if (rear == 5 && front != 0) {
			for (int i = 0; i < rear - front; i++) {
				queue[i] = queue[i + front];
			}
			for (int i = rear - front; i < 5; i++) {
				queue[i] = 0;
			}
			rear -= front;
			front = 0;
		}
	}

	void printAll() {
		for (int i : queue)
			System.out.println(i);
	}

	void runProgram() {
		Scanner sc = new Scanner(System.in);
		char an;
		do {
			System.out.println("어떤 메소드를 실행하시겠습니까?");
			System.out.println("1.enqueue  2.dequeue 3.현재 배열 상태 출력");
			int ans = sc.nextInt();

			switch (ans) {
			case 1:
				System.out.println("저장할 값을 입력해주세요.");
				enQueue(sc.nextInt());
				break;
			case 2:
				System.out.println("출력값 : " + deQueue());
				break;
			default:
				printAll();
			}

			System.out.println("계속하시겠습니까?(Y/N)");
			an = sc.next().charAt(0);
		} while (an == 'y' || an == 'Y');
		System.out.println("고생하셨습니다.");
	}

	public static void main(String[] args) {
		QueueArray qa = new QueueArray();
		qa.runProgram();
	}
}
