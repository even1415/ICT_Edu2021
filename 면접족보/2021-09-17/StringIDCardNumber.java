import java.util.Scanner;

public class StringIDCardNumber {
	private String iDCard;

	private void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�Է� : ");
		iDCard = scanner.next();
	}

	private void print() {
		System.out.print("��� : ");
		for (int i = 0; i < iDCard.length(); i++) {
			if (iDCard.charAt(i) == '-')
				System.out.print(' ');
			else
				System.out.print(iDCard.charAt(i));
		}
	}

	public void run() {
		input();
		print();
	}
}
