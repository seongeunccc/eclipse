import java.util.Scanner;

public class Test{   
	
	public static void main(String []args) {

		Scanner sc;	
		sc = new Scanner(System.in);
		
		System.out.print("첫번째 수 입력 : ");
		int a = sc.nextInt();
		System.out.print("연산 입력 : ");
		String c = sc.next(); 
		System.out.print("두번째 수 입력 : ");
		int b = sc.nextInt();
		
		if (c.equals("+")) {
			System.out.println(a+""+c+""+b+"="+(a+b)); 
		}else if (c.equals("-")) {
			System.out.println(a+""+c+""+b+"="+(a-b));
		}else if (c.equals("*")) {
			System.out.println(a+""+c+""+b+"="+(a*b));
		}else if (c.equals("/")) {
			System.out.println(a+""+c+""+b+"="+((double)a/b));
		}
		else
			
		System.out.println("잘못된 입력");
		}
	}