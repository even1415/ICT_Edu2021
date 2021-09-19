
public class FindMinRandomNum {
	int number[];
	int min;

	public FindMinRandomNum() {
		number = new int[10];
		min = 0;
	}

	private void setNum() {
		for(int i=0; i<number.length; i++) {
			number[i] = (int)(Math.random()*1000+1);
		}
	}
	
	private void getMin() {
		min = number[0];
		for(int i=0; i<number.length; i++) {
			if(min>number[i]) min = number[i];
		}
	}
	
	private void print() {
		for(int i=0; i<number.length; i++) {
			System.out.print(number[i] + " ");
		}
		System.out.println();
		System.out.println("ÃÖ¼Ú°ª : " + min);
	}
	
	public void run() {
		setNum();
		getMin();
		print();
	}
}
