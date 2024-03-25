import java.util.Scanner;

import src.StarExam;

public class StarExam {
	public static void main(String[] args) {
		StarExam se = new StarExam();
		se.runProgram();
		
	}
	
	
	
	void runProgram() {

		char an;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("몇번 모양의 별을 실행하시겠습니까?(1~6 중 선택)");
			int num1 = sc.nextInt();

			switch (num1) {
			case 1:
				star1();
				break;
			case 2:
				star2();
				break;
			case 3:
				star3();
				break;
			case 4:
				star4();
				break;
			case 5:
				star5();
				break;
			case 6:
				star6();
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			}

			System.out.println("계속하시겠습니까? (Y/N)");
			an = sc.next().charAt(0);
		} while (an == 'y' || an == 'Y');
		System.out.println("고생하셨습니다.");
	}
	

	public void star1() {
		int a = 0;
		while (a < 3) {
			int b = 0;
			while (b < 3) {
				System.out.print("*");
				b++;
			}
			a++;
			System.out.println();
		}
	}

	public void star3() {
		int a = 1;
		while (a < 4) {

			int b = 3;
			while (b > a) {
				System.out.print(" ");
				b--;
			}
			int c = 0;
			while (c < a) {
				System.out.print("*");
				c++;
			}
			a++;
			System.out.println();
		}

	}

	public void star2() {
		int a = 1;
		while (a < 4) {
			int b = 0;
			while (b < a) {
				System.out.print("*");
				b++;
			}
			a++;
			System.out.println();
		}

	}

	public void star4() {
		int a = 2, b = 3; // a는 별 앞에 넣을 공백, b는 별 뒤쪽 공백

		for (int i = 1; i <= 3; i++) { // 3행 생성
			for (int j = 1; j < 6; j++) { // 5열 생성
				if (j <= a) { // 별 앞에 공백 생성(2부터 줄어들게 처리)
					System.out.print(" ");
				} else if (j > b) { // 별 찍기 이후에는 아무것도 출력하지 않음
					System.out.print("");
				} else {
					System.out.print("*");
				}
			}
			a--; // 별 개수 두개씩 증가
			b++; // 별 개수 두개씩 증가
			System.out.println(); // 줄 바꿈
		}
	}

	public void star5() {
		int a = 3, b = 3; // a는 앞쪽 공백, b는 관리 목적

		for (int i = 1; i <= 5; i++) { // 5행 생성
			for (int j = 1; j < 6; j++) { // 5열 생성
				if (j < a) { // 앞쪽 공백 찍기
					System.out.print(" ");
				} else if (j > b) { // 별 찍은 뒤에는 아무것도 출력하지 않음.
					System.out.print("");
				} else { // 별 찍기
					System.out.print("*");
				}
			}

			if (i < 3) { // 2행까지 별 개수를 늘림.
				a--;
				b++;
			} else { // 3행부터 별개수를 줄임.
				a++;
				b--;
			}
			System.out.println();
		}
	}

	public void star6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇층짜리를 출력하시겠습니까? (홀수를 입력하세요) : ");
		int count = sc.nextInt();
		int c = count / 2 + 1;
		if (count % 2 == 0) {
			System.out.println("입력오류");
		} else {

			int a = c, b = c; // a는 앞쪽 공백, b는 관리 목적

			for (int i = 1; i <= count; i++) { // 5행 생성
				for (int j = 1; j <= count; j++) { // 입력한 값 만큼의 열 생성
					if (j < a) { // 앞쪽 공백 찍기
						System.out.print(" ");
					} else if (j > b) { // 별 찍은 뒤에는 아무것도 출력하지 않음.
						System.out.print("");
					} else { // 별 찍기
						System.out.print("*");
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
