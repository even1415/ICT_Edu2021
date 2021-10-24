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
public class Anonymous extends JFrame implements ActionListener{
	JPanel p;
	JButton[]b;
	String str[]= {"Naver","Google","Daum","Yahoo"};
	Color origin;
	
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
			b[i].addActionListener(this);
			//b[i].setActionCommand(i+"��ư");
		}
		origin=b[0].getBackground();
		//System.out.println(origin);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������----------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		String cmd=e.getActionCommand();//�̺�Ʈ�ҽ��� ������ �ִ� label���ڿ����� ��ȯ
		
		//�̺�Ʈ�ҽ�(��ư)�� ������ ������
		Color cr=((JButton)obj).getBackground();
		if(cr==origin) {
			setTitle(cmd+"��ư�� ��������");
			if(obj==b[0]) {
				b[0].setBackground(Color.green);
			}else if(obj==b[1]) {
				b[1].setBackground(Color.orange);
			}else if(obj==b[2]) {
				b[2].setBackground(Color.magenta);
			}else if(obj==b[3]) {
				b[3].setBackground(Color.cyan);
			}
		}else {
			setTitle("::Anonymous::");
			//�������� �ٸ��ٸ� ���������� ����
			((JButton)obj).setBackground(origin);
		}
	}

	public static void main(String[] args) {
		Anonymous my = new Anonymous();
		my.setSize(500, 500);
		my.setVisible(true);
	}//main()---------------

	
}//class/////////////////////////////////////

