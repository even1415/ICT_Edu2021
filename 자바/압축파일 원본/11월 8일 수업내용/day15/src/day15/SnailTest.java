package day15;



public class SnailTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//[1]Runnable객체 생성
		Snail r = new Snail();
		//[2]Thread객체 생성해서 생성자에 [1]객체 전달
		Thread tr = new Thread(r);
		//[3]스레드 동작
		tr.start();
	}

}
