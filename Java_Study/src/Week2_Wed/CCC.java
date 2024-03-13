package Week2_Wed;

public interface CCC extends AAA, BBB {
	
	//다중 상속 가능 => AAA, BBB에서 가지고 있는 상수와 추상메소드를 모두 가지고 있음.
	//더 깔끔해짐
	
	default void disp4(){  //default, static 사용가능. 근데 잘 안쓴다고 함.
		
	}
	
	
}
