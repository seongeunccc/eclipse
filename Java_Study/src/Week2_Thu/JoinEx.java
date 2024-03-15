package Week2_Thu;

class MyRunnableTwo implements Runnable {
	public void run() {
		System.out.println("run");
		first(); //퍼스트 메소드 실행
	}

	public void first() {
		System.out.println("first");
		second();
	}

	public void second() {
		System.out.println("second");
	}

}

public class JoinEx {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " start");
		Runnable r = new MyRunnableTwo();
		Thread myThread = new Thread(r);
		myThread.start();

		try {
			myThread.join();    
			//join 을 사용하면 사용한 스레드가 종료되기 전까지 다른 스레드가 실행되지 않음.
			//다 끝나야 다음 꺼 실행 => try~catch 문 넣기 전과 결과 달라짐 확인 가능. 
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println("end");
	}
}
