package day08;
import jdbc.util.*;
import java.sql.*;
import java.util.*;
public class PreparedStatementTest2 {
	

	public static void main(String[] args) throws SQLException{
		Scanner sc=new Scanner(System.in);
		System.out.println("�˻��� ����� �̸��� �Է�=>");
		String findName=sc.next();
		
		
		Connection con=DBUtil.getCon();
		
		//select�� �ۼ� where���� name���� �˻�
		String sql="select empno, ename, job, sal from emp where ename=?";
		
		//PreparedStatement������
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		//�̸��� setter�� ����
		pstmt.setString(1, findName);
		
		//exeucuteQuery()�� ����==>ResultSet�޾Ƽ�
		ResultSet rs=pstmt.executeQuery();
		
		//�ݺ��� ���鼭 �÷������� �����ؼ� ����ϱ�
		// ���(empno), ����̸�(ename), job, sal
		while(rs.next()) {
			int empno=rs.getInt("empno");
			String ename=rs.getString("ename");
			String job=rs.getString("job");
			int sal=rs.getInt("sal");
			System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal);
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) con.close();
	}

}
