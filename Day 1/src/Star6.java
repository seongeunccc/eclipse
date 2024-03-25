import java.util.Scanner;

public class Star6 {

	public static void main(String[] args) {

		Scanner sc;
		sc = new Scanner(System.in);

		System.out.print("몇 층짜리를 출력하시겠습니까? (홀수를 입력하세요) : ");
		int count = sc.nextInt();
		int c = count / 2 + 1;
		if (count % 2 == 0) {
			System.out.println("입력오류");
		} else {

			int a = c, b = c; // a는 앞쪽 공백, b는 관리 목적

			for (int i = 1; i <= count; i++) { // 5행 생성
				for (int j = 1; j <= count; j++) { // 입력한 값 만큼의 열 생성
					if (j < a) { // 앞쪽 공백 찍기
						System.out.print("  ");
					} else if (j > b) { // 별 찍은 뒤에는 아무것도 출력하지 않음.
						System.out.print("");
					} else { // 별 찍기
						System.out.print("* ");
					}
				}

				if (i < c) { // 2행까지 별 개수를 늘림.
					a--;
					b++;
				} else { // 3행부터 별개수를 줄임.
					a++;
					b--;
				}
				System.out.println();
			}
		}
	}
}