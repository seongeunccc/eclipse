/*
 * 
 * public class ArrayExam01 {
	public static void main(String[] args) {
		int[] arr = new int[2]; // arr은 첫 주소와 배열의 사이즈를 다 알고 있음.

		for (int i = 0; i < arr.length; i++) { // length를 활용하면 내가 생성한 배열의 사이즈를 자동으로 긁어오기 가능.
			System.out.println(arr[i]);
		}
		for (int i : arr) { // for each문 활용하면 배열의 길이만큼 결과를 자동으로 꺼내옴
			System.out.println(arr[i]);
		} 
 * 
 * 입력 
 * 
		System.out.println("국어 점수를 입력하세요");
		score[0] = sc.nextInt();

		System.out.println("영어 점수를 입력하세요");
		score[1] = sc.nextInt();

		System.out.println("수학 점수를 입력하세요");
		score[2] = sc.nextInt();
		
 */

import java.util.Scanner;

public class ArrayExam01 {
	public static void main(String[] args) {

		String name;
		int score[] = new int[4]; //
		float avg;

		Scanner sc = new Scanner(System.in);

		// 입력 이름 국어영어 수학
		// 연산 총, 평
		// 출력 : 이름,국어, 영어, 수학, 총점 평균

		System.out.println("이름을 입력하세요");
		name = sc.next();
		
		for(int i=0;i<3;i++) {
			System.out.println("점수를 입력하세요");
			score[i] = sc.nextInt();	
			score[3] += score[i];
		}
		avg = score[3] / 3.f;//.f를 넣으면 float 형식으로 값 반환

		System.out.println("이름 : " + name+ "\t");
		for(int sco:score) {
			System.out.print(sco+"\t");
		}
		System.out.println(avg);				
	}
}
