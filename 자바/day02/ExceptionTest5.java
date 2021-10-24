package day02;
import javax.swing.*;
import java.io.*;
/*  Exception
 * 		|
 * 	  IOException
 * 		+-----FileNotFoundException
 * [�ǽ�] �Ʒ� �߻��� ���ܸ� try~catch���� �̿��� ������ ó���ϼ���
 * 
 * src/day02/ExceptionTest.java
 * C:\Users\ict01-00\Documents\��������-2021-08-31.txt
 * C:\Users\ict01-00\eclipse-workspace\java_09_14\src\CircleConstPI.java
 * */

public class ExceptionTest5 {

	public static void main(String[] args) {
		String fileName=JOptionPane.showInputDialog("���� ���ϸ��� �Է��ϼ���");
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
			//���� ������ data�迭�� ����.
			fr.close();//IOException
		}catch(FileNotFoundException e) {
			System.out.println(fname+"������ ã�� ���� �����");
		}catch(IOException e) {
			System.out.println("����� ���� �߻�: "+e);
		}
		
		content=new String(data);
		
		return content;
	}

}
