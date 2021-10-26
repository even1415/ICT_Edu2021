package day06;
import java.sql.*;
import javax.swing.*;
/*DBMS: Oracle
 * 
 * �뿪��: JDBC DRIVER ==>��ġ�ؾ� ��. DBMS�翡�� �ٿ�ε� �޾ƾ� ��
 * 						�츮 ��ǻ�� ���ÿ� oracle��ġ==> ��ġ�� ���� jdbc driver������ 
 * 
 * 
 *���α׷�: Java 
 * 
 * ������Ʈ(MyJava)=>��Ŭ�� > Configure Build Path > Library�� ���� 
 * > Classpath ������ > add External Jars �����Ͽ�
 * odjbc8.jar�� �߰��Ѵ�.
 * */

public class JDBCTest {

	public static void main(String[] args) {
		
		String name=JOptionPane.showInputDialog("�ۼ��ڸ� �Է��ϼ���");
		if(name==null) return;
		
		String msg=JOptionPane.showInputDialog("�޽����� �Է��ϼ���");
		if(msg==null) return;
		
		
		//����̹� �ε�==> Class.forName()�޼ҵ� �̿��Ѵ�.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
					//��Ű����.Ŭ������ ==> ����Ŭ����̹�
			System.out.println("Driver Loading����!!");
			
			//DB�� �����ϱ� ���� �������� ����
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="c##scott";
			String pwd="c##scott";
			
			//DB���� ==> DriverManagerŬ������ getConnection()�޼ҵ带 �̿�
			Connection con = DriverManager.getConnection(url,user, pwd);
			System.out.println("DB���� ����!!: con="+con);
			
			//SQL�� �ۼ��ؼ� �ش� SQL���� �����Ű�� ���� Statement��ü ������
			Statement stmt = con.createStatement();
			
			//SQL�� �ۼ�
			String sql="insert into memo(idx, name, msg, wdate) "
						+" values(memo_seq.nextval,'"+name+"','"+msg+"',sysdate)";
			//SQL���� �����Ű��
			//boolean execute(String sql)
			/*sql��(query��)�� �����Ű�� �޼ҵ�
			 * ��ȯ���� sql���� select���̸� true�� ��ȯ�ϰ�,
			 * select���� �ƴ� �����̸� false�� ��ȯ�Ѵ�.
			 * */
			boolean b=stmt.execute(sql);
			System.out.println("b="+b);
			
			if(stmt!=null) stmt.close();
			
			if(con!=null) con.close();//DB���� �ڿ� �ݳ� (�ſ� �߿��� �ڵ�)
		}catch(ClassNotFoundException e) {
			System.out.println("Driver�� ��ġ���� �ʾҰų� ����̹����� Ʋ�Ⱦ��");
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}



