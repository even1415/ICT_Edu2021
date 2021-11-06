package day07;

import java.sql.*;
import javax.swing.*;

public class MemoDelete {

	public static void main(String[] args) throws Exception {

		String name = JOptionPane.showInputDialog("������ ���� �ۼ��ڸ��� �Է��ϼ���");
		if (name == null)
			return;
		// 1. ����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loading Success!");

		// 2. DB����
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "c##scott", pwd = "c##scott";

		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("DB���� ����!");

		// 3. stmt������
		Statement stmt = con.createStatement();

		// 4. sql�� �ۼ�=> delete�� (�ۼ��ڷ� ����)
		String sql="delete from memo where name ='"+name+"'";

		// 5. executeUpdate()�� �����Ű��
		int n=stmt.executeUpdate(sql);
		if(n>0)
		// 6. ��� ���� �����Ǿ����� ����Ͻ�
			System.out.println(n+"���� ���� �����߽��ϴ�");
		else
			System.out.println(name+"���� ���� �����");
		
		
		// 7. db�����ڿ� �ݳ�
		if(stmt!=null) stmt.close();
		if(con!=null) con.close();

	}

}
