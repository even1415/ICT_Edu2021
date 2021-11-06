package day08;
import jdbc.util.*;
import java.sql.*;
import java.util.*;
public class PreparedStatementTest3 {

	public static void main(String[] args) 
	throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("�˻��� ����� �̸��� �Է��ϼ���(keyword)");
		String keyword=sc.next();
		System.out.println("�˻� Ű����: "+keyword); //like���� ���� select��
		Connection con=DBUtil.getCon();
		
//		String sql="select empno, ename, job, e.deptno, dname from emp e";
//			   sql+=" join dept d on e.deptno=d.deptno ";
//			   sql+=" where ename like ?";
//			   System.out.println(sql);
//			   
//			   String sql = "select empno, ename, job, dept.deptno, dname" 
//			            + " from emp "
//					    + " join dept on emp.deptno = dept.deptno"
//			            + " where ename like ? "
//					    + " order by dept.deptno asc";
		String sql = "select empno, ename, job, deptno, dname from emp join dept "
				   + " using(deptno) where ename like  ? order by deptno asc";

		
		//PreparedStatement�� ���
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, "%"+keyword+"%");
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			int empno=rs.getInt(1);
			String ename=rs.getString(2);
			String job=rs.getString(3);
			int deptno=rs.getInt(4);
			String dname=rs.getString(5);
			System.out.println(empno+"\t"+ename+"\t"+job+"\t"+deptno+"\t"+dname);
		}
		rs.close(); ps.close(); con.close();
	}

}
