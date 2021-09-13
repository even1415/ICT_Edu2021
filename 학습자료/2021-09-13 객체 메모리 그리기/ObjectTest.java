//
class Plus{
	private int startNum;	
	private int endNum ;
	
	
	public int getEndNum() {
		return endNum;
	}
	
	
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	/*
	
	public int getPlus() {
		int sum = 0;
		
		for(int i = startNum ; i <= endNum;i++) {
			sum = sum + i;
		}
		
		return sum;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	*/

	
}


public class ObjectTest {

	public static void main(String[] args) {

		Plus plus = new Plus();		
		Plus plus2 = new Plus();
		
		plus.setEndNum(100);		
		plus2.setEndNum(500);		
		
		int num = plus.getEndNum();
		System.out.println(num);
		
		num = plus2.getEndNum();
		System.out.println(num);
		
		
		plus = plus2;
		
		plus.setEndNum(100);		
		plus2.setEndNum(500);		
		
		num = plus.getEndNum();
		System.out.println(num);
		
		num = plus2.getEndNum();
		System.out.println(num);
		
		
		/*
		plus.setEndNum(100);		
		plus2.setEndNum(500);		
		
		int num = plus.getEndNum();
		System.out.println(num);
		
		num = plus2.getEndNum();
		System.out.println(num);
		*/
		
		//System.out.println(plus);
		
		
	    
		
		
		/*
		plus.setStartNum(50);
		plus.setEndNum(100);
		
		System.out.println(plus.getPlus());
		
		plus.setStartNum(1);
		plus.setEndNum(10);
		
		System.out.println(plus.getPlus());
		*/
	}

}
