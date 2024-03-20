package March19Exam;

import java.util.Arrays;
import java.util.Scanner;

public class BabyGin {

	int card[];
	int temporary;
	int collate[];
	int run;
	int triplete;

	// 생성자 함수
	public BabyGin() {  
		card = new int[6]; // 카드 6장 뽑아서 저장하는 배열
		collate = new int[10]; // 0~9 의 개수를 담는 배열
	}

	// 오버라이딩
	// 임의의 숫자 6개카드를 랜덤으로 뽑는 과정
	void random() {
		for (int i = 0; i < 6; i++) {
			card[i] = (int) Math.floor(Math.random() * 10);
		}
		// 나중에 지울 부분
		System.out.println("임의의 카드 번호 :");
		for (int i : card)
			System.out.print(i);
		Arrays.sort(card); // 카드 정렬
	}

	// 오버라이딩 : 직접 숫자 입력해서 진행할 경우 => 입력한 수를 한자리씩 card 배열에 넣음
	void random(int num) {
		for (int i = 0; num > 0; i++) {
			card[i] = (num % 10);
			num = num / 10;
		}
		Arrays.sort(card); // 카드 정렬
	}
	//0~9까지 숫자가 몇개씩 있는지 넣어주는 메소드
	void setList() {
		for (int i = 0; i < 6; i++) {
			temporary = card[i];
			collate[temporary] += 1;
		}
		System.out.println("0~9 카드 개수 :");
		for (int i : collate)
			System.out.print(i);
		System.out.println(" ");
	}

	void catchTripleten() {
		for (int j = 0; j < 2; j++) { // 최대 2번까지 발생 가능하므로 2번 반복하게 해줌
			for (int i = 0; i < 10; i++) {
				if (collate[i] >= 3) {
					triplete++;
					collate[i] -= 3;
				}
			}
		}
	}

	void catchRun() {
		for (int j = 0; j < 2; j++) { // 최대 2번까지 발생 가능하므로 2번 반복하게 해줌
			for (int i = 0; i < 8; i++) {
				if (collate[i] >= 1 && collate[i + 1] >= 1 && collate[i + 2] >= 1) {
					run++;
					collate[i] -= 1;
					collate[i + 1] -= 1;
					collate[i + 2] -= 1;
				}
			}
		}
	}

	void resultPrint() {
		if (run + triplete == 0) {
			System.out.println("Lose");
		}
		if (run + triplete == 1) {
			System.out.println("Lose");
		}
		System.out.println("run : " + run + "  triplete : " + triplete);
		if (run + triplete >= 2) {
			System.out.println("Baby gin !!");
		}
	}

	// 초기화 하는 메소드
	void reset() {
		run = 0;
		triplete = 0;
		for (int i = 0; i < 10; i++)
			collate[i] = 0;

	}

	// 동작시키는 메소드(ver1 : 임의의 값 부여 후 Baby gin 여부 파악)
	void runGame() {
		char answer;
		Scanner sc = new Scanner(System.in);
		do {
			reset();
			random();
			System.out.println(" ");
			setList();
			catchRun();
			catchTripleten();
			resultPrint();
			System.out.println("계속하시겠습니까?(Y/N)");
			answer = sc.next().charAt(0);
		} while (answer == 'y' || answer == 'Y');
		System.out.println("고생하셨습니다.");
	}

	// 동작시키는 메소드(ver2 : 직접 입력한 수의 Baby gin 여부 파악)
	void runGame(int num) {
		char answer;
		Scanner sc = new Scanner(System.in);
		do {
			reset();
			System.out.println("임의의 숫자 6자리를 입력하세요.");
			random(sc.nextInt());
			setList();
			catchRun();
			catchTripleten();
			resultPrint();
			System.out.println("계속하시겠습니까?(Y/N)");
			answer = sc.next().charAt(0);
		} while (answer == 'y' || answer == 'Y');
		System.out.println("고생하셨습니다.");
	}

	public static void main(String[] args) {
		BabyGin bg = new BabyGin();
		// 버전 1 실행
		// bg.runGame();

		// 버전 2 실행
		bg.runGame(1);
	}
}
