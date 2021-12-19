package com.ict.pwmanager;

import java.sql.SQLException;
import java.util.*;
import jdbc.util.DBUtil;

public class SiteDAO extends DAOBase {
	SingletonData singletonData = SingletonData.getSingletonUserData();
	SiteVO eachlist;
	Algorithm myAlgo = new Algorithm();
	
	public List<SiteVO> siteList() {
		try {
			SingletonData singletonData = SingletonData.getSingletonUserData();
			
			
			con = DBUtil.getCon();
			String sql = "select key, sitekey, sitename, url, siteid, sitepw, insertdate, guardlevel, category"
					 + " from sitelist where key = " + singletonData.getKey();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			List<SiteVO> arr = new ArrayList<>();
			while(rs.next()) {
				int key = rs.getInt("key");
				int sitekey = rs.getInt("sitekey");
				String siteName = rs.getString("sitename");
				String URL = rs.getString("url");
				String siteID = rs.getString("siteid");
				String sitePW = rs.getString("sitepw");
				java.sql.Date insertDate = rs.getDate("insertDate");
				int guardLevel = rs.getInt("guardlevel");
				int category = rs.getInt("category");
				
				eachlist = new SiteVO(key, sitekey, siteName, URL, siteID, sitePW, insertDate, guardLevel, category);
				arr.add(eachlist);
				
			}
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
	}
	
	public int insertSiteData(SiteVO vo) {
		try {
			con = DBUtil.getCon();
			//insert문 작성 => ps얻기 => executeXXX() => 반환하기
			String sql = "INSERT INTO SITELIST(key, sitekey, sitename, url, siteid, sitepw, "
					+ " insertdate, guardlevel, category)"
					+ " VALUES(?, site_seq.nextval, ?, ?, ?, ?, sysdate, ?, ?)";
			
			SingletonData singletonData = SingletonData.getSingletonSiteData();
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, singletonData.getKey());
			ps.setString(2, vo.getSiteName());
			ps.setString(3, vo.getURL());
			ps.setString(4, vo.getSiteID());
			ps.setString(5, myAlgo.EncryptAlgorithm(vo, vo.getGuardLevel())); //암호화 후 DB저장
			ps.setInt(6, vo.getGuardLevel());
			ps.setInt(7, vo.getCategory());
			
			int n = ps.executeUpdate();
			return n;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}
	
	public int updateSiteData(SiteVO vo) {

		try {
			con = DBUtil.getCon();
			String sql = "UPDATE sitelist SET sitename = ?, url = ?, siteid = ?, sitepw = ?, "
					+ " guardlevel = ?, category = ? WHERE sitekey = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, vo.getSiteName());
			ps.setString(2, vo.getURL());
			ps.setString(3, vo.getSiteID());
			ps.setString(4, myAlgo.EncryptAlgorithm(vo, vo.getGuardLevel()));
			ps.setInt(5, vo.getGuardLevel());
			ps.setInt(6, vo.getCategory());
			ps.setInt(7, vo.getSitekey());

			int n = ps.executeUpdate();
			return n;

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}

	public int deleteData(int key) {
		try {
			con = DBUtil.getCon();
			String sql = "delete from sitelist where sitekey=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, key);
			int n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}
	
	public SiteVO getSiteVO(String siteKey) {
		try {
			con = DBUtil.getCon();
			String sql = "select key, sitekey, sitename, url, siteid, sitepw, insertdate, guardlevel, category"
					+ " from sitelist where sitekey=" + siteKey;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			int key = rs.getInt("key");
			int sitekey = rs.getInt("sitekey");
			String siteName = rs.getString("sitename");
			String URL = rs.getString("url");
			String siteID = rs.getString("siteid");
			String sitePW = rs.getString("sitepw");
			java.sql.Date insertDate = rs.getDate("insertDate");
			int guardLevel = rs.getInt("guardlevel");
			int category = rs.getInt("category");
			
			SiteVO siteVO = new SiteVO(key, sitekey, siteName, URL, siteID, sitePW, insertDate, guardLevel, category);
			
			return siteVO;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
		
	}
}