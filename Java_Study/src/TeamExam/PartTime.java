package TeamExam;

import java.util.Scanner;

public class PartTime {
	SalaryInfo SalaryInfo; // 급여정보 클래스 호출
	PersonalInfo PersonalInfo; // 직원정보 클래스 호출
	Index leavedate;
	Index comebackdate;
	String str;
	
	public PartTime() {
		SalaryInfo = new SalaryInfo();
		PersonalInfo = new PersonalInfo();
		leavedate = new Index(str);
		comebackdate = new Index(str);
	}

	PersonalInfo[] pinfo = new PersonalInfo[1000];// 회사마다 처리할 최대 직원 수를 설정 변경 원할 시 [] 안의 숫자 수정
	SalaryInfo[] sinfo = new SalaryInfo[1000];// 회사마다 처리할 최대 직원 수를 설정 변경 원할 시 [] 안의 숫자 수정

	int index = 0;
	Scanner sc = new Scanner(System.in);// 클래스에서 사용할 스캐너 호출

	public void inputPersonalInfo(int a) {
		pinfo[a] = new PersonalInfo();
		System.out.println("직원 이름을 입력하세요.");
		this.pinfo[a].setName(sc.next());
		System.out.println("직원 번호를 입력하세요.");
		this.pinfo[a].setId(sc.next());
		System.out.println("직급을 입력하세요.");
		this.pinfo[a].setGrade(sc.next());
		System.out.println("부서를 입력하세요.");
		this.pinfo[a].setDept(sc.next());
		System.out.println("급여수령 은헹을 입력하세요.");
		this.pinfo[a].setBank(sc.next());
		System.out.println("급여 계좌를 입력하세요.");
		this.pinfo[a].setAccount(sc.next());
		System.out.println("입사일을 입력하세요");
		this.pinfo[a].setStartDate(sc.next());
		
		//여기서 휴복직/퇴직 여부를 묻는 if문을 실행하여 결과가 Y일 시 입력받는 메소드를 작성해도 좋을듯
		//System.out.println("퇴직일을 입력하세요.");   //퇴직일은 직원 등록시 입력할 필요 없음 / 수정을 통해 입력하는 게 맞을듯
		//this.pinfo[a].setExitDate(sc.next());
		//System.out.println("퇴직일을 입력하세요.");   //휴직일은 직원 등록시 입력할 필요 없음 / 수정을 통해 입력하는 게 맞을듯
		//this.pinfo[a].setExitDate(sc.next());
		//System.out.println("퇴직일을 입력하세요.");   //복직일은 직원 등록시 입력할 필요 없음 / 수정을 통해 입력하는 게 맞을듯
		//this.pinfo[a].setExitDate(sc.next());
	}
	public void modifyPersonalInfo(int a) {
		inputPersonalInfo(a);
		//System.out.println("퇴직일을 입력하세요.");   
		//this.pinfo[a].setExitDate(sc.next());
	}

	public void inputSalaryInfo(int a) {
		sinfo[a] = new SalaryInfo(); 	//배열에 객체 생성
		this.sinfo[a].setId(pinfo[a].getId()); // a번째 직원의 직원번호를 personalInfo에서 불러와서 자동 기입
		System.out.println("근무월을 입력하세요.");
		this.sinfo[a].setMonth(sc.next());
		System.out.println("근무일수를 입력하세요.");
		this.sinfo[a].setWorkDay(sc.nextInt());
		System.out.println("시간외근무 시간을 입력하세요.");
		this.sinfo[a].setOverTime(sc.nextInt());
		System.out.println("중식대 지급여부를 입력하세요.(Y/N)");
		this.sinfo[a].setLunch(sc.next());
		System.out.println("교통비 지급여부를 입력하세요.(Y/N)");
		this.sinfo[a].setTraffic(sc.next());
		System.out.println("근무월을 입력하세요.");
		this.sinfo[a].setMonth(sc.next());
		System.out.println("휴가 일수를 입력하세요");
		this.sinfo[a].setVacDay(sc.nextInt());
		 
	}
	
	
	public String getLeavedate() {
		return leavedate.getStr();
	}
	public void setLeavedate(String aa) {
		leavedate.setStr(aa);
	}
	public String getComebackdate() {
		return comebackdate.getStr();
	}
	public void setComebackdate(String aa) {
		comebackdate.setStr(aa);
	}
	
	
	
	
	
	
	
}




