import java.util.Scanner;

class DrawStarClass {
	int num[];
	int num2[];
	int input;
	int selectNum[];
	int biggest;
	char ch;
	boolean bool;
	
	public DrawStarClass() {
		this.num = new int[3];
		this.num2 = new int[3];
		this.selectNum = new int[3];
		this.input = 0;
		this.biggest = 0;
		this.ch = 0;
		bool = false;
	}
	
	private void setter() {
		for(int i=0; i<3; i++) {
			num2[i] = num[i];
		}
	}
	
	private void inputNum() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ ���� �Է����ּ���.");
		
		for(int i=0; i<3; i++) {
			num[i] = scanner.nextInt();
		}
	}
	
	private void QuestionNum() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("������ ���ڰ� ū ������� �ϰڽ��ϱ�?(Y/N)");
			ch = scanner.next().charAt(0);
			
			if(ch=='Y') {
				printBigStar();
				return;
			}
			else if(ch=='N') {
				bool = true;
			}
			else System.out.println("Y/N���θ� �Է����ּ���.");
			
			if(bool==true) {
				bool = false;
				break;
			}
		}
		
		while(true) {
			System.out.println("������ ���ڰ� ���� ������� �ϰڽ��ϱ�?(Y/N)");
			ch = scanner.next().charAt(0);
			
			if(ch=='Y') {
				printSmallStar();
				return;
			}
			else if(ch=='N') {
				printFastStar();
				return;
			}
			else System.out.println("Y/N���θ� �Է����ּ���.");
			
			if(bool==true) {
				bool = false;
				break;
			}
		}
	}
	
	private void findBestNum() {	
		for(int i=0; i<3; i++) {
			for (int j = 0; j < 3; j++) {
				if (biggest < num[j]) {
					biggest = num[j];
					num[j] = 0;
				}
			}
			selectNum[i] = biggest;
			if(i<2) biggest = num[i+1];
		}
	}
	
	private void printBigStar() {
		System.out.println("ū ������� �Դϴ�.");
		for(int i=0; i<selectNum.length; i++) {
			for(int j=0; j<selectNum[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	private void printSmallStar() {
		System.out.println("���� ������� �Դϴ�.");
		for(int i=selectNum.length-1; i>=0; i--) {
			for(int j=0; j<selectNum[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	private void printFastStar() {
		System.out.println("�Է¹��� ������� �Դϴ�.");
		for(int i=0; i<3; i++) {
			for(int j=0; j<num2[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void run() {
		inputNum();
		setter();
		findBestNum();
		QuestionNum();
	}
}



public class PrintInputStar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrawStarClass drawStarClass = new DrawStarClass();
		
		drawStarClass.run();
	}

}
