package day01;
//Circle�� ��ӹ޾Ƽ� ������ ���� ���� �����غ�����
public class SubCircle extends Circle{

	@Override
	public void area(int a, int b) {
		//�ʿ������ �� �����ζ� �������̵� �ؾ���
	}
	
	public void area(int r) {
		double z=PI*r*r;
		System.out.println("�������� "+r+"�� ���� ����: "+z);
	}
	
}
