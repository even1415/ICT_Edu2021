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
		System.out.println("���� ���� ��� ���ʴ�� �Է��ϼ���!");
		Scanner sc = new Scanner(System.in);
		
		kor = sc.nextInt();
		math = sc.nextInt();
		eng = sc.nextInt();
	}
	
	public void printAvg() {
		System.out.println("����� " + avg);
	}
	
}
