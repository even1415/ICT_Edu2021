package day01;
//final + Ŭ���� : ��ӹ��� ���Ѵ�.
//final + �޼ҵ� : �������̵� ���� ����
//final + ����  : �� ���� ���� (����� ����)
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
	int x=100;//�ν��Ͻ� ����
	final public static int Y=200;//��� Ŭ��������
	//bar()�������̵� �ϱ�
	void bar() {
		System.out.println("Demo's bar()");
	}
	//foo()�������̵� �ϱ�
//	void foo() {
//		
//	}
}
public class FinalTest {
	public static void main(String[] args) {
		//Demo��ü �����ؼ� x, Y�� ����غ���
		//bar()�޼ҵ� ȣ���غ���
		Demo dm=new Demo();
		System.out.println("dm.x: "+dm.x);
		System.out.println("Demo.Y: "+Demo.Y);
		
		//x���� 300���� �����ϼ���
		dm.x=300;
		System.out.println("dm.x: "+dm.x);
		//Y���� 500���� �����ϼ���
		//Demo.Y=500; [x]
		
	}
}
