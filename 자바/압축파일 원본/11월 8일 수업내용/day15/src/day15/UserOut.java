package day15;
//1~5������ �����ϰ� �����ϴ� ������

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
			int val = random.nextInt(5) + 1; //1~5���� ���� �� ����
			account.get(val);
		}
	}
}
