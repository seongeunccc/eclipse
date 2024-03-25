package Week3_Wed;

import java.util.Scanner;

public class LnikedExam {

	static LinkNode head;
	static LinkNode cur;
	static LinkNode newNode;
	static LinkNode del;

	public static void main(String[] args) {

		head = cur = newNode = new LinkNode();
		newNode.next = null;

		newNode.setData(1);
		// newNode.next = null;

		// newNode = new LinkNode();
		newNode.next = new LinkNode();
		newNode.next.setData(2);
		newNode.next.next = null;

		newNode.next.next = new LinkNode();
		newNode.next.next.setData(3);
		newNode.next.next.next = null;

		newNode.next.next.next = new LinkNode();
		newNode.next.next.next.setData(4);
		newNode.next.next.next.next = null;

		newNode = new LinkNode();
		newNode.next = head;
		head = newNode;

		newNode.setData(5);


		
		//여기가 내가 짠 부분
		cur = head;
		Scanner sc = new Scanner(System.in);
		System.out.println("몇번째에 데이터를 삽입하시겠습니까?");
		int an = sc.nextInt();

		newNode = new LinkNode();
		newNode.setData(6);
		if (an == 1) {
			newNode.next = head;
			head = newNode;
		} else {
			cur = head;
			for (int i = 2; i < an; i++) {
				cur = cur.next;
			}
			newNode.next = cur.next;
			cur.next = newNode;
		}

		cur = head;
		// 출력
		while (cur != null) {
			System.out.println(cur.getData());
			cur = cur.next;
		}

		
		
		
		
		cur = head;
		System.out.println("몇번째 데이터를 삭제하시겠습니까?");
		an = sc.nextInt();
		if (an == 1) {
			del = head;
			head = head.next;   //얘만 써도 가능하긴 함.
			del.next = null;
			del = null;
			
		} else {
			cur = head;
			for (int i = 2; i < an; i++) {
				cur = cur.next;
			}
			del = cur.next;
			cur.next = cur.next.next;  //얘만 써도 가능하긴 함
			del.next = null;
			del = null;
		}
		
		
		
		cur = head;
		// 출력
		while (cur != null) {
			System.out.println(cur.getData());
			cur = cur.next;
		}

		
		
	}
}