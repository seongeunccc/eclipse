package TeamExam;



public class PersonalInfo {
	Index name ;
	Index id ;
	Index grade ; 
	Index type ;
	Index account;
	Index dept;
	Index startDate;
	Index exitDate;
	Index bank;
	Index perfomanceGrade;
	
	int num;
	String str;
	
	public PersonalInfo() {
		name = new Index(str);
		id = new Index(str);
		grade = new Index(str);
		type = new Index(str);
		account = new Index(str);
		dept = new Index(str);
		startDate = new Index(str);
		exitDate = new Index(str);
		bank = new Index(str);
		perfomanceGrade = new Index(num);
	}
		//setter getter
	public String getName() {
		return name.getStr();
	}

	public void setName(String aa) {
		name.setStr(aa);
	}

	public String getId() {
		return id.getStr();
	}

	public void setId(String aa) {
		id.setStr(aa);
	}

	public String getGrade() {
		return grade.getStr();
	}

	public void setGrade(String aa) {
		grade.setStr(aa);
	}

	public int getType() {
		return type.getNum();
	}

	public void setType(int aa) {
		type.setNum(aa);
	}

	public String getAccount() {
		return account.getStr();
	}

	public void setAccount(String aa) {
		account.setStr(aa);
	}

	public String getDept() {
		return dept.getStr();
	}

	public void setDept(String aa) {
		dept.setStr(aa);
	}

	public String getStartDate() {
		return startDate.getStr();
	}

	public void setStartDate(String aa) {
		startDate.setStr(aa);
	}

	public String getExitDate() {
		return exitDate.getStr();
	}

	public void setExitDate(String aa) {
		exitDate.setStr(aa);
	}

	public String getBank() {
		return bank.getStr();
	}

	public void setBank(String aa) {
		bank.setStr(aa);
	}
	
	public void setPerfomanceGrade(int aa) {
		perfomanceGrade.setNum(aa);
	}
	
	public int getPerfomanceGrade() {
		return perfomanceGrade.getNum();
	}
	

}