
public class Star4 {

	public static void main(String[] args) {

		int a = 2, b = 3; // a는 별 앞에 넣을 공백, b는 별 뒤쪽 공백

		for (int i = 1; i <= 3; i++) { // 3행 생성
			for (int j = 1; j < 6; j++) { // 5열 생성
				if (j <= a) { // 별 앞에 공백 생성(2부터 줄어들게 처리)
					System.out.print(" ");
				} else if (j > b) { // 별 찍기 이후에는 아무것도 출력하지 않음
					System.out.print("");
				} else {
					System.out.print("*");
				}
			}
			a--; // 별 개수 두개씩 증가
			b++; // 별 개수 두개씩 증가
			System.out.println(); // 줄 바꿈
		}
	}
}


/*
 * 
 * int a =2, b=3; //a는 별 앞에 넣을 공백, b는 별 뒤쪽 공백
 * 
 * for(int i=1;i<=3;i++) { //3행 생성 for(int j =1; j<6;j++) { //5열 생성 if(j<=a){
 * //별 앞에 공백 생성(2부터 줄어들게 처리) System.out.print(" "); }else if (j>b) { // 별 찍기
 * 이후에는 아무것도 출력하지 않음 System.out.print(""); }else { System.out.print("*"); } }
 * a--; //별 개수 두개씩 증가 b++; //별 개수 두개씩 증가 System.out.println(); //줄 바꿈 }
 * 
 * 
 * 
 * 
 * 
 * 
 * int a = 1; while (a < 6) {
 * 
 * int b = 5; while (b > a) { System.out.print(" "); b -= 2; }
 * 
 * 
 * int c = 0; while (c < a) { System.out.print("*"); c++; }
 * 
 * a += 2; System.out.println(); }
 */