import java.util.Scanner;

public class FindMultiple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		  Multiples multiples = new Multiples();
//		  multiples.setNum(10000);  
//		  multiples.getAnswer();
//		  multiples.printNum();
		
		
		//1,2번문제 공통변수
//		boolean end = false;
//		char ch = 'n';
	
		//1번문제
//		while(true) {
//			FindManyAvgScore findManyAvgScore = new FindManyAvgScore(0, 0, 0);
//		
//			findManyAvgScore.inputScore();
//			findManyAvgScore.CalAvg();
//			findManyAvgScore.printAvg();
//			
//			while(true) {
//				System.out.println("계속 하시겠습니까?");
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
//					System.out.println("[y] 혹은 [n] 만 입력해주세요.");
//			}
//			if(end==true) {
//				System.out.println("프로그램 종료 입니다.");
//				break;
//			}
//		}
		

		//2번문제
//		FindBillCount findBillCount = new FindBillCount(0);
//		
//		while(true) {
//			findBillCount.inputMoney();
//			findBillCount.printMoney();
//			
//			while (true) {
//				System.out.println("계속 하시겠습니까?");
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
//					System.out.println("[y] 혹은 [n] 만 입력해주세요.");
//			}
//			if (end == true) {
//				System.out.println("프로그램 종료 입니다.");
//				break;
//			}
//		}
		
		
		//3번문제
//		Rectangle r = new Rectangle(2, 2, 8, 7);
//		Rectangle s = new Rectangle(5, 5, 6, 6);
		Rectangle t = new Rectangle(1, 1, 10, 10);
//		
//		r.show();
//		System.out.println("s의 면적은" + s.square());
//		if(t.contains(r)) System.out.println("t는 r을 포함합니다.");
//		if(t.contains(s)) System.out.println("t는 s을 포함합니다.");
		
		
		//3번문제 + setter/getter 사용(확장버전)
		int x, y, width, height;
		Rectangle u = new Rectangle(0, 0, 0, 0);
		Scanner scanner = new Scanner(System.in);
		
		x = scanner.nextInt();
		y = scanner.nextInt();
		width = scanner.nextInt();
		height = scanner.nextInt();
		
		u.setter(x, y, width, height); //입력받은 값을 삽입
		t.contains(u); //포함여부 확인 메소드(bool 값 변경)
		
		if(t.getter()) System.out.println("t는 r을 포함합니다.");
	}
}
