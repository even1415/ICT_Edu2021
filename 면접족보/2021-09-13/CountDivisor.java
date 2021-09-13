class Divisor {
	public void myDivisor() {
		int result = 1;
		int count = 0;
		
		while(true) {
			if(result%2==0 || result%7==0) count++;
			
			if(count==2021) break;
			else result++;
		}
		System.out.println("2021번째 2 혹은 7의 약수 : " + result);
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
 * 2 또는 7을 약수로 갖는 숫자중 2021번째의 숫자를 출력하시오.
 * ex. 10번째 숫자 = 18
 * 2 4 6 7 8 10 12 14 16 18
 */