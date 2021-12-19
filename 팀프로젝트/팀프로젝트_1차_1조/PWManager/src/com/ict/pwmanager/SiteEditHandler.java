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
	private final String[] Categorylist = { "�⺻", "����", "��ƿ��Ƽ", "SNS", "����" };

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
		// �̰��� ī�װ��Է� �߰� �ʿ�

		// 1. ����ڰ� ������ �� ������
		String siteName = siteEP.EditSiteName.getText();
		String textID = siteEP.EditIDText.getText();
		String textPW = siteEP.EditPassword.getText();
		String textURL = siteEP.EditURL.getText();
		String category = siteEP.EditSelectCategory.getSelectedItem().toString();

		obj = siteEP.EditSelectSecurity.getSelectedItem();
		String textSecurity = obj.toString();
		int guardLevel = selectSecurityCase(textSecurity);
		int categoryNum = findCategoryNum();

		// 2.��ȿ�� üũ
		if (siteName == null || siteName.trim().equals("") || siteName.equals("����Ʈ��(�޸�) �Է�")) {
			show("[����]�߰��Ͻ� ����Ʈ �̸�(�޸�)�� �Է����ּ���.");
			siteEP.EditSiteName.requestFocus();
			return;
		}
		if (textID == null || textID.trim().equals("") || textID.equals("���̵� �Է�")) {
			show("[����]�߰��Ͻ� ����Ʈ�� ���̵� �Է����ּ���.");
			siteEP.EditIDText.requestFocus();
			return;
		}
		if (textPW == null || textPW.trim().equals("") || textPW.equals("��й�ȣ �Է�")) {
			show("[����]�߰��Ͻ� ����Ʈ�� ��й�ȣ�� �Է����ּ���.");
			siteEP.EditPassword.requestFocus();
			return;
		}
		if (textURL == null || textURL.trim().equals("") || textURL.equals("����Ʈ URL �Է�")) {
			show("[����]�߰��Ͻ� ����Ʈ�� URL�� �Է����ּ���.");
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
		String msg=(n>0)?"���� �Ϸ�":"���� ����";
		show(msg);

		clearTf(); // ���������� �߰��� ��츸 �Է��� �ʱ�ȭ
	}

	private int selectSecurityCase(String textSecurity) {
		int guardLevel = 0;

		switch (textSecurity) {
		case "�⺻":
			guardLevel = 1;
			break;
		case "AES":
			guardLevel = 2;
			break;
		case "����(�̱���)":
			// SelectNum = 3;
			// �̰��� ��Ÿ �˰��� ���� �޼ҵ� �߰� �ʿ�
			// break;
		default:
			guardLevel = 1;
			show("[�˸�]���Ŀ� �߰��� �˰����Դϴ�. ������ּ���! (�⺻ �˰������� ����)");
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
		siteEP.EditSiteName.setText("����Ʈ��(�޸�) �Է�");
		siteEP.EditIDText.setText("���̵� �Է�");
		siteEP.EditPassword.setText("��й�ȣ �Է�");
		siteEP.EditURL.setText("����Ʈ URL �Է�");
		siteEP.EditSelectSecurity.setSelectedIndex(0);

		siteEP.EditSiteName.requestFocus(); // �Է��ʵ忡 ��Ŀ�� �ֱ�(Ŀ����ġ �̵�)
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
