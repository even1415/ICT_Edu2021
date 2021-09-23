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
			System.out.println("어떤 번호 생성방법을 사용하시겠습니까?");
			System.out.println("1. 직접 입력(Scanner)");
			System.out.println("2. 랜덤 산출(Math.Random)");
			select = scanner.nextInt();

			switch (select) {
			case 1:
				ScannerInput(); //직접 입력
				bool = true;
				break;
			case 2:
				RandomInput(); //랜덤 산출
				bool = true;
				break;
			default:
				System.out.println("1~2 번호로만 입력해주세요.");
				break;
			}
			if(bool) break;
		}
		bool = false; //초기화
	}
	
	private void ScannerInput() {
		System.out.println("정수를 5개 입력해주세요");
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
			System.out.println(i+1 + "번째 패스"); //과정 출력
			for(int j=0; j<arr.length-1; j++) {
				if(arr[j] < arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					System.out.println(arr[j] + "와(과) " + 
										arr[j+1] + "을(를) 교환"); //과정 출력
				}
			}
		}
	}
	
	private void Selection_Sort() {
		for(int i=0; i<arr.length; i++) {
			System.out.println(i+1 + "번째 패스"); //과정 출력
			temp = arr[i];
			System.out.println("temp" + "을(를) " + arr[i] + "로 초기화"); //과정 출력
			for(int j=i; j<arr.length; j++) {
				if(arr[j]>temp) {
					temp = arr[j];
					System.out.println("temp" + "에 " + arr[j] + "를 저장"); //과정 출력
				}
			}
			
			for(int j=i; j<arr.length; j++) {
				if(temp==arr[j]) {
					arr[j] = arr[i];
					arr[i] = temp;
					System.out.println("저장된 " + temp + "값으로 " + 
							arr[j] + "와(과) " + arr[i] + "을(를) 교환"); //과정 출력
				}
			}
		}
	}
	
	private void Insertion_Sort() {
		for(int i=1; i<arr.length; i++) {
			System.out.println(i + "번째 패스"); //과정 출력
			for(int j=i; j>0; j--) {
				if(arr[j-1]<arr[j]) {
                	temp = arr[j-1];
                	arr[j-1] = arr[j];
                	arr[j] = temp;
                    System.out.println(arr[j-1] + "와(과) " + 
                    				arr[j] + "을(를) 교환"); //과정 출력
                }
			}
		}
	}
	
	private void Output() {
		System.out.println("최댓값부터 정렬합니다");
		System.out.print("정렬 결과 : ");
		for(int i=0; i<5; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	private void Select_Algo() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("어떤 알고리즘을 사용하시겠습니까?");
			System.out.println("1. 버블정렬(Bubble_Sort)");
			System.out.println("2. 선택정렬(Selection_Sort)");
			System.out.println("3. 삽입정렬(Insertion_Sort)");
			select = scanner.nextInt();

			switch (select) {
			case 1:
				Bubble_Sort(); //버블정렬 알고리즘
				bool = true;
				break;
			case 2:
				Selection_Sort(); //선택정렬 알고리즘
				bool = true;
				break;
			case 3:
				Insertion_Sort(); //삽입정렬 알고리즘
				bool = true;
				break;
			default:
				System.out.println("1~3 번호로만 입력해주세요.");
				break;
			}
			if(bool) break;
		}
		bool = false; //초기화
	}
	
	public void show() { //run()
		Scanner scanner = new Scanner(System.in);
		while(true) {
			Input(); //입력방법 선택
			Select_Algo(); //정렬 메소드(알고리즘) 선택
			Output(); //출력
			
			while(true) {
				System.out.println("종료하시겠습니까? 종료:y / 계속:n");
				ch = scanner.next().charAt(0);
				if(ch=='y' || ch=='n') break;
				else System.out.println("y,n으로만 입력해주세요.");
			}
			if(ch=='y') break;
		}
		System.out.println("프로그램 종료");
	}
}


public class NumberSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxNum max = new MaxNum();
		max.show();
	}

}
