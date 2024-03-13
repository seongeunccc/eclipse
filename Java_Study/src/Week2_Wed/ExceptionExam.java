package Week2_Wed;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 	예외처리
 * 	- 정상적인 마무리를 수행하게 해주는 것.
 * 	- try ~ catch 문 : 가독성이 떨어짐.
 * 		: 어떤 상황이 발생할지모르는 경우 Exception으로 받아주기도 가능.
 * 	-throws 
 * 	- finally
 */
public class ExceptionExam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try { // 예상되는 예외를 인식. try 안에서 오류가 발생하면 catch문 실행 
			System.out.println("3을 몇으로 나눌까요?");
			int num = sc.nextInt();

		
			System.out.println(3 / num);
		} catch (ArithmeticException ae) { //catch : 예외 처리기. catch()괄호 안에 오류 나는 코드를 넣음. 
			// 이 괄호 안의 부분은 오류가 나야만 실행됨. 
		//	ae.printStackTrace();  // 얘는 어떤 예외인지 확인하려고 넣어놓은 것. 안 넣어도 됨.
			System.out.println("0으로 나눌 수 없습니다.");
			return ; //return을 만나면 밑에 뭐가 써있던 호출한 곳으로 돌아감.
		} catch (Exception in) { //다중캐치문 사용 가능
			System.out.println("오류 발생");
		} finally { //원래 오류가 나서 리턴을 만나면 프로그램 종료지만 파이널이 있으면 종료되기전 파이널 {} 안에 있는 부분을 무조건 실행함.
			//파이널 안에는 어떤 오류가 나더라도 실행할 구문 넣음. (실무에서는 DB를 닫아라. 이런걸 쓴다고 함.)
		System.out.println("Bye");
		}

	}
}
