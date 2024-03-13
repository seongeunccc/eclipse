package Day4;

import java.util.Scanner;

public class AllStudent {

	StudentScoreHasA StudentScoreHasA;

	public AllStudent() {
		StudentScoreHasA = new StudentScoreHasA();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇명의 학생 성적을 입력하시겠습니까?(숫자만 입력)");
		int num = sc.nextInt();

		StudentScoreHasA[] stu = new StudentScoreHasA[num]; 
		// 배열을 선언해야 함. 배열로 처리하는 이유  = 일괄 처리..!

		for (int i = 0; i < num; i++) {
			stu[i] = new StudentScoreHasA(); // 반복문 돌 때마다 객체를 만들어라. 
			// 배열이 생기면 객체도 만들어줘야 함 !! 이거 안만들면 오류남 꼭 기억하기.!!

			System.out.println(i + 1 + "번째 학생 이름을 입력하세요.");
			stu[i].setName(sc.next());
			System.out.println(i + 1 + "번째 학생 국어 성적을 입력하세요.(숫자만 입력)");
			stu[i].setKor(sc.nextInt());
			System.out.println(i + 1 + "번째 학생 수학 성적을 입력하세요.(숫자만 입력)");
			stu[i].setMat(sc.nextInt());
			System.out.println(i + 1 + "번째 학생 영어 성적을 입력하세요.(숫자만 입력)");
			stu[i].setEng(sc.nextInt());
		}
		
		for (int i = 0; i < num; i++) {
			System.out.print("이름:"+stu[i].getName() + "\t");
			System.out.print("국어:"+stu[i].getKor() + "\t");
			System.out.print("수학:"+stu[i].getMat() + "\t");
			System.out.print("영어:"+stu[i].getEng() + "\t");
			System.out.print("총점:"+stu[i].getTotal() + "\t");
			System.out.print("평균:"+stu[i].getAvg() + "\t");
			System.out.println();
		}
	}
}
