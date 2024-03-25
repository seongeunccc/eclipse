
public class WhileTest {
	
	public static void main(String[] args) {
		
		int a = 1;
		int b = 0;
		while (a<500) {
			b++;
			a<<=1; // a*=2; a=a*2

		}
		System.out.println("접은 횟수: " +b);
		System.out.println("사각형 개수: "+a);
	}
}
