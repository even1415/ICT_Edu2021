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
	
//	public void print() { //★★★여기가 싱글톤 객체 선언,호출하는 부분인듯
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
	
	private void loginC() { //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 이름 바뀜
		vo = new LoginVO();
		
		String uID = lginP.tfID.getText();
		char[] uPW = lginP.tfPW.getPassword();
		String suPW = new String(uPW); //to String from charArray
		
		if (uID == null||uPW == null||uID.trim().equals("")||suPW.trim().equals("")) {
			show("아이디와 비밀번호를 입력하세요");
			lginP.tfID.requestFocus();
			return;
		} else {
			vo.setuID(uID);
			vo.setuPW(suPW);
			
			LoginVO n = lginDao.login(vo);
			String msg = new String();
			if(n != null) {
				msg = "어서오세요";
				clearTF();
//				moveP("List"); //=-=-=-=-=-=-=-=-=-=-= 제거됨
				
				SingletonData singleData = SingletonData.getSingletonUserData();
				singleData.setLoginData(n);
				//System.out.println(lginDao.loginVO.getuKey());
				
//				SingletonData singleData2 = SingletonData.getSingletonUserData();
				//System.out.println(singleData2.getKey());
			} else {
				msg = "아이디와 비밀번호를 확인해주세요";
				lginP.tfID.requestFocus();
			}
			show(msg);
		}
	}
	
	private void loginM() { //=-=-=-=-=-=-=-=-=-=-=-=-= 새로 추가된 기능
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
			loginC(); //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 이름 바뀜
			
			ListP = new SiteListPanel(main);
			AddEditP = new SiteAddPanel(main);
			
			main.p.add(ListP, "List"); //목록 페이지
			main.p.add(AddEditP, "AddEdit"); //추가 페이지
			
			loginM(); //=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-= 변경됨
		} else if (obj == lginP.btSiup) {
			moveP("signup");
		}
	}

}