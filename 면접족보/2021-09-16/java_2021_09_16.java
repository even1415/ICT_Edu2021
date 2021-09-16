package java_2021_09_16;

import java.util.Scanner;

class AlpabetString {
	private int num1 = 0;
	private int num2 = 0;
	private int num3 = 0;
	private String string;
	public char ch;
	
	public void reset() {
		this.num1 = 0;
		this.num2 = 0;
		this.num3 = 0;
	}

	private void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("단어를 입력하세요.");
		string = scanner.nextLine(); // 한줄 전체를 입력받음(단어 단위는 next() 사용)
	}

	private void alpabetCount() {
		for (int i = 0; i < string.length(); i++) {
			char ch = string.charAt(i);

			switch (ch) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
				num1++;
				break;
			case ' ':
				num3++; // 공백 처리
				break;
			default:
				num2++;
				break;
			}
		}
	}

	private void getCount() {
		System.out.println("모음 : " + num1 + "개, 자음 : " + num2 + "개");
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			input();
			alpabetCount();
			getCount();

			System.out.println("종료하시겠습니까? 종료:y");
			ch = scanner.next().charAt(0);
			if(ch=='y') break;
			else reset();
		}
	}
}

class ReverseString {
	private String string;
	//private String revString = "";

	private void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력 : ");
		string = scanner.nextLine();

		scanner.close();
	}

	private void printReverse() {
		System.out.print("출력 : ");
		for (int i = 0; i < string.length(); i++) {
			System.out.print(string.charAt(string.length() - i - 1)); //즉시 출력
			//revString += string.charAt(string.length() - i - 1); //변수에 저장 후 출력(1)
		}
//		for(int i=string.length(); i>=0; i--) {
//			System.out.print(string.charAt(i));
//		}
		//System.out.print(revString); //변수에 저장 후 출력(2)
	}

	public void run() {
		input();
		printReverse();
	}
}

class FindPrimeNumber {
	int k;
	boolean bool;

	public FindPrimeNumber() {
		this.k = 0;
		this.bool = false;
	}

	private void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력 : ");
		k = scanner.nextInt();

		scanner.close();
	}
	
	private void FindPrime() {
		for(int i=2; i<=k; i++) {
			for(int j=2; j<=i-1; j++) {
				if(i%j==0) {
					bool = true;
					break;
				}
			}
			if(bool==false) System.out.print(i + " ");
			bool = false;
		}
	}
	
	public void run() {
		input();
		FindPrime();
	}
}

public class java_2021_09_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String string = "The Best String";
//
//		System.out.print(string.length());

//		String str1 = "Coffee";
//		String str2 = "Bread";
//		
//		String str3 = str1.concat(str2);
//		
//		System.out.println(str1);
//		System.out.println(str3);
//		
//		String str4 = "fresh".concat(str3);
//		System.out.println(str4);

//		String str1 = "Coffee";
//		String str2 = "Bread";
//		
//		String str3 = str1+str2;
//		String str4 = str1.concat(str2);
//		
//		if(str3==str4) System.out.println("얗얗");
//		
//		str1.substring(3);

//		String st1 = "Lexicographically";
//		String st2 = "lexicographically";
//		int cmp;
//		
//		if(st1.equals(st2))
//			System.out.println("두 문자열은 같습니다.");
//		else 
//			System.out.println("두 문자열은 다릅니다.");
//		
//		cmp = st1.compareTo(st2);
//		if(cmp==0)
//			System.out.println("두 문자열은 일치합니다.");
//		else if(cmp<0)
//			System.out.println("사전의 앞에 위치하는 문자 : " + st1);
//		else 
//			System.out.println("사전의 앞에 위치하는 문자 : " + st2);
//		
//		if(st1.compareToIgnoreCase(st2)==0)
//			System.out.println("두 문자열은 같습니다");
//		else 
//			System.out.println("두 문자열은 다릅니다");

//		AlpabetString alpabetString = new AlpabetString();
//		
//		alpabetString.run();

//		ReverseString reverseString = new ReverseString();
//
//		reverseString.run();
		
//		FindPrimeNumber findPrimeNumber = new FindPrimeNumber();
//		
//		findPrimeNumber.run();
		
	}

}
