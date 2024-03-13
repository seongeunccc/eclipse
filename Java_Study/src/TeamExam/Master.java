package TeamExam;

import java.util.Scanner;

public class Master {

	FullTime FullTime;
	PartTime PartTime;
	FullTime ft = new FullTime();
	PartTime pt = new PartTime();
	Scanner sc = new Scanner(System.in);
	static int index1 = 0;
	static int index2 = 0;

	public int select() { // 정규직 비정규직을 입력하는 메소드
		System.out.println("처리하고자 하는 직원의 계약형태를 입력하세요.");
		System.out.println("(숫자로 입력: 1. 정규직 2. 비정규직)");
		return sc.nextInt();
	}

	public static void main(String[] args) {
		Master ma = new Master();
		char an;

		do {
			System.out.println("급여관리 프로그램입니다. 원하는 메뉴를 선택해주세요");
			System.out.println("1. 입력" + "\t" + "2. 수정" + "\t" + "3. 삭제" + "\t" + "4. 검색" + "\t" + "5. 출력");
			ma.selectMenu(ma.sc.nextInt());

			System.out.println("");
			System.out.println("계속하시겠습니까?(Y/N)");
			an = ma.sc.next().charAt(0);
		} while (an == 'Y' || an == 'y');
		System.out.println("고생하셨습니다.");

	}

	public void selectMenu(int a) {
		switch (a) {
		case 1:// 입력
			if (select() == 1) {
				System.out.println("1. 직원정보 입력 / 2. 급여정보 입력");
				switch (sc.nextInt()) {
				case 1:
					ft.inputPersonalInfo(index1);
					index1++;
					break;
				case 2:
					System.out.println("어떤 직원의 급여를 입력하시겠습니까?");
					int aa = ft.serch(index1); // 직원 배열 번호
					System.out.println("");
					System.out.println("몇월 급여를 입력하시겠습니까?(1~12)");
					int mon = sc.nextInt();
					ft.inputSalaryInfo(mon, aa);
					System.out.println("성과등급을 입력하세요.(1~7)");
					ft.pinfo[aa].setPerfomanceGrade(sc.nextInt());
					ft.calTotalPay(aa, mon);
					break;
				default:
					System.out.println("잘못된 입력/selectMenu/input/1");
					break;
				}

			} else {
				System.out.println("1. 직원정보 입력 / 2. 급여정보 입력");
				switch (sc.nextInt()) {
				case 1:
					pt.inputPersonalInfo(index2);
					index2++;
					break;
				case 2:
					System.out.println("어떤 직원의 급여를 입력하시겠습니까?");
					int aa = pt.serch(index2); // 직원 배열 번호
					System.out.println("");
					System.out.println("몇월 급여를 입력하시겠습니까?(1~12)");
					int mon = sc.nextInt();
					pt.inputSalaryInfo(mon, aa);
					System.out.println("성과등급을 입력하세요.(1~7)");
					pt.pinfo[aa].setPerfomanceGrade(sc.nextInt());
					pt.calTotalPay(aa, mon);
					break;
				default:
					System.out.println("잘못된 입력 selectMenu/input/2");
					break;
				}
			}
			break;
		case 2:// 수정
			switch (select()) {
			case 1:
				int cc = ft.serch(index1);
				ft.modifyPersonalInfo(cc);
				break;
			case 2:
				cc = pt.serch(index2);
				pt.modifyPersonalInfo(cc);
				break;
			default:
				System.out.println("잘못된 입력입니다. selectMenu/modify");
			}
			break;

		case 3:// 삭제
			switch (select()) {
			case 1:
				ft.deleteData(ft.serch(index1));
				break;
			case 2:
				pt.deleteData(pt.serch(index2));
				break;
			default:
				System.out.println("잘못된 입력입니다. selectMenu/delete");
				break;
			}
			break;

		case 4:// 검색(원하는 직원 정보 + 원하는 직원의 월 급여 조회 가능)

			switch (select()) {
			case 1:
				int aa = ft.serch(index1);
				System.out.println("몇월 급여를 조회하겠습니까?(1~12)");
				int mon = sc.nextInt();
				ft.printTotalPay(aa, mon);
				break;
			case 2:
				aa = pt.serch(index2);
				System.out.println("몇월 급여를 조회하겠습니까?(1~12)");
				mon = sc.nextInt();
				pt.printTotalPay(aa, mon);
				break;
			default:
				System.out.println("잘못된 입력입니다. selectMenu/serch");
				break;
			}
			break;
		case 5:
			System.out.println("1. 직원 정보 출력 2.직원별 월 급여 조회");

			if (sc.nextInt() == 1) {
				ft.printAll(index1);
				pt.printAll(index2);
			} else {
				int aa = ft.serch(index1);
				System.out.println("몇월 급여를 조회하겠습니까?(1~12)");
				int mon = sc.nextInt();
				ft.printTotalPay(aa, mon);
			}
			break;
		default:
			System.out.println("잘못된 입력입니다.(selectMenu)");
		}
	}
}