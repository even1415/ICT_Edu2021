package day15;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class MyDemo extends JFrame {
	JPanel p;

	Snail sp;
	JButton btStart, btStop;
	
	public MyDemo() {
		super("::MyDemo::");
		Container cp = this.getContentPane();
		p = new JPanel();
		p.setBackground(Color.white);
		cp.add(p, BorderLayout.NORTH);
		
		sp = new Snail();
		cp.add(sp, BorderLayout.CENTER);
		
		btStart = new JButton("START");
		btStop = new JButton("STOP");
		
		p.add(btStart);
		p.add(btStop);
		MyHandler handler = new MyHandler();
		btStart.addActionListener(handler);
		btStop.addActionListener(handler);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������----------------
	
	class MyHandler implements ActionListener {
		Thread tr;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			if(obj==btStart) { //������ ����
				sp.isStop = false;
				tr = new Thread(sp);
				tr.start();
			}
			else if(obj==btStop) { //������ ����
				sp.isStop=true;
				tr.interrupt();
			}
		}
	}

	public static void main(String[] args) {
		MyDemo my = new MyDemo();
		my.setSize(500, 500);
		my.setVisible(true);
	}//main()

}//class