package March19Exam;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

 class OrderlyNumber {
	// field
	ArrayList<Integer> collate;
	ArrayList<Integer> numBCollate;
	int numA;
	int numB;

	// 생성자 함수
	public OrderlyNumber() {
		collate = new ArrayList<Integer>();
		numBCollate = new ArrayList<Integer>();
	}
	
	// 시작 값과 종료값을 설정하는 메소드
	void setNum() {
		Scanner sc = new Scanner(System.in);
		System.out.println("100~9,999,999 사이의 시작 값 A를 입력하세요.");
		numA = sc.nextInt();
		System.out.println("A~9,999,999 사이의 종료 값 B를 입력하세요.");
		numB = sc.nextInt();
	}

	// 100~9,999,999 사이의 시작값 numA를 입력받아 배열에 한자리씩 넣어주는 메소드
	void collateNum(int num) {
		collate.clear();
		Stack<Integer> stack = new Stack<Integer>();
		while (num > 0) {
			stack.push(num % 10);
			num = num / 10;
		}
		int i = 0;
		while ((!stack.isEmpty())) {
			collate.add(stack.pop());
			i++;
		}
	}

	// 입력한 숫자의 자릿수를 구하는 메소드
	int getDigit(int a) {
		numBCollate.clear();
		while (a > 0) {
			numBCollate.add(a % 10);
			a = a / 10;
		}
		return numBCollate.size();
	}

	// 출력메소드
	void printcollate() {
		System.out.print("입력한 시작값 : " + numA);
		System.out.print("\s 입력한 종료 값 : " + numB);

		System.out.println("\n정돈된 수: ");
		int count = 0;
		int count1 = 0;
		for (int i = numA; i < numB + 1; i++) {
			collateNum(i);
			int num1 = getDigit(i);
			count1 = 0;
			for (int j = 0; j < num1 - 1; j++) {
				if (collate.get(j) < collate.get(j + 1)) {
					count1++;
				}
			}
			if (num1 == count1 + 1) {//입력 받은 numA~numB사의 값 i가 정돈된 수면 화면에 출력
				System.out.print(i + "\s");
				count++;
				if (count % 10 == 0) {//이거는 그냥 10개씩 찍고 줄 바꿔주는 if 문
					System.out.println(" ");
				}
			}
		}
		System.out.println(" ");
		System.out.println("정돈된 수의 개수 : " + count);
	}

	void runProgram() {
		setNum();
		printcollate();
	}

	public static void main(String[] args) {
		OrderlyNumber on = new OrderlyNumber();
		on.runProgram();
	}
}
