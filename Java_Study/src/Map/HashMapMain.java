package Map;

import java.util.HashMap;
import java.util.Scanner;
class StudentScoreData {
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
        this.avg = this.total / 3.0; // 소수점으로 계산하기 위해 3.0으로 나눔
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

public class HashMapMain {

	 Scanner sc = new Scanner(System.in);

	    HashMap<String, StudentScoreData> map = new HashMap<>();

	    // 메인구문
	    public static void main(String[] args) {
	        HashMapMain hm = new HashMapMain();

	        char an;
	        do {
	            switch (hm.selectMenu()) {

	                case 1:
	                    hm.inputScore();
	                    break;
	                case 2:// 2. 수정
	                    hm.modify();
	                    break;
	                case 3: // 3. 검색
	                    hm.search();
	                    break;
	                case 4:
	                    hm.printAll();
	                    break;
	                default:
	                    System.out.println("잘못된 입력입니다.");
	            }

	            System.out.println("계속하시겠습니까?(Y/N)");
	            an = hm.sc.next().charAt(0);
	        } while (an == 'y' || an == 'Y'||an == 'ㅛ');
	        System.out.println("프로그램을 종료합니다. 고생하셨습니다.");
	    }

	    // 만들어놓은 메소드
	    public void inputScore() {
	        System.out.println("학생의 데이터를 입력하세요. (name/kor/mat/eng 순으로)");
	        String name = sc.next();
	        int kor = sc.nextInt();
	        int mat = sc.nextInt();
	        int eng = sc.nextInt();
	        StudentScoreData student = new StudentScoreData(name, kor, mat, eng);
	        map.put(name, student);
	    }

	    // hashMap 에서 studentScoreData 를 꺼냄.
	    public void printAll() {
	        for (StudentScoreData student : map.values()) {
	            student.printData(); // StudentScoreData에서 정의해놓은 메소드 printData를 리스트 전체에서 실행
	        }
	    }

	    public int selectMenu() { // 어떤 메뉴를 선택할지 묻는 메소드
	        System.out.println("학생 성적 관리 프로그램입니다. 원하는 메뉴를 선택하세요.(숫자로 입력)");
	        System.out.println("1.입력" + "\t" + "2.수정" + "\t" + " 3.검색" + "\t" + " 4.전체출력");
	        return sc.nextInt();
	    }

	    public void modify() {
	        System.out.println("누구의 점수를 수정하시겠습니까?");
	        String name = sc.next();
	        if (!map.containsKey(name)) {
	            System.out.println("해당 학생의 데이터가 존재하지 않습니다.");
	            return;
	        }
	        StudentScoreData student = map.get(name);
	        System.out.println("어떤 점수를 수정하시겠습니까?");
	        System.out.println("1.이름 2.국어성적 3.수학성적 4.영어성적 (숫자로 입력)");
	        switch (sc.nextInt()) {
	            case 1:
	                System.out.println("변경할 이름을 입력하세요");
	                String newName = sc.next();
	                student.setName(newName);
	                map.remove(name);
	                map.put(newName, student);
	                break;
	            case 2:
	                System.out.println("변경할 국어 점수를 입력하세요");
	                student.setKor(sc.nextInt());
	                break;
	            case 3:
	                System.out.println("변경할 수학 점수를 입력하세요");
	                student.setMat(sc.nextInt());
	                break;
	            case 4:
	                System.out.println("변경할 영어 점수를 입력하세요");
	                student.setEng(sc.nextInt());
	                break;
	            default:
	                System.out.println("잘못된 입력입니다.(modify)");
	        }
	    }

	    public void search() {
	        System.out.println("어떤 것을 기준으로 검색하시겠습니까?");
	        System.out.println("1.이름 2.국어성적 3.수학성적 4.영어성적 5.평균점수(숫자로 입력)");
	        switch (sc.nextInt()) {
	            case 1:
	                System.out.println("검색할 이름을 입력하세요.");
	                String name = sc.next();
	                if (map.containsKey(name)) {
	                    printOne(name);
	                } else {
	                    System.out.println("해당 학생의 데이터가 존재하지 않습니다.");
	                }
	                break;
	            case 2:
	                searchSubject("국어점수");
	                break;
	            case 3:
	                searchSubject("수학점수");
	                break;
	            case 4:
	                searchSubject("영어점수");
	                break;
	            case 5:
	                searchAvg();
	                break;
	            default:
	                System.out.println("잘못된 입력입니다.");
                
        }
    }
	    public void searchAvg() {
	        System.out.println("검색할 평균 점수를 입력하세요:");
	        double avgScore = sc.nextDouble();

	        for (StudentScoreData student : map.values()) {
	            if (student.getAvg() == avgScore) {
	                student.printData();
	            }
	        }
	    }
	    
	    public void printOne(String name) {
	        StudentScoreData student = map.get(name);
	        student.printData();
	    }
	    
	    public void searchSubject(String subject) {
	        System.out.println("검색할 " + subject + "의 기준을 선택하세요:");
	        System.out.println("1. 특정 점수 이상  2. 특정 점수 이하  3. 특정 점수");
	        int option = sc.nextInt();
	        System.out.println("점수를 입력하세요:");
	        int score = sc.nextInt();

	        for (StudentScoreData student : map.values()) {
	            int studentScore = 0;
	            switch (subject) {
	                case "국어점수":
	                    studentScore = student.getKor();
	                    break;
	                case "수학점수":
	                    studentScore = student.getMat();
	                    break;
	                case "영어점수":
	                    studentScore = student.getEng();
	                    break;
	            }

	            if (option == 1 && studentScore >= score) {
	                student.printData();
	            } else if (option == 2 && studentScore <= score) {
	                student.printData();
	            } else if (option == 3 && studentScore == score) {
	                student.printData();
	            }
	        }
	    }
}