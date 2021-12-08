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
	} // =-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-= 뷰/모델 연결

	public void regist() {
		String id = siupP.tfID.getText();
		char[] pw1 = siupP.pfPW1.getPassword();
		char[] pw2 = siupP.pfPW2.getPassword();
		String name = siupP.tfName.getText();

		String spw1 = new String(pw1);
		String spw2 = new String(pw2);

		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 회원가입 빈 칸 체크
		if (id == null || spw1 == null || spw2 == null || name == null ||
				id.trim().equals("") || spw1.trim().equals("") ||
				spw2.trim().equals("") || name.trim().equals("")) {
			show("빈 칸을 전부 채워주세요");
		} else if (!spw1.equals(spw2)) { // =-=-=-=-=-=-=-=-=-=- 비밀번호 일치 체크
			show("입력한 비밀번호가 일치하지 않습니다");
		} else { // =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 비밀번호 일치하면 DB에 데이터 담기
			SignupVO vo = new SignupVO();
			vo.setuID(id);
			vo.setuPW(spw2);
			vo.setuName(name);

			int n = siupDao.dupCheck(vo);
			if (n == 1) {
				int m = siupDao.sign(vo);
				show("회원가입 완료. 로그인 화면으로 돌아갑니다.");
				clearTF();
				moveP("login");
			} else if (n == -1) {
				show("아이디 중복을 확인해주세요");
			}
		}
	} // =-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-= 회원가입 메소드

	private void check() {
		String id = siupP.tfID.getText();

		SignupVO vo = new SignupVO();
		vo.setuID(id);
		int n = siupDao.dupCheck(vo);
		if (n == 1) {
			show("사용 가능한 아이디입니다");
		} else if (n == 0) {
			show("아이디를 입력해주세요");
		} else if (n == -1) {
			show("중복된 아이디입니다");
		} else {
			show("에러 발생 관리자에게 문의하세요");
		}
	} // =-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-==-=-=-=-= 중복체크 버튼용 메소드

	private void moveP(String str) {
		siupP.main.card.show(siupP.main.p, str);
	} // =-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-= 패널이동 메소드

	public void show(String msg) {
		JOptionPane.showMessageDialog(siupP, msg);
	} // =-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-= 메시지 출력 메소드

	public void clearTF() {
		siupP.tfID.setText("");
		siupP.tfName.setText("");
		siupP.pfPW1.setText("");
		siupP.pfPW2.setText("");
	} // =-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-==-=-=-=-=-= 입력칸 초기화 메소드

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
