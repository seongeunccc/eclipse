//package Map;
//
//import java.awt.Frame;
//import java.util.HashMap;
//import java.util.Scanner;
//import java.util.Set;
//
//public class MapMain {
//
//	// field
//	int index;
//
//	// 생성자함수
//	public MapMain() {
//
//	}
//
//	Scanner sc = new Scanner(System.in);
//	HashMap<Integer, StudentScoreData> list = new HashMap<Integer, StudentScoreData>();
//
//	// 메인구문
//	public static void main(String[] args) {
//		MapMain lm = new MapMain();
//
//		char an;
//		do {
//			switch (lm.selectMenu()) {
//
//			case 1:
//				lm.inputScore();
//				break;
//			case 2:// 2. 수정
//				lm.modify();
//				break;
//			case 3: // 3. 검색
//				lm.serch();
//				break;
//			case 4:
//				lm.printall();
//				break;
//			default:
//				System.out.println("잘못된 입력입니다.");
//			}
//
//			System.out.println("계속하시겠습니까?(Y/N)");
//			an = lm.sc.next().charAt(0);
//		} while (an == 'y' || an == 'Y' || an == 'ㅛ');// 자꾸 y를 ㅛ로 입력해 종료되어ㅇ 추가함.
//		System.out.println("프로그램을 종료합니다. 고생하셨습니다.");
//
//	}
//
//	// 만들어놓은 메소드
//	public void inputScore() {
//		StudentScoreData stu = new StudentScoreData();
//		System.out.println("새로 등록할 학생의 이름을 입력하세요.");
//		stu.setName(sc.next());
//		System.out.println("새로 등록할 학생의 국어점수를 입력하세요.");
//		stu.setKor(sc.nextInt());
//		System.out.println("새로 등록할 학생의 수학점수를 입력하세요.");
//		stu.setMat(sc.nextInt());
//		System.out.println("새로 등록할 학생의 영어점수를 입력하세요.");
//		stu.setEng(sc.nextInt());
//		list.put(index, stu);
//
//	}
//
//	// arrayList 에서 studentScoreData 를 꺼냄.
//	public void printall() {
//	
//		for (int key : list.kdeySet()) {
//			System.out.println("이름: " + list.get(key).getName() + "\t" + "국어점수: " + list.get(key).getKor() + "\t"
//					+ "수학점수: " + list.get(key).getMat() + "\t" + "영어점수: " + list.get(key).getEng() + "\t" + "총점: "
//					+ list.get(key).getTotal() + "\t" + "평균점수: " + list.get(key).getAvg());
//
//		}
//	}
//
//	public int selectMenu() { // 어떤 메뉴를 선택할지 묻는 메소드
//		System.out.println("학생 성적 관리 프로그램입니다. 원하는 메뉴를 선택하세요.(숫자로 입력)");
//		System.out.println("1.입력" + "\t" + "2.수정" + "\t" + " 3.검색" + "\t" + " 4.전체출력");
//		return sc.nextInt();
//	}
//
//	public void modify() {
//		System.out.println("누구의 점수를 수정하시겠습니까?");
//		int an = serchName();
//		System.out.println("어떤 점수를 수정하시겠습니까?");
//		System.out.println("1.이름 2.국어성적 3.수학성적 4.영어성적 (숫자로 입력)");
//		switch (sc.nextInt()) {
//		case 1:
//			System.out.println("변경할 이름을 입력하세요");
//			list.get(an).setName(sc.next());
//			break;
//		case 2:
//			System.out.println("변경할 국어 점수를 입력하세요");
//			list.get(an).setKor(sc.nextInt());
//			break;
//		case 3:
//			System.out.println("변경할 수학 점수를 입력하세요");
//			list.get(an).setMat(sc.nextInt());
//			break;
//		case 4:
//			System.out.println("변경할 영어 점수를 입력하세요");
//			list.get(an).setEng(sc.nextInt());
//			break;
//		default:
//			System.out.println("잘못된 입력입니다.(modify)");
//		}
//	}
//
//	public void serch() {
//		System.out.println("어떤 것을 기준으로 검색하시겠습니까?");
//		System.out.println("1.이름 2.국어성적 3.수학성적 4.영어성적 5.평균점수(숫자로 입력)");
//		switch (sc.nextInt()) {
//		case 1:
//			printone(serchName());
//			break;
//		case 2:
//			switch (answer2()) {
//			case 1:
//				System.out.println("검색할 점수를 입력하세요.");
//				int a = sc.nextInt();
//				for (int i = 0; i < list.size(); i++) {
//					if (list.get(i).getKor() == a) {
//						printone(i);
//					}
//				}
//				break;
//			case 2:
//				System.out.println("몇점 이상의 점수를 검색할까요");
//				a = sc.nextInt();
//				for (int i = 0; i < list.size(); i++) {
//					if (list.get(i).getKor() >= a) {
//						printone(i);
//					}
//				}
//				break;
//			case 3:
//				System.out.println("몇점 이하의 점수를 검색할까요");
//				a = sc.nextInt();
//				for (int i = 0; i < list.size(); i++) {
//					if (list.get(i).getKor() <= a) {
//						printone(i);
//					}
//				}
//				break;
//			default:
//				System.out.println("잘못된 입력입니다.(serchKor)");
//			}
//			break;
//		case 3:
//			switch (answer2()) {
//			case 1:
//				System.out.println("검색할 점수를 입력하세요.");
//				int a = sc.nextInt();
//				for (int i = 0; i < list.size(); i++) {
//					if (list.get(i).getMat() == a) {
//						printone(i);
//					}
//				}
//				break;
//			case 2:
//				System.out.println("몇점 이상의 점수를 검색할까요");
//				a = sc.nextInt();
//				for (int i = 0; i < list.size(); i++) {
//					if (list.get(i).getMat() >= a) {
//						printone(i);
//					}
//				}
//				break;
//			case 3:
//				System.out.println("몇점 이하의 점수를 검색할까요");
//				a = sc.nextInt();
//				for (int i = 0; i < list.size(); i++) {
//					if (list.get(i).getMat() <= a) {
//						printone(i);
//					}
//				}
//				break;
//			default:
//				System.out.println("잘못된 입력입니다.(serchMat)");
//			}
//			break;
//
//		case 4:
//			switch (answer2()) {
//			case 1:
//				System.out.println("검색할 점수를 입력하세요.");
//				int a = sc.nextInt();
//				for (int i = 0; i < list.size(); i++) {
//					if (list.get(i).getEng() == a) {
//						printone(i);
//					}
//				}
//				break;
//			case 2:
//				System.out.println("몇점 이상의 점수를 검색할까요");
//				a = sc.nextInt();
//				for (int i = 0; i < list.size(); i++) {
//					if (list.get(i).getEng() >= a) {
//						printone(i);
//					}
//				}
//				break;
//			case 3:
//				System.out.println("몇점 이하의 점수를 검색할까요");
//				a = sc.nextInt();
//				for (int i = 0; i < list.size(); i++) {
//					if (list.get(i).getEng() <= a) {
//						printone(i);
//					}
//				}
//				break;
//			default:
//				System.out.println("잘못된 입력입니다.(serchEng)");
//			}
//			break;
//
//		case 5:
//			switch (answer2()) {
//			case 1:
//				System.out.println("검색할 점수를 입력하세요.");
//				int a = sc.nextInt();
//				for (int i = 0; i < list.size(); i++) {
//					if (list.get(i).getAvg() == a) {
//						printone(i);
//					}
//				}
//				break;
//			case 2:
//				System.out.println("몇점 이상의 점수를 검색할까요");
//				a = sc.nextInt();
//				for (int i = 0; i < list.size(); i++) {
//					if (list.get(i).getAvg() >= a) {
//						printone(i);
//					}
//				}
//				break;
//			case 3:
//				System.out.println("몇점 이하의 점수를 검색할까요");
//				a = sc.nextInt();
//				for (int i = 0; i < list.size(); i++) {
//					if (list.get(i).getAvg() <= a) {
//						printone(i);
//					}
//				}
//				break;
//			default:
//				System.out.println("잘못된 입력입니다.(serchAvg)");
//			}
//			break;
//
//		default:
//			System.out.println("잘못된 입력입니다.(serch)");
//		}
//	}
//
//	public int answer2() {
//		System.out.println("어떤 것을 기준으로 검색하시겠습니까?");
//		System.out.println("1.특정점수 검색 2.특정점수 이상 검색 3. 특정점수 이하 검색");
//		return sc.nextInt();
//	}
//
//	public int serchName() {
//		int index = 0;
//		System.out.println("검색할 이름을 입력하세요.");
//		String an = sc.next();
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i).getName() == an) {
//				index = i;
//			}
//		}
//		return index;
//	}
//
//	public void printone(int i) {
//		System.out.println("이름: " + list.get(i).getName() + "\t" + "국어점수: " + list.get(i).getKor() + "\t" + "수학점수: "
//				+ list.get(i).getMat() + "\t" + "영어점수: " + list.get(i).getEng() + "\t" + "총점: " + list.get(i).getTotal()
//				+ "\t" + "평균점수: " + list.get(i).getAvg());
//	}
//
//}
