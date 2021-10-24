package day02;

public class InterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MyInter mi=new MyInter(); [x]
		//MyInter타입의 변수 선언 MyClass객체를 생성해서 foo()호출해보기
		MyInter mi=new MyClass();
		mi.foo();
		
		//YourInter 변수 선언 MyClass객체를 생성해서 bar()호출해보기
		YourInter yi=new MyClass();
		String str=yi.bar();
		System.out.println(str);
		((MyInter)yi).foo();
		
		//STR도 출력해보기
		System.out.println(yi.STR);
		System.out.println(YourInter.STR);
		System.out.println(MyClass.STR);
		//System.out.println(MyInter.STR);[x]

	}

}
