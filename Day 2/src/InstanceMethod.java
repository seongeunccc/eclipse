import java.util.Scanner;

public class InstanceMethod {

	public static void main(String[] args) {

		int i, j; // 계산할 두개의 숫자 i, j 선언
		double r = 0;// 계산결과를 받는 함수 r 선언(나누기의 값을 받기위해 double로 선언함
		char a, b;// 부호를 받는 a와 계속 계산할지 질문하는 것의 대답을 받아오는 b 선언
		Scanner sc = new Scanner(System.in); // input 함수에서 사용할 스캐너

		InstanceMethod im = new InstanceMethod();
		
		do {
			i = Method.input1(sc);// 정수 i값 입력받기
			System.out.print("계산할 부호 입력 : ");
			a = Method.input2(sc);// 계산할 부호 입력받기
			j = Method.input1(sc);// 정수 j값 입력받기

			r = Method.calculate(a, i, j); // 어떤 연산을 적용할지 판단하는 calculate 함수 실행
			Method.print(a, i, j, r); // 출력함수 실행

			System.out.println("계산을 계속하시겠습니까?(Y/N)");	//계산을 계속 진행할 지 질문 출력
			b = Method.input2(sc); // 대답을 b에 저장하고 Y일 경우 do~while 문 반복 실행
		} while (b == 'Y' || b == 'y');

		System.out.println("고생하셨습니다. 계산을 다시 진행하고 싶으시면 프로그램을 다시 실행해주세요."); //y가 아닐 경우 안내문 출력 후 종료
	}

	public static int input1(Scanner sc) { // 숫자를 입력받는 메소드
		System.out.print("계산할 숫자 입력 : ");
		int a = sc.nextInt();
		return a;
	}

	public static char input2(Scanner sc) { // 문자를 입력받는 메소드
		char a = sc.next().charAt(0);
		return a;
	}

	public static int plus(int i, int j) { // 더하기 메소드
		return i + j;
	}

	public static int minus(int i, int j) { // 더하기 메소드
		return i - j;
	}

	public static int multiplication(int i, int j) { // 곱하기 메소드
		return i * j;
	}

	public static double division(int i, int j) { // 나누기 메소드
		return (double) i / j;
	}

	public static double calculate(char a, int i, int j) {
		// 어떤 계산 메소드를 실행할지 판단하는 메소드

		double r = 0;
		switch (a) {
		case '+': // 계산부호가 '+'이면 plus 메소드 실행
			r = Method.plus(i, j);
			break;
		case '-': // 계산부호가 '-'이면 minus 메소드 실행
			r = Method.minus(i, j);
			break;
		case '*': // 계산부호가 '*'이면 multiplication 메소드 실행
			r = Method.multiplication(i, j);
			break;
		case '/': // 계산부호가 '/'이면 division 메소드 실행
			r = Method.division(i, j);
			break;
		default: // 계산 부호가 사칙연산이 아니면 "잘못된 입력" 출력
			System.out.println("잘못된 입력. 잘못된 입력으로 인해 결과값은 0으로 표시되며 에러 발생하였습니다.");
		}
		return r; // 계산 값을 반환
	}

	public static void print(char a, int i, int j, double r) { // 출력 메소드
		if (r % 1 != 0) { // 실수일 경우 double 형식으로 출력
			System.out.println(i + "" + a + "" + j + "=" + r + "입니다.");
		} else { // 정수일 경우 int 형식으로 출력
			System.out.println(i + "" + a + "" + j + "=" + (int) r + "입니다.");
		}
	}

}
