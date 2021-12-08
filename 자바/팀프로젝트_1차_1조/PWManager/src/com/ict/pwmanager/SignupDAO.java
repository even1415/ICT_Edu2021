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
					dupCheck = -1; //중복 시 -1 반환
				} else if (rs.getInt(1) == 0) {
					dupCheck = 1; //사용가능시 1 반환
					if(vo.getuID().isEmpty()) {
						dupCheck = 0; //근데 빈칸도 사용가능으로 판정됨. 빈칸이면 0 반환
					}
				}
			}
			
			if(dupCheck == 1) {
				//System.out.println("아이디 사용 가능");
				return 1;
			} else if (dupCheck == 0) {
				//System.out.println("아이디 공백");
				return 0;
			} else {
				//System.out.println("아이디 중복");
				return -1;
			}
		} catch(Exception e) {
			e.printStackTrace();
			return -2;
		}
	}

}