package day07;
import java.sql.*;
public class MemoSelect {

	public static void main(String[] args) 
	throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("����̹� �ε� ����!");
		/* 1. OracleDriver��ü�� ����
		 * 2. DriverManager�� OracleDriver��ü�� ����Ѵ�.
		 *    DriverManager ==> ���� ���� ����̹����� �����Ѵ�. (Vector�� �����ؼ� ������)
		 * */
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "c##scott", pwd = "c##scott";
		
		Connection con=DriverManager.getConnection(url, user, pwd);
		System.out.println("DB���� ����!");
		
		Statement stmt=con.createStatement();
		
		String sql="select idx, name, msg, wdate from memo order by idx desc";
		//select���� ���=> ResultSet executeQuery(String sql)
		//ResultSet=> ��� ���̺��� �����Ѵ�.
		/* ResultSet�� select���� ���� ������� ��� ���̺��� �����Ѵ�.
		 * - ������ Ŀ���� �̵���Ű�� ������� �����͸� �����Ѵ�.
		 * - ������ Ŀ���� ù��° ���� ������ ��ġ�ϰ� �ִٰ� (before first)
		 *   next()�޼ҵ尡 ȣ��Ǹ� Ŀ���� ���� ĭ���� �̵���Ű��, �̵��� ��ġ��
		 *   ���ڵ尡 �ִٸ� true�� ��ȯ�Ѵ�.
		 *   boolean next()
		 *   ������ �������� rs.getXXX("�÷���"), rs.getXXX(�÷��ε���)
		 * */
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			int idx=rs.getInt("idx");//number ==> rs.getInt("�÷���"), rs.getFloat(),rs.getDouble()
			String name=rs.getString("name");//varchar2, char => rs.getString()
			String msg=rs.getString("msg");
			java.sql.Date wdate=rs.getDate("wdate");//date => rs.getDate()
			System.out.println(idx+"\t"+name+"\t"+msg+"\t"+wdate);
		}//while-----
		
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(con!=null) con.close();

	}//main()

}//class
