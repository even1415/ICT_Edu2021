public class Multiples {
	int num;
	int count = 0;

	public void setNum(int num) {
		this.num = num;
	}
	
	public void getAnswer() {
		for(int i=1; i<=num; i++)
			if(i%12==0 && i%14==0) count++;
	}
	
	public void printNum() {
		System.out.println("1���� "+ num + "������ ���� �� 12 & 14�� ����� ������ "
				+ count + "���Դϴ�.");
	}
}