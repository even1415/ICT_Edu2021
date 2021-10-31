package com.ict.jdbc_hr;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class ICTMainFrame extends JFrame {
	JPanel p;
	JTabbedPane tp;
	
	DeptPanel deptP=new DeptPanel();
	public ICTMainFrame() {
		super("::ICTMainFrame::");
		Container cp = this.getContentPane();
		p = new JPanel();
		p.setBackground(Color.white);
		cp.add(p, BorderLayout.CENTER);
		p.setLayout(new BorderLayout());
		
		tp=new JTabbedPane();
		p.add(tp);
		
		tp.add(deptP,"부서 관리");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자----------------

	public static void main(String[] args) {
		ICTMainFrame my = new ICTMainFrame();
		my.setSize(770, 670);
		my.setVisible(true);
	}//main()

}//class
