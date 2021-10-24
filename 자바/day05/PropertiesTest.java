package day05;
/*Dictionary
 * 	+---Hashtable
 * 			+---Properties
 * -Map�迭
 * -key,value�����ؼ� ����
 * - ������ ����: setProperty(String key, String value[, String defaultValue])
 * - ������ ������: String getProperty(String key)
 * 
 * */
import java.util.*;
public class PropertiesTest {

	public static void main(String[] args) {
		Properties p=new Properties();
		p.setProperty("OS","Windows");
		p.setProperty("DBMS", "Oracle");
		p.setProperty("Lang", "Java#SQL#HTML#JavaScript");
		
		Object val=p.get("OS");
		System.out.println(val);
		
		String val2=p.getProperty("DBMS");
		System.out.println(val2);
		//[1] ��밡���� ��� ���� ����ϼ���
		System.out.println(p.getProperty("Lang"));
		
		//[2] #�� �������� ���ڿ��� �ɰ��� Java SQL HTML JavaScript�� ����غ���
		// split() ����
		String str=p.getProperty("Lang");
		String[] tokens=str.split("#");
		if(tokens!=null) {
			for(String tk: tokens)
				System.out.println(tk);
		}
	}
}
