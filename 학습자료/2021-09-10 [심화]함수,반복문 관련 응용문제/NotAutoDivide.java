
public class NotAutoDivide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		divideNumber(71, 3);
	}

	private static void divideNumber(int num1, int num2) {
		// TODO Auto-generated method stub
		int origin = num1;
		
		while(num1>=num2) num1 -= num2;
		
		if(num1==0) 
			System.out.println(origin + " 은 " + num2 + " 의 배수입니다.");
		else 
			System.out.println(origin + " 은 " + num2 + " 의 배수가 아닙니다.");
	}

}

/*
 * 나눗셈은 곧 나누려는 숫자(num1)를 나눌 숫자(num2)로 쪼개는 연산이기 때문에
 * 나누려는 숫자를 나눌 숫자로 계속 빼면서 0으로 떨어지는지 확인하면 된다.
 * 나누려는 숫자가 나눌 숫자의 배수라면, 마지막 뺄셈에서 0이 된다.
*/
