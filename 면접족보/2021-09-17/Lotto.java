import java.util.Scanner;

import javax.security.sasl.SaslException;

import com.sun.source.tree.WhileLoopTree;

public class Lotto {
	int lottoNum[];
	int myNum[];
	boolean bool;
	int count;
	int score;
	
	public Lotto() {
		lottoNum = new int[6];
		myNum = new int[6];
		bool = false;
		count = 0;
		score = 0;
	}

	private void input() {
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < 6; i++) {
			while (true) {
				System.out.print((i + 1) + "번째 숫자 입력 : ");
				myNum[i] = scanner.nextInt();

				for (int j = 0; j < i; j++) {
					if (myNum[i] == myNum[j]) {
						System.out.println("중복숫자 입력, 다시 입력해주세요");
						bool = true;
					}
				}
				if (bool == false)
					break;
				else bool = false;
			}
		}
	}

	private void setLotto() {
		for (int i = 0; i < 6; i++) {
			while (true) {
				lottoNum[i] = (int) (Math.random() * 45 + 1);
				for (int j = 0; j < i; j++) {
					if (lottoNum[i] == lottoNum[j]) {
						bool = true;
						break;
					}
				}
				if (bool == false)
					break;
				else bool = false;
			}
		}
	}
	
	private void getLotto() {
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				if(myNum[i]==lottoNum[j]) {
					count++;
					break;
				}
			}
		}
		
		switch(count) {
		case 6 :
			score = 1;
			break;
		case 5 :
			score = 2;
			break;
		case 4 :
			score = 3;
			break;
		default :
			score = 4;
			break;
		}
	}

	private void printLotto() {
		System.out.print("로또번호 : ");
		for (int i = 0; i < 6; i++) {
			System.out.print(lottoNum[i] + " ");
		}
	}
	
	private void printWinLotto() {
		System.out.print("로또번호 : ");
		for (int i = 0; i < 6; i++) {
			System.out.print(lottoNum[i] + " ");
		}
		System.out.println();
		System.out.print("입력번호 : ");
		for (int i = 0; i < 6; i++) {
			System.out.print(myNum[i] + " ");
		}
		System.out.println();
		
		System.out.println("일치번호 갯수 : " + count);
		
		if(score<4) System.out.println(score + "등 당첨입니다, 축하합니다!");
		else System.out.println("3등 안에 당첨되지 않았습니다.");
	}

	public void baseRun() { //족보 기본문제(로또번호 출력)
		setLotto();
		printLotto();
	}
	
	public void plusRun() { //족보 확장문제(사용자가 번호입력, 로또번호 출력 및 당첨여부 확인)
		input();
		setLotto();
		getLotto();
		printWinLotto();
	}
}
