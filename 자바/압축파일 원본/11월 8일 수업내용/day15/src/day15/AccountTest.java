package day15;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account ac = new Account();
		
		UserIn u1 = new UserIn("개미", ac);
		UserIn u3 = new UserIn("개미", ac);
		UserIn u5 = new UserIn("개미", ac);
		UserOut u2 = new UserOut("베짱이", ac);
		UserOut u4 = new UserOut("베짱이", ac);
		UserOut u6 = new UserOut("베짱이", ac);
		
		u1.start();
		u2.start();
//		u3.start();
//		u4.start();
//		u5.start();
//		u6.start();
	}

}
