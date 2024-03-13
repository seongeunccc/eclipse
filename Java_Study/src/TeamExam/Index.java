package TeamExam;

public class Index {
	
	//field
	int num ;
	String str ;
	
	//생성자함수
	public Index (int a) {
		num = a;
	}
	public Index(String a) {
		str = a;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}
