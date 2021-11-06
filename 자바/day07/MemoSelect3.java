package day07;
import java.sql.*;
import javax.swing.*;

public class MemoSelect3 {

   public static void main(String[] args)
   throws Exception
   {
      String keyword = JOptionPane.showInputDialog("검색할 메모내용(msg)의 키워드를 입력하세요");
      if(keyword == null) return;
      //1. 드라이버 로딩
      Class.forName("oracle.jdbc.driver.OracleDriver");
      System.out.println("드라이버 로딩 성공!!!!!");
      
      String url = "jdbc:oracle:thin:@localhost:1521:XE";
      String user = "c##scott", pwd = "c##scott";   
      
      //2. DB연결
      Connection con = DriverManager.getConnection(url, user, pwd);
      System.out.println("DB연결 성공!!!!!!");
      
      //3. stmt얻기
      Statement stmt = con.createStatement();
      
      //4. select문 where절에 like검색
      String sql = "select idx, name, msg, wdate from memo where msg like '%"+ keyword +"%'";

      
      //5. rs받기=> 
      ResultSet rs=stmt.executeQuery(sql);
            
      //6. 반복문 돌면서 출력
      while(rs.next()) {
    	  int idx=rs.getInt(1);
    	  String name=rs.getString(2);
    	  String msg=rs.getString(3);
    	  String wdate=rs.getString(4);
    	  System.out.println(idx+"\t"+name+"\t"+msg+"\t"+wdate);
      }
      //7. DB연결 자원 반납
      rs.close();
      stmt.close();
      if(con!=null) con.close();   
   }
}