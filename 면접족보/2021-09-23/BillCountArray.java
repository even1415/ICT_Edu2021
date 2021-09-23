import java.util.Scanner;

public class BillCountArray {
	private final int[] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};
	private int money;
	private int bill[];
	
	public BillCountArray() {
		this.bill = new int[8];
	}
	
	private void MoneyInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("금액을 입력하시오 >> ");
		money = scanner.nextInt();
	}
	
	private void CountMoney() {
		for(int i=0; i<unit.length; i++) {
			bill[i] = money/unit[i];
			money -= bill[i]*unit[i];
		}
	}
	
	private void print() {
		for(int i=0; i<unit.length; i++) {
			System.out.println(unit[i] + " 원 짜리 : " + bill[i] + "개");
		}
	}
	
	public void run() {
		MoneyInput();
		CountMoney();
		print();
	}
}
