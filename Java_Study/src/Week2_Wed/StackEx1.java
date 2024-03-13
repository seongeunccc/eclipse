package Week2_Wed;
import java.util.Stack;
//List 중 Stack 활용 예제
// 스텍은 마지막에 입력한 게 자동으로 나오고 ArrayList/Vector 은 인덱스 지정해 원하는 값을 찾을 수 있음
// 스레드의 동기화 지원여부(vector = 스레드 지원 / Arraylist 스레드 미지원 / 그래도 싱크로나이트(?)뭐를 쓰면 동기화 가능하다함)
// 그래서 arraylist 제일 많이 사용(제일 최근에 나옴)

public class StackEx1 {
	public static void main(String[] args) {
		String[] groupA = {"우즈베키스탄","쿠웨이트","사우디","대한민국"};
		
		Stack<String> stack = new Stack<String>();
		for(String n : groupA)  
			//foreach 문 구조가 배열명이 뒤에 오고 앞에는 배열의 타입 작성. 중간에 n은 그냥 변수명인데 맘대루 적어도ㄴ 됨
			
			stack.push(n);
		
		while(!stack.isEmpty())
			System.out.println(stack.pop());		
	}
}