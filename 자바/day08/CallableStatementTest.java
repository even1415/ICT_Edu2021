package day08;
import java.sql.*;
import jdbc.util.*;
import java.util.*;

public class CallableStatementTest {

	public static void main(String[] args) 
	throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("작성자 입력=>");
		String name=sc.next();
		sc.skip("\r\n");//엔터값 건너뛰기
		System.out.println("메시지 입력=>");
		String msg=sc.nextLine();
		System.out.println(name+"/"+msg);
		
		Connection con=DBUtil.getCon();
		//프로시저를 호출하려면  CallableStatement를 얻어와야 한다.
		
		String sql="{call memo_add(?,?)}";
		
		CallableStatement cstmt=con.prepareCall(sql);
		cstmt.setString(1, name);
		cstmt.setString(2, msg);
		int n=cstmt.executeUpdate();
		System.out.println(n+"개의 레코드를 삽입했어요");

		cstmt.close();
		con.close();
	}
	

}
