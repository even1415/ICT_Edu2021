package day04_ExerciseGUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class FindSearchEngine extends JFrame implements ActionListener {

	JPanel p;
	JButton[] b;
	String str[] = {"Naver", "Daum", "Google", "Yahoo"};
	int[] click; //�� ��ư�� Ŭ��Ƚ���� ����
	Color origin; //��ư ���� ���� ����

	public FindSearchEngine() {
		// TODO Auto-generated constructor stub
		super("::FindSearchEngine::");
		Container cp = this.getContentPane();
		p = new JPanel() {
			@Override
			public Insets getInsets() {
				return new Insets(20, 20, 20, 20);
			}
		}; //Anonymous Class(�̸����� Ŭ����)
		p.setBackground(Color.white);
		p.setLayout(new GridLayout(2,2,10,10));
		cp.add(p, BorderLayout.CENTER);
		
		click = new int[4]; //�迭 �ʱ�ȭ
		
		
		b = new JButton[4]; //��ư �Ҵ� �� ����, ��ġ
		for(int i=0; i<4; i++) {
			b[i] = new JButton(str[i]);
			p.add(b[i]);
			b[i].addActionListener(this);
		}
		origin = b[0].getBackground(); //���� ���� ����
		
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
		//String cmd = e.getActionCommand(); //�̺�Ʈ�ҽ��� �������ִ� label ���ڿ��� ��ȯ
		//setTitle(cmd + "��ư�� �������ϴ�.");
		if(obj == b[0]) { //1��° ��ư�� ���� ���
			click[0]++;
			if(click[0]%2!=0) b[0].setBackground(Color.green); //�ѹ� ������ ���� ����
			else b[0].setBackground(origin); //�ι� ������ ���� �������� ����
			
			super.setTitle("::Clicked Naver::");
		}
		else if(obj == b[1]) { //2��° ��ư�� ���� ���
			click[1]++;
			if(click[1]%2!=0) b[1].setBackground(Color.orange);
			else b[1].setBackground(origin);
			
			super.setTitle("::Clicked Daum::");
		}
		else if(obj == b[2]) { //3��° ��ư�� ���� ���
			click[2]++;
			if(click[2]%2!=0) b[2].setBackground(Color.magenta);
			else b[2].setBackground(origin);
			
			super.setTitle("::Clicked Google::");
		}
		else if(obj == b[3]) { //4��° ��ư�� ���� ���
			click[3]++;
			if(click[3]%2!=0) b[3].setBackground(Color.cyan);
			else b[3].setBackground(origin);
			
			super.setTitle("::Clicked Yahoo::");
		}
		else {}
		
		/*//����� �ؼ�
		 * Color cr = ((JButton)obj).getBackground();
		 * 
		 * if(cr==origin) { //�������� ���ٸ� ���� ����
		 *  //�� ��ư �� ���� �����ڵ� ���� ��
		 * }
		 * else { //�������� �ٸ��ٸ� ���������� ����
		 * 		((JButton)obj).setBackground(origin);
		 * }
		*/
	}

}