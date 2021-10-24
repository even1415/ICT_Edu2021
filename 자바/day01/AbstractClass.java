package day01;
//abstract class(추상클래스): 추상메소드를 갖는 클래스
//<=> concrete class 
public abstract class AbstractClass { //추상클래스
	int x=10;
	
	public void printInfo() {
		System.out.println("I am AbstracClass");
	}
	
	abstract public void sub(); //추상메소드 앞에는 abstract=>modifier를 붙인다.
	//추상메소드를 1개라도 가진 클래스는 그 자신도 추상클래스여야 한다.
}
