package day15;

public class Account {
	private int money = 10;
	private boolean flag = false;
	
	//��ü�� lock�� ���߸� �޼ҵ带 ������ �� ����(���ý��� �Ұ�)
	synchronized public void get(int val) {
		if(!flag) {
			try {
				wait();
				/*wait() ȣ��Ǹ� ������� ������� �����ϰ�
				 * waiting pool (����)���� ����Ѵ�.
				 * �� �� lock�� �ݳ��ϰ� �����¿� ��
				 * */
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(money-val < 0) {
			System.out.println("���� ���� : ���� �ܾ� = " + money + ", ��û �ݾ�  = " + val);
			flag = false;
			notify();
			return;
		}
		money-=val;
		System.out.println("��ݾ� = " + val + ", ��� �� �ܾ� = " + money);
		flag = false;
		notify();
	}
	
	public void save(int val) {
		synchronized(this) {
			if(flag) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			money+=val;
			System.out.println("�Աݾ� = " + val + ", �Ա� �� �ܾ� = " + money);
			flag = true;
			notify();
			/*waiting pool�� ��� ���� ������ �ϳ��� ������ runnable ���·� ��ȯ
			 * notifyAll() : ��� ��� ���� �����带 ���� ����
			 * */
		}
	}
}
