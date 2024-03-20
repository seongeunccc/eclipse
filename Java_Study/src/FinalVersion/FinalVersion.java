package FinalVersion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

interface finVer {// 인터페이스(동적바인딩)
	void runProgram();
}

//숫자야구 클래스
class BullsAndCows implements finVer {

	int computer[] = new int[3];
	int attack[] = new int[3];
	int ball = 0; // 볼 개수를 받는 변수
	int strike = 0; // 스트라이크 개수를 받는 변수
	int repeatCount = 0; // 반복 횟수를 받는 변수
	boolean check = true; // 반복 여부를 담는 변수o
	double avgcount; // 평균 시도횟수를 계산할 때 잠깐 쓰는 변수
	Scanner sc = new Scanner(System.in); // 스캐너 IMPORT
	ArrayList<Integer> avg = new ArrayList<Integer>(); // 시도횟수를 저장하는 ArrayList

	// 게임을 구동시키는 메소드 (멈출 때까지 계속 구동시킴.)
	public void runProgram() {
		char answer;
		System.out.println("숫자야구 프로그램입니다.");
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
}

//작은수정렬 클래스
class Collate implements finVer {
	// field
	int collate[];

	// 생성자 함수
	public Collate() {
		collate = new int[4];
	}

	// 4자리의 숫자를 입력받아 배열에 한자리씩 넣어주는 메소드
	void setNum(int input) {

		LinkedList<Integer> stack = new LinkedList<Integer>();
		while (input > 0) {
			stack.push(input % 10);
			input = input / 10;
		}
		int i = 0;
		while ((!stack.isEmpty())) {
			collate[i] = stack.pop();
			i++;
		}
	}

	// 양옆의 수를 한번씩 비교해서 자리를 바꾸는 메소드
	void collateNum() {
		int temporary = 0;
		for (int j = 0; j < 3; j++) {// N번째 자리수
			for (int i = 0; i < 3; i++) {
				if (collate[i] > collate[i + 1]) {
					temporary = collate[i];
					collate[i] = collate[i + 1];
					collate[i + 1] = temporary;
				} else {
				}
			}
		}
	}

	// 맨 앞자리 0을 숫자 뒤로 보내주는 메소드
	void zeroCheck() {
		if (collate[0] != 0) {
			// 맨 앞자리가 0이 아니면 그냥 0순서 정렬 없이 그냥 끝내기.
		} else { // 앞자리가 0이라면 0이아닌 수가 오는 자릿수를 찾아 맨앞으로 끌어주고 그 자리까지 0 넣어줌
			for (int i = 0; i < 4; i++) {
				if (collate[i] != 0) {
					collate[0] = collate[i];
					for (int j = 1; j < i + 1; j++) {
						collate[j] = 0;
					}
					break;
				}
			}
		}
	}

	// 출력메소드
	void printcollate() {
		for (int i : collate)
			System.out.print(i);
	}

	// 프로그램 실행 메소드
	public void runProgram() {
		System.out.println("작은 수 정렬 프로그램입니다.");
		char answer;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1000~9999 사이의 4자리 정수를 입력하세요.");
			setNum(sc.nextInt());
			collateNum();
			zeroCheck();
			System.out.print("정렬된 수 : ");
			printcollate();
			System.out.println(" ");
			System.out.println("계속하시겠습니까?(Y/N)");
			answer = sc.next().charAt(0);
		} while (answer == 'y' || answer == 'Y');
		System.out.println("작은 수 정렬 프로그램을 종료합니다.");
	}

	// 오버로딩 (정수를 넣어주면 그 값을 반환
	void runProgram(int input) {
		setNum(input);
		collateNum();
		zeroCheck();
		System.out.print("입력한 수 : " + input);
		System.out.print(" 정렬된 수 : ");

		printcollate();
		System.out.println(" ");

	}
}

//정돈된 수 클래스
class OrderlyNumber implements finVer {
	// field
	ArrayList<Integer> collate;
	ArrayList<Integer> numBCollate;
	int numA;
	int numB;

	// 생성자 함수
	public OrderlyNumber() {
		collate = new ArrayList<Integer>();
		numBCollate = new ArrayList<Integer>();
	}

	// 시작 값과 종료값을 설정하는 메소드
	void setNum() {
		Scanner sc = new Scanner(System.in);
		System.out.println("100~9,999,999 사이의 시작 값 A를 입력하세요.");
		numA = sc.nextInt();
		System.out.println("A~9,999,999 사이의 종료 값 B를 입력하세요.");
		numB = sc.nextInt();
	}

	// 100~9,999,999 사이의 시작값 numA를 입력받아 배열에 한자리씩 넣어주는 메소드
	void collateNum(int num) {
		collate.clear();
		Stack<Integer> stack = new Stack<Integer>();
		while (num > 0) {
			stack.push(num % 10);
			num = num / 10;
		}
		int i = 0;
		while ((!stack.isEmpty())) {
			collate.add(stack.pop());
			i++;
		}
	}

	// 입력한 숫자의 자릿수를 구하는 메소드
	int getDigit(int a) {
		numBCollate.clear();
		while (a > 0) {
			numBCollate.add(a % 10);
			a = a / 10;
		}
		return numBCollate.size();
	}

	// 출력메소드
	void printcollate() {
		System.out.print("입력한 시작값 : " + numA);
		System.out.print("\s 입력한 종료 값 : " + numB);

		System.out.println("\n정돈된 수: ");
		int count = 0;
		int count1 = 0;
		for (int i = numA; i < numB + 1; i++) {
			collateNum(i);
			int num1 = getDigit(i);
			count1 = 0;
			for (int j = 0; j < num1 - 1; j++) {
				if (collate.get(j) < collate.get(j + 1)) {
					count1++;
				}
			}
			if (num1 == count1 + 1) {// 입력 받은 numA~numB사의 값 i가 정돈된 수면 화면에 출력
				System.out.print(i + "\s");
				count++;
				if (count % 10 == 0) {// 이거는 그냥 10개씩 찍고 줄 바꿔주는 if 문
					System.out.println(" ");
				}
			}
		}
		System.out.println(" ");
		System.out.println("정돈된 수의 개수 : " + count);
	}

	public void runProgram() {
		System.out.println("두 숫자 사이의 정돈된 수를 찾는 프로그램입니다.");
		System.out.println("작은 수 정렬 프로그램입니다.");
		char answer;
		Scanner sc = new Scanner(System.in);
		do {
			setNum();
			printcollate();
			System.out.println("계속하시겠습니까?(Y/N)");
			answer = sc.next().charAt(0);
		} while (answer == 'y' || answer == 'Y');
		System.out.println("정돈된 수 찾기 프로그램을 종료합니다.");
	}

}

//BabyGin 클래스
class BabyGin implements finVer {

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

	// 0~9까지 숫자가 몇개씩 있는지 넣어주는 메소드
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

	// triplete 있는지 확인
	void catchTriplete() {
		for (int j = 0; j < 2; j++) { // 최대 2번까지 발생 가능하므로 2번 반복하게 해줌
			for (int i = 0; i < 10; i++) {
				if (collate[i] >= 3) {
					triplete++;
					collate[i] -= 3;
				}
			}
		}
	}

	// run 이 있는지 확인
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

	// 결과출력 메소드
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

	void runProgram(int num) {
		char answer;
		Scanner sc = new Scanner(System.in);
		do {
			reset();
			random();
			System.out.println(" ");
			setList();
			catchRun();
			catchTriplete();
			resultPrint();
			System.out.println("계속하시겠습니까?(Y/N)");
			answer = sc.next().charAt(0);
		} while (answer == 'y' || answer == 'Y');
		System.out.println("Baby gin 프로그램을 종료합니다.");
	}

	// 동작시키는 메소드(ver2 : 직접 입력한 수의 Baby gin 여부 파악)
	@Override
	public void runProgram() {
		System.out.println("Baby gin 프로그램입니다.");
		char answer;
		Scanner sc = new Scanner(System.in);
		do {
			reset();
			System.out.println("임의의 숫자 6자리를 입력하세요.");
			random(sc.nextInt()); // 입력한 숫자를 한자리씩 배열에 입력하는 메소드
			setList(); // 0~9까지 숫자가 몇개씩 있는지 찾아서 배열에 넣어주는 메소드
			catchRun(); // 연속된 숫자가 세개 있으면 run 값이 하나 증가하는 메소드
			catchTriplete(); // 동일한 숫자가 세개 있으면 triplete 값이 증가하는 메소드
			resultPrint(); // 결과 출력 메소드
			System.out.println("Baby gin 프로그램을 계속하시겠습니까?(Y/N)");
			answer = sc.next().charAt(0); // 계속 할지 여부를 묻는 메소드
		} while (answer == 'y' || answer == 'Y');
		System.out.println("Baby gin 프로그램을 종료합니다.");
	}
}

public class FinalVersion {

	public static void main(String[] args) {
		BullsAndCows bc = new BullsAndCows();
		Collate co = new Collate();
		OrderlyNumber on = new OrderlyNumber();
		BabyGin bg = new BabyGin();
		finVer fv; // 동적바인딩

		Scanner sc = new Scanner(System.in);
		char ans;
		do {
			System.out.println("어떤 프로그램을 동작시키시겠습니까? (숫자로 입력하세요)");
			System.out.println("1. 숫자야구 2.작은 수 변경 3. 정돈된 수 4. baby-gin");
			int answer = sc.nextInt();
			// answer 값에 따라 fv의 값을 바꿔줌
			if (answer == 1) {
				fv = bc; // 숫자야구
			} else if (answer == 2) {
				fv = co;// 2.작은 수 변경
			} else if (answer == 3) {
				fv = on; // 3. 정돈된 수
			} else {
				fv = bg; // 4. baby-gin
			}

			fv.runProgram();

			System.out.println("다른 프로그램을 실행하시겠습니까?(Y/N)");
			ans = sc.next().charAt(0);
		} while (ans == 'y' || ans == 'Y');
		System.out.println("프로그램을 완전히 종료합니다. 고생하셨습니다.");
	}
}
