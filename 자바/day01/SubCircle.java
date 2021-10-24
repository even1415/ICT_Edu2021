package day01;
//Circle을 상속받아서 컴파일 오류 없이 구현해보세요
public class SubCircle extends Circle{

	@Override
	public void area(int a, int b) {
		//필요없으면 빈 블럭으로라도 오버라이드 해야함
	}
	
	public void area(int r) {
		double z=PI*r*r;
		System.out.println("반지름이 "+r+"인 원의 면적: "+z);
	}
	
}
