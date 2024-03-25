package Week3_Wed;
import java.util.Scanner;

public class RecursiveCall {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RecursiveCall rs = new RecursiveCall();

//		팩토리얼 출력
//		System.out.println("어떤 수의 팩토리얼을 확인할까요?");
//		int a = sc.nextInt(); //팩토리얼 확인하고 싶은 수 입력받기
//		
//		System.out.println(a+"! = "+rs.Factorial(a)); //출력
		
		
		System.out.println("피보나치 수열의 몇번째 값을 출력할까요?");
		int b = sc.nextInt(); //팩토리얼 확인하고 싶은 수 입력받기
		for (int i = 1; i<=b;i++)
		System.out.println("피보나치 수열의 "+i+"번째 값 : "+rs.fibonacci(i)); //출력		
	}

	//피보나치 수열구하기 (재귀함수 사용  ver)
		int fibonacci(int i) {
			if(i==1) {
				return 0;
			}
			if(i==2) {
				return 1;
			}
			return fibonacci(i-1)+fibonacci(i-2);
		}
	
	//재귀함수 사용한 팩토리얼 구하기 메소드
	//재귀함수 단점 : 메모리 사용량이 증가한다. : 메모리를 많이 쓰는 함수는 재귀함수 쓰지 말기.
	//재귀함수 장점 : 코드가 간결해진다. (더 효율적임)
	int Factorial(int input) {
		if (input == 1) {
			return input;
		}
		int result;
		result = input * Factorial(input - 1);
		
		return result;
	}
	
	//Do ~ While  사용한 팩토리얼 구하기 메소드
	void doWhile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("어떤 수의 팩토리얼을 확인할까요?");

		int result = 1;
		int input = 0;
		int input2;
		input = sc.nextInt();
		input2 = input;
		do {
			result = result * input;

			input--;

		} while (input != 0);
		System.out.println(input2 + "! = " + result);
	}
	
	
	
}
