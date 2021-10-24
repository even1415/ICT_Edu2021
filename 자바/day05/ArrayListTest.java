package day05;
import java.util.*;
/*ArrayList
 *  - java.util.List계열
 *  - Vector와 기능은 동일
 *  - 단 벡터는 메소드들이 동기화가 구현된 반면
 *    ArrayList는 동기화되어 있지 않음=> 웹에서 많이 사용됨
 * */
public class ArrayListTest {

	public static void main(String[] args) {
		
		ArrayList<String> arrList=new ArrayList<>();
		arrList.add("Java");
		arrList.add("HTML");
		arrList.add("JavaScript");
		arrList.add("JSP");
		
		String str=arrList.get(3);
		System.out.println(str);
		//iterator()메소드 이용해서 arrList에 저장된 요소들을 한꺼번에 출력하세요
		Iterator<String> it=arrList.iterator();
		while(it.hasNext()) {
			String str2=it.next();
			System.out.println(str2);
		}
		
		System.out.println("arrList.size(): "+arrList.size());
		

	}

}
