package Day4;

import java.util.Scanner;

public class ClassExamFin {
	// field
	int num1, num2;
	char a;
	double result;
	Scanner sc = new Scanner(System.in);

	// constructor
	public ClassExamFin() {

	}

	public ClassExamFin(int num1, char a, int num2) {
		this.num1 = num1;
		this.a = a;
		this.num2 = num2;
	}

	// setter, getter
	public int setNum() {
		System.out.println("계산할 숫자를 입력하세요.");
		return sc.nextInt();
	}

	public char setA() {
		return sc.next().charAt(0);
	}

	public double getRseult() {
		return result;
	}

	public void setResult(double i) {
		this.result = i;
	}

	public static void main(String[] args) {
		ClassExamFin cef = new ClassExamFin();
		char answer ;
		do {
			cef.num1 = cef.setNum();
			System.out.println("계산할 부호를 입력하세요.");
			cef.a = cef.setA();
			cef.num2 = cef.setNum();
			cef.calculate(cef.a, cef.num1, cef.num2);
			cef.print();
			System.out.println("계산을 계속하시겠습니까?(Y/N)");
			answer = cef.setA();
		} while (answer == 'Y' || answer == 'y');
		System.out.println("고생하셨습니다.");
	}

	// method
	// 계산을 실행하는 메소드
	public int plus(int i, int j) {
		return i + j;
	}

	public int minus(int i, int j) {
		return i - j;
	}

	public int multiplication(int i, int j) {
		return i * j;
	}

	public double division(int i, int j) {
		return (double) i / j;
	}

	// 어떤 계산 메소드를 실행할지 판단하는 메소드
	public double calculate(char a, int i, int j) {

		switch (a) {
		case '+': // 계산부호가 '+'이면 plus 메소드 실행
			setResult(plus(i, j));
			break;
		case '-': // 계산부호가 '-'이면 minus 메소드 실행
			setResult(minus(i, j));
			break;
		case '*': // 계산부호가 '*'이면 multiplication 메소드 실행
			setResult(multiplication(i, j));
			break;
		case '/': // 계산부호가 '/'이면 division 메소드 실행
			setResult(division(i, j));
			break;
		default: // 계산 부호가 사칙연산이 아니면 "잘못된 입력" 출력
			System.out.println("잘못된 입력. 잘못된 입력으로 인해 결과값은 0으로 표시되며 에러 발생하였습니다.");
		}
		return getRseult(); // 계산 값을 반환
	}

	// 출력 메소드
	public void print() {
		System.out.println("계산 결과는 " + this.result + "입니다.");
	}

}