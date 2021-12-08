package com.ict.pwmanager;

import jdbc.util.DBUtil;
import java.sql.*;
import java.util.*;

public class SignupDAO extends DAOBase {
	
	public int sign(SignupVO vo) {
		try {
			con = DBUtil.getCon();
			String sql = "INSERT INTO USERDATA(KEY, ID, NICKNAME, PASSWORD, JOINDATE) "
					+ " VALUES(USER_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";

			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getuID());
			ps.setString(2, vo.getuName());
			ps.setString(3, vo.getuPW());
			
			int n = ps.executeUpdate();
			return n;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}
	
	public int dupCheck(SignupVO vo) {
		try {
			con = DBUtil.getCon();
			String sql = "SELECT COUNT(*) FROM USERDATA WHERE ID = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getuID());
			
			rs = ps.executeQuery();
			int dupCheck = 0;
			while(rs.next()) {
				if(rs.getInt(1) != 0) {
					dupCheck = -1; //�ߺ� �� -1 ��ȯ
				} else if (rs.getInt(1) == 0) {
					dupCheck = 1; //��밡�ɽ� 1 ��ȯ
					if(vo.getuID().isEmpty()) {
						dupCheck = 0; //�ٵ� ��ĭ�� ��밡������ ������. ��ĭ�̸� 0 ��ȯ
					}
				}
			}
			
			if(dupCheck == 1) {
				//System.out.println("���̵� ��� ����");
				return 1;
			} else if (dupCheck == 0) {
				//System.out.println("���̵� ����");
				return 0;
			} else {
				//System.out.println("���̵� �ߺ�");
				return -1;
			}
		} catch(Exception e) {
			e.printStackTrace();
			return -2;
		}
	}

}