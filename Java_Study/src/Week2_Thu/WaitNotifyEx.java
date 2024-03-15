package Week2_Thu;

class ATMTwo implements Runnable {
	private long depositeMoney = 10000;

	public void run() {
		synchronized (this) { // 내 안에서 작업할 거니까 this
			for (int i = 0; i < 10; i++) {
				try {
					notify();
					if (getDepositeMoney() <= 0)
						break;
					withDraw(1000);
					Thread.sleep(500);
					wait();
				} catch (InterruptedException e) {
				}
			}
		}
	}

//	} 
	public void withDraw(long howMuch) {
		if (getDepositeMoney() > 0) {
			depositeMoney -= howMuch;
			System.out.print(Thread.currentThread().getName() + " ,  잔액 :");
			System.out.printf("%d %n", getDepositeMoney());
		} else {
			System.out.print(Thread.currentThread().getName() + " , ");
			System.out.println("End.");
		}
	}

	public long getDepositeMoney() {
		return depositeMoney;
	}
}

public class WaitNotifyEx {
	public static void main(String[] args) {
		ATMTwo atm = new ATMTwo();
		Thread mother = new Thread(atm, "mother");
		Thread son = new Thread(atm, "son");
		mother.start();
		son.start();
	}
}
