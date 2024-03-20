package March19Exam;

import java.util.LinkedList;
import java.util.Scanner;

public class Collate {
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
	void runProgram() {
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
		System.out.println("고생하셨습니다.");
	}
	
	
	//오버로딩 (정수를 넣어주면 그 값을 반환
	void runProgram(int input) {
			setNum(input);
			collateNum();
			zeroCheck();
			System.out.print("입력한 수 : "+ input);
			System.out.print(" 정렬된 수 : ");
			
			printcollate();
			System.out.println(" ");
	
	}

	// 메인함수
	public static void main(String[] args) {
		Collate ca = new Collate();
	 	ca.runProgram(); // 얘는 입력한 정수를 작은 수 변경해주는 프로그램
		
// 얘는 반복문 사용해서 테스트하는 것(1000~9999)	 	
//		for(int i=1000;i<10000;i++){
//			ca.runProgram(i);
//		}
		
	}

}
