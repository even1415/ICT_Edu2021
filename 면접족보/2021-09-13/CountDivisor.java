class Divisor {
	public void myDivisor() {
		int result = 1;
		int count = 0;
		
		while(true) {
			if(result%2==0 || result%7==0) count++;
			
			if(count==2021) break;
			else result++;
		}
		System.out.println("2021��° 2 Ȥ�� 7�� ��� : " + result);
	}
}


public class CountDivisor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Divisor divisor = new Divisor();
		
		divisor.myDivisor();
	}

}

/*
 * 2 �Ǵ� 7�� ����� ���� ������ 2021��°�� ���ڸ� ����Ͻÿ�.
 * ex. 10��° ���� = 18
 * 2 4 6 7 8 10 12 14 16 18
 */