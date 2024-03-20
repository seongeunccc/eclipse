package Week2_Weekend;

import java.util.LinkedList;

public class StackEx1 {
	public static void main(String[] args) {
		String[] groupA = {"우즈베키스탄", "쿠웨이트", "사우디", "대한민국"};
		
		LinkedList<String> stack = new LinkedList<String>();
		for(String n : groupA)
			stack.offer(n);
		
		String data="";
		while((data = stack.poll())!=null)
			System.out.println(data+"삭제!");
		
	}
}
