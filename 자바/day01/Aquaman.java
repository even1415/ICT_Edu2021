package day01;

/*1. Human상속받기
 *2. 생성자 오버로드 하기- 2개
 *3. printInfo() 오버라이드 하기
 *4. printInfo() 오버로드 하기 
 * */
public class Aquaman extends Human{
	double speed;

	public Aquaman() {
		//super() //부모의 기본생성자가 없을 경우 문제생김
		//이럴 때는 명시적으로 부모가 가진 생성자를 호출해준다.
		super("아쿠아맨",155);
	}

	public Aquaman(String name, int height, int speed) {
		super(name, height);
		this.speed = speed;
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("속도: " + speed);
	}

	public void printInfo(String title) {
		System.out.println(title);
		this.printInfo();
	}

}
