package day01;

public class Rectangle extends Shape{

	@Override
	public void area(int x, int y) {
		int z=x*y;
		System.out.println("가로: "+x+", 세로: "+y+"인 사각형 면적: "+z);
	}
}
