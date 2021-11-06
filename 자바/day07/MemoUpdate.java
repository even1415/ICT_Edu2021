package day07;

import java.sql.*;

public class MemoUpdate {

	public static void main(String[] args)
			// 1. 드라이버 로딩
			throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver 로딩");
		// 2. DB연결
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "c##scott";
		String pwd = "c##scott";

		// 3. statement 받아오기 DB연결 ->
		// DriverManager 클래스의 getConnection() 메소드 이용

		Connection con = DriverManager.getConnection(url, user, pwd);

		System.out.println("DB연결 성공 : con" + con);

		// 4. sql문 작성 1->1번 글의 msg를 변경 "오늘도 즐거운 하루 되세요 " update 문
		// SQL문 작성해서 해당 SQL문을 실행시키기 위한 Statement 객체 얻어오기

		Statement stmt = con.createStatement();
		String sql = "update memo set msg = '오늘도 즐거운 하루 되세요~' where idx = 2";

		// 5. boolean excute(String sql) :모든 sql문을 실행시킨다.
		// int executeUpdate(String sql): DML문장(insert/update/delete) 실행시킨다.
		// : DML문장에 의해 영향받은 레코드수를 반환한다.

		// boolean b = stmt.execute(sql);
		int b = stmt.executeUpdate(sql);
		System.out.println(b + "개의 레코드가 변경되었습니다");
		// 6. DB연결자원 반환
		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();

	}

}
