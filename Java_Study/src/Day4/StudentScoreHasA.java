package Day4;

//성적처리 클래스
public class StudentScoreHasA {
	// 이름=> name
	// 과목=> subject
	// 총점, 평균 -> 여기서 만들기

	// 외부 클래스 객체 생성
	Name name;
	Subject kor;
	Subject mat;
	Subject eng;


	public StudentScoreHasA() {
		name = new Name();
		kor = new Subject();
		mat = new Subject();
		eng = new Subject();
	}
	
	public StudentScoreHasA(Name name, Subject kor, Subject mat, Subject eng) {
		this.name = name;
		this.kor = kor;
		this.mat = mat;
		this.eng = eng;
	}

	// 외부 클래스 데이터 접근(gettet, setter)
	void setName(String aa) {

		name.setName(aa);
	}

	String getName() {
		return name.getName();
	}

	void setKor(int aa) {
		kor.setSubject(aa);
	}

	int getKor() {
		return kor.getSubject();
	}

	void setMat(int aa) {
		mat.setSubject(aa);
	}

	int getMat() {
		return mat.getSubject();
	}

	void setEng(int aa) {
		eng.setSubject(aa);
	}

	int getEng() {
		return eng.getSubject();
	}

	// 외부 클래스의 값에 접근해서 합계, 평균 계산
	int getTotal() {
		int a = kor.getSubject() + mat.getSubject() + eng.getSubject();
		return a;
	}

	double getAvg() {
		double a =  getTotal() / 3.f;
		return a;
	}
}
