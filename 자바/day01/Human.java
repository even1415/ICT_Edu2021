package day01;

public class Human {
	
	private String name;
	private int height;//멤버변수, 인스턴스 변수
	
//	public Human() {//default construtor-기본생성자
//		name="아무개"; //인스턴스 변수 초기화
//		height=170;
//	}
	public Human(String n, int h) {//인자 생성자 -생성자 overloading 
		name=n;
		height=h;
	}
	public Human(int h, String n) {
		height=h;
		name=n;
	}
	//setter, getter------
	public void setName(String n) {
		this.name=n;
	}
	public String getName() {
		return name;
	}
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {//매개변수-지역변수
		//멤버변수와 지역변수가 동일할 경우 멤버변수 앞에 this를 붙여 구분한다.
		this.height = height;
	}

	//접근제한자 생략형=> 같은 패키지 내에 있으면 접근 가능
	public void printInfo() {
		System.out.println("이름: "+name);
		System.out.println("키 : "+height);
	}

}
