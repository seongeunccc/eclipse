package Week3_Wed;

import java.util.Random;

public class InsertExam {

	// 메인함수
	public static void main(String[] args) {
		int data[] = new int[1000];
		Random random = new Random();

		System.out.println("<삽입 정렬1>");
		// j 를 0부터 i까지 늘려나가며 비교하는 버전
		for (int i = 0; i < 1000; i++) { // data에 랜덤 정수 입력
			data[i] = random.nextInt(1000); // (int)(Math.random()*1000);
		}
		InsertionSort1(data, 1000);
		int error = 0;// 에러체크
		for (int i = 0; i <= 998; i++) {
			if (data[i] > data[i + 1]) {
				error++;
			}
		}
		System.out.println("Error : " + error + "개");

		System.out.println("<삽입 정렬2>");
		// j 를 i부터 줄여나가며 비교하는 버전
		for (int i = 0; i < 1000; i++) {// data에 랜덤 정수 입력
			data[i] = random.nextInt(1000); // (int)(Math.random()*1000);
		}

		InsertionSort(data, 1000);
		error = 0; // 에러체크
		for (int i = 0; i <= 998; i++) {
			if (data[i] > data[i + 1]) {
				error++;
			}
		}
		System.out.println("Error : " + error + "개");

		System.out.println("<버블정렬>");
		for (int i = 0; i < 1000; i++) {// data에 랜덤 정수 입력
			data[i] = random.nextInt(1000); // (int)(Math.random()*1000);
		}

		bubbleSort(data);
		error = 0;//에러체크
		for (int i = 0; i <= 998; i++) {
			if (data[i] > data[i + 1]) {
				error++;
			}
		}
		System.out.println("Error : " + error + "개");
	}

	// method
	// j 를 0부터 i까지 늘려나가며 비교하는 버전
	static void InsertionSort(int[] a, int b) {
		int count = 0; // 바꾼 횟수를 담는 변수
		int count1 = 0; // 비교 횟수를 담는 변수

		for (int i = 1; i < b; i++) {
			for (int j = 0; j < i; j++) {
				count1++;
				if (a[i] < a[j]) {
					int t = 0;
					t = a[j];
					a[j] = a[i];
					a[i] = a[j];
					count++;
				}
			}
		}
		System.out.println("변경 횟수 : " + count + "  비교 횟수 : " + count1);
	}

	static void bubbleSort(int[] a) {

		int count = 0; // 바꾼 횟수를 담는 변수
		int count1 = 0; // 비교 횟수를 담는 변수
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				count1++;
				if (a[j] > a[j + 1]) {
					int t = a[j];
					a[j] = a[j + 1];
					a[j + 1] = t;
					count++;
				}
			}
		}
		System.out.println("변경 횟수 : " + count + "  비교 횟수 : " + count1);
	}

	// j 를 i부터 줄여나가며 비교하는 버전
	static void InsertionSort1(int[] a, int b) {

		int count = 0; // 바꾼 횟수를 담는 변수
		int count1 = 0; // 비교 횟수를 담는 변수

		for (int i = 1; i < b; i++) {
			for (int j = i - 1; j >= 0; j--) {
				count1++;
				if (a[i] < a[j]) {
					int t = 0;
					t = a[j];
					a[j] = a[i];
					a[i] = a[j];
					count++;
				}
			}
		}
		System.out.println("변경 횟수 : " + count + "  비교 횟수 : " + count1);
	}

}
