package day02;

//MyInter, YourInter인터페이스를 상속받아서 구현해보기
//인터페이스를 상속받을 때는 implements를 이용. 여러 개 상속 가능
public class MyClass implements MyInter, YourInter{

	@Override
	public void foo() {
		System.out.println("foo()~~");
	}
	public String bar() {
		return "bar()~~";
	}
}
