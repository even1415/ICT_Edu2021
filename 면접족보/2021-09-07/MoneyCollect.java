
public class MoneyCollect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//11�� ���� ������ ���ںٱ�
//		int Money = 500;
//		
//		for(int day=1; day<=5; day++) {
//			Money++;
//		}
//		System.out.println(Money);
		
		//10�� ���� ������� ȯ��(�ݺ��� ���O)
//		int Money = 126500;
//		int[] bill = {0,0,0,0,0,0};
//		
//		while(Money>=50000) {
//			bill[0]++;
//			Money -= 50000;
//		}
//		System.out.println("������ : " + bill[0] + "��");
//		while(Money>=10000) {
//			bill[1]++;
//			Money -= 10000;
//		}
//		System.out.println("���� : " + bill[1] + "��");
//		while(Money>=5000) {
//			bill[2]++;
//			Money -= 5000;
//		}
//		System.out.println("��õ�� : " + bill[2] + "��");
//		while(Money>=1000) {
//			bill[3]++;
//			Money -= 1000;
//		}
//		System.out.println("õ�� : " + bill[3] + "��");
//		while(Money>=500) {
//			bill[4]++;
//			Money -= 500;
//		}
//		System.out.println("����� : " + bill[4] + "��");
//		while(Money>=100) {
//			bill[5]++;
//			Money -= 100;
//		}
//		System.out.println("��� : " + bill[5] + "��");
		
		//10�� ���� ������� ȯ��(�ݺ��� ���X)
//		int Money = 126500;
//		int billcount = 0;
//		
//		billcount = Money/50000;
//		System.out.println("������ : " + billcount + "��");
//		Money -= billcount * 50000;
//		
//		billcount = Money/10000;
//		System.out.println("���� : " + billcount + "��");
//		Money -= billcount * 10000;
//		
//		billcount = Money/5000;
//		System.out.println("��õ�� : " + billcount + "��");
//		Money -= billcount * 5000;
//		
//		billcount = Money/1000;
//		System.out.println("õ�� : " + billcount + "��");
//		Money -= billcount * 1000;
//		
//		billcount = Money/500;
//		System.out.println("����� : " + billcount + "��");
//		Money -= billcount * 500;
//		
//		billcount = Money/100;
//		System.out.println("��� : " + billcount + "��");
//		Money -= billcount * 100;
		
		//10�� ���� ������� ȯ��(�ݺ��� ���X)
		int Money = 126500;
		
		System.out.println("������ : " + (Money/50000) + "��");
		System.out.println("���� : " + ((Money % 50000)/10000) + "��");
		System.out.println("��õ�� : " + ((Money % 10000)/5000) + "��");
		System.out.println("õ�� : " + ((Money % 5000)/1000) + "��");
		System.out.println("����� : " + ((Money % 1000)/500) + "��");
		System.out.println("��� : " + ((Money % 500)/100) + "��");
	}

}
