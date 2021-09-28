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
		System.out.println("---��������---");
		System.out.println("�̸� : " + this.name);
		System.out.println("���� : " + this.age);
		System.out.println("�ּ� : " + this.address);
		System.out.println("�μ� : " + this.section);
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
		System.out.println("�����з� : ������");
		super.printInfo();
		System.out.println("���� : " + super.getter());
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
//									//�̰� �翬�� ����(���ǵ� �������� 2��¥�� �����ڰ� ����)
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
		
//		Employee employee = new Employee("ȫ�浿", 25, "�����", "�渮��");
//		employee.printInfo();
//		Employee employee2 = new Regular("��ö��", 26, "�����", "������", 2_500_000);
//		employee2.printInfo();

	}

}
