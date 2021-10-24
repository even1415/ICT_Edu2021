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
//1.Inter3가 Inter1과 Inter2를 상속받도록 하세요
//2. MyDemo가 Inter3와 AbsClass를 상속받도록 하세요
//   컴파일 오류가 없도록 구현하세요
public class InterfaceTest2 {

	public static void main(String[] args) {
		System.out.println("1.----------");
		//MyDemo타입 변수 선언 MyDemo객체 생성한 후 a(), b(), c(), d()호출하기
		MyDemo md=new MyDemo();
		md.a();
		System.out.println(md.b());
		md.c(567.890f);
		md.d();
		System.out.println("2.----------");
		//AbsClass타입 변수 선언 MyDemo객체 생성후 각 메소드 호출하기
		AbsClass ac=new MyDemo();
		ac.d();
		((Inter3)ac).a();
		((MyDemo)ac).b();
		((MyDemo)ac).c(123);
		System.out.println("3.----------");
		//Inter3타입 변수 선언 MyDemo객체 생성후 각 메소드 호출하기
		Inter3 i3=new MyDemo();
		i3.a();
		i3.b();
		i3.c(100e-3f);
		//100e-3=>100*10^-3
		((AbsClass)i3).d();
		System.out.println("4.-------------");
		//PI값 출력하기
		System.out.println(Inter2.PI);
		System.out.println(Inter3.PI);
		System.out.println(MyDemo.PI);
		System.out.println(md.PI);
	}
}


