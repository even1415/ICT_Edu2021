import java.util.Scanner;

class MultipleNumber {
	int num1;
	int num2;
	char ch;
	
	private void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�� ���� �Է��ϼ���");
		num1 = scanner.nextInt();
		num2 = scanner.nextInt();
	}
	
	private int findMultiple() {
		int result = 0;
		if(num1%3!=0 || num1%6!=0 || num2%3!=0 || num2%6!=0) {
			System.out.println(num1 + "Ȥ�� " + num2 + "��(��) 3�� 6�� ����� �ƴմϴ�");
			result = 0;
		}
		else {
			result = num1*num2;
			System.out.println(num1 + "*" + num2 + "=" + result);
		}
		return result;
	}
	
	public void run() {
		while (true) {
			input();
			if(findMultiple()!=0) break;
		}
		
	}
}

public class InterView_006 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultipleNumber multipleNumber = new MultipleNumber();
		
		multipleNumber.run();
	}

}
