package day07;
import java.sql.*;
import jdbc.util.*;
import java.util.*;
/* Statement
 * 		+---PreparedStatement/CallableStatement
 * sql문장을 dbms포맷에 맞게 미리 컴파일 시켜 준비해 두는 클래스 
 * Statement를 이용할 때보다 성능이 훨씬 좋음
 * */

public class PreparedStatementTest {

	public static void main(String[] args) 
	throws Exception
	{
		Connection con=DBUtil.getCon();
		System.out.println("con: "+con);
		//dept테이블에 50 Development Seoul 데이터를 삽입해봅시다.
		Scanner sc=new Scanner(System.in);
		
		System.out.println("부서번호 입력=>");
		int deptno=sc.nextInt();
		
		System.out.println("부서명 입력=>");
		String dname=sc.next();
		
		System.out.println("부서 위치 입력=>");
		String loc=sc.next();
		System.out.println(deptno+"/"+dname+"/"+loc);
		
		//Statement stmt=con.createStatement();
		String sql="insert into dept(deptno,dname,loc) values(?,?,?)";
		//? : In Parameter
		PreparedStatement pstmt=con.prepareStatement(sql);
		//인 파라미터(?)를 제외한 sql문장을 db포맷에 맞게 전처리(컴파일) 시켜둔다.
		//executeXXX()하기 전에 ?값을 setting을 해야 함
		pstmt.setInt(1, deptno);
		pstmt.setString(2, dname);
		pstmt.setString(3, loc);
		
		int n=pstmt.executeUpdate();
		//int n=stmt.executeUpdate(sql);
		System.out.println(n+"개의 레코드를 삽입했어요");
		
		pstmt.close();
		con.close();

	}

}
