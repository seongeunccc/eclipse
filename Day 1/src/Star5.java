
public class Star5 {

	public static void main(String[] args) {

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
}


/*
 * for (int a = 1; a < 6; a += 2) { for (int b = 5; b > a; b -= 2) {
 * System.out.print(" "); } for (int b = 0; b < a; b++) { System.out.print("*");
 * } System.out.println(); }
 * 
 * for (int a = 1; a < 6; a += 2) { for (int b = 0; b < a; b += 2) {
 * System.out.print(" "); } for (int b = 4; b > a; b--) { System.out.print("*");
 * } System.out.println(); }
 */