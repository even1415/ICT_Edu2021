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
		//�̰��� ī�װ��Է� �߰� �ʿ�
		
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
		
		
		//��ȿ�� üũ
		if(siteName==null || siteName.trim().equals("") || siteName.equals("����Ʈ��(�޸�) �Է�")) {
			show("[����]�߰��Ͻ� ����Ʈ �̸�(�޸�)�� �Է����ּ���.");
			siteAP.AddSiteName.requestFocus();
			return false;
		}
		if(textID==null || textID.trim().equals("") || textID.equals("���̵� �Է�")) {
			show("[����]�߰��Ͻ� ����Ʈ�� ���̵� �Է����ּ���.");
			siteAP.AddIDText.requestFocus();
			return false;
		}
		if(textPW==null || textPW.trim().equals("") || textPW.equals("��й�ȣ �Է�")) {
			show("[����]�߰��Ͻ� ����Ʈ�� ��й�ȣ�� �Է����ּ���.");
			siteAP.AddPassword.requestFocus();
			return false;
		}
		if(textURL==null || textURL.trim().equals("") || textURL.equals("����Ʈ URL �Է�")) {
			show("[����]�߰��Ͻ� ����Ʈ�� URL�� �Է����ּ���.");
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
			show("[�˸�]����Ʈ������ �߰��Ǿ����!");
		}
		else {
			show("[����]����Ʈ���� �߰��� �����߾��.");
			return false;
		}
		
		clearTf(); //���������� �߰��� ��츸 �Է��� �ʱ�ȭ
		return true;
	}
	
	private int SelectSecurityCase(String textSecurity) {
		int guardLevel = 0;
		
		switch (textSecurity) {
		case "�⺻":
			guardLevel = 1;
			break;
		case "AES":
			guardLevel = 1;
			show("[�˸�]���� ������ �⺻ �˰��� �����մϴ�. (���� ���������� ���氡��)");
			break;
		case "����(�̱���)":
			//SelectNum = 3;
			//�̰��� ��Ÿ �˰��� ���� �޼ҵ� �߰� �ʿ�
			//break;
		default:
			guardLevel = 1;
			show("[�˸�]���Ŀ� �߰��� �˰����Դϴ�. ������ּ���! (�⺻ �˰������� ����)");
			break;
		}
		
		return guardLevel;
	}
	
	private int SelectCategoryCase(String textSecurity) {
		int categorynum = 0;
		
		switch (textSecurity) {
		case "�⺻":
			categorynum = 0;
			break;
		case "����":
			categorynum = 1;
			break;
		case "��ƿ��Ƽ":
			categorynum = 2;
			break;
		case "SNS":
			categorynum = 3;
			break;
		case "����":
			categorynum = 4;
			break;
		default:
			categorynum = 0; //�̿��� ��� �⺻�׷����� �ʱ�ȭ
			break;
		}
		
		return categorynum;
	}
	
	public void show(String msg) {
		JOptionPane.showMessageDialog(siteAP, msg);
	}
	
	public void clearTf() {
		siteAP.AddSiteName.setHintText("����Ʈ��(�޸�) �Է�");
		siteAP.AddIDText.setHintText("���̵� �Է�");
		siteAP.AddPassword.setHintText("��й�ȣ �Է�");
		siteAP.AddURL.setHintText("����Ʈ URL �Է�");
		siteAP.AddSelectSecurity.setSelectedIndex(0);
		siteAP.AddSelectCategory.setSelectedIndex(0);
		
		siteAP.AddSiteName.requestFocus(); //�Է��ʵ忡 ��Ŀ�� �ֱ�(Ŀ����ġ �̵�)
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
