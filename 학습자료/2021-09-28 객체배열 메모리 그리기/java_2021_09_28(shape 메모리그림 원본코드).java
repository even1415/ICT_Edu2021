package java_2021_09_28;

class Shape {
	public double getArea() {
		return 0.0;
	}
}

class Circle extends Shape {
	private int radius;
	
	public Circle() {
	}
	
	public Circle(int radius) {
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		return radius * radius * Math.PI;
	}
}

class Triangle extends Shape {
	private int width;
	private int height;
	
	public Triangle() {
	}
	
	public Triangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		return width * height * 0.5;
	}
}

class Rectangle extends Shape {
	private int width;
	private int height;
	
	public Rectangle() {
	}
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		return width * height;
	}
}

public class java_2021_09_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Shape shape[] = new Shape[3];
		
		shape[0] = new Circle(5);
		shape[1] = new Triangle(3,3);
		shape[2] = new Rectangle(5,5);
		
		double areaSum = 0;
		for (Shape s : shape) {
			//System.out.println(s.getArea()); //확인용 출력문
			areaSum += s.getArea();
		}
		
		System.out.println("모든 넓이의 합은" + areaSum);
	}

}
