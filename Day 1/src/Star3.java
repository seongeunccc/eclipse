
public class Star3 {

	public static void main(String[] args) {

		int a = 1;  	
		int c = 2;
		while (a < 4) {  //3개의 행 만들기
			int b = 1;
		
			while (b < 4) {		//3개의 열 만들기
				if (b<=c) {
					System.out.print(" ");
				}else {
				System.out.print("*");
				}
				b++;
			}
			c--;
			a++;
			System.out.println();
		}
	}
}
