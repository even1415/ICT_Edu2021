public class DrawStar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//drawStar(4);
		//drawStar1(5);
		drawStar2(5);
	}
	
	public static void drawStar(int num) {
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=num*2-1; j++) {
				
				if((j==num) || (j<=num+(i-1) && j>=num-(i-1)))
					System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
		
		/*
		//���䵵(2n-1)
		0 0 0 1 0 0 0
		0 0 1 1 1 0 0
		0 1 1 1 1 1 0
		1 1 1 1 1 1 1
		*/
	}
	
	public static void drawStar1(int num) { //��� �ڵ�
		for(int i=1; i<=num; i++) {
			for(int j=num; j>i; j--) {
				System.out.print(" ");
			}
					
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
					
			for(int j=1; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/*
		//���䵵(3�κ����� ������ ����/��/�� ���)
		0 0 0 1
		0 0 1 1 2
		0 1 1 1 2 2
		1 1 1 1 2 2 2
		*/
	}
	
	public static void drawStar2(int num) {
		for (int i = 1; i <= num; i++) {
			for (int j = num; j >= i; j--) {
				System.out.print(" ");

			}
			for (int k = 1; k < (2 * i); k++) {
				System.out.print("*");
			}
			System.out.println();
		}

		/*
		//https://blog.naver.com/dltkd0737/222499444237
		//���䵵(3�κ����� ������ ����/��/�� ���)
		0 0 0 1
		0 0 1 1 1
		0 1 1 1 1 1
		1 1 1 1 1 1 1
		*/
	}

}





