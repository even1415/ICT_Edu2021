package com.ict.pwmanager;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

/*
로그인 페이지 - Login
회원가입 페이지 - Signup
목록 페이지 - SiteList
조회 페이지 - SiteView
추가/수정 페이지 - SiteAddEdit
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
		
		
		p.add(lginP, "login"); //로그인페이지 부착
		p.add(siupP, "signup"); //회원가입페이지 부착
		
		//p.add(ListP, "List"); //목록 페이지
		//p.add(AddEditP, "AddEdit"); //추가 페이지
		
		//p.add(listP, "ListP");
		//p.add(viewP, "ViewP"); //조회 페이지
		//p.add(editP, "EditP"); //수정 페이지
		
		
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
