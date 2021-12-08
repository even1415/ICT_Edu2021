package com.ict.pwmanager;

import jdbc.util.DBUtil;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class LoginDAO extends DAOBase {

	LoginVO loginVO;

	public LoginVO login(LoginVO vo) {
		String tID;
		String tPW;

		try {
			con = DBUtil.getCon();
			String sql = "SELECT KEY, ID, NICKNAME, PASSWORD, JOINDATE "
					+ " FROM USERDATA WHERE ID = ? AND PASSWORD = ?";

			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getuID());
			ps.setString(2, vo.getuPW());

			 //=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-==-=-=-= ���� �߰� �� ���� ������
			LoginVO n = new LoginVO();
			SingletonData singleData = SingletonData.getSingletonUserData();
			singleData.setLoginData(n);

			rs = ps.executeQuery();
			if (rs.next()) { 
				// System.out.println("�α��� ����");
				int key = rs.getInt(1);
				String iD = rs.getString(2);
				String name = rs.getString(3);
				String pW = rs.getString(4);
				Date date = rs.getDate(5);

				loginVO = new LoginVO(key, iD, name, pW, date);
				return loginVO;
			} else {
				// System.out.println("�н����� �ٸ�");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			close();
		}

	}

}