import java.util.Scanner;

class MaxNum {
	int arr[];
	int temp;
	char ch;
	int select;
	boolean bool;
	
	public MaxNum() {
		this.arr = new int[5];
		this.temp = 0;
		this.ch = 0;
		this.select = 0;
		bool = false;
	}
	
	private void Input() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("� ��ȣ ��������� ����Ͻðڽ��ϱ�?");
			System.out.println("1. ���� �Է�(Scanner)");
			System.out.println("2. ���� ����(Math.Random)");
			select = scanner.nextInt();

			switch (select) {
			case 1:
				ScannerInput(); //���� �Է�
				bool = true;
				break;
			case 2:
				RandomInput(); //���� ����
				bool = true;
				break;
			default:
				System.out.println("1~2 ��ȣ�θ� �Է����ּ���.");
				break;
			}
			if(bool) break;
		}
		bool = false; //�ʱ�ȭ
	}
	
	private void ScannerInput() {
		System.out.println("������ 5�� �Է����ּ���");
		Scanner scanner = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			arr[i] = scanner.nextInt();
		}
	}
	
	private void RandomInput() {
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int) (Math.random() * 100 + 1);
		}
	}
	
	private void Bubble_Sort() {
		for(int i=0; i<arr.length; i++) {
			System.out.println(i+1 + "��° �н�"); //���� ���
			for(int j=0; j<arr.length-1; j++) {
				if(arr[j] < arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					System.out.println(arr[j] + "��(��) " + 
										arr[j+1] + "��(��) ��ȯ"); //���� ���
				}
			}
		}
	}
	
	private void Selection_Sort() {
		for(int i=0; i<arr.length; i++) {
			System.out.println(i+1 + "��° �н�"); //���� ���
			temp = arr[i];
			System.out.println("temp" + "��(��) " + arr[i] + "�� �ʱ�ȭ"); //���� ���
			for(int j=i; j<arr.length; j++) {
				if(arr[j]>temp) {
					temp = arr[j];
					System.out.println("temp" + "�� " + arr[j] + "�� ����"); //���� ���
				}
			}
			
			for(int j=i; j<arr.length; j++) {
				if(temp==arr[j]) {
					arr[j] = arr[i];
					arr[i] = temp;
					System.out.println("����� " + temp + "������ " + 
							arr[j] + "��(��) " + arr[i] + "��(��) ��ȯ"); //���� ���
				}
			}
		}
	}
	
	private void Insertion_Sort() {
		for(int i=1; i<arr.length; i++) {
			System.out.println(i + "��° �н�"); //���� ���
			for(int j=i; j>0; j--) {
				if(arr[j-1]<arr[j]) {
                	temp = arr[j-1];
                	arr[j-1] = arr[j];
                	arr[j] = temp;
                    System.out.println(arr[j-1] + "��(��) " + 
                    				arr[j] + "��(��) ��ȯ"); //���� ���
                }
			}
		}
	}
	
	private void Output() {
		System.out.println("�ִ񰪺��� �����մϴ�");
		System.out.print("���� ��� : ");
		for(int i=0; i<5; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	private void Select_Algo() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("� �˰����� ����Ͻðڽ��ϱ�?");
			System.out.println("1. ��������(Bubble_Sort)");
			System.out.println("2. ��������(Selection_Sort)");
			System.out.println("3. ��������(Insertion_Sort)");
			select = scanner.nextInt();

			switch (select) {
			case 1:
				Bubble_Sort(); //�������� �˰���
				bool = true;
				break;
			case 2:
				Selection_Sort(); //�������� �˰���
				bool = true;
				break;
			case 3:
				Insertion_Sort(); //�������� �˰���
				bool = true;
				break;
			default:
				System.out.println("1~3 ��ȣ�θ� �Է����ּ���.");
				break;
			}
			if(bool) break;
		}
		bool = false; //�ʱ�ȭ
	}
	
	public void show() { //run()
		Scanner scanner = new Scanner(System.in);
		while(true) {
			Input(); //�Է¹�� ����
			Select_Algo(); //���� �޼ҵ�(�˰���) ����
			Output(); //���
			
			while(true) {
				System.out.println("�����Ͻðڽ��ϱ�? ����:y / ���:n");
				ch = scanner.next().charAt(0);
				if(ch=='y' || ch=='n') break;
				else System.out.println("y,n���θ� �Է����ּ���.");
			}
			if(ch=='y') break;
		}
		System.out.println("���α׷� ����");
	}
}


public class NumberSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxNum max = new MaxNum();
		max.show();
	}

}
