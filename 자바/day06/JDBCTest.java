package day06;
import java.sql.*;
import javax.swing.*;
/*DBMS: Oracle
 * 
 * 통역사: JDBC DRIVER ==>설치해야 함. DBMS사에서 다운로드 받아야 함
 * 						우리 컴퓨터 로컬에 oracle설치==> 설치한 곳에 jdbc driver존재함 
 * 
 * 
 *프로그램: Java 
 * 
 * 프로젝트(MyJava)=>우클릭 > Configure Build Path > Library탭 선택 
 * > Classpath 선택후 > add External Jars 선택하여
 * odjbc8.jar를 추가한다.
 * */

public class JDBCTest {

	public static void main(String[] args) {
		
		String name=JOptionPane.showInputDialog("작성자를 입력하세요");
		if(name==null) return;
		
		String msg=JOptionPane.showInputDialog("메시지를 입력하세요");
		if(msg==null) return;
		
		
		//드라이버 로딩==> Class.forName()메소드 이용한다.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
					//패키지명.클래스명 ==> 오라클드라이버
			System.out.println("Driver Loading성공!!");
			
			//DB에 연결하기 위해 연결정보 설정
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="c##scott";
			String pwd="c##scott";
			
			//DB연결 ==> DriverManager클래스의 getConnection()메소드를 이용
			Connection con = DriverManager.getConnection(url,user, pwd);
			System.out.println("DB연결 성공!!: con="+con);
			
			//SQL문 작성해서 해당 SQL문을 실행시키기 위핸 Statement객체 얻어오기
			Statement stmt = con.createStatement();
			
			//SQL문 작성
			String sql="insert into memo(idx, name, msg, wdate) "
						+" values(memo_seq.nextval,'"+name+"','"+msg+"',sysdate)";
			//SQL문을 실행시키자
			//boolean execute(String sql)
			/*sql문(query문)을 실행시키는 메소드
			 * 반환값은 sql문이 select문이면 true를 반환하고,
			 * select문이 아닌 문장이면 false를 반환한다.
			 * */
			boolean b=stmt.execute(sql);
			System.out.println("b="+b);
			
			if(stmt!=null) stmt.close();
			
			if(con!=null) con.close();//DB연결 자원 반납 (매우 중요한 코드)
		}catch(ClassNotFoundException e) {
			System.out.println("Driver가 설치되지 않았거나 드라이버명이 틀렸어요");
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}



