package day05;
import java.util.*;
import java.io.*;
public class PropertiesTest2 {

	public static void main(String[] args) {
		//database.properties���Ͽ� ����� ������ Properties��ü�� �Űܺ���.
		String file="src/day05/database.properties";
		try {
			//���� �д� Ŭ������ ����
			FileReader fr=new FileReader(file);
			
			Properties pr=new Properties();
			
			pr.load(fr);
			//database.properties���Ͽ� ����� key=value������ Properties��ü�� �ű��
			
			fr.close();
			System.out.println(pr.getProperty("DbType"));
			System.out.println(pr.getProperty("DbUser"));
			System.out.println(pr.getProperty("DbPwd"));
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		//[�ǽ�] ���� ó���� �Ŀ� DbType�� DbUser���� ������ ����ϼ���
		

	}

}
