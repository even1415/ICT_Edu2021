package day04;
import java.util.*;
public class VectorTest2 {

	public static void main(String[] args) {
		//[1] Person객체를 3개 생성하기(이름,나이 값 할당)
		Person person1 = new Person("홍길동", 20);
		Person person2 = new Person("김철수", 22);
		Person person3 = new Person("박영희", 30);

		
		//[2] Person객체를 저장할 Vector생성하기=>v
		//[3] v에 [1]에서 생성한 객체 3개 저장하기
		Vector<Person> v=new Vector<>();
		v.add(person1);
		v.add(person2);
		v.add(person3);
		
		
		//[4] for루프 이용해서 v에 저장된 Person의 이름과 나이를 출력하세요
		for(int i=0;i<v.size();i++) {
			Person p=v.get(i);
			System.out.println(p.getName()+": "+p.getAge()+"세");
		}
		//Enumeration<E>	elements()
		Enumeration<Person> en = v.elements();
		
		while(en.hasMoreElements()) {
			Person p=en.nextElement();
			System.out.println(p.getName()+"#"+p.getAge());
		}
		
		
		//Iterator<E>	iterator()
		
		/* 
		 * Enumeration이나 Iterator 들은 객체들을 집합체로 관리해주는 인터페이스이다.
		 *   이들 인터페이스에는 각각의 객체들을 한 순간에 하나씩 처리할 수 있는 메소드를 제공한다.
		 *   (논리적 커서가 존재하여 커서를 이동하면서 데이터를 꺼내올 수 있다.)
		 *   -논리적 커서는 첫번째 요소 직전(before First)에 위치한다.
		 *   1. Enumeration의 주요 메소드
		 *   	- boolean hasMoreElements(): 논리적 커서가 위치하는 곳 이후에 요소들이 있는지
		 *   			여부를 묻는다. 요소들이 있으면 true를 반환하고 없으면 false를 반환한다.
		 *      - E  nextElement() : 논리적 커서를 다음으로 이동시키고 가리키고 있는 지점의 요소를
		 *      			반환한다.
		 *  2.  Iterator 주요 메소드
		 *     - boolean hasNext()
		 *     - E next();  
		 *    
		 * */
		//iterator()메소드를 이용해서 v에 저장된 요소들의 이름을 한꺼번에 출력하세요
		Iterator<Person> ir=v.iterator();
		for(int i=1;ir.hasNext();i++) {
			Person p=ir.next();
			System.out.println(i+":"+p.getName());
		}
		
		ir=v.iterator();
		for(;ir.hasNext();) {
			Person p=ir.next();
			System.out.println(p.getName());
		}
		//void	copyInto(Object[] anArray):벡터에 저장된 요소들을 배열에 카피해주는 기능
		//v에 저장된 요소들을 1차원 배열에 카피한 뒤에 확장for루프 이용해서 "이름@나이" 출력하세요
		
		Person[] arr=new Person[v.size()];
		v.copyInto(arr);
		
		for(Person pe:arr)
			System.out.println(pe.getName()+"@"+pe.getAge());
	}
}
//List계열
//ArrayList : 동기화(synchronized)가 되어 있지 않음
//Vector : 동기화가 구현되어 있음
//Map계열, Set계열

