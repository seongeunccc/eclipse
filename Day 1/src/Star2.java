

public class Star2 {

	public static void main(String[] args) {

		int a = 1;
		while (a < 4) {
			int b = 0;
			while (b < a) {
				System.out.print("* ");
				b++;
			}
			a++;
			System.out.println();
		}
	}
}
