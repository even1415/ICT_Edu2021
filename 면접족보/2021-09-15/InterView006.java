import java.util.Scanner;

class Gugudan {
	int num;

	public void setGugudan(int num) {
		this.num = num;
	}
	public void showGugudan() {
		for(int i=1; i<=num; i++) {
			System.out.print("<" + i + ">��" + '\t');
		}
		System.out.println("");
		
		for(int j=1; j<=9; j++) {
			for(int i=1; i<=num; i++) {
				System.out.print(i + "*" + j + "=" + i*j + '\t');
			}
			System.out.println("");
		}
	}
	public void showReverse() {
		for(int i=num; i>=1; i--) {
			System.out.print("<" + i + ">��" + '\t');
		}
		System.out.println("");
		
		for(int j=1; j<=9; j++) {
			for(int i=num; i>=1; i--) {
				System.out.print(i + "*" + j + "=" + i*j + '\t');
			}
			System.out.println("");
		}
	}
}

class UpDown {
	int input;
	int num;
	int chance = 10;
	int count = 0;
	boolean bool = false;
	
	public void setNum() {
		double randomValue = Math.random();
		num = (int)(randomValue * 100) +1;
		System.out.println(num);
	}
	
	public void inputNum() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("���ڸ� �Է����ּ��� : ");
			input = sc.nextInt();
			
			if(input>=1 && input<=100) break;
			else System.out.println("1~100 ���ڸ� �Է����ּ���.");
		}
	}
	
	public void Chance() {
		chance--;
		count++;
		System.out.println("���� ��ȸ : " + chance);
		CalNum();
		
		if(chance<=0) System.out.println("��� ��ȸ�� �����Ǿ����ϴ�.");
	}
	public boolean getBool() {
		return bool;
	}
	
	public void CalNum() {
		if(num>input) {
			System.out.println("Up");
			bool = false;
		}
		else if(num<input) {
			System.out.println("Down");
			bool = false;
		}
		else {
			System.out.println("�����Դϴ�!" + count + "ȸ ���� ���߼̽��ϴ�.");
			bool = true;
		}
	}
	
}

class Calculator {
	int num1;
	int num2;
	char ch;
	double result;
	
	public Calculator(int num1, int num2, char ch) {
		this.num1 = num1;
		this.num2 = num2;
		this.ch = ch;
		result = 0;
	}
	
	public double Calculate() {
		switch(ch) {
		case '+' :
			result = num1+num2;
			break;
		case '-' :
			result = num1-num2;
			break;
		case '*' :
			result = num1*num2;
			break;
		case '/' :
			result = (double)num1/(double)num2;
			break;
		default : 
			System.out.println("������ ����");
			break;
		}
		
		return result;
	}
}

class Player {
	static int instance;
	
	public Player() {
		instance++;
	}
}


public class InterView006 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Gugudan gugudan = new Gugudan();
		int num = 0;
//		char ch = 0;
		
//		while(true) {
//			System.out.print("����� ��� �Ͻðڽ��ϱ�? : ");
//			num = sc.nextInt();
//			
//			gugudan.setGugudan(num);
//			
//			System.out.print("�Ųٷ� ��� �Ͻðڽ��ϱ�?(y/n) : ");
//			ch = sc.next().charAt(0);
//		
//			if(ch=='n') gugudan.showGugudan();
//			else gugudan.showReverse();
//			
//			System.out.print("��� �Ͻðڽ��ϱ�?(y/n) : ");
//			ch = sc.next().charAt(0);
//			
//			if(ch=='n') break;
//		}
		
//		UpDown myUpDown = new UpDown();
//		
//		myUpDown.setNum();
//		while(myUpDown.chance>=0) {
//			myUpDown.inputNum();
//			myUpDown.Chance();
//			if(myUpDown.getBool() || myUpDown.chance<=0) break;
//		}
//		System.out.println("���� ����");
		
		
//		while (true) {
//			System.out.println("ù ��° ���ڸ� �Է��ϼ���.");
//			int num1 = sc.nextInt();
//			System.out.println("���� ��ȣ�� �Է��ϼ���.");
//			char ch = sc.next().charAt(0);
//			System.out.println("�� ��° ���ڸ� �Է��ϼ���.");
//			int num2 = sc.nextInt();
//			Calculator myCal = new Calculator(num1, num2, ch);
//
//			System.out.println(myCal.Calculate());
//			
//			System.out.println("�����Ͻðڽ��ϱ�? ����:y ���:n");
//			ch = sc.next().charAt(0);
//			if(ch=='y') {
//				System.out.println("���α׷� ����");
//				break;
//			}
//		}
		
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();
		
		System.out.println(Player.instance);
	}

}
