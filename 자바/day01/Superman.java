package day01;
//Ŭ������ ��������� ����: has a���谡 �����ؾ� �Ѵ�.
//�θ�� �ڽ��� ����: is a���谡 �����ؾ� �Ѵ�.
//Superman is a Human
//Aquaman is a Human
//���: extends �θ�  (�ڹٴ� ���ϻ��. �θ�� 1���� ����)

public class Superman extends Human{
	
	//String name; //Superman has a name;
	//int height;
	int power;
	
	//�⺻ ������
	public Superman() { //this()ȣ���ؼ� �Ʒ� ���ڻ����ڿ��� ��� �ʱ�ȭ��Ű��		
		this("���۸�", 160, 100);
	}
	
	//���� ������ 
	public Superman(String name, int height, int power) {
		//super.name=name;
		//super.height=height;
		//setName(name);
		//setHeight(height);
		super(name, height);//Human�� String,int�� �޴� �����ڸ� ȣ��
		this.power=power;
	}
	//Override: �θ�Ŭ�������� ������ �޼ҵ带 �ڽ�Ŭ�������� �������ؼ� ����ϴ� ��
	/*�������̵� ����
	 * - �θ� ���� �޼ҵ�� ������ �̸����� �ۼ��ؾ� �� (��ҹ��ڵ� ���ƾ� ��)
	 * - �Ű������� �θ��� �޼ҵ�� �����ϰ� �ۼ��Ѵ�.
	 * - ��ȯŸ�Ե� �θ��� �޼ҵ�� �����ϰ�
	 * - ���������ڴ� �θ��� �޼ҵ�� �����ϰų� �� ���� ������ �����ڸ� �� �� �ִ�.
	 * 
	 * ���ٹ���
	 * private < ������ < protected < public
	 * private: �ڱ� Ŭ���� �������� ���� ����
	 * ������: ���� ��Ű�� ���� Ŭ�������� ���� ����
	 * protected: ���� ��Ű�� + �θ�,�ڽ��� ��Ӱ���
	 * public : ��𼭵� ���� ����
	 * */
	@Override
	public void printInfo() {
		super.printInfo();//�̸�, Ű�� ���
		//System.out.println("�̸�: "+getName());		
		//System.out.println("Ű : "+getHeight());
		System.out.println("�ʴɷ�: "+power);
	}
	//�޼ҵ� Overload ���� 
	/*- �ڱ� Ŭ���� ���� �޼ҵ带 �پ��ϰ� ������ �����ϴ� ��
	 * - �޼ҵ���� ���ƾ� ��
	 * - �Ű������� �ڷ����� �ٸ��ų�, ������ �ٸ��ų�, ������ �޶�� �Ѵ�.
	 * - ��ȯŸ���� ���Ƶ��ǰ� �޶� �ȴ�. 
	 * */
	public void printInfo(String title) {
		System.out.println(title);
		//�̸�, Ű, �ʴɷ�
		this.printInfo();//�̸�,Ű,�ʴɷ�
	}
	public String printInfo(String title, int powerUp) {
		
		String str=">>�ʴɷ� ����>>>"+powerUp;
		this.power+=powerUp;
		
		this.printInfo(title);
		return str;
	}
}
