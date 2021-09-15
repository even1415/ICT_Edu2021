class AccessWay {
	static int num = 0;
	
	AccessWay() {incrCnt();}
	void incrCnt() {
		num++;
	}
}

class A {
	static int num = 0;
	int num2 = 0;
	
	public void printNum() {
		System.out.println(num2);
		System.out.println(num);
	}
	
	static public void printNum2() {
		System.out.println(num2); //컴파일오류
		System.out.println(num);
	}
}


public class ClassVarAccess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccessWay way = new AccessWay();
		way.num++;
		AccessWay.num++;
		
		System.out.println("num = " + AccessWay.num);
	}

}
