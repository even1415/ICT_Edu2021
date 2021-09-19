import java.util.Scanner;

class MaxPlusMin {
	private int[] ar;
	private int num;
	private int num2;
	private int max;
	private int min;
	private int answer1;
	private int answer2;

	public MaxPlusMin() {
		this.num = 0;
		this.num2 = 0;
		this.max = 0;
		this.min = 0;
		this.answer1 = 0;
		this.answer2 = 0;
	}
	
	private void setter(int num[]) {
		ar = new int[5];
		
		for(int i=0; i<ar.length; i++) {
			ar[i] = num[i];
		}
	}
	
	private void findMaxMinNum() {
		num = ar[0];
		num2 = ar[0];
		
		for (int i = 0; i < ar.length; i++) {
			if (num < ar[i]) {
				num = ar[i];
				max = num;
			}
		}
		for (int i = 0; i < ar.length; i++) {
			if (num2 >= ar[i]) {
				num2 = ar[i];
				min = num2;
			}
		}
	}
	
	private void input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("300, 17, 450, 180, 505 �߿�");
		System.out.print("���� ū ��: ");
		answer1 = sc.nextInt();
		System.out.print("���� ���� ��: ");
		answer2 = sc.nextInt();
	}
	
	private boolean printResult() {
		boolean stop = false;
		
		if (answer1 == max && answer2 == min) {
			System.out.println("�����Դϴ�!");
			System.out.println("�ִ밪 + �ּҰ� = " + (max + min));
			stop = true;
		} else {
			System.out.println("�ִ밪 Ȥ�� �ּҰ��� Ʋ�Ƚ��ϴ�.");
			stop = false;
		}
		return stop;
	}
	
	public void run() {
		int[] ar = { 300, 17, 450, 180, 505 };
		
		setter(ar);
		findMaxMinNum();
		
		while(true) {
			input();
			if(printResult()) break;
		}
	}
}


public class FindMaxMinNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			MaxPlusMin plus = new MaxPlusMin();
			plus.run();

	}

}
