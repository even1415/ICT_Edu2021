
public class RandomNumThree {
	int ary[];

	public RandomNumThree() {
		this.ary = new int[10];
	}
	
	private void setter() {
		for(int i=0; i<ary.length; i++) {
			ary[i] = (int)(Math.random() * 100 + 1); //Integer.MAX_VALUE ��� 100
		}
	}
	
	private void getter() {
		System.out.print("��ü ���� ��� : ");
		for(int i=0; i<ary.length; i++) {
			System.out.print(ary[i] + " ");
		}
		
		System.out.println(); //�ٹٲ�
		
		System.out.print("3�� ��� ��� : ");
		for(int i=0; i<ary.length; i++) {
			if(ary[i]%3==0) System.out.print(ary[i] + " ");
		}
	}
	
	public void run() {
		setter();
		getter();
	}
}
