package day01;

public class Rectangle extends Shape{

	@Override
	public void area(int x, int y) {
		int z=x*y;
		System.out.println("����: "+x+", ����: "+y+"�� �簢�� ����: "+z);
	}
}
