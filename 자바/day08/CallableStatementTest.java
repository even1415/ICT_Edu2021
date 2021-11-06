package day08;
import java.sql.*;
import jdbc.util.*;
import java.util.*;

public class CallableStatementTest {

	public static void main(String[] args) 
	throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("�ۼ��� �Է�=>");
		String name=sc.next();
		sc.skip("\r\n");//���Ͱ� �ǳʶٱ�
		System.out.println("�޽��� �Է�=>");
		String msg=sc.nextLine();
		System.out.println(name+"/"+msg);
		
		Connection con=DBUtil.getCon();
		//���ν����� ȣ���Ϸ���  CallableStatement�� ���;� �Ѵ�.
		
		String sql="{call memo_add(?,?)}";
		
		CallableStatement cstmt=con.prepareCall(sql);
		cstmt.setString(1, name);
		cstmt.setString(2, msg);
		int n=cstmt.executeUpdate();
		System.out.println(n+"���� ���ڵ带 �����߾��");

		cstmt.close();
		con.close();
	}
	

}
