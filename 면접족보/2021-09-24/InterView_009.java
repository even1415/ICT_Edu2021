import java.util.Scanner;

class SubjectScore {
	final String course[] = {"Java", "C++", "HTML5", "��ǻ�ͱ���", "�ȵ���̵�"};
	final int score[]  = {95, 88, 76, 62, 55};
	String subject;
	boolean bool;
	
	public SubjectScore() {
		this.subject = "";
		bool = true;
	}

	private void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�����̸� >> ");
		subject = scanner.next();
		
		if(subject.equals("�׸�")) bool = false;
		else bool = true;
	}
	
	private void getScore() {
		int i=0;
		
		for(i=0; i<course.length; i++) {
			if(course[i].equals(subject)) {
				System.out.println(subject + "�� ������ " + score[i]);
				break;
			}
		}
		if(i==course.length) System.out.println("���� �����Դϴ�.");
	}
	
	public void run() {
		while(bool) {
			input();
			if(bool) getScore();
		}
	}
}


public class InterView_009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//5�� ����
//		SubjectScore subjectScore = new SubjectScore();
//		subjectScore.run();
	}

}
