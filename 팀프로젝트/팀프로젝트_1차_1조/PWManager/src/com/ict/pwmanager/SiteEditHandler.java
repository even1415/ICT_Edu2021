package com.ict.pwmanager;

import java.awt.event.*;
import javax.swing.*;

public class SiteEditHandler implements ActionListener {
	private static final SiteViewPanel SiteEditHandler = null;
	private SiteViewPanel siteVP;
	private SiteEditPanel siteEP;
	//private SiteViewHandler siteVH;
	private SiteVO vo;
	private SiteDAO siteEDao; // Model
	Object obj;
	PWManager main;
	private final String[] Categorylist = { "기본", "게임", "유틸리티", "SNS", "금융" };

//	public SiteEditHandler(SiteEditPanel siteEP, SiteViewPanel siteVP, PWManager main) {
//		this.main = main;
//		this.siteEP = siteEP;
//		this.siteVP = siteVP;
//		this.siteEDao = new SiteDAO();
//	}

	public SiteEditHandler(SiteEditPanel siteEP, SiteViewPanel siteVP) {
		this.siteEP = siteEP;
		this.siteEDao = new SiteDAO();
		this.siteVP = siteVP;
	}

	public void updateSiteData() {
		// 이곳에 카테고리입력 추가 필요

		// 1. 사용자가 수정한 값 얻어오기
		String siteName = siteEP.EditSiteName.getText();
		String textID = siteEP.EditIDText.getText();
		String textPW = siteEP.EditPassword.getText();
		String textURL = siteEP.EditURL.getText();
		String category = siteEP.EditSelectCategory.getSelectedItem().toString();

		obj = siteEP.EditSelectSecurity.getSelectedItem();
		String textSecurity = obj.toString();
		int guardLevel = selectSecurityCase(textSecurity);
		int categoryNum = findCategoryNum();

		// 2.유효성 체크
		if (siteName == null || siteName.trim().equals("") || siteName.equals("사이트명(메모) 입력")) {
			show("[오류]추가하실 사이트 이름(메모)을 입력해주세요.");
			siteEP.EditSiteName.requestFocus();
			return;
		}
		if (textID == null || textID.trim().equals("") || textID.equals("아이디 입력")) {
			show("[오류]추가하실 사이트의 아이디를 입력해주세요.");
			siteEP.EditIDText.requestFocus();
			return;
		}
		if (textPW == null || textPW.trim().equals("") || textPW.equals("비밀번호 입력")) {
			show("[오류]추가하실 사이트의 비밀번호를 입력해주세요.");
			siteEP.EditPassword.requestFocus();
			return;
		}
		if (textURL == null || textURL.trim().equals("") || textURL.equals("사이트 URL 입력")) {
			show("[오류]추가하실 사이트의 URL을 입력해주세요.");
			siteEP.EditURL.requestFocus();
			return;
		}

		vo=new SiteVO();
		vo.setSiteName(siteName);
		vo.setSiteID(textID);
		vo.setSitePW(textPW);
		vo.setURL(textURL);
		vo.setGuardLevel(guardLevel);
		vo.setCategory(categoryNum);
		
		SingletonData singletonData = SingletonData.getSingletonSiteData();
		vo.setSitekey(Integer.parseInt(singletonData.getSitekey()));
		
		int n =siteEDao.updateSiteData(vo);
		String msg=(n>0)?"수정 완료":"수정 실패";
		show(msg);

		clearTf(); // 정상적으로 추가된 경우만 입력폼 초기화
	}

	private int selectSecurityCase(String textSecurity) {
		int guardLevel = 0;

		switch (textSecurity) {
		case "기본":
			guardLevel = 1;
			break;
		case "AES":
			guardLevel = 2;
			break;
		case "랜덤(미구현)":
			// SelectNum = 3;
			// 이곳에 기타 알고리즘 선택 메소드 추가 필요
			// break;
		default:
			guardLevel = 1;
			show("[알림]차후에 추가될 알고리즘입니다. 기대해주세요! (기본 알고리즘으로 저장)");
			break;
		}

		return guardLevel;
	}
	
	private int findCategoryNum() {
		int i;
		
		for(i=0; i<Categorylist.length; i++) {
			if(Categorylist[i].equals(siteEP.EditSelectCategory.getSelectedItem().toString()))
				break;
		}
		
		return i;
	}

	public void show(String msg) {
		JOptionPane.showMessageDialog(siteEP, msg);
	}

	public void SendData() {
		SingletonData singleData = SingletonData.getSingletonSiteData();
		singleData.setSiteData(vo);
	}
	
//	public void resetTa() {
//		siteVP.pwTf.setText("");
//		siteVP.sPWTa.setText("");
//	}

	public void clearTf() {
		siteEP.EditSiteName.setText("사이트명(메모) 입력");
		siteEP.EditIDText.setText("아이디 입력");
		siteEP.EditPassword.setText("비밀번호 입력");
		siteEP.EditURL.setText("사이트 URL 입력");
		siteEP.EditSelectSecurity.setSelectedIndex(0);

		siteEP.EditSiteName.requestFocus(); // 입력필드에 포커스 주기(커서위치 이동)
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == siteEP.BackButton) {
			siteEP.main.card.show(siteEP.main.p, "ViewP");
		}
		if (obj == siteEP.resetBtn) {
			clearTf();
		}
		if (obj == siteEP.saveBtn) {
			updateSiteData();
			SendData();
			siteEP.main.card.show(siteEP.main.p, "List");
			siteEP.main.lginP.lginH.ListP.insertEachPanel();
			//resetTa();
//			SingletonData singleData2 = SingletonData.getSingletonSiteData();
//			System.out.println(singleData2.getSiteName());
		}

	}

}
