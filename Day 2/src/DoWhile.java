import java.util.Scanner;

public class DoWhile {
	public static void main(String[] args) {
		Scanner sc;
		sc = new Scanner(System.in);

		char q; // 문자형 변수 q 선언(계산을 계속할지 묻는 답을 받는 변수)
		int a, b; // 계산할 숫자를 받을 변수 a,b 선언
		char c; // 계산할 부호 받을 변수 c 선언

		do { // 사칙연산 계산기 실행
			System.out.print("첫번째 수 입력 : ");
			a = sc.nextInt();
			System.out.print("연산 입력 : ");
			c = sc.next().charAt(0);
			System.out.print("두번째 수 입력 : ");
			b = sc.nextInt();

			if (c == '+') {
				System.out.println(a + "" + c + "" + b + "=" + (a + b));
			} else if (c == '-') {
				System.out.println(a + "" + c + "" + b + "=" + (a - b));
			} else if (c == '*') {
				System.out.println(a + "" + c + "" + b + "=" + (a * b));
			} else if (c == '/') {
				System.out.println(a + "" + c + "" + b + "=" + ((double) a / b));
			} else {

				System.out.println("잘못된 입력");
			}
			System.out.print("계속하시겠습니까?(Y/N) : ");
			q = sc.next().charAt(0);

		} while (q == 'y' || q == 'Y');
		if (q == 'n' || q == 'N') {
			System.out.println("고생하셨습니다.");
		} else {
			System.out.println("오류; 잘못된 입력. 다시 실행하세요");
		}
	}
}