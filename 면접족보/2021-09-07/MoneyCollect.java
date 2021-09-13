
public class MoneyCollect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//11번 문제 영희의 이자붙기
//		int Money = 500;
//		
//		for(int day=1; day<=5; day++) {
//			Money++;
//		}
//		System.out.println(Money);
		
		//10번 문제 지폐단위 환산(반복문 사용O)
//		int Money = 126500;
//		int[] bill = {0,0,0,0,0,0};
//		
//		while(Money>=50000) {
//			bill[0]++;
//			Money -= 50000;
//		}
//		System.out.println("오만원 : " + bill[0] + "장");
//		while(Money>=10000) {
//			bill[1]++;
//			Money -= 10000;
//		}
//		System.out.println("만원 : " + bill[1] + "장");
//		while(Money>=5000) {
//			bill[2]++;
//			Money -= 5000;
//		}
//		System.out.println("오천원 : " + bill[2] + "장");
//		while(Money>=1000) {
//			bill[3]++;
//			Money -= 1000;
//		}
//		System.out.println("천원 : " + bill[3] + "장");
//		while(Money>=500) {
//			bill[4]++;
//			Money -= 500;
//		}
//		System.out.println("오백원 : " + bill[4] + "개");
//		while(Money>=100) {
//			bill[5]++;
//			Money -= 100;
//		}
//		System.out.println("백원 : " + bill[5] + "개");
		
		//10번 문제 지폐단위 환산(반복문 사용X)
//		int Money = 126500;
//		int billcount = 0;
//		
//		billcount = Money/50000;
//		System.out.println("오만원 : " + billcount + "장");
//		Money -= billcount * 50000;
//		
//		billcount = Money/10000;
//		System.out.println("만원 : " + billcount + "장");
//		Money -= billcount * 10000;
//		
//		billcount = Money/5000;
//		System.out.println("오천원 : " + billcount + "장");
//		Money -= billcount * 5000;
//		
//		billcount = Money/1000;
//		System.out.println("천원 : " + billcount + "장");
//		Money -= billcount * 1000;
//		
//		billcount = Money/500;
//		System.out.println("오백원 : " + billcount + "개");
//		Money -= billcount * 500;
//		
//		billcount = Money/100;
//		System.out.println("백원 : " + billcount + "개");
//		Money -= billcount * 100;
		
		//10번 문제 지폐단위 환산(반복문 사용X)
		int Money = 126500;
		
		System.out.println("오만원 : " + (Money/50000) + "장");
		System.out.println("만원 : " + ((Money % 50000)/10000) + "장");
		System.out.println("오천원 : " + ((Money % 10000)/5000) + "장");
		System.out.println("천원 : " + ((Money % 5000)/1000) + "장");
		System.out.println("오백원 : " + ((Money % 1000)/500) + "개");
		System.out.println("백원 : " + ((Money % 500)/100) + "개");
	}

}
