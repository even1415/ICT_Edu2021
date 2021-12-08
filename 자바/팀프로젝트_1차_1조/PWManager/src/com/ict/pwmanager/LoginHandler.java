package com.ict.pwmanager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class LoginHandler extends MouseAdapter implements ActionListener {
	
	private LoginPanel lginP; //View
	private LoginDAO lginDao; //Model
	private LoginVO loginVO;
	private SingletonData patternData;
	LoginVO vo;
	SiteListPanel ListP;
	SiteAddPanel AddEditP;
	PWManager main;
	
//	public void print() { //�ڡڡڿ��Ⱑ �̱��� ��ü ����,ȣ���ϴ� �κ��ε�
//	    patternData.setLoginData(vo);
//	    patternData.print(this.name + " print using " + printer.toString());
//	  }
	
	public LoginHandler(LoginPanel lginP, PWManager main) {
		 this.lginP = lginP;
		 this.lginDao = new LoginDAO();
		 
		 this.main = main;
		 
	}
	
	public void show(String msg) {
		JOptionPane.showMessageDialog(lginP, msg);
	}
	
	private void loginC() { //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= �̸� �ٲ�
		vo = new LoginVO();
		
		String uID = lginP.tfID.getText();
		char[] uPW = lginP.tfPW.getPassword();
		String suPW = new String(uPW); //to String from charArray
		
		if (uID == null||uPW == null||uID.trim().equals("")||suPW.trim().equals("")) {
			show("���̵�� ��й�ȣ�� �Է��ϼ���");
			lginP.tfID.requestFocus();
			return;
		} else {
			vo.setuID(uID);
			vo.setuPW(suPW);
			
			LoginVO n = lginDao.login(vo);
			String msg = new String();
			if(n != null) {
				msg = "�������";
				clearTF();
//				moveP("List"); //=-=-=-=-=-=-=-=-=-=-= ���ŵ�
				
				SingletonData singleData = SingletonData.getSingletonUserData();
				singleData.setLoginData(n);
				//System.out.println(lginDao.loginVO.getuKey());
				
//				SingletonData singleData2 = SingletonData.getSingletonUserData();
				//System.out.println(singleData2.getKey());
			} else {
				msg = "���̵�� ��й�ȣ�� Ȯ�����ּ���";
				lginP.tfID.requestFocus();
			}
			show(msg);
		}
	}
	
	private void loginM() { //=-=-=-=-=-=-=-=-=-=-=-=-= ���� �߰��� ���
		LoginVO n = lginDao.login(vo);
		SingletonData singleData = SingletonData.getSingletonUserData();
		singleData.setLoginData(n);
		
		if (n != null) {
			moveP("List");
		}
	}
	
	private void clearTF() {
		lginP.tfID.setText("");
		lginP.tfPW.setText("");
	}
	
	private void moveP(String str) {
		main.card.show(main.p, str);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == lginP.btLgin) {
			loginC(); //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= �̸� �ٲ�
			
			ListP = new SiteListPanel(main);
			AddEditP = new SiteAddPanel(main);
			
			main.p.add(ListP, "List"); //��� ������
			main.p.add(AddEditP, "AddEdit"); //�߰� ������
			
			loginM(); //=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-= �����
		} else if (obj == lginP.btSiup) {
			moveP("signup");
		}
	}

}