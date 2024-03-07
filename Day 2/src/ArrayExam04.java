
//학생성적관리함수,  성적관리 다차원배열 함수 나누기 및 학생 수 정의
import java.util.Scanner;

public class ArrayExam04 {
	// field
	String name[] = null;
	int score[][] = null;
	float[] avg = null;
	Scanner sc = new Scanner(System.in);

	// constructor

	public ArrayExam04() {
	}

	public ArrayExam04(int num) {
		this.name = new String[num];
		this.score = new int[num][4];
		avg = new float[num];
	}

	//메인 함수
	public static void main(String[] args) {

		System.out.println("몇명의 성적을 처리하시겠습니까? (숫자로 입력)");

		Scanner sc = new Scanner(System.in);
		int num = ArrayExam04.input1(sc); // 정수를 입력받는 함수를 실행하여 학생수를 입력 받음.

		ArrayExam04 ae = new ArrayExam04(num);

		ae.setName(num);
		ae.setScore(num);
		ae.print(num);
	}

	// 함수 //
	// 배열 name 에 값을 입력해주는 함수
	public void setName(int a) {
		for (int i = 0; i < a; i++) {
			System.out.println(i + 1 + "" + "번째 학생 이름을 입력하세요");
			name[i] = ArrayExam04.input2(sc);
		}
	}
	// 배열 score 에 값을 입력해주는 함수
	public void setScore(int a) {
		for (int j = 0; j < a; j++) {
			System.out.println(j + 1 + "" + "번째 학생 점수를 입력하세요.(국어, 영어, 수학 순서로)");
			for (int i = 0; i < 3; i++) {// 국,영, 수 성적을 score 함수에 넣음
				score[j][i] = ArrayExam04.input1(sc);
				score[j][3] += score[j][i];
			}
			avg[j] = score[j][3] / 3; //한 학생의 점수를 모두 입력하면 평균 값을 계산해서 avg 배열에 값을 입력함.
		}
	}
	
	// 학생 수 만큼 값 출력하기
	public void print(int a) {
		System.out.println();
		for (int j = 0; j < a; j++) { 
			System.out.print(name[j] + "\t");
			for (int i = 0; i < 4; i++) {
				System.out.print(score[j][i] + "\t");
			}
			System.out.print(avg[j] + "\n");
		}
	}

	// 정수를 입력 받는 Input 함수
	public static int input1(Scanner sc) {
		int a = sc.nextInt();
		return a;
	}

	// 문자열을 입력 받는 Input 함수
	public static String input2(Scanner sc) {
		String a = sc.next();
		return a;
	}
}