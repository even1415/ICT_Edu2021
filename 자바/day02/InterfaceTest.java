package day02;

public class InterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MyInter mi=new MyInter(); [x]
		//MyInterŸ���� ���� ���� MyClass��ü�� �����ؼ� foo()ȣ���غ���
		MyInter mi=new MyClass();
		mi.foo();
		
		//YourInter ���� ���� MyClass��ü�� �����ؼ� bar()ȣ���غ���
		YourInter yi=new MyClass();
		String str=yi.bar();
		System.out.println(str);
		((MyInter)yi).foo();
		
		//STR�� ����غ���
		System.out.println(yi.STR);
		System.out.println(YourInter.STR);
		System.out.println(MyClass.STR);
		//System.out.println(MyInter.STR);[x]

	}

}
