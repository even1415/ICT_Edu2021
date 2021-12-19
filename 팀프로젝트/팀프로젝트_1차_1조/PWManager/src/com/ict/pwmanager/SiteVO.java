package com.ict.pwmanager;

import java.sql.Date;

public class SiteVO {
	//SITELIST 테이블의 각 값들 목록
	private int key;
	private int sitekey;
	private String siteName;
	private String URL;
	private String siteID;
	private String sitePW;
	private java.sql.Date insertDate;
	private int guardLevel;
	private int category;
	
	private int userkey; //USERDATA 테이블의 KEY 값
	
	public SiteVO() {}

	public SiteVO(int key, int sitekey, String siteName, String URL, String siteID, String sitePW, Date insertDate,
			int guardLevel, int category) {
		super();
		this.key = key;
		this.sitekey = sitekey;
		this.siteName = siteName;
		this.URL = URL;
		this.siteID = siteID;
		this.sitePW = sitePW;
		this.insertDate = insertDate;
		this.guardLevel = guardLevel;
		this.category = category;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getSitekey() {
		return sitekey;
	}

	public void setSitekey(int sitekey) {
		this.sitekey = sitekey;
	}
	
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getSiteID() {
		return siteID;
	}

	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}

	public String getSitePW() {
		return sitePW;
	}

	public void setSitePW(String sitePW) {
		this.sitePW = sitePW;
	}

	public java.sql.Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(java.sql.Date insertDate) {
		this.insertDate = insertDate;
	}

	public int getGuardLevel() {
		return guardLevel;
	}

	public void setGuardLevel(int guardLevel) {
		this.guardLevel = guardLevel;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getUserkey() {
		return userkey;
	}

	public void setUserkey(int userkey) {
		this.userkey = userkey;
	}
	
}
