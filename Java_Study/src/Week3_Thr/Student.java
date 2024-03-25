package Week3_Thr;

public class Student {
	private String name;
	private int kor;
	private int mat;
	private int eng;
	
	Student next;
	
	//생성자 함수
	public Student(){
		kor = 0;
		mat = 0;
		eng = 0 ;
	}
	
	public Student(String name, int kor, int mat, int eng){
		this.name = name;
		this.kor = kor;
		this.mat = mat;
		this.eng = eng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {

		this.kor = kor;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}
	
	

	public int getTotal() {
		return kor+ mat+eng;
	}
	
	
	
	public double getAvg() {
		return (kor+ mat+eng)/3.f;
	}
	
	
	
}
