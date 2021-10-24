package day02;
interface Inter1{
	void a();
	int b();
}///////////////////////
interface Inter2{
	double PI=3.14;
}////////////////////////
interface Inter3 extends Inter1, Inter2
{
	void c(float f);
}////////////////////////////
abstract class AbsClass
{
	abstract void d();
}////////////////////////////
class MyDemo extends AbsClass implements Inter3
{
	public void a() {
		System.out.println("a()");
	}
	public int b() {
		System.out.println("b()");	
		return 100;
	}
	public void c(float a) {
		System.out.println("c(): a="+a);
	}
	void d() {
		System.out.println("d()");
	}
}/////////////////////////
//1.Inter3�� Inter1�� Inter2�� ��ӹ޵��� �ϼ���
//2. MyDemo�� Inter3�� AbsClass�� ��ӹ޵��� �ϼ���
//   ������ ������ ������ �����ϼ���
public class InterfaceTest2 {

	public static void main(String[] args) {
		System.out.println("1.----------");
		//MyDemoŸ�� ���� ���� MyDemo��ü ������ �� a(), b(), c(), d()ȣ���ϱ�
		MyDemo md=new MyDemo();
		md.a();
		System.out.println(md.b());
		md.c(567.890f);
		md.d();
		System.out.println("2.----------");
		//AbsClassŸ�� ���� ���� MyDemo��ü ������ �� �޼ҵ� ȣ���ϱ�
		AbsClass ac=new MyDemo();
		ac.d();
		((Inter3)ac).a();
		((MyDemo)ac).b();
		((MyDemo)ac).c(123);
		System.out.println("3.----------");
		//Inter3Ÿ�� ���� ���� MyDemo��ü ������ �� �޼ҵ� ȣ���ϱ�
		Inter3 i3=new MyDemo();
		i3.a();
		i3.b();
		i3.c(100e-3f);
		//100e-3=>100*10^-3
		((AbsClass)i3).d();
		System.out.println("4.-------------");
		//PI�� ����ϱ�
		System.out.println(Inter2.PI);
		System.out.println(Inter3.PI);
		System.out.println(MyDemo.PI);
		System.out.println(md.PI);
	}
}


