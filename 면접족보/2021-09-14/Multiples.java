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
		System.out.println("1부터 "+ num + "까지의 숫자 중 12 & 14의 배수의 갯수는 "
				+ count + "개입니다.");
	}
}