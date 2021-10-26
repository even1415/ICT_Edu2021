package day06;
import java.util.*;
/*Member클래스의 객체 : VO, DTO,  도메인(domain) 객체
 * ==> HashSet에 저장 
 * 		"홍길동", 22
 * 		"김길동", 23
 * 		"홍길동", 23
 *      "홍길동", 22
 *      
 *  - 해시셋은 객체를 저장하기 전에 객체의 hashCode()를 호출해서
 *   해시코드를 얻어낸다. 그리고 이미 저장되어 있는 객체들의 해시코드와
 *   비교한다. 만약 동일한 해시코드가 있다면 다시 equals()메소드로
 *   두 객체를 비교해서 true가 나오면 동일한 객체로 판단하고
 *   중복 저장을 하지 않는다
 * */

public class HashSetTest2 {

	public static void main(String[] args) {
		// Member객체 4개 생성해서 HashSet에 저장하세요
		Member m1=new Member("홍길동",22);
		Member m2=new Member("김길동",23);
		Member m3=new Member("홍길동",25);
		Member m4=new Member("홍길동",22);
		// HashSet에 저장된 회원의 이름, 나이를 한꺼번에 출력하세요
		Set<Member> set=new HashSet<>();
		set.add(m1);
		set.add(m2);
		set.add(m3);
		set.add(m4);
		System.out.println("set.size(): "+set.size());
		System.out.println(m1.hashCode());
		System.out.println(m4.hashCode());
		System.out.println("m1.equals(m2): "+m1.equals(m2));
		System.out.println("m1.equals(m4): "+m1.equals(m4));
		
		for(Member user:set)
			System.out.println(user.name+": "+user.age);

	}

}
