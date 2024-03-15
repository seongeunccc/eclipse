package Set;

public class StudentScoreData {
	private String name;
	private int kor;
	private int mat;
	private int eng;
	private int total;
	private double avg;

	// 생성자함수
	public StudentScoreData() {

	}

	public StudentScoreData(String name, int kor, int mat, int eng) {
		this.name = name;
		this.kor = kor;
		this.mat = mat;
		this.eng = eng;
		this.total = kor + mat + eng;
		this.avg = this.total / 3;
	}

	public void printData() {
		System.out.println("이름: " + name + "\t" + "국어점수: " + kor + "\t" + "수학점수: " + mat + "\t" + "영어점수: " + eng + "\t"
				+ "총점: " + total + "\t" + "평균점수: " + avg);
	}

	// getter, Setter
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
}