package day01;

/*1. Human��ӹޱ�
 *2. ������ �����ε� �ϱ�- 2��
 *3. printInfo() �������̵� �ϱ�
 *4. printInfo() �����ε� �ϱ� 
 * */
public class Aquaman extends Human{
	double speed;

	public Aquaman() {
		//super() //�θ��� �⺻�����ڰ� ���� ��� ��������
		//�̷� ���� ��������� �θ� ���� �����ڸ� ȣ�����ش�.
		super("����Ƹ�",155);
	}

	public Aquaman(String name, int height, int speed) {
		super(name, height);
		this.speed = speed;
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("�ӵ�: " + speed);
	}

	public void printInfo(String title) {
		System.out.println(title);
		this.printInfo();
	}

}
