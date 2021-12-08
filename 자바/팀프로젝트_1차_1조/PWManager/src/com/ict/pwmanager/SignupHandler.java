package com.ict.pwmanager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class SignupHandler extends MouseAdapter implements ActionListener {

	private SignupPanel siupP; // View
	private SignupDAO siupDao; // Model

	public SignupHandler(SignupPanel siupP) {
		this.siupP = siupP;
		this.siupDao = new SignupDAO();
	} // =-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-= ��/�� ����

	public void regist() {
		String id = siupP.tfID.getText();
		char[] pw1 = siupP.pfPW1.getPassword();
		char[] pw2 = siupP.pfPW2.getPassword();
		String name = siupP.tfName.getText();

		String spw1 = new String(pw1);
		String spw2 = new String(pw2);

		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= ȸ������ �� ĭ üũ
		if (id == null || spw1 == null || spw2 == null || name == null ||
				id.trim().equals("") || spw1.trim().equals("") ||
				spw2.trim().equals("") || name.trim().equals("")) {
			show("�� ĭ�� ���� ä���ּ���");
		} else if (!spw1.equals(spw2)) { // =-=-=-=-=-=-=-=-=-=- ��й�ȣ ��ġ üũ
			show("�Է��� ��й�ȣ�� ��ġ���� �ʽ��ϴ�");
		} else { // =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= ��й�ȣ ��ġ�ϸ� DB�� ������ ���
			SignupVO vo = new SignupVO();
			vo.setuID(id);
			vo.setuPW(spw2);
			vo.setuName(name);

			int n = siupDao.dupCheck(vo);
			if (n == 1) {
				int m = siupDao.sign(vo);
				show("ȸ������ �Ϸ�. �α��� ȭ������ ���ư��ϴ�.");
				clearTF();
				moveP("login");
			} else if (n == -1) {
				show("���̵� �ߺ��� Ȯ�����ּ���");
			}
		}
	} // =-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-= ȸ������ �޼ҵ�

	private void check() {
		String id = siupP.tfID.getText();

		SignupVO vo = new SignupVO();
		vo.setuID(id);
		int n = siupDao.dupCheck(vo);
		if (n == 1) {
			show("��� ������ ���̵��Դϴ�");
		} else if (n == 0) {
			show("���̵� �Է����ּ���");
		} else if (n == -1) {
			show("�ߺ��� ���̵��Դϴ�");
		} else {
			show("���� �߻� �����ڿ��� �����ϼ���");
		}
	} // =-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-==-=-=-=-= �ߺ�üũ ��ư�� �޼ҵ�

	private void moveP(String str) {
		siupP.main.card.show(siupP.main.p, str);
	} // =-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-= �г��̵� �޼ҵ�

	public void show(String msg) {
		JOptionPane.showMessageDialog(siupP, msg);
	} // =-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-= �޽��� ��� �޼ҵ�

	public void clearTF() {
		siupP.tfID.setText("");
		siupP.tfName.setText("");
		siupP.pfPW1.setText("");
		siupP.pfPW2.setText("");
	} // =-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-==-=-=-=-=-= �Է�ĭ �ʱ�ȭ �޼ҵ�

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == siupP.btSiup) {
			regist();
		} else if (obj == siupP.btBack) {
			moveP("login");
		} else if (obj == siupP.btIdch) {
			check();
		}
	}

}
