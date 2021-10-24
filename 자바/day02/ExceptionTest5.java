package day02;
import javax.swing.*;
import java.io.*;
/*  Exception
 * 		|
 * 	  IOException
 * 		+-----FileNotFoundException
 * [실습] 아래 발생된 예외를 try~catch절을 이용해 적절히 처리하세요
 * 
 * src/day02/ExceptionTest.java
 * C:\Users\ict01-00\Documents\면접족보-2021-08-31.txt
 * C:\Users\ict01-00\eclipse-workspace\java_09_14\src\CircleConstPI.java
 * */

public class ExceptionTest5 {

	public static void main(String[] args) {
		String fileName=JOptionPane.showInputDialog("읽을 파일명을 입력하세요");
		if(fileName==null) return;
		String str=reading(fileName);
		System.out.println(str);
	}
	
	public static String reading(String fname) {
		System.out.println("****"+fname+"**************");
		String content="";
		FileReader fr=null;
		char[] data=new char[1000];
		try {
			fr=new FileReader(fname);//FileNotFoundException
			
			fr.read(data,0,1000);//IOException
			//파일 내용은 data배열에 담긴다.
			fr.close();//IOException
		}catch(FileNotFoundException e) {
			System.out.println(fname+"파일을 찾을 수가 없어요");
		}catch(IOException e) {
			System.out.println("입출력 에러 발생: "+e);
		}
		
		content=new String(data);
		
		return content;
	}

}
