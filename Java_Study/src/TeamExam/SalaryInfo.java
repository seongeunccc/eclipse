package TeamExam;

public class SalaryInfo {
	Index workDay;
	Index overTime;
	Index lunch;
	Index traffic;
	//추가
	Index id;
	Index month;
	Index vacDay;
	Index basicPay;
	Index gradePay;
	Index perfomancePay;
	Index totalPay;

	
	int num;
	String str;
	
	public SalaryInfo() {
		workDay = new Index(num);
		overTime = new Index(num);
		lunch = new Index(str);
		traffic = new Index(str);
		id = new Index(str);
		month = new Index(str);
		vacDay = new Index(num);
		basicPay = new Index(num);
		gradePay = new Index(num);
		totalPay = new Index(num);
		perfomancePay = new Index(num);
	}

	public int getWorkDay() {
		return workDay.getNum();
	}

	public void setWorkDay(int aa) {
		workDay.setNum(aa);
	}

	public int getOverTime() {
		return overTime.getNum();
	}

	public void setOverTime(int aa) {
		overTime.setNum(aa);
	}

	public String getLunch() {
		return lunch.getStr();
	}

	public void setLunch(String aa) {
		lunch.setStr(aa);
	}

	public String getTraffic() {
		return traffic.getStr();
	}

	public void setTraffic(String aa) {
		traffic.setStr(aa);
	}

	public String getId() {
		return id.getStr();
	}

	public void setId(String aa) {
		id.setStr(aa);
	}
	public String getMonth() {
		return month.getStr();
	}

	public void setMonth(String aa) {
		month.setStr(aa);
	}
	
	public int getVacDay() {
		return vacDay.getNum();
	}

	public void setVacDay(int aa) {
		vacDay.setNum(aa);
	}
	public int getBasicPay() {
		return basicPay.getNum();
	}

	public void setBasicPay(int aa) {
		basicPay.setNum(aa);
	}
	public int getGradePay() {
		return gradePay.getNum();
	}

	public void setGradePay(int aa) {
		gradePay.setNum(aa);
	}
	public int getPerfomancePay() {
		return perfomancePay.getNum();
	}

	public void setPerfomancePay(int aa) {
		perfomancePay.setNum(aa);
	}
	public int getTotalPay() {
		return gradePay.getNum()+basicPay.getNum()+basicPay.getNum();
	}

	/*
	 * 	//추가
	Index totalPay;

	 */
	
	
	
}
