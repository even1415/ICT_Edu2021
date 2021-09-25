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
		return (color + "���� " + "(" + super.getX() + ","
				+ super.getY() + ")�� ��");
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
				+ super.getY() + "," + this.z +") �� ��");
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
		System.out.println(super.getSize() + "��ġ " + color + "�÷�");
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
		System.out.println("���� IPTV�� " + ip + "�ּ��� " +
					super.getSize() + "��ġ " + super.getColor() + "�÷�");
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
//		System.out.println(str+"�Դϴ�. ");
		
//		ColorPoint zeroPoint = new ColorPoint(); // (0,0) ��ġ�� BLACK �� ��
//		System.out.println(zeroPoint.toString() + "�Դϴ�.");
//		ColorPoint cp = new ColorPoint(10, 10); // (10,10) ��ġ�� BLACK �� ��
//		cp.setXY(5,5);
//		cp.setColor("RED");
//		System.out.println(cp.toString()+"�Դϴ�.");
		
//		ColorTV myTV = new ColorTV(32, 1024);
//		myTV.printProperty();
		
//		IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
//				//"192.1.1.2" �ּҿ� 32��ġ, 2048�÷�
//		iptv.printProperty();
		
		Point3D p = new Point3D(1,2,3); // 1,2,3�� ���� x, y, z���� ��.
		System.out.println(p.toString()+"�Դϴ�.");
		p.moveUp(); // z ������ ���� �̵�
		System.out.println(p.toString()+"�Դϴ�.");
		p.moveDown(); // z ������ �Ʒ��� �̵�
		p.move(10, 10); // x, y ������ �̵�
		System.out.println(p.toString()+"�Դϴ�.");
		p.move(100,  200, 300); // x, y, z������ �̵�
		System.out.println(p.toString()+"�Դϴ�.");

	}

}
