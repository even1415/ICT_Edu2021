package day04;

public class Outer {
	int a = 10;// �ν��Ͻ� ����
	static int b = 20; // Ŭ���� ����

	class Inner {// Inner Member class(non-staitc)
		int c = 30;

		void foo() { 
			System.out.println("foo()###");
		}
	}// Inner////////

	static class SInner {// Inner Member class(static)
		int d = 40;
		static int e = 50;
		
		public void bar() {
			System.out.println("bar()@@@");
		}
		public static void baz() {
			System.out.println("baz()$$$");
		}
	}// SInner/////////////////
}// outer///////////////////////////
