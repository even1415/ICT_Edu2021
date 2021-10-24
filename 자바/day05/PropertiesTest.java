package day05;
/*Dictionary
 * 	+---Hashtable
 * 			+---Properties
 * -Map계열
 * -key,value매핑해서 저장
 * - 데이터 저장: setProperty(String key, String value[, String defaultValue])
 * - 데이터 꺼내기: String getProperty(String key)
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
		//[1] 사용가능한 언어 꺼내 출력하세요
		System.out.println(p.getProperty("Lang"));
		
		//[2] #을 기준으로 문자열을 쪼개어 Java SQL HTML JavaScript로 출력해보기
		// split() 참조
		String str=p.getProperty("Lang");
		String[] tokens=str.split("#");
		if(tokens!=null) {
			for(String tk: tokens)
				System.out.println(tk);
		}
	}
}
