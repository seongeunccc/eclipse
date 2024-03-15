package ChatGPT;

import java.util.HashMap;
import java.util.Scanner;

class StudentScoreData {
	private String name;
	private int kor;
	private int mat;
	private int eng;

	// 생성자
	public StudentScoreData(String name, int kor, int mat, int eng) {
		this.name = name;
		this.kor = kor;
		this.mat = mat;
		this.eng = eng;
	}

	// 총점 계산
	public int calculateTotal() {
		return kor + mat + eng;
	}

	// 평균 계산
	public double calculateAverage() {
		return calculateTotal() / 3.0;
	}

	// 데이터 출력
	public void printData() {
		System.out.println("이름: " + name + "\t국어점수: " + kor + "\t수학점수: " + mat + "\t영어점수: " + eng + "\t총점: "
				+ calculateTotal() + "\t평균점수: " + calculateAverage());
	}

	// getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
}

public class HashMapMain {
	Scanner sc = new Scanner(System.in);
	HashMap<String, StudentScoreData> map = new HashMap<>(); // name 을 key 로 설정

	// 메인 함수
	public static void main(String[] args) {
		HashMapMain hm = new HashMapMain();
		hm.runProgram();
	}

	// 프로그램을 실행하는 메소드
	public void runProgram() {
		System.out.println("학생성적관리 프로그램입니다.");
		char an;
		do {
			switch (selectMenu()) {
			case 1:
				inputScore();
				break;
			case 2:
				modifyScore();
				break;
			case 3:
				searchScore();
				break;
			case 4:
				delete();
				break;
			case 5:
				printAllScores();
				break;
			default:
				System.out.println("잘못된 입력입니다."); // 1~4 이외의 값이들어가면 오류메세지 출력
			}
			System.out.println("계속하시겠습니까?(Y/N)"); // 프로그램을 계속 실행할지 여부 입력요청
			an = sc.next().charAt(0);
		} while (an == 'y' || an == 'Y' || an == 'ㅛ'); // Y를 입력받는 동안은 계속 반복
		System.out.println("프로그램을 종료합니다. 수고하셨습니다.");
	}

	// 성적 입력
	public void inputScore() {
		System.out.println("등록할 학생의 이름을 입력하세요.");
		String name = sc.next();
		System.out.println("등록할 학생의 국어성적을 입력하세요.");
		int kor = sc.nextInt();
		System.out.println("등록할 학생의 수학성적을 입력하세요.");
		int mat = sc.nextInt();
		System.out.println("등록할 학생의 영어성적을 입력하세요.");
		int eng = sc.nextInt();

		// 성적을 받아서 StudentScoreData 에 입력 + 이 개체를 맵에 저장
		StudentScoreData stu = new StudentScoreData(name, kor, mat, eng);
		map.put(name, stu); // String name = key / StudentScoreData student = value
	}

	// 전체 성적 출력
	public void printAllScores() {
		for (StudentScoreData student : map.values()) {
			student.printData();
		}
	}

	// 메뉴 선택
	public int selectMenu() {
		System.out.println("원하는 메뉴를 선택하세요: ");
		System.out.println("1. 입력\t2. 수정\t3. 검색\t4. 삭제\t5. 전체 출력");
		return sc.nextInt();
	}

	// 학생 데이터 삭제
	public void delete() {
		System.out.println("누구의 점수를 삭제하시겠습니까?");
		String name = sc.next();
		if (!map.containsKey(name)) {
			System.out.println("해당 학생의 데이터가 존재하지 않습니다.");
		}
		map.remove(name);
		System.out.println("정상적으로 삭제되었습니다.");
	}

	// 성적 수정
	public void modifyScore() {
		System.out.println("어떤 학생의 데이터를 수정할까요? 이름으로 입력해주세요.");
		String name = sc.next();
		if (!map.containsKey(name)) {
			System.out.println("해당 학생의 데이터가 존재하지 않습니다.");
			return;
		} // 검색하는 이름이 없으면 없다고 안내.
		StudentScoreData stu = map.get(name);// 동일한 이름을 가진 녀석의 값을 불러옴.
		System.out.println("어떤 점수를 수정하시겠습니까?");
		System.out.println("1. 이름\t2. 국어\t3. 수학\t4. 영어");
		int option = sc.nextInt();
		switch (option) {
		case 1: // 이름수정 선택시
			System.out.println("변경할 이름을 입력하세요"); // 이름 변경시 key 값이랑 StudentScoreData의 이름이 달라짐
			String newName = sc.next(); // 변경할 이름을 받아서 StudentScoreData 에 입력
			stu.setName(newName); // 변경할 이름을 받아서 StudentScoreData 에 입력
			map.remove(name); // 변경전 이름을 키값으로 가지고 있는 데이터를 삭제
			map.put(newName, stu); // 새로운 이름으로 키 값을 변경해 배열에 삽입
			break;
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
			System.out.println("잘못된 입력입니다.");
		}
	}

	// 성적 검색
	public void searchScore() {
		System.out.println("검색 기준을 선택하세요:");
		System.out.println("1. 이름\t2. 국어\t3. 수학\t4. 영어\t5. 평균 점수");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			searchByName();
			break;
		case 2:
			searchBySubject("국어점수");
			break;
		case 3:
			searchBySubject("수학점수");
			break;
		case 4:
			searchBySubject("영어점수");
			break;
		case 5:
			searchByAverage();
			break;
		default:
			System.out.println("잘못된 입력입니다.");
		}
	}

	// 이름으로 성적 검색
	public void searchByName() {
		System.out.println("검색할 이름을 입력하세요.");
		String name = sc.next();
		if (map.containsKey(name)) {
			map.get(name).printData();
		} else {
			System.out.println("해당 학생의 데이터가 존재하지 않습니다.");
		}
	}

	// 과목별 성적 검색
	public void searchBySubject(String subject) {
		System.out.println("검색할 " + subject + "의 기준을 선택하세요:");
		System.out.println("1. 특정 점수\t2. 특정 점수 이상 \t3. 특정 점수 이하");
		int option = sc.nextInt();
		System.out.println("점수를 입력하세요:");
		int score = sc.nextInt();
		for (StudentScoreData student : map.values()) {
			int studentScore = 0;
			switch (subject) {
			case "국어점수":
				studentScore = student.getKor();
				break;
			case "수학점수":
				studentScore = student.getMat();
				break;
			case "영어점수":
				studentScore = student.getEng();
				break;
			}

			if ((option == 1 && studentScore == score) || (option == 2 && studentScore >= score)
					|| (option == 3 && studentScore <= score)) {
				student.printData();
			}
		}
	}
	
	// 평균 점수로 검색
	public void searchByAverage() {
		System.out.println("검색할 평균 점수의 기준을 선택하세요:");
		System.out.println("1. 특정 점수\t2. 특정 점수 이상 \t3. 특정 점수 이하");
		int option = sc.nextInt();
		System.out.println("검색할 점수를 입력하세요:");
		double avgScore = sc.nextDouble();
		
		for (StudentScoreData student : map.values()) {
			int studentScore = 0;
			if ((option == 1 && studentScore == avgScore) || (option == 2 && studentScore >= avgScore)
				|| (option == 3 && studentScore <= avgScore)) {
				student.printData();
			}
		}
	}
}