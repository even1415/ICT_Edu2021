package day04;

public class App {

	public static void main(String[] args) {
		//1. Outer클래스의 변수 a, b값을 출력하세요
		Outer o1=new Outer();
		System.out.println("o1.a: "+o1.a);
		System.out.println("Outer.b: "+Outer.b);
		
		//2. Outer.Inner클래스의 변수 c값을 출력, foo()호출하세요
		Outer o2=new Outer();
		Outer.Inner oi=o2.new Inner();
		System.out.println("oi.c: "+oi.c);
		oi.foo();
		
		Outer.Inner oi2=new Outer().new Inner();
		System.out.println("oi2.c: "+oi2.c);
		
		//3 Outer.SInner클래스의 변수 d, e값 출력, bar(), baz()호출
		Outer.SInner os=new Outer.SInner();
		System.out.println("os.d: "+os.d);
		os.bar();
		System.out.println("Outer.SInner.e: "+Outer.SInner.e);
		Outer.SInner.baz();
	}

}
