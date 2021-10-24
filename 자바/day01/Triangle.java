package day01;
//직삼각형
//Shape을 상속받아 구현하세요
public class Triangle extends Shape {

	@Override
	public void area(int a, int b) {
		System.out.println("가로: "+a+", 세로: "+b+"인 직삼각형 면적: "+((a*b)/2));
	}
}
