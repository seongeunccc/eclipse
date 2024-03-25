/*
 * 반복문
 * : 조건
 * 
 * for 문
 * While 문
 * 조건 따지고 실행여부 결정
 * 
 * do ~ while 문 / 무조건 한번 실행 후 조건 따짐
 * 
 * foreach문 : 배열을 사용할 때 사용
 * 
 * for (초기문; 조건문, 증감문){
 * ......
 * }
 * 조건이 참이면 {}실행, 거짓이면 {}탈출, 참일 때 괄호 실행 후 증감문 실행 -> 조건이 거짓이 될 때까지 반복
 * 
 */

public class ForTest {
			
	public static void main(String[] args) {
		
		int a = 1; //사각형의 개수
		int b = 0; //접은 횟수
		
		for (b = 0;a<500;b++) {

			a<<=1; // a*=2; a=a*2 비트 연산자 사용

		}
		System.out.println("접은횟수: "+b);
		System.out.println("사각형의 개수: "+a);
	}
}
