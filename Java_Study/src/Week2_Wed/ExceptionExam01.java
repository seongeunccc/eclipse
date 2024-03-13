package Week2_Wed;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 메소드 뒤에 throw 작성하면 ~~한 예외가 발생할 수 있다. 다만 직접 처리하지 않고 알아서 위에 적어놓은 곳에서 처리함. 
 * 0으로 나눴을 때 나오는 오류도 ArithmeticException 에 던지긴 하지만 0을 처리해주는 내용이 없어서  catch값을 넣어줌. 
 */
public class ExceptionExam01 extends Exception {
	
	//나만의 예외처리 클래스 : Exception을 상속받아서 오버라이딩
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[];
		arr = new int [5];
		
			try {
			System.out.println("3을 몇으로 나눌까요?");
			int num = sc.nextInt();
			System.out.println(3 / num);
			
			} catch(ArithmeticException ae) {
				System.out.println("------------------------");
				System.out.println("0으로 나눌 수 없습니다.");
				System.out.println("0으로 나누는 오류 발생");
			}
			System.out.println("");
			System.out.println("배열에 저장할 정수를 입력하세요");
			try { 
				arr[5] = sc.nextInt();
				
			} catch(ArrayIndexOutOfBoundsException aio) {
				System.out.println("------------------------");
				System.out.println("입력 가능한 배열의 길이를 초과하였습니다.");
				System.out.println("선언한 배열의 길이를 초과하는 곳에 데이터 입력됨");
			}
			System.out.println("Bye");
	}
}
	
	
			//무조건 예외처리가 발생하는 구문.
			//Thread.sleep(3000); //3000 = 3초간 기다려라 (컴퓨터 기본 시간 단위 밀리세컨드 1000 = 1초)
			// 이 구문은 무조건 try-catch가 필요한 구문임. 그래서  걍 InterruptedException 이것만 가져다 붙여도 에러 없이 해결가능함.
			
			
			
