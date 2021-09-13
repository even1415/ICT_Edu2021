
public class OddEvenNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = -4;
		
		if(number>=0 && number<=100) { //0~100 범위부터 먼저 검사
			System.out.println(number + " (은)는 0~100 사이의 정수입니다.");
			
			if(number%2==0 && number!=0) //if(number==0) 으로 먼저 0을 걸러내도 됩니다
				System.out.println(number + " (은)는 [짝수] 입니다.");
			else if(number==0) //if(number%2==0) 으로 0 골라낸 후에 짝수를 걸러도 됩니다
				System.out.println("0은 짝수도 홀수도 아닙니다.");
			else //0과 짝수를 모두 고른, 즉 홀수만 남은 상태
				System.out.println(number + " (은)는 [홀수] 입니다.");
		}
		else { //0~100 범위를 벗어나는 경우
			System.out.println("입력된 숫자 : " + number);
			System.out.println("0~100 사이의 숫자만 입력해주세요.");
		}
		
	}
}
