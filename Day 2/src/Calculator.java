import java.util.Scanner;

public class Calculator {

	// field

	private int i, j; // 계산할 두개의 숫자 i, j 선언
	private char aa, bb;// 부호를 받는 aa와 계속 계산할지 질문하는 것의 대답을 받아오는 bb 선언
	private double r;
	Scanner sc = new Scanner(System.in);

	// 디폴트생성자
	public Calculator() {
	}

	// 생성자 함수
	public Calculator(int a, char c, int b) { // 계산할 값을 기본으로 넣는 생성자
		i = a;
		aa = c;
		j = b;
	}

	// setter
	public void setI(int a) {
		i = a;
	}

	public void setj(int a) {
		j = a;
	}

	public void setAa(char g) {
		aa = g;
	}

	// getter
	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	public char getAa() {
		return aa;
	}

	// main 함수

	public static void main(String[] args) {

		Calculator cal = new Calculator();

		int i = cal.input1();
		char aa = cal.input2();
		int j = cal.input1();
		cal.calculate(aa, i, j);

	}

	public int input1() { // 숫자를 입력받는 메소드
		System.out.print("계산할 숫자 입력 : ");

		int a = sc.nextInt();
		return a;
	}

	public char input2() { // 문자를 입력받는 메소드
		System.out.print("계산할 부호 입력 : ");
		char a = sc.next().charAt(0);
		return a;
	}

	public double plus(int a, int b) {
		return r = a + b;
	}

	public int minus(int i, int j) { // 더하기 메소드
		return i - j;
	}

	public int multiplication(int i, int j) { // 곱하기 메소드
		return i * j;
	}

	public double division(int i, int j) { // 나누기 메소드
		return (double) i / j;
	}

	public void calculate(char a, int i, int j) {
		// 어떤 계산 메소드를 실행할지 판단하는 메소드

		double r = 0;
		switch (a) {
		case '+': // 계산부호가 '+'이면 plus 메소드 실행
			r = plus(i, j);
			break;
		case '-': // 계산부호가 '-'이면 minus 메소드 실행
			r = minus(i, j);
			break;
		case '*': // 계산부호가 '*'이면 multiplication 메소드 실행
			r = multiplication(i, j);
			break;
		case '/': // 계산부호가 '/'이면 division 메소드 실행
			r = division(i, j);
			break;
		default: // 계산 부호가 사칙연산이 아니면 "잘못된 입력" 출력
			System.out.println("잘못된 입력. 잘못된 입력으로 인해 결과값은 0으로 표시되며 에러 발생하였습니다.");
		}
		print(a, i, j, r); // 계산 값을 반환
	}

	public void print(char a, int i, int j, double r) { // 출력 메소드
		if (r % 1 != 0) { // 실수일 경우 double 형식으로 출력
			System.out.println(i + "" + a + "" + j + "=" + r + "입니다.");
		} else { // 정수일 경우 int 형식으로 출력
			System.out.println(i + "" + a + "" + j + "=" + (int) r + "입니다.");
		}
	}
}
