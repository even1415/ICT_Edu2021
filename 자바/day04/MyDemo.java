package day04;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;//[1]
/* 1. EventSource : �̺�Ʈ�� �߻��� �ٿ���. �ַ� ������Ʈ�� �����̳ʰ� �̺�Ʈ�ҽ��� �ȴ�.(JButton)
 * 2  Event : JVM�� �߻���Ų��. �̺�Ʈ �ҽ����� �߻��Ǵ� �̺�Ʈ�� �ٸ���.
 * 		ex)JButton => ActionEvent
 *         JCheckBox=> ItemEvent 
 * 3. EventHandler : �̺�Ʈ�� ó�����ִ� ��ü==>�̰� �����ڰ� �����ؾ� ��
 * 		XXXListener �������̽��� ��ӹ޾� �����Ѵ�.
 *  JButton => ActionEvent ==>  ActionListener
 *  JCheckBox=> ItemEvent  ==> ItemListener
 *  [1] �̺�Ʈ �ڵ鷯�� �̺�Ʈ�ҽ��� ���� Ŭ�������� �����ϴ� ���
 *  [2] �̺�Ʈ �ڵ鷯�� �̳� Ŭ������ �����ϴ� ��� *  
 *  [3] �̺�Ʈ�ڵ鷯��  �ܺ�Ŭ������ �����ϴ� ��� 
 * */
/*
1> import java.awt.event.*; 
2> XXXListener �������̽��� ��� 
3> 2���� ������ �ִ� �߻� �޼ҵ� ������ 
4> �̺�Ʈ�ҽ��� �ڵ鷯�� �������� 
...addXXXListener()�޼ҵ��. 
5> 3������ �������� �޼ҵ忡 ��ü���� 
�̺�Ʈ ó�� �ڵ� ����
* */
public class MyDemo extends JFrame implements ActionListener{
	//2)XXXListener�� implments
	JPanel p;

	JButton b1,b2,b3;
	public MyDemo() {
		super("::MyDemo::");
		Container cp = this.getContentPane();
		p = new JPanel();
		p.setBackground(Color.white);
		cp.add(p, BorderLayout.CENTER);
		
		b1=new JButton("Red");
		b2=new JButton("Green");
		b3=new JButton("Blue");
		p.add(b1);
		p.add(b2);
		p.add(b3);
		//������ ���� => ������ �ȿ��� �ؾ� ��
		b1.addActionListener(this);//[4]
		//public void addActionListener(ActionListener l)
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������----------------
	
	@Override
	public void actionPerformed(ActionEvent e) {//[3]�߻�޼ҵ� ������
		Object obj=e.getSource();
		//�̺�Ʈ�� �߻��� �̺�Ʈ�ҽ� ��ü�� ��ȯ��
		if(obj==b1) {
		//�̺�Ʈ ó���ڵ� ����
			p.setBackground(Color.red);
		}else if(obj==b2) {
			p.setBackground(Color.green);
		}else if(obj==b3) {
			p.setBackground(Color.blue);
		}
	}//------------------------------

	public static void main(String[] args) {
		MyDemo my = new MyDemo();
		my.setSize(500, 500);
		my.setVisible(true);
	}//main()

}//class
