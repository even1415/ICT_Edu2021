package com.ict.pwmanager;
/** 싱글톤(Singleton) 패턴의 데이터 공유용 객체
 * */

public class SingletonData {
	private static SingletonData singletonData = null;
	private SingletonData() {} //외부에서 생성자 사용 불가
	
	//저장할 변수를 여기다 구현
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
	
	//구현할 함수를 여기다 구현(아래 testPrint 메소드는 예제)
	public void testPrint(String str) {
	    System.out.println(str);
	}
	
	public void setLoginData(LoginVO loginVO) {
		this.loginVO = loginVO;
	} //로그인데이터 저장
	public int getKey() {
		return this.loginVO.getuKey();
	} //로그인데이터 중, 유저키 방출
	public String getPW() {
		return this.loginVO.getuPW();
	} //로그인데이터 중, 패스워드 방출
	public String getID() {
		return this.loginVO.getuID();
	} //로그인데이터 중, 아이디 방출
	
	
	public void setSiteData(SiteVO siteVO) {
		this.siteVO = siteVO;
	} //특정 사이트데이터 저장
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
 * 사용방법(예제)

public class User {
  private String name;
  public User(String name) { this.name = name; }
  public void print() { //★★★여기가 싱글톤 객체 선언,호출하는 부분인듯
    Printer printer = printer.getPrinter();
    printer.print(this.name + " print using " + printer.toString());
  }
}
public class Client {
  private static final int USER_NUM = 5;
  public static void main(String[] args) {
    User[] user = new User[USER_NUM];
    for (int i = 0; i < USER_NUM; i++) {
      // User 인스턴스 생성
      user[i] = new User((i+1))
      user[i].print(); //★★★여기가 호출해뒀던거 실행하는 부분인듯
    }
  }
}

//참고 : https://gmlwjd9405.github.io/2018/07/06/singleton-pattern.html

*/