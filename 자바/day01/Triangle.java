package day01;
//���ﰢ��
//Shape�� ��ӹ޾� �����ϼ���
public class Triangle extends Shape {

	@Override
	public void area(int a, int b) {
		System.out.println("����: "+a+", ����: "+b+"�� ���ﰢ�� ����: "+((a*b)/2));
	}
}
