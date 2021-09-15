import java.util.Scanner;

public class FindBillCount {
	int money;

	public FindBillCount(int money) {
		this.money = money;
	}
	
	public void inputMoney() {
		Scanner sc = new Scanner(System.in);
		
		money = sc.nextInt();
	}

	public void printMoney() {
		System.out.println("오만원 : " + (money/50000) + "장");
		System.out.println("만원 : " + ((money % 50000)/10000) + "장");
		System.out.println("오천원 : " + ((money % 10000)/5000) + "장");
		System.out.println("천원 : " + ((money % 5000)/1000) + "장");
		System.out.println("오백원 : " + ((money % 1000)/500) + "개");
		System.out.println("백원 : " + ((money % 500)/100) + "개");
	}
}
