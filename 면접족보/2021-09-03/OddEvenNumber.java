
public class OddEvenNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = -4;
		
		if(number>=0 && number<=100) { //0~100 �������� ���� �˻�
			System.out.println(number + " (��)�� 0~100 ������ �����Դϴ�.");
			
			if(number%2==0 && number!=0) //if(number==0) ���� ���� 0�� �ɷ����� �˴ϴ�
				System.out.println(number + " (��)�� [¦��] �Դϴ�.");
			else if(number==0) //if(number%2==0) ���� 0 ��� �Ŀ� ¦���� �ɷ��� �˴ϴ�
				System.out.println("0�� ¦���� Ȧ���� �ƴմϴ�.");
			else //0�� ¦���� ��� ��, �� Ȧ���� ���� ����
				System.out.println(number + " (��)�� [Ȧ��] �Դϴ�.");
		}
		else { //0~100 ������ ����� ���
			System.out.println("�Էµ� ���� : " + number);
			System.out.println("0~100 ������ ���ڸ� �Է����ּ���.");
		}
		
	}
}
