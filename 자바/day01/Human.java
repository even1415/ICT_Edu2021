package day01;

public class Human {
	
	private String name;
	private int height;//�������, �ν��Ͻ� ����
	
//	public Human() {//default construtor-�⺻������
//		name="�ƹ���"; //�ν��Ͻ� ���� �ʱ�ȭ
//		height=170;
//	}
	public Human(String n, int h) {//���� ������ -������ overloading 
		name=n;
		height=h;
	}
	public Human(int h, String n) {
		height=h;
		name=n;
	}
	//setter, getter------
	public void setName(String n) {
		this.name=n;
	}
	public String getName() {
		return name;
	}
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {//�Ű�����-��������
		//��������� ���������� ������ ��� ������� �տ� this�� �ٿ� �����Ѵ�.
		this.height = height;
	}

	//���������� ������=> ���� ��Ű�� ���� ������ ���� ����
	public void printInfo() {
		System.out.println("�̸�: "+name);
		System.out.println("Ű : "+height);
	}

}
