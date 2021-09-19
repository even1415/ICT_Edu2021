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
				System.out.print((i + 1) + "��° ���� �Է� : ");
				myNum[i] = scanner.nextInt();

				for (int j = 0; j < i; j++) {
					if (myNum[i] == myNum[j]) {
						System.out.println("�ߺ����� �Է�, �ٽ� �Է����ּ���");
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
		System.out.print("�ζǹ�ȣ : ");
		for (int i = 0; i < 6; i++) {
			System.out.print(lottoNum[i] + " ");
		}
	}
	
	private void printWinLotto() {
		System.out.print("�ζǹ�ȣ : ");
		for (int i = 0; i < 6; i++) {
			System.out.print(lottoNum[i] + " ");
		}
		System.out.println();
		System.out.print("�Է¹�ȣ : ");
		for (int i = 0; i < 6; i++) {
			System.out.print(myNum[i] + " ");
		}
		System.out.println();
		
		System.out.println("��ġ��ȣ ���� : " + count);
		
		if(score<4) System.out.println(score + "�� ��÷�Դϴ�, �����մϴ�!");
		else System.out.println("3�� �ȿ� ��÷���� �ʾҽ��ϴ�.");
	}

	public void baseRun() { //���� �⺻����(�ζǹ�ȣ ���)
		setLotto();
		printLotto();
	}
	
	public void plusRun() { //���� Ȯ�幮��(����ڰ� ��ȣ�Է�, �ζǹ�ȣ ��� �� ��÷���� Ȯ��)
		input();
		setLotto();
		getLotto();
		printWinLotto();
	}
}
