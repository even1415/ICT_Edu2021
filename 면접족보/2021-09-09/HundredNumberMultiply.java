
public class HundredNumberMultiply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		myMultiply(352,373);
	}
	
	public static void myMultiply(int num1, int num2) {
		int hundred = 0;
		int ten = 0;
		int one = 0;
		
		hundred = num2/100;
		ten = (num2%100)/10;
		one = num2%10;
		
		System.out.println(num1*one);
		System.out.println(num1*ten);
		System.out.println(num1*hundred);
		System.out.println(num1*num2);
		//���� ������ ���� ���ϰ� ��¹��� ���� ���� �־ �˴ϴ�(hundred, ten, one).
	}

}
