
public class AvgRandomNum {
	int ary[];
	double avg;

	public AvgRandomNum() {
		this.ary = new int[10];
		this.avg = 0;
	}
	
	private void setter() {
		for(int i=0; i<ary.length; i++) {
			ary[i] = (int)(Math.random() * 10 + 1);
			avg += ary[i];
		}
		avg /= (double)ary.length;
	}
	
	private void getter() {
		System.out.print("������ ������ : ");
		for(int i=0; i<ary.length; i++) {
			System.out.print(ary[i] + " ");
		}
		System.out.println(); //�ٹٲ�
		System.out.println("����� : " + avg);
	}
	
	public void run() {
		setter();
		getter();
	}
}
