package day01;
//추상클래스의 목적=> 상속받게할 목적. 상속받아서 추상메소드를 의무적으로 오버라이딩 하게끔
abstract public class Shape { 
	
	int x=10;
	static int y=20;
	
	public String getInfo() {
		return "나 도형 클래스";
	}
	public abstract void area(int a, int b);

}/////////////////////////
