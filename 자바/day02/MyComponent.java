package day02;
import javax.swing.*;
import java.awt.*;

public class MyComponent extends JFrame{

	JButton b1;
	JTextField tf1, tf2;
	JPasswordField tfPwd;
	JLabel lb1, lb2, lb3;
	JCheckBox ck1,ck2,ck3;
	JRadioButton rb1, rb2;
	JTextArea ta1, ta2;
	
	public MyComponent() {
		super("::MyComponent::");
		Container cp=this.getContentPane();
		cp.setLayout(new FlowLayout());
		b1=new JButton("Home");
		cp.add(b1);
		b1.setBackground(Color.red);//����
		b1.setForeground(Color.white);//���ڻ�
		//tf1, tf2�����ؼ� ���̱�
		tf1=new JTextField(20);
		tf2=new JTextField("Hello",30);
		cp.add(tf1);
		cp.add(tf2);
		
		tfPwd=new JPasswordField(20);
		cp.add(tfPwd);
		
		//ck1,ck2,ck3 : ����, ���ǰ���, ��ȭ����
		//���� üũ�� ����
		ck1=new JCheckBox("����");
		ck2=new JCheckBox("���ǰ���", true);
		ck3=new JCheckBox("��ȭ����", false);
		cp.add(ck1);
		cp.add(ck2);
		cp.add(ck3);
		
		//JRadioButton: ���� ������ �� ���.
		//ButtonGroup�� �Բ� ���
		//rb1, rb2 : ����, ����
		rb1=new JRadioButton("����");
		rb2=new JRadioButton("����", true);
		cp.add(rb1);
		cp.add(rb2);
		
		ButtonGroup group=new ButtonGroup();
		group.add(rb1);
		group.add(rb2);
		//���� �׷� ���� �Ѱ��� ���ð���
		
		lb1=new JLabel("��  ��: ");
		lb2=new JLabel("���̵�: ");
		lb3=new JLabel("��й�ȣ: ");
		cp.add(lb1);
		cp.add(lb2);
		cp.add(lb3);
		
		lb1.setOpaque(true);
		lb2.setOpaque(true);
		lb3.setOpaque(true);
		
		lb1.setBackground(Color.yellow);
		lb2.setBackground(Color.LIGHT_GRAY);
		lb3.setBackground(Color.cyan);
		
		//JTextArea: ��Ƽ������ �Է� �� �� �ִ�.
		//�ٸ�, ��ũ�ѹٰ� �ڵ����� ���� �ʱ� ������ JScrollPane�� �ٿ��� ����ؾ� ��
		ta1=new JTextArea("Hello",5,20);
		//cp.add(ta1);[x]
		cp.add(new JScrollPane(ta1));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MyComponent my=new MyComponent();
		my.setSize(500,500);
		my.setVisible(true);

	}

}
