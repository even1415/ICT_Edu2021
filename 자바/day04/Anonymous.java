package day04;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

//AnonymousŬ���� (�̸����� �̳� Ŭ����)
//��ü�� �����ϴ� �ڵ� �ڿ� { }�� �ٿ��� �����Ѵ�.
//ActionListener a=new ActionListener(){...�߻�޼ҵ� ������};
//{}�� ActionListener�������̽��� ��ӹ޴� �ڽ� Ŭ������ �ȴ�.
//��ü ������ 1���� ������=> 1ȸ��
public class Anonymous extends JFrame {
	JPanel p;
	JButton[]b;
	String str[]= {"Naver","Google","Daum","Yahoo"};
	public Anonymous() {
		super("::Anonymous::");
		Container cp = this.getContentPane();
		//{}=>JPanel�� ��ӹ޴� �̸����� Ŭ����
		p = new JPanel() {
			@Override
			public Insets getInsets() {
				return new Insets(20,20,20,20);
			}
		};
		p.setBackground(Color.white);
		cp.add(p, BorderLayout.CENTER);
		
		//2��2�� ���·� ��ư 4�� p�� �����ϼ���. hgap 10, vgap 10
		//��ư�� �ö� ���ڿ��� Naver, Google, Daum, Yahoo
		p.setLayout(new GridLayout(2,2,10,10));
		b=new JButton[4];
		for(int i=0;i<b.length;i++) {
			b[i]=new JButton(str[i]);
			p.add(b[i]);
		}

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������----------------

	public static void main(String[] args) {
		Anonymous my = new Anonymous();
		my.setSize(500, 500);
		my.setVisible(true);
	}//main()---------------
}//class/////////////////////////////////////

