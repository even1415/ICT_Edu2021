package day07;

import java.sql.*;

public class MemoUpdate {

	public static void main(String[] args)
			// 1. ����̹� �ε�
			throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver �ε�");
		// 2. DB����
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "c##scott";
		String pwd = "c##scott";

		// 3. statement �޾ƿ��� DB���� ->
		// DriverManager Ŭ������ getConnection() �޼ҵ� �̿�

		Connection con = DriverManager.getConnection(url, user, pwd);

		System.out.println("DB���� ���� : con" + con);

		// 4. sql�� �ۼ� 1->1�� ���� msg�� ���� "���õ� ��ſ� �Ϸ� �Ǽ��� " update ��
		// SQL�� �ۼ��ؼ� �ش� SQL���� �����Ű�� ���� Statement ��ü ������

		Statement stmt = con.createStatement();
		String sql = "update memo set msg = '���õ� ��ſ� �Ϸ� �Ǽ���~' where idx = 2";

		// 5. boolean excute(String sql) :��� sql���� �����Ų��.
		// int executeUpdate(String sql): DML����(insert/update/delete) �����Ų��.
		// : DML���忡 ���� ������� ���ڵ���� ��ȯ�Ѵ�.

		// boolean b = stmt.execute(sql);
		int b = stmt.executeUpdate(sql);
		System.out.println(b + "���� ���ڵ尡 ����Ǿ����ϴ�");
		// 6. DB�����ڿ� ��ȯ
		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();

	}

}
