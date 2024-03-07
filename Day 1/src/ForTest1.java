
public class ForTest1 {

	public static void main(String[] args) {

		int a = 1; // 증가
		int b = 2; // 2단부터 시작

		for (a = 1; a < 10; a++) {
			for (b = 2; b < 10; b++) {
				System.out.print(b + "" + "*" + a + "=" + (a * b) + "\t");

			}
			System.out.println();
		}

	}
}
//for문 사용할 때 무한루프 주의