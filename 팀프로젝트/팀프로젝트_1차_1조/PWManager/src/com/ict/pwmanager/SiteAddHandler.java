package com.ict.pwmanager;

import java.awt.event.*;
import javax.swing.*;


public class SiteAddHandler implements ActionListener {
	private SiteAddPanel siteAP;
	SiteDAO siteDao; //Model
	Object obj;
	PWManager main;
	
	public SiteAddHandler(SiteAddPanel siteAP, PWManager main) {
		this.main = main;
		this.siteAP = siteAP;
		this.siteDao = new SiteDAO();
	}
	
	public void BackButtonEvent() {
		siteAP.BackButton.addActionListener(this);
	}
	
	public boolean AddSiteData() {
		//이곳에 카테고리입력 추가 필요
		
		String siteName = siteAP.AddSiteName.getText();
		String textID = siteAP.AddIDText.getText();
		String textPW = siteAP.AddPassword.getText();
		String textURL = siteAP.AddURL.getText();
		
		obj = siteAP.AddSelectSecurity.getSelectedItem();
		String textSecurity = obj.toString();
		int guardLevel = SelectSecurityCase(textSecurity);
		
		obj = siteAP.AddSelectCategory.getSelectedItem();
		String textCategory = obj.toString();
		int categorynum = SelectCategoryCase(textCategory);
		
		
		//유효성 체크
		if(siteName==null || siteName.trim().equals("") || siteName.equals("사이트명(메모) 입력")) {
			show("[오류]추가하실 사이트 이름(메모)을 입력해주세요.");
			siteAP.AddSiteName.requestFocus();
			return false;
		}
		if(textID==null || textID.trim().equals("") || textID.equals("아이디 입력")) {
			show("[오류]추가하실 사이트의 아이디를 입력해주세요.");
			siteAP.AddIDText.requestFocus();
			return false;
		}
		if(textPW==null || textPW.trim().equals("") || textPW.equals("비밀번호 입력")) {
			show("[오류]추가하실 사이트의 비밀번호를 입력해주세요.");
			siteAP.AddPassword.requestFocus();
			return false;
		}
		if(textURL==null || textURL.trim().equals("") || textURL.equals("사이트 URL 입력")) {
			show("[오류]추가하실 사이트의 URL을 입력해주세요.");
			siteAP.AddURL.requestFocus();
			return false;
		}
		
		SiteVO vo = new SiteVO();
		vo.setSiteName(siteName);
		vo.setSiteID(textID);
		vo.setSitePW(textPW);
		vo.setURL(textURL);
		vo.setGuardLevel(guardLevel);
		vo.setCategory(categorynum);
		
		int n = siteDao.insertSiteData(vo);
		if(n > 0) {
			show("[알림]사이트정보가 추가되었어요!");
		}
		else {
			show("[오류]사이트정보 추가에 실패했어요.");
			return false;
		}
		
		clearTf(); //정상적으로 추가된 경우만 입력폼 초기화
		return true;
	}
	
	private int SelectSecurityCase(String textSecurity) {
		int guardLevel = 0;
		
		switch (textSecurity) {
		case "기본":
			guardLevel = 1;
			break;
		case "AES":
			guardLevel = 1;
			show("[알림]최초 저장은 기본 알고리즘만 가능합니다. (수정 페이지에서 변경가능)");
			break;
		case "랜덤(미구현)":
			//SelectNum = 3;
			//이곳에 기타 알고리즘 선택 메소드 추가 필요
			//break;
		default:
			guardLevel = 1;
			show("[알림]차후에 추가될 알고리즘입니다. 기대해주세요! (기본 알고리즘으로 저장)");
			break;
		}
		
		return guardLevel;
	}
	
	private int SelectCategoryCase(String textSecurity) {
		int categorynum = 0;
		
		switch (textSecurity) {
		case "기본":
			categorynum = 0;
			break;
		case "게임":
			categorynum = 1;
			break;
		case "유틸리티":
			categorynum = 2;
			break;
		case "SNS":
			categorynum = 3;
			break;
		case "금융":
			categorynum = 4;
			break;
		default:
			categorynum = 0; //이외의 경우 기본그룹으로 초기화
			break;
		}
		
		return categorynum;
	}
	
	public void show(String msg) {
		JOptionPane.showMessageDialog(siteAP, msg);
	}
	
	public void clearTf() {
		siteAP.AddSiteName.setHintText("사이트명(메모) 입력");
		siteAP.AddIDText.setHintText("아이디 입력");
		siteAP.AddPassword.setHintText("비밀번호 입력");
		siteAP.AddURL.setHintText("사이트 URL 입력");
		siteAP.AddSelectSecurity.setSelectedIndex(0);
		siteAP.AddSelectCategory.setSelectedIndex(0);
		
		siteAP.AddSiteName.requestFocus(); //입력필드에 포커스 주기(커서위치 이동)
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean addDB;
		
		Object obj = e.getSource();
		
		if(obj==siteAP.BackButton) {
			siteAP.main.card.show(siteAP.main.p, "List");
		}
		if(obj==siteAP.AddReset) {
			clearTf();
		}
		if(obj==siteAP.AddSave) {		
			addDB = AddSiteData();
			main.lginP.lginH.ListP.insertEachPanel();
			if(addDB) siteAP.main.card.show(siteAP.main.p, "List");
		}
		
	}

}
