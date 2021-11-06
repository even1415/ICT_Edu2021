package day07;
import java.sql.*;
import javax.swing.*;

public class MemoSelect2 {

   public static void main(String[] args)
   throws Exception
   {
      String name1 = JOptionPane.showInputDialog("�˻��� �ۼ��ڸ� �Է��ϼ���");
      if(name1 == null) return;
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
      
      //4. select�� => �˻�(where���� ����)
      String sql = "select idx, name, msg, wdate from memo where name = '"+name1+"'";
      
      //5. select�� ���� => executeQuery()
      ResultSet rs = stmt.executeQuery(sql);
      
      //6. �ݺ��� ���鼭 Ŀ�� �̵����� ������ ���� ���
      while(rs.next()) {
         int idx = rs.getInt(1); //number ==> rs.getInt("�÷���"), rs.getFloat(),rs.getDouble() 
         String name = rs.getString(2); //varchar2, char => rs.getString("�÷���")
         String msg = rs.getString(3); 
         java.sql.Date wdate = rs.getDate(4); //date => rs.getDate("�÷���")
         System.out.println(idx + "\t" + name + "\t" + msg + "\t" + wdate);
      } //while---------
      
      //7. DB���� �ڿ� �ݳ�
      if(rs!=null) rs.close();
      if(stmt!=null) stmt.close();
      if(con!=null) con.close();   
   }
}