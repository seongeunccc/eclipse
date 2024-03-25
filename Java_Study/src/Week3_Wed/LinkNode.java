package Week3_Wed;

public class LinkNode {
	private int data;
	 LinkNode next;

	// 생성자 함수
	public void LinkNode(int data, LinkNode next) {
		this.data = data;
		this.next = next;
	}

	// 메소드
	public void setData(int a) {
		this.data = a;
	}

	public int getData() {
		return data;
	}

}
