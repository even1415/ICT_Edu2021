package day01;
//final + 클래스 : 상속받지 못한다.
//final + 메소드 : 오버라이드 하지 못함
//final + 변수  : 값 변경 못함 (상수로 만듦)
abstract class Super{ 
	final void foo() {
		System.out.println("Super's foo()");
	}
	abstract void bar();
	
}//////////////

final class Sub extends Super{
	
	public void bar() {
		System.out.println("Sub's bar()");
	}
	
}///////////////
class Demo extends Super //extends Sub
{
	int x=100;//인스턴스 변수
	final public static int Y=200;//상수 클래스변수
	//bar()오버라이드 하기
	void bar() {
		System.out.println("Demo's bar()");
	}
	//foo()오버라이드 하기
//	void foo() {
//		
//	}
}
public class FinalTest {
	public static void main(String[] args) {
		//Demo객체 생성해서 x, Y값 출력해보기
		//bar()메소드 호출해보기
		Demo dm=new Demo();
		System.out.println("dm.x: "+dm.x);
		System.out.println("Demo.Y: "+Demo.Y);
		
		//x값을 300으로 변경하세요
		dm.x=300;
		System.out.println("dm.x: "+dm.x);
		//Y값은 500으로 변경하세요
		//Demo.Y=500; [x]
		
	}
}
