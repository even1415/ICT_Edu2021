package day01;
//클래스와 멤버변수의 관계: has a관계가 성립해야 한다.
//부모와 자식의 관계: is a관계가 성립해야 한다.
//Superman is a Human
//Aquaman is a Human
//상속: extends 부모  (자바는 단일상속. 부모는 1개만 가능)

public class Superman extends Human{
	
	//String name; //Superman has a name;
	//int height;
	int power;
	
	//기본 생성자
	public Superman() { //this()호출해서 아래 인자생성자에서 모두 초기화시키고		
		this("슈퍼맨", 160, 100);
	}
	
	//인자 생성자 
	public Superman(String name, int height, int power) {
		//super.name=name;
		//super.height=height;
		//setName(name);
		//setHeight(height);
		super(name, height);//Human의 String,int를 받는 생성자를 호출
		this.power=power;
	}
	//Override: 부모클래스에서 정의한 메소드를 자식클래스에서 재정의해서 사용하는 것
	/*오버라이드 조건
	 * - 부모가 가진 메소드와 동일한 이름으로 작성해야 함 (대소문자도 같아야 함)
	 * - 매개변수도 부모의 메소드와 동일하게 작성한다.
	 * - 반환타입도 부모의 메소드와 동일하게
	 * - 접근제한자는 부모의 메소드와 동일하거나 더 넓은 범위의 제한자를 둘 수 있다.
	 * 
	 * 접근범위
	 * private < 생략형 < protected < public
	 * private: 자기 클래스 내에서만 접근 가능
	 * 생략형: 같은 패키지 내의 클래스끼리 접근 가능
	 * protected: 같은 패키지 + 부모,자식의 상속관계
	 * public : 어디서든 접근 가능
	 * */
	@Override
	public void printInfo() {
		super.printInfo();//이름, 키를 출력
		//System.out.println("이름: "+getName());		
		//System.out.println("키 : "+getHeight());
		System.out.println("초능력: "+power);
	}
	//메소드 Overload 조건 
	/*- 자기 클래스 내의 메소드를 다양하게 여러개 정의하는 것
	 * - 메소드명은 같아야 함
	 * - 매개변수는 자료형이 다르거나, 개수가 다르거나, 순서가 달라야 한다.
	 * - 반환타입은 같아도되고 달라도 된다. 
	 * */
	public void printInfo(String title) {
		System.out.println(title);
		//이름, 키, 초능력
		this.printInfo();//이름,키,초능력
	}
	public String printInfo(String title, int powerUp) {
		
		String str=">>초능력 충전>>>"+powerUp;
		this.power+=powerUp;
		
		this.printInfo(title);
		return str;
	}
}
