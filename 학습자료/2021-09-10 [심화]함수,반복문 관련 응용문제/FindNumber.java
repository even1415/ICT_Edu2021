public class FindNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		
		for(int i=1; i<=10000; i++) {
			for(int j=i; j>0; j/=10) {
				if(j%10==7) count++;
			}
		}
		
		System.out.println("1���� 10000���� ���� 7�� " + count + "�� ����");
	}
}

/*
 * <���䵵>
 * 10000���� 7�� ������ ����. ��, 1~4�ڸ� ���ڵ鸸 ����
 * 7XXX �� 000 ~ 999���� 1õ��
 * X7XX �� 000 ~ 999���� 1õ��
 * XX7X �� 000 ~ 999���� 1õ��
 * XXX7 �� 000 ~ 999���� 1õ��
 *  = �հ� �� 4õ��
*/