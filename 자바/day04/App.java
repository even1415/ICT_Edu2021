package day04;

public class App {

	public static void main(String[] args) {
		//1. OuterŬ������ ���� a, b���� ����ϼ���
		Outer o1=new Outer();
		System.out.println("o1.a: "+o1.a);
		System.out.println("Outer.b: "+Outer.b);
		
		//2. Outer.InnerŬ������ ���� c���� ���, foo()ȣ���ϼ���
		Outer o2=new Outer();
		Outer.Inner oi=o2.new Inner();
		System.out.println("oi.c: "+oi.c);
		oi.foo();
		
		Outer.Inner oi2=new Outer().new Inner();
		System.out.println("oi2.c: "+oi2.c);
		
		//3 Outer.SInnerŬ������ ���� d, e�� ���, bar(), baz()ȣ��
		Outer.SInner os=new Outer.SInner();
		System.out.println("os.d: "+os.d);
		os.bar();
		System.out.println("Outer.SInner.e: "+Outer.SInner.e);
		Outer.SInner.baz();
	}

}
