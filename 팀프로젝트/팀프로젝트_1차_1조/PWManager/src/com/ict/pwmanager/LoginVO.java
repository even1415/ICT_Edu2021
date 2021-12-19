package com.ict.pwmanager;

import java.sql.Date;

public class LoginVO {
	
	private int uKey;
	private String uID;
	private String uPW;
	private String uName;
	private java.sql.Date jDate;
	
	public LoginVO() {;}
	
	public LoginVO(int uKey, String uID, String uName, String uPW, Date jDate) {
		super();
		this.uKey = uKey;
		this.uID = uID;
		this.uPW = uPW;
		this.uName = uName;
		this.jDate = jDate;
	}
	
	public int getuKey() {
		return uKey;
	}
	
	public void setuKey(int uKey) {
		this.uKey = uKey;
	}
	
	public String getuID() {
		return uID;
	}
	
	public void setuID(String uID) {
		this.uID = uID;
	}
	
	public String getuPW() {
		return uPW;
	}
	
	public void setuPW(String uPW) {
		this.uPW = uPW;
	}
	
	public String getuName() {
		return uName;
	}
	
	public void setuName(String uName) {
		this.uName = uName;
	}
	
	public java.sql.Date getjDate() {
		return jDate;
	}
	
	public void setjDate(java.sql.Date jDate) {
		this.jDate = jDate;
	}
}
