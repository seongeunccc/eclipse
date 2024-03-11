package TeamExam;

import java.util.Scanner;

public class InputSalaryInfo {
	
	SalaryInfo[] sinfo = new SalaryInfo[1000];
	Scanner sc = new Scanner(System.in);
	
	public void inputSalaryInfo(int a) {
		sinfo[a] = new SalaryInfo(); // 배열에 객체 생성
	//	this.sinfo[a].setId(pinfo[a].getId()); // a번째 직원의 직원번호를 personalInfo에서 불러와서 자동 기입
		System.out.println("근무일수를 입력하세요.");
		this.sinfo[a].setWorkDay(sc.nextInt());
		System.out.println("시간외근무 시간을 입력하세요.");
		this.sinfo[a].setOverTime(sc.nextInt());
		System.out.println("중식대 지급여부를 입력하세요.(Y/N)");
		this.sinfo[a].setLunch(sc.next());
		System.out.println("교통비 지급여부를 입력하세요.(Y/N)");
		this.sinfo[a].setTraffic(sc.next());
		System.out.println("휴가 일수를 입력하세요");
		this.sinfo[a].setVacDay(sc.nextInt());
	}
	
	
	public void printSalaryInfo(int a) {
	//	sinfo[a] = new SalaryInfo(); // 배열에 객체 생성
	//	this.sinfo[a].setId(pinfo[a].getId()); // a번째 직원의 직원번호를 personalInfo에서 불러와서 자동 기입
		System.out.println("근무일수:"+this.sinfo[a].getWorkDay()+"\t");
		System.out.println("시간외근무:"+this.sinfo[a].getOverTime()+"\t");
		this.sinfo[a].getOverTime();
		System.out.println("중식대 지급여부를 입력하세요.(Y/N)");
		this.sinfo[a].getLunch();
		System.out.println("교통비 지급여부를 입력하세요.(Y/N)");
		this.sinfo[a].getTraffic();
		System.out.println("휴가 일수를 입력하세요");
		this.sinfo[a].getVacDay();
	}
}
