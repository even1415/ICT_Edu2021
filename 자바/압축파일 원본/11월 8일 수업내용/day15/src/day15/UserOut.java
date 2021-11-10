package day15;
//1~5만원씩 랜덤하게 인출하는 쓰레드

import java.util.Random;

public class UserOut extends Thread {
	private Account account;
	
	public UserOut(String name, Account ac) {
		this.setName(name);
		this.account = ac;
	}
	
	public void run() {
		Random random = new Random();
		for(int i=0; i<5; i++) {
			int val = random.nextInt(5) + 1; //1~5만원 사이 값 인출
			account.get(val);
		}
	}
}
