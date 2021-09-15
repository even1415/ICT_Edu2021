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
		System.out.println("������ : " + (money/50000) + "��");
		System.out.println("���� : " + ((money % 50000)/10000) + "��");
		System.out.println("��õ�� : " + ((money % 10000)/5000) + "��");
		System.out.println("õ�� : " + ((money % 5000)/1000) + "��");
		System.out.println("����� : " + ((money % 1000)/500) + "��");
		System.out.println("��� : " + ((money % 500)/100) + "��");
	}
}
