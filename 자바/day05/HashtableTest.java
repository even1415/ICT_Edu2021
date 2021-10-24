package day05;
import java.util.*;
/*Map계열
 * - Hashtable, HashMap
 * - Object유형을 저장할 수 있다
 * - key와 value값을 매핑하여 저장한다.
 * - key값의 중복을 허용하지 않음
 * - 무순서
 * - 데이터가 75%차면 자동으로 저장영역을 확대한다.
 * - 데이터 저장: Object put(Object key, Object value)
 * - 데이터 꺼내기: Object get(Object key)
 * 
 * */
public class HashtableTest {

	public static void main(String[] args) {
		Hashtable h=new Hashtable(20, 0.9f);
		//초기용량: 20, 90%가 차면 자동으로 저장 영역을 확대
		h.put("하나", Integer.valueOf(1));
		h.put("둘", 2);
		h.put("빨강", "Red");
		h.put("파랑", java.awt.Color.blue);
		System.out.println(h.size()+"개 저장");
		
		Integer i=(Integer)h.get("하나");
		System.out.println(i);
		
		java.awt.Color cr=(java.awt.Color)h.get("파랑");
		System.out.println(cr);
		System.out.println("------------------");
		//Generic사용 <Key값의 유형, Value값의 유형>
		Hashtable<String, Integer> h2=new Hashtable<>();
		h2.put("생년", 2000);
		h2.put("나이", 21);
		h2.put("연봉", Integer.valueOf(5000));
		//h2.put("나이", 33);
		//key값의 중복을 허용하지 않음. 나중에 저장한 값으로 덮어쓰기 함
		System.out.println("h2.size(): "+h2.size());
		System.out.println(h2.get("나이"));
		
		//key값들만 추출
		//Enumeration<K>	keys()
		System.out.println(h2.keys());
		//Set<K>	keySet()
		//key값들만 출력해보세요
		Enumeration <String> en = h2.keys();
		while(en.hasMoreElements()) {
			//System.out.println("keys : " + en.nextElement());
			String key=en.nextElement();
			Integer val=h2.get(key);
			System.out.println(key+": "+val);
		}
		System.out.println("---------------------------------------------------");
		Enumeration <Integer> en2 = h2.elements();
		while(en2.hasMoreElements()) {
			System.out.println("value : " + en2.nextElement());
		}
		System.out.println("************************************");
		
		Set<String> set=h2.keySet();
		/*
		Iterator<String> it=set.iterator();
		while(it.hasNext()) {
			String key=it.next();
			System.out.println(key);
		}
		*/
		for(String key:set)
			System.out.println(key);
		
		//value값들만 추출
		//Collection<V>	values()
		//Enumeration<V> elements()
		//value값들만 출력해보세요
		Collection<Integer> col=h2.values();
		for(Integer val:col)
			System.out.println(val);
	}

}




