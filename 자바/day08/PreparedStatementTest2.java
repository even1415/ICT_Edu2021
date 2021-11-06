package day08;
import jdbc.util.*;
import java.sql.*;
import java.util.*;
public class PreparedStatementTest2 {
	

	public static void main(String[] args) throws SQLException{
		Scanner sc=new Scanner(System.in);
		System.out.println("검색할 사원의 이름을 입력=>");
		String findName=sc.next();
		
		
		Connection con=DBUtil.getCon();
		
		//select문 작성 where절에 name으로 검색
		String sql="select empno, ename, job, sal from emp where ename=?";
		
		//PreparedStatement얻어오기
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		//이름값 setter로 셋팅
		pstmt.setString(1, findName);
		
		//exeucuteQuery()로 실행==>ResultSet받아서
		ResultSet rs=pstmt.executeQuery();
		
		//반복문 돌면서 컬럼데이터 추출해서 출력하기
		// 사번(empno), 사원이름(ename), job, sal
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
