package day15;



public class SnailTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//[1]Runnable��ü ����
		Snail r = new Snail();
		//[2]Thread��ü �����ؼ� �����ڿ� [1]��ü ����
		Thread tr = new Thread(r);
		//[3]������ ����
		tr.start();
	}

}
