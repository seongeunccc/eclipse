
class WhileTest2 {

	public static void main(String[] args) {

		int a = 1;
		while (a < 10) {
			int b = 2;
			while (b < 10) {
				System.out.print(b + "" + "*" + a + "=" + (a * b) + "\t");
				b++;
			}
			a++;
			System.out.println();
		}
	}
}
