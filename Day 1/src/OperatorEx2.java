import java.util.Scanner;

public class OperatorEx2 {

	public static void main(String[] args) {

		Scanner sc;
		sc = new Scanner(System.in);

		System.out.print("첫번째 수 입력 : ");
		int a = sc.nextInt();
		System.out.print("연산 입력 : ");
		char c = sc.next().charAt(0);
		System.out.print("두번째 수 입력 : ");
		int b = sc.nextInt();

		if (c == '+') {
			System.out.println(a + "" + c + "" + b + "=" + (a + b));
		} else if (c == '-') {
			System.out.println(a + "" + c + "" + b + "=" + (a - b));
		} else if (c == '*') {
			System.out.println(a + "" + c + "" + b + "=" + (a * b));
		} else if (c == '/') {
			System.out.println(a + "" + c + "" + b + "=" + ((double) a / b));
		} else

			System.out.println("잘못된 입력");
	}
}