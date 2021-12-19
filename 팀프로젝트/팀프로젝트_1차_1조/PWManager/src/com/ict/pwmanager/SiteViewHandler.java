package com.ict.pwmanager;

import java.awt.event.*;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SiteViewHandler implements ActionListener, KeyListener {

	SiteViewPanel siteVP;
	SiteEditHandler siteEH;
	private LoginVO loginVO;
	SiteVO listVO;
	PWManager main;
	SiteEditPanel editP;
	Algorithm myAlgo;

	public SiteViewHandler(SiteViewPanel siteVP, PWManager main) {
		this.siteVP = siteVP;
		this.main = main;
		myAlgo = new Algorithm();
	}
	

//	public SiteViewHandler(SiteEditHandler siteEH) {
//		this.siteEH = siteEH;
//	}


	public void setsiteVOData() {
		SingletonData singleData = SingletonData.getSingletonSiteData();
		
		listVO=new SiteVO();
		listVO = singleData.siteVO;
//		listVO.setSitekey(singleData.siteVO.getSitekey());
//		listVO.setSiteName(singleData.siteVO.getSiteName());
//		listVO.setURL(singleData.siteVO.getURL());
//		listVO.setSiteID(singleData.siteVO.getSiteID());
//		listVO.setSitePW(singleData.siteVO.getSitePW());
//		listVO.setInsertDate(insertDate)
//		siteID="park";
//		sitePW="pk1234@!";
//		insertDate;
//		guardLevel;
//		category;
		
//		return listVO; 
	}
	
	public String getloginVOData() {
		SingletonData singleData = SingletonData.getSingletonSiteData();
//		System.out.println(singleData.getSiteName());
		
		return SingletonData.getSingletonUserData().getPW();
	}
	
	@SuppressWarnings("deprecation")
	public void checkPW() {
		loginVO = new LoginVO();
		listVO = new SiteVO();
		setsiteVOData();
		String uPW = getloginVOData();
		String sID = listVO.getSiteID();
		String sPW = listVO.getSitePW();
		String inputPW;
		inputPW = siteVP.pwTf.getText();
		if (uPW.equals(inputPW)) {
			siteVP.sPWTa.setText("����Ʈ ���̵� : " + sID + "\n���� ��й�ȣ : " + myAlgo.DecryptAlgorithm(listVO, listVO.getGuardLevel()));
			siteVP.editBtn.setEnabled(true);
		} else {
			siteVP.sPWTa.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
	}
	
	public void resetTa() {
		siteVP.pwTf.setText("");
		siteVP.sPWTa.setText("");
		siteVP.editBtn.setEnabled(false);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == siteVP.backBtn) {
			//list�гη� �̵�
			siteVP.main.card.show(siteVP.main.p, "List");
		}
		if (obj == siteVP.editBtn) {
			//edit�гη� �̵�
			resetTa();
			String siteKey=e.getActionCommand();
			//System.out.println(siteKey+"@@");
			editP = new SiteEditPanel(main,main.lginP.lginH.ListP.edp.handler.siteVP);
			main.p.add(editP, "EditP");
			
			SingletonData singletonData = SingletonData.getSingletonSiteData();
			singletonData.setSitekey(siteKey);
			
			
			siteVP.main.card.show(siteVP.main.p, "EditP");
		}
		if (obj == siteVP.pwBtn) {
			//��й�ȣ Ȯ��
			checkPW();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//���͸� ������ �̺�Ʈ�� �߻���
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			checkPW();
		}
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}

	public void backButtonEvent() {
		siteVP.backBtn.addActionListener(this);
	}


}
