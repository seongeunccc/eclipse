/*
 * 세명의 성적 처리 프로그램
 */

import java.util.Scanner;

public class ArrayExam02 {
	public static void main(String[] args) {

		String name[] = new String[3]; // 이름
		int score[][] = new int[3][4]; // 국,영,수,총
		float[] avg = new float[3];

		Scanner sc = new Scanner(System.in);

		// 입력 이름 국어 영어 수학
		// 연산 총, 평
		// 출력 : 이름,국어, 영어, 수학, 총점 평균

		System.out.println("학생 세 명의 이름을 입력하세요");
		for (int i = 0; i < 3; i++) {
			name[i] = sc.next();
		}

		for (int j = 0; j < 3; j++) {
			System.out.println(j+1 + "번째 학생의 점수를 입력하세요");
			System.out.println("국어, 수학, 영어 순으로");

			for (int i = 0; i < 3; i++) {
				score[j][i] = sc.nextInt();
				score[j][3] += score[j][i];
			}
			avg[j] = score[j][3] / 3.f;
		}

		for (int j = 0; j < 3; j++) {
			System.out.print(name[j] + "\t");
			for (int i = 0; i < 4; i++) {
				System.out.print(score[j][i] + "\t");
			}
			System.out.print(avg[j] + "\t" + "\n");
		}
	}
}
