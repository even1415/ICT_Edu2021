package day15;
//1만원씩 저축하는 쓰레드
public class UserIn extends Thread {
	private Account account;
	
	public UserIn(String name, Account ac) {
		this.setName(name);
		this.account = ac;
	}
	
	public void run() {
		for(int i=0; i<5; i++) {
			account.save(1); //1만원씩 저축
		}
	}
}
