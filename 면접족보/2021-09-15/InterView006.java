import java.util.Scanner;

class Gugudan {
	int num;

	public void setGugudan(int num) {
		this.num = num;
	}
	public void showGugudan() {
		for(int i=1; i<=num; i++) {
			System.out.print("<" + i + ">단" + '\t');
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
			System.out.print("<" + i + ">단" + '\t');
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
			System.out.print("숫자를 입력해주세요 : ");
			input = sc.nextInt();
			
			if(input>=1 && input<=100) break;
			else System.out.println("1~100 숫자만 입력해주세요.");
		}
	}
	
	public void Chance() {
		chance--;
		count++;
		System.out.println("남은 기회 : " + chance);
		CalNum();
		
		if(chance<=0) System.out.println("모든 기회가 소진되었습니다.");
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
			System.out.println("정답입니다!" + count + "회 만에 맞추셨습니다.");
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
			System.out.println("연산자 오류");
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
//			System.out.print("몇단을 출력 하시겠습니까? : ");
//			num = sc.nextInt();
//			
//			gugudan.setGugudan(num);
//			
//			System.out.print("거꾸로 출력 하시겠습니까?(y/n) : ");
//			ch = sc.next().charAt(0);
//		
//			if(ch=='n') gugudan.showGugudan();
//			else gugudan.showReverse();
//			
//			System.out.print("계속 하시겠습니까?(y/n) : ");
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
//		System.out.println("게임 종료");
		
		
//		while (true) {
//			System.out.println("첫 번째 숫자를 입력하세요.");
//			int num1 = sc.nextInt();
//			System.out.println("연산 기호를 입력하세요.");
//			char ch = sc.next().charAt(0);
//			System.out.println("두 번째 숫자를 입력하세요.");
//			int num2 = sc.nextInt();
//			Calculator myCal = new Calculator(num1, num2, ch);
//
//			System.out.println(myCal.Calculate());
//			
//			System.out.println("종료하시겠습니까? 종료:y 계속:n");
//			ch = sc.next().charAt(0);
//			if(ch=='y') {
//				System.out.println("프로그램 종료");
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
