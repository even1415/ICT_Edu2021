package day07;
import java.sql.*;
import javax.swing.*;

public class MemoSelect3 {

   public static void main(String[] args)
   throws Exception
   {
      String keyword = JOptionPane.showInputDialog("�˻��� �޸𳻿�(msg)�� Ű���带 �Է��ϼ���");
      if(keyword == null) return;
      //1. ����̹� �ε�
      Class.forName("oracle.jdbc.driver.OracleDriver");
      System.out.println("����̹� �ε� ����!!!!!");
      
      String url = "jdbc:oracle:thin:@localhost:1521:XE";
      String user = "c##scott", pwd = "c##scott";   
      
      //2. DB����
      Connection con = DriverManager.getConnection(url, user, pwd);
      System.out.println("DB���� ����!!!!!!");
      
      //3. stmt���
      Statement stmt = con.createStatement();
      
      //4. select�� where���� like�˻�
      String sql = "select idx, name, msg, wdate from memo where msg like '%"+ keyword +"%'";

      
      //5. rs�ޱ�=> 
      ResultSet rs=stmt.executeQuery(sql);
            
      //6. �ݺ��� ���鼭 ���
      while(rs.next()) {
    	  int idx=rs.getInt(1);
    	  String name=rs.getString(2);
    	  String msg=rs.getString(3);
    	  String wdate=rs.getString(4);
    	  System.out.println(idx+"\t"+name+"\t"+msg+"\t"+wdate);
      }
      //7. DB���� �ڿ� �ݳ�
      rs.close();
      stmt.close();
      if(con!=null) con.close();   
   }
}