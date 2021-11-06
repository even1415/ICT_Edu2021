package day07;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
//BorderLayout, FlowLayout, GridLayout
//CardLayout
public class MyCardGui extends JFrame {
	JPanel p;
	CardLayout card;
	
	//ī�巹�̾ƿ� ������ JPanel
	JPanel p1;
	
	JButton b1,b2,b3;
	
	JLabel lb;
	JTextArea ta;
	JList lst;

	public MyCardGui() {
		super("::MyCardGui::");
		Container cp = this.getContentPane();
		p = new JPanel();
		p.setBackground(Color.white);
		cp.add(p, BorderLayout.CENTER);
		
		p.setLayout(new BorderLayout());
		JPanel pN=new JPanel();
		p.add(pN,BorderLayout.NORTH);
		
		p1=new JPanel();
		p.add(p1,BorderLayout.CENTER);
		
		pN.setBackground(Color.DARK_GRAY);
		p1.setBackground(Color.yellow);
		pN.setLayout(new GridLayout(1,0));
		//���� 1������ ����. ���� ���������� ����
		b1=new JButton("Main");
		b2=new JButton("Join");
		b3=new JButton("Users");
		pN.add(b1);
		pN.add(b2);
		pN.add(b3);
		
		card=new CardLayout();
		p1.setLayout(card);//p1�� ���̾ƿ��� ī�巹�̾ƿ����� ����
		
		//ù��° ī��(������Ʈ,�����̳�)
		lb=new JLabel(new ImageIcon("images/b.png"));
		//�ι�° ī��
		ta=new JTextArea("::ȸ������ ������::");
		//����° ī��
		lst=new JList();
		
		p1.add(lb, "mainP"); //ī�带 ������ ���ڿ�(alias)
		p1.add(new JScrollPane(ta),"joinP");
		p1.add(new JScrollPane(lst),"userP");
		
		//card.show(p1, "userP");
		//card.show(ī�巹�̾ƿ��� ����� �����̳�, ������ī���� ��Ī���ڿ�)
		//b1, b2,b3 ������ ����
		MyHandler handler=new MyHandler();
		b1.addActionListener(handler);
		b2.addActionListener(handler);
		b3.addActionListener(handler);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������----------------
	class MyHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj=e.getSource();
			if(obj==b1) {
				card.show(p1, "mainP");
			}else if(obj==b2) {
				card.show(p1, "joinP");
			}else if(obj==b3) {
				card.show(p1, "userP");				
			}
		}
	}//////////////////
	public static void main(String[] args) {
		MyCardGui my = new MyCardGui();
		my.setSize(480, 700);
		my.setVisible(true);
	}//main()

}//class
