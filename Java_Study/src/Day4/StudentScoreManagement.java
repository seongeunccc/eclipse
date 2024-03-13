package Day4;

import java.util.Scanner;

public class StudentScoreManagement {
	//기존에 만들어놓은 클래스들 호출 + 생성자함수 설정
	StudentScoreHasA StudentScoreHasA;

	public StudentScoreManagement() {
		StudentScoreHasA = new StudentScoreHasA();
	}

	static StudentScoreHasA[] stu = new StudentScoreHasA[100];

	// 배열을 선언해야 함. 배열로 처리하는 이유 = 일괄 처리..!
	int index = 0; //입력할 자리를 찾는 변수 index
	Scanner sc = new Scanner(System.in); // 외부 메소드에서 사용할 스캐너 호출

	public int getIndex() {
		return this.index;
	}

	public static void main(String[] args) {
		StudentScoreManagement ssm = new StudentScoreManagement();
		//만들어진 배열만큼 객체 미리 만들어 놓고 시작
		for (int i = 0; i < 100; i++) {
			stu[i] = new StudentScoreHasA();
		}
		char an; // 계속할지 여부를 묻는 답을 담는 변수 an, do~while 문 밖에서 선언했음
		do {				//어떤 메뉴를 실행할지 묻는 메소드호출 + 입력한 메류를 실행하는 메소드 호출
			ssm.runMenu(ssm.selectMenu());
			System.out.println("계속하시겠습니까?(Y/N)");
			Scanner sc = new Scanner(System.in);
			an = sc.next().charAt(0);

		} while (an == 'y' || an == 'Y'); //사용자가 y를 입력하면 계속 반복
		System.out.println("고생하셨습니다.");
	}

	public void inputScore(int a) { 			//1. 입력 선택시 실행되는 메소드, 값을 하나 입력하면 인덱스를 1 증가시킴. 
		this.stu[a] = new StudentScoreHasA();
		System.out.println("학생 이름을 입력하세요.");
		this.stu[a].setName(sc.next());
		System.out.println("국어 성적을 입력하세요.(숫자만 입력)");
		this.stu[a].setKor(sc.nextInt());
		System.out.println("수학 성적을 입력하세요.(숫자만 입력)");
		this.stu[a].setMat(sc.nextInt());
		System.out.println("영어 성적을 입력하세요.(숫자만 입력)");
		this.stu[a].setEng(sc.nextInt());
		index++;
	}

	public void printScore(int a) { //원하는 점수를 출력하는 메소드
		for (int i = 0; i < a; i++) {
			System.out.print("이름:" + stu[i].getName() + "\t");
			System.out.print("국어:" + stu[i].getKor() + "\t");
			System.out.print("수학:" + stu[i].getMat() + "\t");
			System.out.print("영어:" + stu[i].getEng() + "\t");
			System.out.print("총점:" + stu[i].getTotal() + "\t");
			System.out.print("평균:" + stu[i].getAvg() + "\t");
			System.out.println();
		}

	}

	public int selectMenu() { 		//어떤 메뉴를 선택할지 묻는 메소드

		System.out.println("학생 성적 관리 프로그램입니다. 원하는 메뉴를 선택하세요.(숫자로 입력");
		System.out.println("1.입력" + "\t" + "2.수정" + "\t" + " 3.검색" + "\t" + " 4.출력");
		return sc.nextInt();
	}

	public void modify() {  //수정하는 메소드, 수정할 학생의 이름 입력시 현재 데이터가 표출되며, 수정하고자 하는 부분을 선택하라는 메세지 호출.
		System.out.println("어떤 학생의 데이터를 수정하시겠습니까? (이름으로 검색)");
		String name = sc.next();

		for (int i = 0; i < 100; i++) {
			if (stu[i].getName().equals(name)) {
				System.out.println("[현재 데이터]");
				System.out.print("이름:" + stu[i].getName() + "\t");
				System.out.print("국어:" + stu[i].getKor() + "\t");
				System.out.print("수학:" + stu[i].getMat() + "\t");
				System.out.print("영어:" + stu[i].getEng() + "\t");
				System.out.println();
				System.out.println("어떤 것을 수정하시겠습니까?(숫자로 입력)");
				System.out.println("1.이름" + "\t" + "2.국어" + "\t" + " 3.수학" + "\t" + " 4.영어");
				int a = sc.nextInt();

				switch (a) {
				case 1:			//이름 수정 원할 시 이름을 입력하는 메소드 호출
					System.out.println("학생 이름을 입력하세요.");
					stu[i].setName(sc.next());
					break;
				case 2:		//국어점수 수정 메소드
					System.out.println("국어 성적을 입력하세요.(숫자만 입력)");
					stu[i].setKor(sc.nextInt());
					break;
				case 3:	//수학점수 수정 메소드
					System.out.println("수학 성적을 입력하세요.(숫자만 입력)");
					stu[i].setMat(sc.nextInt());
					break;
				case 4://영어점수 수정 메소드
					System.out.println("영어 성적을 입력하세요.(숫자만 입력)");
					stu[i].setEng(sc.nextInt());
					break;
				default:
					System.out.println("잘못된 입력입니다.");
				}
				break;
			}
		}
	}

	public void serch() {		//검색 메소드 

		System.out.println("무엇으로 검색하시겠습니까?");	//검색하고자 하는 부분 선택 가능
		System.out.println("1.이름" + "\t" + "2.국어" + "\t" + " 3.수학" + "\t" + " 4.영어");
		int an = sc.nextInt();

		switch (an) {		//어떤 부분을 검색할지 선택시 그 내용 검색함.
		case 1:
			System.out.println("검색할 이름을 입력하세요.");
			String name = sc.next();

			for (int i = 0; i < index; i++) {
				if (stu[i].getName().equals(name)) {
					System.out.print("이름:" + stu[i].getName() + "\t");
					System.out.print("국어:" + stu[i].getKor() + "\t");
					System.out.print("수학:" + stu[i].getMat() + "\t");
					System.out.print("영어:" + stu[i].getEng() + "\t");
					System.out.println();
				}
			}
			break;
		case 2:
			System.out.println("조건을 입력하세요");
			System.out.println("1.특정 점수 검색" + "\t" + "2.특정 점수 이하 모두 찾기" + "\t" + " 3.특정 점수 이상 모두 찾기");
			int ans = sc.nextInt();
			switch (ans) {
			case 1:
				System.out.println("찾고싶은 점수를 입력하세요");
				int serchScore = sc.nextInt();
				for (int i = 0; i < index; i++) {
					if (serchScore == stu[i].getKor()) {
						System.out.print("이름:" + stu[i].getName() + "\t");
						System.out.print("국어:" + stu[i].getKor() + "\t");
						System.out.print("수학:" + stu[i].getMat() + "\t");
						System.out.print("영어:" + stu[i].getEng() + "\t");
						System.out.println();
					}
				}
				break;
			case 2:
				System.out.println("몇점 이하의 점수를 검색할까요?");
				serchScore = sc.nextInt();
				for (int i = 0; i < index; i++) {
					if (serchScore >= stu[i].getKor()) {
						System.out.print("이름:" + stu[i].getName() + "\t");
						System.out.print("국어:" + stu[i].getKor() + "\t");
						System.out.print("수학:" + stu[i].getMat() + "\t");
						System.out.print("영어:" + stu[i].getEng() + "\t");
						System.out.println();
					}
				}
				break;
			case 3:
				System.out.println("몇점 이상의 점수를 검색할까요?");
				serchScore = sc.nextInt();
				for (int i = 0; i < index; i++) {
					if (serchScore <= stu[i].getKor()) {
						System.out.print("이름:" + stu[i].getName() + "\t");
						System.out.print("국어:" + stu[i].getKor() + "\t");
						System.out.print("수학:" + stu[i].getMat() + "\t");
						System.out.print("영어:" + stu[i].getEng() + "\t");
						System.out.println();
					}
				}
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		case 3:
			System.out.println("조건을 입력하세요");
			System.out.println("1.특정 점수 검색" + "\t" + "2.특정 점수 이하 모두 찾기" + "\t" + " 3.특정 점수 이상 모두 찾기");
			ans = sc.nextInt();
			switch (ans) {
			case 1:
				System.out.println("찾고싶은 점수를 입력하세요");
				int serchScore = sc.nextInt();
				for (int i = 0; i < index; i++) {
					if (serchScore == stu[i].getMat()) {
						System.out.print("이름:" + stu[i].getName() + "\t");
						System.out.print("국어:" + stu[i].getKor() + "\t");
						System.out.print("수학:" + stu[i].getMat() + "\t");
						System.out.print("영어:" + stu[i].getEng() + "\t");
						System.out.println();
					}
				}
				break;
			case 2:
				System.out.println("몇점 이하의 점수를 검색할까요?");
				serchScore = sc.nextInt();
				for (int i = 0; i < index; i++) {
					if (serchScore >= stu[i].getMat()) {
						System.out.print("이름:" + stu[i].getName() + "\t");
						System.out.print("국어:" + stu[i].getKor() + "\t");
						System.out.print("수학:" + stu[i].getMat() + "\t");
						System.out.print("영어:" + stu[i].getEng() + "\t");
						System.out.println();
					}
				}
				break;
			case 3:
				System.out.println("몇점 이상의 점수를 검색할까요?");
				serchScore = sc.nextInt();
				for (int i = 0; i < index; i++) {
					if (serchScore <= stu[i].getMat()) {
						System.out.print("이름:" + stu[i].getName() + "\t");
						System.out.print("국어:" + stu[i].getKor() + "\t");
						System.out.print("수학:" + stu[i].getMat() + "\t");
						System.out.print("영어:" + stu[i].getEng() + "\t");
						System.out.println();
					}
				}
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			}
			;
			break;
		case 4:
			System.out.println("조건을 입력하세요");
			System.out.println("1.특정 점수 검색" + "\t" + "2.특정 점수 이하 모두 찾기" + "\t" + " 3.특정 점수 이상 모두 찾기");
			ans = sc.nextInt();
			switch (ans) {
			case 1:
				System.out.println("찾고싶은 점수를 입력하세요");
				int serchScore = sc.nextInt();
				for (int i = 0; i < index; i++) {
					if (serchScore == stu[i].getEng()) {
						System.out.print("이름:" + stu[i].getName() + "\t");
						System.out.print("국어:" + stu[i].getKor() + "\t");
						System.out.print("수학:" + stu[i].getMat() + "\t");
						System.out.print("영어:" + stu[i].getEng() + "\t");
						System.out.println();
					}
				}
				break;
			case 2:
				System.out.println("몇점 이하의 점수를 검색할까요?");
				serchScore = sc.nextInt();
				for (int i = 0; i < index; i++) {
					if (serchScore >= stu[i].getEng()) {
						System.out.print("이름:" + stu[i].getName() + "\t");
						System.out.print("국어:" + stu[i].getKor() + "\t");
						System.out.print("수학:" + stu[i].getMat() + "\t");
						System.out.print("영어:" + stu[i].getEng() + "\t");
						System.out.println();
					}
				}
				break;
			case 3:
				System.out.println("몇점 이상의 점수를 검색할까요?");
				serchScore = sc.nextInt();
				for (int i = 0; i < index; i++) {
					if (serchScore <= stu[i].getEng()) {
						System.out.print("이름:" + stu[i].getName() + "\t");
						System.out.print("국어:" + stu[i].getKor() + "\t");
						System.out.print("수학:" + stu[i].getMat() + "\t");
						System.out.print("영어:" + stu[i].getEng() + "\t");
						System.out.println();
					}
				}
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			}
			;
			break;

		default:
			System.out.println("잘못된 입력입니다.");
		}

	}

	public void runMenu(int a) {
		switch (a) {
		case 1:
			inputScore(index);
			break;
		case 2:
			modify();
			break;
		case 3:
			serch();
			break;
		case 4:
			printScore(getIndex());
			break;
		default:
			System.out.println("잘못된 입력입니다.");
		}
	}
}
