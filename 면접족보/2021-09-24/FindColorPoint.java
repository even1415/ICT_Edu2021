package java_2021_09_24;

class Point {
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	protected void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class ColorPoint extends Point {
	private String color;
	
	public ColorPoint() {
		super(0, 0);
		this.color = "BLACK";
	}
	
	public ColorPoint(int x, int y) {
		super(x, y);
		this.color = "BLACK";
	}

	public ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}
	
	public void setXY(int x, int y) {
		super.move(x, y);
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		return (color + "색의 " + "(" + super.getX() + ","
				+ super.getY() + ")의 점");
	}
	
}

class Point3D extends Point {
	private int z;

	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	public void moveUp() {
		this.z++;
	}

	public void moveDown() {
		this.z--;
	}

	public void move(int x, int y, int z) {
		super.move(x, y);
		this.z = z;
	}
	
	public String toString() {
		return ("(" + super.getX() + ","
				+ super.getY() + "," + this.z +") 의 점");
	}
	
}

class TV{
	   private int size;
	   public TV(int size) { this.size = size; }
	   protected int getSize() { return size; }
	}

class ColorTV extends TV {
	private int color;

	public ColorTV(int size, int color) {
		super(size);
		this.color = color;
	}
	
	public void printProperty() {
		System.out.println(super.getSize() + "인치 " + color + "컬러");
	}
	
	public int getColor() {
		return color;
	}
}

class IPTV extends ColorTV {
	private String ip;

	public IPTV(String ip, int size, int color) {
		super(size, color);
		this.ip = ip;
	}
	
	public void printProperty() {
		System.out.println("나의 IPTV는 " + ip + "주소의 " +
					super.getSize() + "인치 " + super.getColor() + "컬러");
	}
}

public class FindColorPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ColorPoint cp = new ColorPoint(5, 5, "YELLOW");
//		
//		cp.setXY(10, 20);
//		cp.setColor("RED");
//		String str = cp.toString();
//		System.out.println(str+"입니다. ");
		
//		ColorPoint zeroPoint = new ColorPoint(); // (0,0) 위치의 BLACK 색 점
//		System.out.println(zeroPoint.toString() + "입니다.");
//		ColorPoint cp = new ColorPoint(10, 10); // (10,10) 위치의 BLACK 색 점
//		cp.setXY(5,5);
//		cp.setColor("RED");
//		System.out.println(cp.toString()+"입니다.");
		
//		ColorTV myTV = new ColorTV(32, 1024);
//		myTV.printProperty();
		
//		IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
//				//"192.1.1.2" 주소에 32인치, 2048컬러
//		iptv.printProperty();
		
		Point3D p = new Point3D(1,2,3); // 1,2,3은 각각 x, y, z축의 값.
		System.out.println(p.toString()+"입니다.");
		p.moveUp(); // z 축으로 위쪽 이동
		System.out.println(p.toString()+"입니다.");
		p.moveDown(); // z 축으로 아래쪽 이동
		p.move(10, 10); // x, y 축으로 이동
		System.out.println(p.toString()+"입니다.");
		p.move(100,  200, 300); // x, y, z축으로 이동
		System.out.println(p.toString()+"입니다.");

	}

}
