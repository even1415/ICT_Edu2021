package day09;
import java.sql.*;
import jdbc.util.*;
/*��� �޸���� �������� ���ν����� ȣ���غ���.
 -------------------------------------
 CREATE OR REPLACE PROCEDURE MEMO_ALL
(MYCR OUT SYS_REFCURSOR )
IS
BEGIN
    OPEN MYCR 
    FOR 
    SELECT IDX, NAME, MSG, WDATE
    FROM MEMO
    ORDER BY IDX DESC;
END;
/
-------------------------------------
 * */

public class CallableStatementTest3 {

	public static void main(String[] args) 
	throws Exception
	{
		Connection con=DBUtil.getCon();
		String sql="{call memo_all(?)}";
		
		CallableStatement cs=con.prepareCall(sql);
		//�ƿ� �Ķ���Ͱ� ����==> registerOutParameter(�ε���, sqltype)
		cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
		
		cs.execute();
		
		ResultSet rs=(ResultSet)cs.getObject(1);
		
		while(rs.next()) {
			int idx=rs.getInt("idx");
			String name=rs.getString("name");
			String msg=rs.getString("msg");
			Date wdate=rs.getDate("wdate");
			System.out.println(idx+"\t"+name+"\t"+wdate+"\t"+msg);
		}
		rs.close();
		cs.close();
		con.close();
	}

}




