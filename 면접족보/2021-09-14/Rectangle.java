
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
		System.out.println("(" + x + "," + y + ")에서 크기가 "
				+ width + "x" + height + "인 사각형");
	}
	
	public int square() {
		return width*height;
	}
	
	public boolean contains(Rectangle rec) {
		//"포함" 의 정의가 모호한듯. 선 겹치는 경우 빼면 족보대로 나옴
		if((x<=rec.x && y<=rec.y) && 
			(x+width>=rec.x+rec.width && y+height>=rec.y+rec.height))
			bool = true;
		else bool = false;
		
		return bool;
	}
}
