package Week3_Thr;

import java.util.Scanner;

public class StuManagementLinked {

	static Student head;
	static Student cur;
	static Student newNode;
	static Student del;
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StuManagementLinked stu = new StuManagementLinked();
		stu.runProgram();
	}

	void runProgram() {
		char answer;
		do {
			System.out.println("학생관리 프로그램입니다. 무엇을 도와드릴까요?");
			System.out.println("1. 입력  2. 수정  3. 검색  4. 삭제  5. 전체 출력 ");
			int ans = sc.nextInt();

			switch (ans) {
			case 1:
				input(score());
				break;
			case 2:
				modify();
				break;
			case 3:
				serch();
				break;
			case 4:
				delete();
				break;
			case 5:
				printAll();
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			}
			System.out.println("계속하시겠습니까? (Y/N)");
			answer = sc.next().charAt(0);
		} while (answer == 'y' || answer == 'Y');
		System.out.println("프로그램을 종료합니다. 고생하셨습니다.");
	}

	Student score() {
		newNode = new Student();
		System.out.println("학생 이름을 입력하세요.");
		newNode.setName(sc.next());
		System.out.println("국어성적을 입력하세요");
		newNode.setKor(sc.nextInt());
		System.out.println("수학성적을 입력하세요");
		newNode.setMat(sc.nextInt());
		System.out.println("영어성적을 입력하세요");
		newNode.setEng(sc.nextInt());

		return newNode;
	}

	void input(Student newNode) {

		if (head == null) {
			head = cur = newNode;
		} else if (head.getTotal() < newNode.getTotal()) { // input 총점 1등교체
			newNode.next = head;
			head = newNode;
		} else {
			cur = head;
			while (cur.next != null) {
				if (cur.next.getTotal() < newNode.getTotal()) { // 중간에 학생추가
					break;
				}
				cur = cur.next;
			}
			newNode.next = cur.next;
			cur.next = newNode;

		}
	}

	void scoreModify(Student newNode) {

		System.out.println("무엇을 수정하시겠습니까?");
		System.out.println("1. 이름  2. 국어점수  3. 수학점수  4. 영어점수");
		int ans = sc.nextInt();
		switch (ans) {
		case 1:
			System.out.println("변경할 이름을 입력하세요.");
			newNode.setName(sc.next());
			break;
		case 2:
			System.out.println("변경할 국어 점수를 입력하세요.");
			newNode.setKor(sc.nextInt());
			break;
		case 3:
			System.out.println("변경할 수학 점수를 입력하세요.");
			newNode.setMat(sc.nextInt());
			break;
		case 4:
			System.out.println("변경할 영어 점수를 입력하세요.");
			newNode.setEng(sc.nextInt());
			break;
		default:
			System.out.println("잘못된 입력입니다.");
		}
	}

	void modify() {

		System.out.println("수정할 학생 이름을 입력하세요.");
		String an = sc.next();

		if (head.getName().equals(an)) {
			System.out.println("수정할 학생의 정보를 출력합니다.");
			printOne(head);
			scoreModify(head);
			del = head;
			head = head.next;
			input(del);
		} else {
			cur = head;
			while (cur.next != null) {
				if (cur.next.getName().equals(an)) {
					System.out.println("수정할 학생의 정보를 출력합니다.");
					printOne(cur.next);
					scoreModify(cur.next);

					del = cur.next;
					cur.next = cur.next.next;
					input(del);
					break;
				}
				cur = cur.next;
				if (cur.next == null) {
					System.out.println("입력한 학생이 존재하지 않습니다.");
				}
			}
		}
	}

	void delete() {
		System.out.println("삭제할 학생 이름을 입력하세요.");
		String an = sc.next();

		cur = head;

		if (head.getName().equals(an)) {
			printOne(head);
			del = head;
			head = head.next;
		} else {
			while (cur != null) {
				if (cur.next.getName().equals(an)) {
					printOne(cur.next);
					break;
				}
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		System.out.println("학생의 데이터가 정상적으로 삭제되었습니다.");
	}

	void serch() {
		System.out.println("검색할 학생 이름을 입력하세요.");
		String an = sc.next();
		cur = head;
		while (cur != null) {
			if (cur.getName().equals(an)) {
				printOne(cur);
				break;
			}
			cur = cur.next;
		}
	}

	void printOne(Student cur) {
		System.out.println("이름 : " + cur.getName() + " 국어 :" + cur.getKor() + " 수학 :" + cur.getMat() + " 영어 :"
				+ cur.getEng() + " 총점 :" + cur.getTotal() + " 평균 :" + cur.getAvg());
	}

	void printAll() {
		cur = head;
		while (cur != null) {
			printOne(cur);
			cur = cur.next;
		}
	}
}
