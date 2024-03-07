
import java.util.Scanner;

public class ArrayExam03 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇명의 성적을 처리하시겠습니까? (숫자로 입력)");
		int st = sc.nextInt();		//학생수를 받는 변수 st	
					
		String name[] = new String[st]; // 이름
		int score[][] = new int[st][4]; // 국,영,수,총점
		float[] avg = new float[st];

		
		System.out.println("이름을 입력하세요");
		for (int i = 0; i < st; i++) {		//입력할 학생 수 만큼의 이름 입력
			name[i] = sc.next();
		}

		for (int j = 0; j < st; j++) {	//학생 수 만큼 반복
			System.out.println("점수를 입력하세요.(국어, 영어, 수학 순서로)");

			for (int i = 0; i < 3; i++) {//국,영, 수 성적을 score 함수에 넣음
				score[j][i] = sc.nextInt();
				score[j][3] += score[j][i];
			}
			avg[j] = score[j][3] / 3.f;	//학생별 성적 총점 구하기
		}

		for (int j = 0; j < st; j++) {		//값 출력하기(학생 수 만큼)
			System.out.print(name[j] + "\t");
			for (int i = 0; i < 4; i++) {
				System.out.print(score[j][i] + "\t");
			}
			System.out.print(avg[j] + "\n");
		}
	}
}
