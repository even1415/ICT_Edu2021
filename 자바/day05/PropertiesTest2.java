package day05;
import java.util.*;
import java.io.*;
public class PropertiesTest2 {

	public static void main(String[] args) {
		//database.properties파일에 저장된 내용을 Properties객체로 옮겨보자.
		String file="src/day05/database.properties";
		try {
			//파일 읽는 클래스와 연결
			FileReader fr=new FileReader(file);
			
			Properties pr=new Properties();
			
			pr.load(fr);
			//database.properties파일에 저장된 key=value값들을 Properties객체에 옮긴다
			
			fr.close();
			System.out.println(pr.getProperty("DbType"));
			System.out.println(pr.getProperty("DbUser"));
			System.out.println(pr.getProperty("DbPwd"));
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		//[실습] 예외 처리한 후에 DbType과 DbUser명을 가져와 출력하세요
		

	}

}
