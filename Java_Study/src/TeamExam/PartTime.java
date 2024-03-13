package TeamExam;
import java.util.Scanner;

public class PartTime {
	SalaryInfo SalaryInfo; // 급여정보 클래스 호출
	PersonalInfo PersonalInfo; // 직원정보 클래스 호출
	InputSalaryInfo InputSalaryInfo;
	Index leavedate;
	Index comebackdate;
	int serchResult;
	String str;
	PartTime PartTime;

	public PartTime() {
		//SalaryInfo = new SalaryInfo();
		PersonalInfo = new PersonalInfo();
		leavedate = new Index(str);
		comebackdate = new Index(str);
		for(int i = 0; i<12; i++) {
			imsa[i] = new TeamExam.InputSalaryInfo();
			
			
		}
	}
	static InputSalaryInfo[] imsa = new InputSalaryInfo[12];
	PersonalInfo[] pinfo = new PersonalInfo[1000];// 회사마다 처리할 최대 직원 수를 설정 변경 원할 시 [] 안의 숫자 수정
//	SalaryInfo[] sinfo = new SalaryInfo[1000];// 회사마다 처리할 최대 직원 수를 설정 변경 원할 시 [] 안의 숫자 수정
	FullTime[] ft = new FullTime[1000];
	static int index = 0;

	
	
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
	}

	public void modifyPersonalInfo(int a) {
		System.out.println("");
		System.out.println("수정하실 값을 선택하세요");
		System.out.println("1.이름 2.직원번호 3.직급 4.부서 5.급여수령은행 6.급여계좌 7.입사일 8.퇴직일 9.휴직일 10.복직일");
		int answer = sc.nextInt();
		System.out.println("변경할 내용을 입력해주세요.(숫자로 입력)");
		
		switch (answer) {
		case 1:
			this.pinfo[a].setName(sc.next());
			break;
		case 2:
			this.pinfo[a].setId(sc.next());
			break;
		case 3:
			this.pinfo[a].setGrade(sc.next());
			break;
		case 4:
			this.pinfo[a].setDept(sc.next());
			break;
		case 5:
			this.pinfo[a].setBank(sc.next());
			break;
		case 6:
			this.pinfo[a].setAccount(sc.next());
			break;
		case 7:
			this.pinfo[a].setStartDate(sc.next());
			break;
		case 8:
			this.pinfo[a].setExitDate(sc.next());
			break;
		case 9:
			this.ft[a].setLeavedate(sc.next());
			break;
		case 10:
			this.ft[a].setComebackdate(sc.next());
			break;
		default:
			System.out.println("잘못된 입력입니다.(modifyPersonalInfo)");
		}
	}

	public void inputSalaryInfo(int a, int b) { //int a = 급여 입력받을 월 / int b = 처리할 직원 선택	
		imsa[a].inputSalaryInfo(b);
		}
	
	public void printSalaryInfo(int a, int b) { //int a = 급여 입력받을 월 / int b = 처리할 직원 선택	
		imsa[a].inputSalaryInfo(b);
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

	public int serch(int a) {
		System.out.println("검색조건을 입력하세요.");
		System.out.println("숫자로 입력.(1. 이름 2. 직원번호)");
		int answer = sc.nextInt();
		System.out.println("검색할 내용을 입력해주세요.");
		String aa = sc.next();
		int aaa = 0 ;
		if (answer == 1) {
			for (int i = 0; i < a; i++) {
				if (pinfo[i].getName().equals(aa)) {
					print(i);
					aaa = i;
				}
			}
		} else if (answer == 2) {
			for (int i = 0; i < a; i++) {
				if (pinfo[i].getId().equals(aa)) {
					print(i);
					aaa = i;
				}
			}
		} else {
			System.out.println("잘못된 입력입니다.(serch)");
		}
		return aaa;
	}

	public void print(int a) {
		System.out.print("이름 : " + this.pinfo[a].getName() + "\t");
		System.out.print("직원번호 : " + this.pinfo[a].getId() + "\t");
		System.out.print("직급 : " + this.pinfo[a].getGrade() + "\t");
		System.out.print("부서 : " + this.pinfo[a].getDept() + "\t");
		System.out.print("지급은행 : " + this.pinfo[a].getBank() + "\t");
		System.out.print("계좌번호 : " + this.pinfo[a].getAccount() + "\t");
		System.out.print("입사일 : " + this.pinfo[a].getStartDate() + "\t");
		System.out.println("");
	}

	public void printAll(int a) {
		for (int i = 0; i < a; i++) {
			if(this.pinfo[i].getName().equals("")) {
				System.out.print("");
			}else {
			System.out.print("이름 : " + this.pinfo[i].getName() + "\t");
			System.out.print("직원번호 : " + this.pinfo[i].getId() + "\t");
			System.out.print("직급 : " + this.pinfo[i].getGrade() + "\t");
			System.out.print("부서 : " + this.pinfo[i].getDept() + "\t");
			System.out.print("지급은행 : " + this.pinfo[i].getBank() + "\t");
			System.out.print("계좌번호 : " + this.pinfo[i].getAccount() + "\t");
			System.out.print("입사일 : " + this.pinfo[i].getStartDate() + "\t");
			System.out.println("");
			}
		}
	}
	public void calBasicPay(int a, int b) {  //b월 , a직원
		int change = Integer.parseInt(this.pinfo[a].getStartDate().substring(0, 3));
		switch((2024-change)/3) {
		case 1: imsa[b].sinfo[a].setBasicPay(100000); break;
		case 2: imsa[b].sinfo[a].setBasicPay(200000); break;
		case 3: imsa[b].sinfo[a].setBasicPay(300000); break;
		case 4: imsa[b].sinfo[a].setBasicPay(400000); break;
		case 5: imsa[b].sinfo[a].setBasicPay(500000); break;
		case 6: imsa[b].sinfo[a].setBasicPay(600000); break;
		case 7: imsa[b].sinfo[a].setBasicPay(700000); break;
		case 8: imsa[b].sinfo[a].setBasicPay(800000); break;
		case 9: imsa[b].sinfo[a].setBasicPay(900000); break;
		default : imsa[b].sinfo[a].setBasicPay(1000000); break;
		}
	}
	
	public void calPerfomancePay(int a, int b) {		//a번째 직원의 b월 성과급 입력(기본급X성과등급에 따른 배율)
		switch (this.pinfo[a].getPerfomanceGrade()) {
		case 1:imsa[b].sinfo[a].setPerfomancePay(imsa[b].sinfo[a].getBasicPay()*8);break;
		case 2:imsa[b].sinfo[a].setPerfomancePay(imsa[b].sinfo[a].getBasicPay()*7);break;
		case 3:imsa[b].sinfo[a].setPerfomancePay(imsa[b].sinfo[a].getBasicPay()*6);break;
		case 4:imsa[b].sinfo[a].setPerfomancePay(imsa[b].sinfo[a].getBasicPay()*5);break;
		case 5:imsa[b].sinfo[a].setPerfomancePay(imsa[b].sinfo[a].getBasicPay()*4);break;
		case 6:imsa[b].sinfo[a].setPerfomancePay(imsa[b].sinfo[a].getBasicPay()*3);break;
		case 7:imsa[b].sinfo[a].setPerfomancePay(imsa[b].sinfo[a].getBasicPay()*2);break;
		default : System.out.println("잘못된 입력입니다.(calPerfomancePay)");
		}
	}
	
	public void calGradePay(int a, int b) { 
		switch (this.pinfo[a].getGrade()) {
		case "L0" : imsa[b].sinfo[a].setGradePay(100000);break;
		case "l0" : imsa[b].sinfo[a].setGradePay(100000);break;
		case "L1" : imsa[b].sinfo[a].setGradePay(200000);break;
		case "l1" : imsa[b].sinfo[a].setGradePay(200000);break;
		case "l2" : imsa[b].sinfo[a].setGradePay(300000);break;
		case "L2" : imsa[b].sinfo[a].setGradePay(300000);break;
		case "l3" : imsa[b].sinfo[a].setGradePay(400000);break;
		case "L3" : imsa[b].sinfo[a].setGradePay(400000);break;
		case "l4" : imsa[b].sinfo[a].setGradePay(500000);break;		
		case "L4" : imsa[b].sinfo[a].setGradePay(500000);break;	
		default : System.out.println("잘못된 입력입니다.(calGradePay)");
		}
	}	
	
	public int calOverTimePay(int a, int b) {
		return imsa[b].sinfo[a].getOverTime()*200000;
	}
	
	public int calTotalPay(int a,int b) {  //A직원 B월급여
		int salary =0;
		calBasicPay(a,b);
		calPerfomancePay(a,b);
		calGradePay(a,b);
		if(imsa[b].sinfo[a].getLunch().equals("Y")||imsa[b].sinfo[a].getLunch().equals("y")){
			salary+=200000;			
		}
		if(imsa[b].sinfo[a].getTraffic().equals("Y")||imsa[b].sinfo[a].getTraffic().equals("y")){
			salary+=200000;			
		}
		int total = salary +imsa[b].sinfo[a].getBasicPay()+imsa[b].sinfo[a].getPerfomancePay()+imsa[b].sinfo[a].getGradePay()+calOverTimePay(a,b);
		return total;
	}
	
	public void printSalary(int a, int b){
		
	}
	public void deleteData(int a) {
		
		this.pinfo[a].setName("");
		this.pinfo[a].setId("");
		this.pinfo[a].setGrade("");
		this.pinfo[a].setDept("");
		this.pinfo[a].setBank("");
		this.pinfo[a].setAccount("");
		this.pinfo[a].setStartDate("");
		
	}
	
	public void printTotalPay(int a, int b) {
		int lunch = 0, traffic=0;
		if(imsa[b].sinfo[a].getLunch().equals("Y")||imsa[b].sinfo[a].getLunch().equals("y")){
			lunch = 200000;
		}
		if(imsa[b].sinfo[a].getTraffic().equals("Y")||imsa[b].sinfo[a].getTraffic().equals("y")){
			traffic=200000;	}
		
		System.out.println("총급여: "+calTotalPay(a,b));
		System.out.println("기본급: "+imsa[b].sinfo[a].getBasicPay());
		System.out.println("직무급: "+imsa[b].sinfo[a].getGradePay());
		System.out.println("성과급: "+imsa[b].sinfo[a].getPerfomancePay());
		System.out.println("시간외급여: "+calOverTimePay(a,b));
		System.out.println("중식대: "+lunch);
		System.out.println("교통비: "+lunch);
		
	}
}
