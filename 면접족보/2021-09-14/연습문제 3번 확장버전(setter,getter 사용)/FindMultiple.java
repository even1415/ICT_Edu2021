import java.util.Scanner;

public class FindMultiple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		  Multiples multiples = new Multiples();
//		  multiples.setNum(10000);  
//		  multiples.getAnswer();
//		  multiples.printNum();
		
		
		//1,2������ ���뺯��
//		boolean end = false;
//		char ch = 'n';
	
		//1������
//		while(true) {
//			FindManyAvgScore findManyAvgScore = new FindManyAvgScore(0, 0, 0);
//		
//			findManyAvgScore.inputScore();
//			findManyAvgScore.CalAvg();
//			findManyAvgScore.printAvg();
//			
//			while(true) {
//				System.out.println("��� �Ͻðڽ��ϱ�?");
//				Scanner scanner = new Scanner(System.in);
//				ch = scanner.next().charAt(0);
//			
//				if (ch == 'y')
//					break;
//				else if (ch == 'n') {
//					end = true;
//					break;
//				}
//				else
//					System.out.println("[y] Ȥ�� [n] �� �Է����ּ���.");
//			}
//			if(end==true) {
//				System.out.println("���α׷� ���� �Դϴ�.");
//				break;
//			}
//		}
		

		//2������
//		FindBillCount findBillCount = new FindBillCount(0);
//		
//		while(true) {
//			findBillCount.inputMoney();
//			findBillCount.printMoney();
//			
//			while (true) {
//				System.out.println("��� �Ͻðڽ��ϱ�?");
//				Scanner scanner = new Scanner(System.in);
//				ch = scanner.next().charAt(0);
//
//				if (ch == 'y')
//					break;
//				else if (ch == 'n') {
//					end = true;
//					break;
//				}
//				else
//					System.out.println("[y] Ȥ�� [n] �� �Է����ּ���.");
//			}
//			if (end == true) {
//				System.out.println("���α׷� ���� �Դϴ�.");
//				break;
//			}
//		}
		
		
		//3������
//		Rectangle r = new Rectangle(2, 2, 8, 7);
//		Rectangle s = new Rectangle(5, 5, 6, 6);
		Rectangle t = new Rectangle(1, 1, 10, 10);
//		
//		r.show();
//		System.out.println("s�� ������" + s.square());
//		if(t.contains(r)) System.out.println("t�� r�� �����մϴ�.");
//		if(t.contains(s)) System.out.println("t�� s�� �����մϴ�.");
		
		
		//3������ + setter/getter ���(Ȯ�����)
		int x, y, width, height;
		Rectangle u = new Rectangle(0, 0, 0, 0);
		Scanner scanner = new Scanner(System.in);
		
		x = scanner.nextInt();
		y = scanner.nextInt();
		width = scanner.nextInt();
		height = scanner.nextInt();
		
		u.setter(x, y, width, height); //�Է¹��� ���� ����
		t.contains(u); //���Կ��� Ȯ�� �޼ҵ�(bool �� ����)
		
		if(t.getter()) System.out.println("t�� r�� �����մϴ�.");
	}
}
