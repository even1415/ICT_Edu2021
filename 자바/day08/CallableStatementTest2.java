package day08;
import java.sql.*;
import javax.swing.*;
import jdbc.util.*;
/*
=============================================
CREATE OR REPLACE PROCEDURE MEMO_UPDATE
(PIDX IN MEMO.IDX%TYPE, PMSG IN MEMO.MSG%TYPE)
IS BEGIN 
UPDATE MEMO SET MSG = PMSG WHERE IDX = PIDX;
END;
/
============================================= 
 * */
public class CallableStatementTest2 {
	public static void main(String[] args) 	throws SQLException	{
		String idx = JOptionPane.showInputDialog("수정할 글 번호를 입력하세요");
		String msg = JOptionPane.showInputDialog("수정할 글 내용을 입력하세요");		
		Connection con = DBUtil.getCon();		
		String sql = "{call memo_update(?,?)}";		
		java.sql.CallableStatement cs = con.prepareCall(sql);
		cs.setString(1, idx);
		cs.setString(2, msg);		
		int n = cs.executeUpdate();
		System.out.println(n + "개의 레코를 수정했어요");		
		if(cs != null) cs.close();
		if(con != null) con.close();

	}
}
