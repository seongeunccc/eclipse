package StudentScoreManagement;

import java.util.ArrayList;
import java.util.Scanner;

class StudentScoreData {
	private String name;
	private int kor;
	private int mat;
	private int eng;
	private int total;
	private double avg;

	// 생성자함수
	public StudentScoreData() {

	}

	public StudentScoreData(String name, int kor, int mat, int eng) {
		this.name = name;
		this.kor = kor;
		this.mat = mat;
		this.eng = eng;
		this.total = kor + mat + eng;
		this.avg = this.total / 3;
	}

	public void printData() {
		System.out.println("이름: " + name + "\t" + "국어점수: " + kor + "\t" + "수학점수: " + mat + "\t" + "영어점수: " + eng + "\t"
				+ "총점: " + total + "\t" + "평균점수: " + avg);
	}

	// getter, Setter
	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
}

public class ListMain {

	// 생성자함수
	public ListMain() {
		// ArrayList<StudentScoreData> list = new ArrayList<StudentScoreData>();
	}

	Scanner sc = new Scanner(System.in);

	ArrayList<StudentScoreData> list = new ArrayList<StudentScoreData>();
	// LinkedList<StudentScoreData> list = new LinkedList<StudentScoreData>();
	// linkedlist 랑 사실 거의 비슷한 형태를 가짐. 사용자입장에서는 차이가 없고 처리 방식만 좀 다름(오버라이딩되어서 같은 형태의
	// 함수로 사용가능)

	// 메인구문
	public static void main(String[] args) {
		ListMain lm = new ListMain();

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

	// 만들어놓은 메소드
	public void inputScore() {
		System.out.println("학생의 데이터를 입력하세요. (name/kor/mat/eng 순으로)");
		list.add(new StudentScoreData(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));

	}

	// arrayList 에서 studentScoreData 를 꺼냄.
	public void printall() {
		for (StudentScoreData stsd : list) {
			stsd.printData(); // StudentScoreData에서 정의해놓은 메소드 printData를 리스트 전체에서 실행
		}
	}

	public int selectMenu() { // 어떤 메뉴를 선택할지 묻는 메소드
		System.out.println("학생 성적 관리 프로그램입니다. 원하는 메뉴를 선택하세요.(숫자로 입력)");
		System.out.println("1.입력" + "\t" + "2.수정" + "\t" + " 3.검색" + "\t" + " 4.전체출력");
		return sc.nextInt();
	}

	public void modify() {
		System.out.println("누구의 점수를 수정하시겠습니까?");
		int an = serchName();
		System.out.println("어떤 점수를 수정하시겠습니까?");
		System.out.println("1.이름 2.국어성적 3.수학성적 4.영어성적 (숫자로 입력)");
		switch (sc.nextInt()) {
		case 1:
			System.out.println("변경할 이름을 입력하세요");
			list.get(an).setName(sc.next());
			break;
		case 2:
			System.out.println("변경할 국어 점수를 입력하세요");
			list.get(an).setKor(sc.nextInt());
			break;
		case 3:
			System.out.println("변경할 수학 점수를 입력하세요");
			list.get(an).setMat(sc.nextInt());
			break;
		case 4:
			System.out.println("변경할 영어 점수를 입력하세요");
			list.get(an).setEng(sc.nextInt());
			break;
		default:
			System.out.println("잘못된 입력입니다.(modify)");
		}
	}

	public void serch() {
		System.out.println("어떤 것을 기준으로 검색하시겠습니까?");
		System.out.println("1.이름 2.국어성적 3.수학성적 4.영어성적 5.평균점수(숫자로 입력)");
		switch (sc.nextInt()) {
		case 1:
			printone(serchName());
			break;
		case 2:
			switch (answer2()) {
			case 1:
				System.out.println("검색할 점수를 입력하세요.");
				int a = sc.nextInt();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getKor() == a) {
						printone(i);
					}
				}
				break;
			case 2:
				System.out.println("몇점 이상의 점수를 검색할까요");
				a = sc.nextInt();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getKor() >= a) {
						printone(i);
					}
				}
				break;
			case 3:
				System.out.println("몇점 이하의 점수를 검색할까요");
				a = sc.nextInt();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getKor() <= a) {
						printone(i);
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
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getMat() == a) {
						printone(i);
					}
				}
				break;
			case 2:
				System.out.println("몇점 이상의 점수를 검색할까요");
				a = sc.nextInt();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getMat() >= a) {
						printone(i);
					}
				}
				break;
			case 3:
				System.out.println("몇점 이하의 점수를 검색할까요");
				a = sc.nextInt();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getMat() <= a) {
						printone(i);
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
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getEng() == a) {
						printone(i);
					}
				}
				break;
			case 2:
				System.out.println("몇점 이상의 점수를 검색할까요");
				a = sc.nextInt();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getEng() >= a) {
						printone(i);
					}
				}
				break;
			case 3:
				System.out.println("몇점 이하의 점수를 검색할까요");
				a = sc.nextInt();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getEng() <= a) {
						printone(i);
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
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getAvg() == a) {
						printone(i);
					}
				}
				break;
			case 2:
				System.out.println("몇점 이상의 점수를 검색할까요");
				a = sc.nextInt();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getAvg() >= a) {
						printone(i);
					}
				}
				break;
			case 3:
				System.out.println("몇점 이하의 점수를 검색할까요");
				a = sc.nextInt();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getAvg() <= a) {
						printone(i);
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

	public int serchName() {
		int index = 0;
		System.out.println("검색할 이름을 입력하세요.");
		String an = sc.next();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName() == an) {
				index = i;
			}
		}
		return index;
	}

	public void printone(int i) {
		System.out.println("이름: " + list.get(i).getName() + "\t" + "국어점수: " + list.get(i).getKor() + "\t" + "수학점수: "
				+ list.get(i).getMat() + "\t" + "영어점수: " + list.get(i).getEng() + "\t" + "총점: " + list.get(i).getTotal()
				+ "\t" + "평균점수: " + list.get(i).getAvg());
	}

}
