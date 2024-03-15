package Set;

import java.util.*;

public class SetMain extends StudentScoreData {

	// 생성자함수
	public SetMain() {
	}

	StudentScoreData stsd;
	Scanner sc = new Scanner(System.in);
	Set<StudentScoreData> st = new HashSet<StudentScoreData>();
	Iterator<StudentScoreData> it = st.iterator();

	// 메인구문
	public static void main(String[] args) {
		SetMain lm = new SetMain();

		char an;
		do {
			switch (lm.selectMenu()) {

			case 1:
				lm.inputScore();
				break;
			case 2:// 2. 수정
				lm.modify();
				break;
			case 3: // 3. 검색
				lm.serch();
				break;
			case 4:
				lm.printall();
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			}

			System.out.println("계속하시겠습니까?(Y/N)");
			an = lm.sc.next().charAt(0);
		} while (an == 'y' || an == 'Y' || an == 'ㅛ');
		System.out.println("프로그램을 종료합니다. 고생하셨습니다.");

	}


	void find(StudentScoreData stsd) {
		System.out.println("이름: " + stsd.getName() + "\t" + "국어점수: " + stsd.getKor() + "\t" + "수학점수: " + stsd.getMat()
				+ "\t" + "영어점수: " + stsd.getEng() + "\t" + "총점: " + stsd.getTotal() + "\t" + "평균점수: " + stsd.getAvg());
	}

	// 만들어놓은 메소드
	public void inputScore() {
		System.out.println("학생의 데이터를 입력하세요. (name/kor/mat/eng 순으로)");
		st.add(new StudentScoreData(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));

	}

	// arrayList 에서 studentScoreData 를 꺼냄.
	public void printall() {
		for (StudentScoreData stsd : st) {
			stsd.printData(); // StudentScoreData에서 정의해놓은 메소드 printData를 리스트 전체에서 실행
		}
	}

	public int selectMenu() { // 어떤 메뉴를 선택할지 묻는 메소드
		System.out.println("학생 성적 관리 프로그램입니다. 원하는 메뉴를 선택하세요.(숫자로 입력)");
		System.out.println("1.입력" + "\t" + "2.수정" + "\t" + " 3.검색" + "\t" + " 4.전체출력");
		return sc.nextInt();
	}

	public void modify() {
		it = st.iterator();
		System.out.println("누구의 점수를 수정하시겠습니까?");
		String nn = sc.next();
		while (it.hasNext()) {
			StudentScoreData stu = (StudentScoreData) it.next();
			if (stu.getName().equals(nn)) {
				
				System.out.println("어떤 점수를 수정하시겠습니까?");
				System.out.println("1.이름 2.국어성적 3.수학성적 4.영어성적 (숫자로 입력)");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("변경할 이름을 입력하세요");
					stu.setName(sc.next());		break;
				case 2:
					System.out.println("변경할 국어 점수를 입력하세요");

					stu.setKor(sc.nextInt());
					break;
				case 3:
					System.out.println("변경할 수학 점수를 입력하세요");
					stu.setMat(sc.nextInt());
					break;
				case 4:
					System.out.println("변경할 영어 점수를 입력하세요");
					stu.setEng(sc.nextInt());
					break;
				default:
					System.out.println("잘못된 입력입니다.(modify)");								
					find(stu);
				}
			}
		}
	}		
	public void serch() {
		System.out.println("어떤 것을 기준으로 검색하시겠습니까?");
		System.out.println("1.이름 2.국어성적 3.수학성적 4.영어성적 5.평균점수(숫자로 입력)");
		it = st.iterator();
		// StudentScoreData stu = (StudentScoreData) it.next();

		switch (sc.nextInt()) {
		case 1:
			System.out.println("검색할 이름을 입력하세요");
			String nn = sc.next();
			while (it.hasNext()) {
				StudentScoreData stu = (StudentScoreData) it.next();
				if (stu.getName().equals(nn)) {
					find(stu);
				}
			}
			break;
		case 2:
			switch (answer2()) {
			case 1:
				System.out.println("검색할 점수를 입력하세요.");
				int a = sc.nextInt();
				while (it.hasNext()) {
					StudentScoreData stu = (StudentScoreData) it.next();
					if (stu.getKor() == a) {
						find(stu);
					}
				}
				break;
			case 2:
				System.out.println("몇점 이상의 점수를 검색할까요");
				a = sc.nextInt();
				while (it.hasNext()) {
					StudentScoreData stu = (StudentScoreData) it.next();
					if (stu.getKor() >= a) {
						find(stu);
					}
				}
				break;
			case 3:
				System.out.println("몇점 이하의 점수를 검색할까요");
				a = sc.nextInt();
				while (it.hasNext()) {
					StudentScoreData stu = (StudentScoreData) it.next();
					if (stu.getKor() <= a) {
						find(stu);
					}
				}
				break;
			default:
				System.out.println("잘못된 입력입니다.(serchKor)");
			}
			break;
		case 3:
			switch (answer2()) {
			case 1:
				System.out.println("검색할 점수를 입력하세요.");
				int a = sc.nextInt();
				while (it.hasNext()) {
					StudentScoreData stu = (StudentScoreData) it.next();
					if (stu.getMat() == a) {
						find(stu);
					}
				}
				break;
			case 2:
				System.out.println("몇점 이상의 점수를 검색할까요");
				a = sc.nextInt();
				while (it.hasNext()) {
					StudentScoreData stu = (StudentScoreData) it.next();
					if (stu.getMat() >= a) {
						find(stu);
					}
				}
				break;
			case 3:
				System.out.println("몇점 이하의 점수를 검색할까요");
				a = sc.nextInt();
				while (it.hasNext()) {
					StudentScoreData stu = (StudentScoreData) it.next();
					if (stu.getMat() <= a) {
						find(stu);
					}
				}
				break;
			default:
				System.out.println("잘못된 입력입니다.(serchMat)");
			}
			break;

		case 4:
			switch (answer2()) {
			case 1:
				System.out.println("검색할 점수를 입력하세요.");
				int a = sc.nextInt();
				while (it.hasNext()) {
					StudentScoreData stu = (StudentScoreData) it.next();
					if (stu.getEng() == a) {
						find(stu);
					}
				}
				break;
			case 2:
				System.out.println("몇점 이상의 점수를 검색할까요");
				a = sc.nextInt();
				while (it.hasNext()) {
					StudentScoreData stu = (StudentScoreData) it.next();
					if (stu.getEng() >= a) {
						find(stu);
					}
				}
				break;
			case 3:
				System.out.println("몇점 이하의 점수를 검색할까요");
				a = sc.nextInt();
				while (it.hasNext()) {
					StudentScoreData stu = (StudentScoreData) it.next();
					if (stu.getEng() <= a) {
						find(stu);
					}
				}
				break;
			default:
				System.out.println("잘못된 입력입니다.(serchEng)");
			}
			break;

		case 5:
			switch (answer2()) {
			case 1:
				System.out.println("검색할 점수를 입력하세요.");
				int a = sc.nextInt();

				while (it.hasNext()) {
					StudentScoreData stu = (StudentScoreData) it.next();
					if (stu.getAvg() == a) {
						find(stu);
					}
				}
				break;
			case 2:
				System.out.println("몇점 이상의 점수를 검색할까요");
				a = sc.nextInt();
				while (it.hasNext()) {
					StudentScoreData stu = (StudentScoreData) it.next();
					if (stu.getAvg() >= a) {
						find(stu);
					}
				}
				break;
			case 3:
				System.out.println("몇점 이하의 점수를 검색할까요");
				a = sc.nextInt();
				while (it.hasNext()) {
					StudentScoreData stu = (StudentScoreData) it.next();
					if (stu.getAvg() <= a) {
						find(stu);
					}
				}
				break;
			default:
				System.out.println("잘못된 입력입니다.(serchAvg)");
			}
			break;

		default:
			System.out.println("잘못된 입력입니다.(serch)");
		}
	}

	public int answer2() {
		System.out.println("어떤 것을 기준으로 검색하시겠습니까?");
		System.out.println("1.특정점수 검색 2.특정점수 이상 검색 3. 특정점수 이하 검색");
		return sc.nextInt();
	}

	public void serchName() {
		System.out.println("검색할 이름을 입력하세요.");
		Iterator<StudentScoreData> it = st.iterator();
		String an = sc.next();
		while (it.hasNext()) {
			StudentScoreData stu = (StudentScoreData) it.next();
			if (stu.getName().equals(an)) {
				find(stu);
			}
		}

	}

}
