
public class RandomNumThree {
	int ary[];

	public RandomNumThree() {
		this.ary = new int[10];
	}
	
	private void setter() {
		for(int i=0; i<ary.length; i++) {
			ary[i] = (int)(Math.random() * 100 + 1); //Integer.MAX_VALUE 대신 100
		}
	}
	
	private void getter() {
		System.out.print("전체 정수 목록 : ");
		for(int i=0; i<ary.length; i++) {
			System.out.print(ary[i] + " ");
		}
		
		System.out.println(); //줄바꿈
		
		System.out.print("3의 배수 목록 : ");
		for(int i=0; i<ary.length; i++) {
			if(ary[i]%3==0) System.out.print(ary[i] + " ");
		}
	}
	
	public void run() {
		setter();
		getter();
	}
}
