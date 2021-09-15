import java.util.Scanner;

public class FindManyAvgScore {
	int kor;
	int math;
	int eng;
	double avg;
	
	public FindManyAvgScore(int kor, int math, int eng) {
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}
	
	public void CalAvg() {
		avg = (kor+math+eng)/3.0;
	}
	
	public void inputScore() {
		System.out.println("국어 수학 영어를 차례대로 입력하세요!");
		Scanner sc = new Scanner(System.in);
		
		kor = sc.nextInt();
		math = sc.nextInt();
		eng = sc.nextInt();
	}
	
	public void printAvg() {
		System.out.println("평균은 " + avg);
	}
	
}
