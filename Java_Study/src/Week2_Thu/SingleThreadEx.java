package Week2_Thu;

public class SingleThreadEx implements Runnable { // extends Thread { //얘는 상속을 할 수 있는 상황에서만 쓸 수 있음.
	//runnable 은 그자체로 스레드는 아니고, Thread를 사용할 수 있는 환경을 제공
	//runnable을 쓴다 => 내가 만든 SingleThreadEx 를 쓰레드로 던지겠다는 뜻.
	//runnable 을 받으면 run 메소드를 무조건 오버라이딩해야함. 
	//스레드를 호출하면 run안에 있는 구문이 실행됨.
	
	private int[] temp;

	public SingleThreadEx() {

		//super(threadname); {요렇게 하면 상위 클래스인 object로 감 => runnable 할때는 이구문 사용 불가.
		temp = new int[10];
		for (int start = 0; start < temp.length; start++) {
			temp[start] = start;
		}
	}

	public void run() {
		for (int start : temp) {
			try {
				Thread.sleep(1000);  //슬립 메소드는 static / 쓰레드 객체 없어도 사용가능
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			System.out.printf("현재 쓰레드 이름 : %s ,", Thread.currentThread().getName()); //그래서 여기 Thread. 을 붙여줘야함.
			
			System.out.printf("temp value : %d %n", start);

		}
	}

	public static void main(String[] args) {
		SingleThreadEx st = new SingleThreadEx();
		Thread t = new Thread(st,"superman");  
		// 생성자가 다양해서, 찾아보면 실행시킬 객체+스레드이름 동시에 주는 것도 있고 다양함.
		t.start();
	}

}
