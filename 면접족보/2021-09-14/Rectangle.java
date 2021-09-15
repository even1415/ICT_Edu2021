
public class Rectangle {
	int x;
	int y;
	int width;
	int height;
	boolean bool;
	
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bool = false;
	}
	
	public void show() {
		System.out.println("(" + x + "," + y + ")���� ũ�Ⱑ "
				+ width + "x" + height + "�� �簢��");
	}
	
	public int square() {
		return width*height;
	}
	
	public boolean contains(Rectangle rec) {
		//"����" �� ���ǰ� ��ȣ�ѵ�. �� ��ġ�� ��� ���� ������� ����
		if((x<=rec.x && y<=rec.y) && 
			(x+width>=rec.x+rec.width && y+height>=rec.y+rec.height))
			bool = true;
		else bool = false;
		
		return bool;
	}
}
