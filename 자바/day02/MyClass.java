package day02;

//MyInter, YourInter�������̽��� ��ӹ޾Ƽ� �����غ���
//�������̽��� ��ӹ��� ���� implements�� �̿�. ���� �� ��� ����
public class MyClass implements MyInter, YourInter{

	@Override
	public void foo() {
		System.out.println("foo()~~");
	}
	public String bar() {
		return "bar()~~";
	}
}
