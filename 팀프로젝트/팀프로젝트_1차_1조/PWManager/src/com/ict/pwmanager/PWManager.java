package com.ict.pwmanager;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

/*
�α��� ������ - Login
ȸ������ ������ - Signup
��� ������ - SiteList
��ȸ ������ - SiteView
�߰�/���� ������ - SiteAddEdit
*/

public class PWManager extends JFrame {

	PWManager main;
	JPanel p;

	LoginPanel lginP = new LoginPanel(this);
	SignupPanel siupP = new SignupPanel(this);
	CardLayout card;

	public PWManager() {
		super("::PWManager::");
		Container cp = this.getContentPane();
		p = new JPanel();
		p.setBackground(Color.white);
		cp.add(p, BorderLayout.CENTER);
		p.setLayout(card = new CardLayout());
		
		
		p.add(lginP, "login"); //�α��������� ����
		p.add(siupP, "signup"); //ȸ������������ ����
		
		//p.add(ListP, "List"); //��� ������
		//p.add(AddEditP, "AddEdit"); //�߰� ������
		
		//p.add(listP, "ListP");
		//p.add(viewP, "ViewP"); //��ȸ ������
		//p.add(editP, "EditP"); //���� ������
		
		
		//main.card.show(main.p, "login");
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PWManager my = new PWManager();
		my.setSize(432, 768);
		my.setVisible(true);
		my.setLocationRelativeTo(null);
	}

}
