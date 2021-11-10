package day15;

public class Account {
	private int money = 10;
	private boolean flag = false;
	
	//객체의 lock을 쥐어야만 메소드를 수행할 수 있음(동시실행 불가)
	synchronized public void get(int val) {
		if(!flag) {
			try {
				wait();
				/*wait() 호출되면 쓰레드는 수행권한 포기하고
				 * waiting pool (대기실)에서 대기한다.
				 * 이 때 lock을 반납하고 대기상태에 들어감
				 * */
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(money-val < 0) {
			System.out.println("현금 부족 : 현재 잔액 = " + money + ", 요청 금액  = " + val);
			flag = false;
			notify();
			return;
		}
		money-=val;
		System.out.println("출금액 = " + val + ", 출금 후 잔액 = " + money);
		flag = false;
		notify();
	}
	
	public void save(int val) {
		synchronized(this) {
			if(flag) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			money+=val;
			System.out.println("입금액 = " + val + ", 입금 후 잔액 = " + money);
			flag = true;
			notify();
			/*waiting pool에 대기 중인 쓰레드 하나를 깨워서 runnable 상태로 전환
			 * notifyAll() : 모든 대기 중인 쓰레드를 전부 깨움
			 * */
		}
	}
}
