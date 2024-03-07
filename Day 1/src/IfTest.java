
import java.util.Scanner;  // API 가져오기 본 건은 스캐너 api 가져옴

public class IfTest {   
	
	public static void main(String []args) {   //main 함수로 클래스 시작

		Scanner sc;			//scanner 클래스 불러오기 - 콘솔에 값을 입력하면 그 값을 변수로 받아옴
		sc = new Scanner(System.in);
		
		System.out.print("첫번째 수 입력 : ");
		int a = sc.nextInt();
		
		System.out.print("두번째 수 입력 : ");
		int b = sc.nextInt();
		
		
		if (a>b) {
			System.out.println("a가 크다");
		}
		else if(a==b) {
			System.out.println("a와 b가 같다");
		}
		else {
			System.out.println("b가 크다");
		}
	}
	
}