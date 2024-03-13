package Week2_Wed;

/*
 * 	제너릭타입 활용하기
 */


public class GenericEx1Main {
	public static void main(String [] args) {
		GenericEx1<String> t = new GenericEx1<String>();
		
		String[] ss = {"애","아","서"};
		t.set(ss);
		t.print();
		
		GenericEx1<Integer> t1 = new GenericEx1<Integer>();
		
		Integer[] ii = {1,2,3};
		t1.set(ii);
		t1.print();
		
	}

}
