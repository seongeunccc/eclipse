package BullsAndCows;

import java.util.ArrayList;
import java.util.Scanner;

public class BullsAndCows {

	int computer[] = new int[3];
	int attack[] = new int[3];
	int ball = 0; // 볼 개수를 받는 변수
	int strike = 0; // 스트라이크 개수를 받는 변수
	int repeatCount = 0; // 반복 횟수를 받는 변수
	boolean check = true; // 반복 여부를 담는 변수
	double avgcount; // 평균 시도횟수를 계산할 때 잠깐 쓰는 변수
	Scanner sc = new Scanner(System.in); // 스캐너 IMPORT
	ArrayList<Integer> avg = new ArrayList<Integer>(); // 시도횟수를 저장하는 ArrayList

	// 게임을 구동시키는 메소드 (멈출 때까지 계속 구동시킴.)
	void runGame() {
		char answer;
		do {
			random();
			while (check) {
				System.out.println("공격할 숫자를 입력하세요.");
				System.out.println("(한자리씩 입력 후 엔터)");
				setAccack();
				getPrint();
			}
			System.out.println("계속하시겠습니까?(Y/N)");
			check = true;
			answer = sc.next().charAt(0);
		} while (answer == 'y' || answer == 'Y');
		average();
		System.out.println("고생하셨습니다.");
	}

	// 결과 출력 메소드
	void resultPrint() {
		if (ball == 0 && strike == 0) {// 스트라이크, 볼 모두 없으면
			System.out.println("아웃입니다.");
		} else if (strike == 3) { // 3스트라이크 일 때
			print();
			System.out.println("축하합니다. 3스트라이크 입니다. 고생하셨습니다.");
			reset();
		} else {
			System.out.println(strike + " 스트라이크 " + ball + " 볼입니다.");
			System.out.println(repeatCount + "번째 시도입니다.");
			strike = 0;
			ball = 0;
		}
	}

	// 컴퓨터에게 0~9 겹치지 않는 세자리 숫자를 부여하는 메소드
	void random() {
		for (int i = 0; i < 3; i++) {
			computer[i] = (int) Math.floor(Math.random() * 9);

			for (int j = 0; j < i; j++) {
				if (i == 0) {

				} else if (computer[i] == computer[j]) {
					i--;
				}
			}
		}
	}

	// 내가 공격할 숫자를 입력받는 메소드
	void setAccack() {
		for (int i = 0; i < 3; i++)
			attack[i] = sc.nextInt();
		repeatCount++;
	}

	// 컴퓨터가 가지고 있던 수를 가지고 있던 수를 출력하는 메소드
	void print() {
		System.out.print("컴퓨터는 ");
		for (int i = 0; i < 3; i++) {
			System.out.print(computer[i]);
		}
		System.out.println("");
	}

	// 게임 한 판 종료시 시도횟수를 반환하고 볼, 스트라이크를 초기화하는 메소드
	void reset() {
		System.out.println("시도횟수는 " + repeatCount + "번 입니다.");
		strike = 0;
		ball = 0;
		avg.add(repeatCount); // 평균 시도횟수 담는 배열에 시도횟수 넣기.
		repeatCount = 0; // 게임 횟수 초기화
	}

	// 평균 시도횟수 구하기 메소드
	void average() {
		for (int a : avg) {
			avgcount += a;
		}
		System.out.println("평균 시도 횟수는 " + avgcount / avg.size() + "번 입니다.");
	}

	// 볼과 스트라이트를 판단하는 메소드
	void check() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (computer[i] == attack[j]) {
					if (i == j) {
						strike++;
					} else
						ball++;
				}
			}
		}
	}

	// 성공여부 판단 및 결과 판정 + 결과출력
	void getPrint() {
		check = out(); // 성공여부 판단.
		check();
		resultPrint();
	}

	// 3스트라이크 되면 멈추도록 계속 여부 반환(check에 false를 받으면 멈춤)
	boolean out() {
		if (computer[0] == attack[0] && computer[1] == attack[1] && computer[2] == attack[2]) {
			return false;
		}
		return true;
	}

	// 메인함수
	public static void main(String[] args)  {
		BullsAndCows bac = new BullsAndCows();
		bac.runGame();
	}

}
