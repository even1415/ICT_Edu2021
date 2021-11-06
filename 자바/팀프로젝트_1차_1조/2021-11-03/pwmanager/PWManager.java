package com.ict.pwmanager;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.ArrayList;

/*
로그인 페이지 - Login
회원가입 페이지 - Signup
목록 페이지 - SiteList
조회 페이지 - SiteView
추가/수정 페이지 - SiteAddEdit
*/

public class PWManager extends JFrame {

	JPanel p;
	SiteListPanel List = new SiteListPanel();

	public PWManager() {
		// TODO Auto-generated constructor stub
		super("::PWManager::");
		Container cp = this.getContentPane();
		p = new JPanel();
		p.setBackground(Color.white);
		cp.add(p, BorderLayout.CENTER);
		p.setLayout(new BorderLayout());
		
		p.add(List);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PWManager my = new PWManager();
		my.setSize(432, 768);
		my.setVisible(true);

	}

}
