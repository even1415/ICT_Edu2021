package day01;
//abstract class(�߻�Ŭ����): �߻�޼ҵ带 ���� Ŭ����
//<=> concrete class 
public abstract class AbstractClass { //�߻�Ŭ����
	int x=10;
	
	public void printInfo() {
		System.out.println("I am AbstracClass");
	}
	
	abstract public void sub(); //�߻�޼ҵ� �տ��� abstract=>modifier�� ���δ�.
	//�߻�޼ҵ带 1���� ���� Ŭ������ �� �ڽŵ� �߻�Ŭ�������� �Ѵ�.
}
