package day04_ExerciseGUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class FindSearchEngine extends JFrame implements ActionListener {

	JPanel p;
	JButton[] b;
	String str[] = {"Naver", "Daum", "Google", "Yahoo"};
	int[] click; //각 버튼의 클릭횟수를 저장
	Color origin; //버튼 원래 색상 저장

	public FindSearchEngine() {
		// TODO Auto-generated constructor stub
		super("::FindSearchEngine::");
		Container cp = this.getContentPane();
		p = new JPanel() {
			@Override
			public Insets getInsets() {
				return new Insets(20, 20, 20, 20);
			}
		}; //Anonymous Class(이름없는 클래스)
		p.setBackground(Color.white);
		p.setLayout(new GridLayout(2,2,10,10));
		cp.add(p, BorderLayout.CENTER);
		
		click = new int[4]; //배열 초기화
		
		
		b = new JButton[4]; //버튼 할당 및 셋팅, 배치
		for(int i=0; i<4; i++) {
			b[i] = new JButton(str[i]);
			p.add(b[i]);
			b[i].addActionListener(this);
		}
		origin = b[0].getBackground(); //원래 색상 저장
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindSearchEngine my = new FindSearchEngine();
		my.setSize(500, 500);
		my.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		//String cmd = e.getActionCommand(); //이벤트소스가 가지고있는 label 문자열값 반환
		//setTitle(cmd + "버튼을 눌렀습니다.");
		if(obj == b[0]) { //1번째 버튼을 누른 경우
			click[0]++;
			if(click[0]%2!=0) b[0].setBackground(Color.green); //한번 누르면 색상 변경
			else b[0].setBackground(origin); //두번 누르면 원래 색상으로 복구
			
			super.setTitle("::Clicked Naver::");
		}
		else if(obj == b[1]) { //2번째 버튼을 누른 경우
			click[1]++;
			if(click[1]%2!=0) b[1].setBackground(Color.orange);
			else b[1].setBackground(origin);
			
			super.setTitle("::Clicked Daum::");
		}
		else if(obj == b[2]) { //3번째 버튼을 누른 경우
			click[2]++;
			if(click[2]%2!=0) b[2].setBackground(Color.magenta);
			else b[2].setBackground(origin);
			
			super.setTitle("::Clicked Google::");
		}
		else if(obj == b[3]) { //4번째 버튼을 누른 경우
			click[3]++;
			if(click[3]%2!=0) b[3].setBackground(Color.cyan);
			else b[3].setBackground(origin);
			
			super.setTitle("::Clicked Yahoo::");
		}
		else {}
		
		/*//강사님 해설
		 * Color cr = ((JButton)obj).getBackground();
		 * 
		 * if(cr==origin) { //원래색과 같다면 색상 변경
		 *  //각 버튼 별 색상 변경코드 들어가면 됨
		 * }
		 * else { //원래색과 다르다면 원래색으로 설정
		 * 		((JButton)obj).setBackground(origin);
		 * }
		*/
	}

}