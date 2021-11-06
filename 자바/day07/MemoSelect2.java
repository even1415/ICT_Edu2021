package day07;
import java.sql.*;
import javax.swing.*;

public class MemoSelect2 {

   public static void main(String[] args)
   throws Exception
   {
      String name1 = JOptionPane.showInputDialog("검색할 작성자를 입력하세요");
      if(name1 == null) return;
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
      
      //4. select문 => 검색(where절을 갖는)
      String sql = "select idx, name, msg, wdate from memo where name = '"+name1+"'";
      
      //5. select문 실행 => executeQuery()
      ResultSet rs = stmt.executeQuery(sql);
      
      //6. 반복문 돌면서 커서 이동시켜 데이터 꺼내 출력
      while(rs.next()) {
         int idx = rs.getInt(1); //number ==> rs.getInt("컬럼명"), rs.getFloat(),rs.getDouble() 
         String name = rs.getString(2); //varchar2, char => rs.getString("컬럼명")
         String msg = rs.getString(3); 
         java.sql.Date wdate = rs.getDate(4); //date => rs.getDate("컬럼명")
         System.out.println(idx + "\t" + name + "\t" + msg + "\t" + wdate);
      } //while---------
      
      //7. DB연결 자원 반납
      if(rs!=null) rs.close();
      if(stmt!=null) stmt.close();
      if(con!=null) con.close();   
   }
}