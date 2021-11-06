package day07;
import java.sql.*;
import jdbc.util.*;
import java.util.*;
/* Statement
 * 		+---PreparedStatement/CallableStatement
 * sql������ dbms���˿� �°� �̸� ������ ���� �غ��� �δ� Ŭ���� 
 * Statement�� �̿��� ������ ������ �ξ� ����
 * */

public class PreparedStatementTest {

	public static void main(String[] args) 
	throws Exception
	{
		Connection con=DBUtil.getCon();
		System.out.println("con: "+con);
		//dept���̺� 50 Development Seoul �����͸� �����غ��ô�.
		Scanner sc=new Scanner(System.in);
		
		System.out.println("�μ���ȣ �Է�=>");
		int deptno=sc.nextInt();
		
		System.out.println("�μ��� �Է�=>");
		String dname=sc.next();
		
		System.out.println("�μ� ��ġ �Է�=>");
		String loc=sc.next();
		System.out.println(deptno+"/"+dname+"/"+loc);
		
		//Statement stmt=con.createStatement();
		String sql="insert into dept(deptno,dname,loc) values(?,?,?)";
		//? : In Parameter
		PreparedStatement pstmt=con.prepareStatement(sql);
		//�� �Ķ����(?)�� ������ sql������ db���˿� �°� ��ó��(������) ���ѵд�.
		//executeXXX()�ϱ� ���� ?���� setting�� �ؾ� ��
		pstmt.setInt(1, deptno);
		pstmt.setString(2, dname);
		pstmt.setString(3, loc);
		
		int n=pstmt.executeUpdate();
		//int n=stmt.executeUpdate(sql);
		System.out.println(n+"���� ���ڵ带 �����߾��");
		
		pstmt.close();
		con.close();

	}

}
