package com.ict.pwmanager;
/** �̱���(Singleton) ������ ������ ������ ��ü
 * */

public class SingletonData {
	private static SingletonData singletonData = null;
	private SingletonData() {} //�ܺο��� ������ ��� �Ұ�
	
	//������ ������ ����� ����
	LoginVO loginVO;
	SiteVO siteVO;
	String sitekey;
	
	

	public static SingletonData getSingletonUserData() {
		if(singletonData == null) {
			singletonData = new SingletonData();
		}
		
		return singletonData;
	}
	
	public static SingletonData getSingletonSiteData() {
		if(singletonData == null) {
			singletonData = new SingletonData();
		}
		
		return singletonData;
	}
	
	//������ �Լ��� ����� ����(�Ʒ� testPrint �޼ҵ�� ����)
	public void testPrint(String str) {
	    System.out.println(str);
	}
	
	public void setLoginData(LoginVO loginVO) {
		this.loginVO = loginVO;
	} //�α��ε����� ����
	public int getKey() {
		return this.loginVO.getuKey();
	} //�α��ε����� ��, ����Ű ����
	public String getPW() {
		return this.loginVO.getuPW();
	} //�α��ε����� ��, �н����� ����
	public String getID() {
		return this.loginVO.getuID();
	} //�α��ε����� ��, ���̵� ����
	
	
	public void setSiteData(SiteVO siteVO) {
		this.siteVO = siteVO;
	} //Ư�� ����Ʈ������ ����
	public String getSiteName() {
		return this.siteVO.getSiteName();
	}
	
	public String getSitekey() {
		return sitekey;
	}

	public void setSitekey(String sitekey) {
		this.sitekey = sitekey;
	}
}


/*
 * �����(����)

public class User {
  private String name;
  public User(String name) { this.name = name; }
  public void print() { //�ڡڡڿ��Ⱑ �̱��� ��ü ����,ȣ���ϴ� �κ��ε�
    Printer printer = printer.getPrinter();
    printer.print(this.name + " print using " + printer.toString());
  }
}
public class Client {
  private static final int USER_NUM = 5;
  public static void main(String[] args) {
    User[] user = new User[USER_NUM];
    for (int i = 0; i < USER_NUM; i++) {
      // User �ν��Ͻ� ����
      user[i] = new User((i+1))
      user[i].print(); //�ڡڡڿ��Ⱑ ȣ���ص״��� �����ϴ� �κ��ε�
    }
  }
}

//���� : https://gmlwjd9405.github.io/2018/07/06/singleton-pattern.html

*/