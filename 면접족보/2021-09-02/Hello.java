
public class Hello {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch = 'A';
		System.out.println("Hello World");
		
		/*----------------------------------------*/
		int Native = 80;
		int Math = 60;
		int English = 70;
		int total = 0;
		double avg = 0;
		
		total = Native + Math + English;
		avg = total/3.0;
		
		System.out.println("�հ� : " + total);
		System.out.println("��� : " + avg);
		
		/*----------------------------------------*/
		int num1 = 10;
		int num2 = 20;
		
		System.out.println(num1 < num2);
		System.out.println(num1 > num2);
		
		/*----------------------------------------*/
		int a = 3;
		int b = 4;
		double result;
		
		//double result = a / b;
		//1. a/b ���� : ���� �� int���� �������� ��� 0
		//2. result�� ����(����) : 0.0���� �ڵ� ����ȯ �� ����
		//3. double result = (double)a/b;
		//�ȵǴ� ���� : a/b ������ ���� ������ int�� ���̶� �������� 0�� ����.
		//double�� �Ҽ��� ���ϸ� ������� ���� ���� ���Ŀ� double�̾�� ��
		
		//a,b ��� ����� ����ȯ���� double�� ��ȯ
		result = (double)a / (double)b;
		System.out.println(result);
		
		//a�� double, b�� int���� ���� �ÿ� b�� double�� ������ ����ȯ
		result = (double)a / b;
		System.out.println(result);
		/*----------------------------------------*/
		int num3 = 7;
		int num4 = 3;
		
		System.out.println("num3 + num4 = " + (num3 + num4));
		System.out.println("num3 - num4 = " + (num3 - num4));
		System.out.println("num3 * num4 = " + (num3 * num4));
		System.out.println("num3 / num4 = " + (num3 / num4));
		System.out.println("num3 % num4 = " + (num3 % num4));
		
		short num = 10;
		num = (short)(num + 77L);
		int rate = 3;
		rate = (int)(rate * 3.5);
		System.out.println(num);
		System.out.println(rate);
		
		num = 10;
		rate = 3;
		num += 77L; //����ȯ �ʿ����
		rate *= 3.5;
		System.out.println(num);
		System.out.println(rate);
		/*----------------------------------------*/
		int num5 = 11;
		int num6 = 22;
		boolean resultbool;
		
		resultbool = (num5>1) && (num5<100);
		System.out.println("1 �ʰ� 100 �̸��ΰ�?" + resultbool);
		
		resultbool = (num6 % 2 == 0) || (num6 % 3 == 0);
		System.out.println("2 Ȥ�� 3�� ����ΰ�?" + resultbool);
		
		resultbool = !(num1 != 0);
		System.out.println("0�ΰ�?" + resultbool);
		/*----------------------------------------*/
		int num7 = 0;
		int num8 = 0;
		boolean resultnum;
		
		resultnum = ((num7 += 10) < 0) && ((num8 += 10) > 0);
		System.out.println("result = " + resultnum);
		System.out.println("num7 = " + num7);
		System.out.println("num8 = " + num8 + '\n');
		
		resultnum = ((num7 += 10) > 0) || ((num8 += 10) > 0);
		System.out.println("result = " + resultnum);
		System.out.println("num7 = " + num7);
		System.out.println("num8 = " + num8);
	}

}
