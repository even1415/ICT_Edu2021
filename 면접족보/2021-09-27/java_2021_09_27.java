package java_2021_09_27;

class MobilePhone {
	protected String number;
	
	public MobilePhone(String num) {
		number = num;
	}
	public void answer() {
		System.out.println("Hi~ from " + number);
	}
}

class SmartPhone extends MobilePhone {
	private String androidVer;
	
	public SmartPhone(String num, String ver) {
		super(num);
		androidVer = ver;
	}
	public void playApp() {
		System.out.println("App is running in " + androidVer);
	}
}

class Cake {
	public void yummy() {
		System.out.println("Yummy Cake");
	}
}

class CheeseCake extends Cake {
	public void yummy() {
		System.out.println("Yummy Cheese Cake");
	}
}

class StrawberryCheeseCake extends CheeseCake {
	public void yummy() {
		System.out.println("Yummy Strawberry Cheese Cake");
	}
}

class Employee {
	private String name;
	private int age;
	private String address;
	private String section;
	private int salary;
	
	public Employee() {
		
	}
	
	public Employee(String name, int age, String address, String section) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.section = section;
	}
	
	protected void setter(int salary) {
		this.salary = salary;
	}
	
	protected int getter() {
		return this.salary;
	}

	protected void printInfo() {
		System.out.println("---직원정보---");
		System.out.println("이름 : " + this.name);
		System.out.println("나이 : " + this.age);
		System.out.println("주소 : " + this.address);
		System.out.println("부서 : " + this.section);
	}
}
//----------------------------------------------------------

class Regular extends Employee {
	
	public Regular(String name, int age, String address, String section, int salary) {
		super(name, age, address, section);
		super.setter(salary);
	}
	
	@Override
	protected void printInfo() {
		System.out.println("직업분류 : 정규직");
		super.printInfo();
		System.out.println("월급 : " + super.getter());
	}
}

public class java_2021_09_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		SmartPhone phone = new SmartPhone("010-555-7777", "Nougat");
//		phone.answer();
//		phone.playApp();
//		MobilePhone mobilePhone1 = new MobilePhone("010-555-7777");
//		//MobilePhone mobilePhone2 = new MobilePhone("010-555-7777", "Nougat");
//									//이건 당연히 에러(정의된 전달인자 2개짜리 생성자가 없음)
//		MobilePhone mobilePhone3 = new SmartPhone("010-555-7777", "Nougat");
		
//		Cake c1 = new Cake();
//		CheeseCake c2 = new CheeseCake();
//		Cake c3 = new CheeseCake();
//		
//		c1.yummy();
//		c2.yummy();
//		c3.yummy();
		
//		Cake c1 = new StrawberryCheeseCake();
//		CheeseCake c2 = new StrawberryCheeseCake();
//		StrawberryCheeseCake c3 = new StrawberryCheeseCake();
//		
//		c1.yummy();
//		c2.yummy();
		
//		Employee employee = new Employee("홍길동", 25, "서울시", "경리과");
//		employee.printInfo();
//		Employee employee2 = new Regular("김철수", 26, "서울시", "마케팅", 2_500_000);
//		employee2.printInfo();

	}

}
