
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
			System.out.println(origin + " �� " + num2 + " �� ����Դϴ�.");
		else 
			System.out.println(origin + " �� " + num2 + " �� ����� �ƴմϴ�.");
	}

}

/*
 * �������� �� �������� ����(num1)�� ���� ����(num2)�� �ɰ��� �����̱� ������
 * �������� ���ڸ� ���� ���ڷ� ��� ���鼭 0���� ���������� Ȯ���ϸ� �ȴ�.
 * �������� ���ڰ� ���� ������ ������, ������ �������� 0�� �ȴ�.
*/
