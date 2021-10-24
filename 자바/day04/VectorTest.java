package day04;
import java.util.*;
/*java.util.Vector클래스
 * - Collection중에서 List계열
 * - 특징: index번호를 붙여서 데이터를 관리함
 *        저장되는 데이터의 순서를 기억함
 *        중복 데이터 저장 가능
 * - 데이터가 꽉 차면 동적으로 저장 공간을 늘린다.
 *   cf>배열=> 고정 크기 => 저장영역 넘어가면 예외 발생
 * - 데이터 저장: add(Object o)
 * - 데이터 꺼내기 : Object get(int index), Object elementAt(int index)  
 * */
public class VectorTest {

	public static void main(String[] args) {
		//java 5버전 이후=> Generic 이용  
		//5이전 버전
		Vector v=new Vector(5, 3);//초기 용량: 5, 증가치: 3
		System.out.println("v.capacity(): "+v.capacity());
		System.out.println("v.size(): "+v.size());
		
		v.add("Hello");
		v.add(new Object());
		v.add(new Outer());
		v.add(10);//int형으로 저장되는 것이 아니라 Integer객체로 변환되어 저장 (auto boxing)
		v.add(Integer.valueOf(200));
		
		System.out.println("v.capacity() 2: "+v.capacity());
		System.out.println("v.size() 2: "+v.size());
		
		v.add(new String("Hi"));
		System.out.println("v.capacity() 3: "+v.capacity());
		System.out.println("v.size() 3: "+v.size());
		
		//Object get(int i) //인덱스번호는 0부터 시작
		String obj=(String)v.get(0);
		System.out.println(obj);
		//모두 대문자로 바꾸어 출력하기
		//toUpperCase()/toLowerCase()
		System.out.println(obj.toUpperCase());
		System.out.println(obj.toLowerCase());
		
		Outer ot=(Outer)v.get(2);
		System.out.println(ot.a);
		
		//Outer obj2=(Outer)v.get(0);
		//System.out.println(obj2);//[x] String형변환해야 함
		System.out.println("---------------------");
		//5.0이후 Generic을 이용
		//Vector<E>
		Vector<String> v2=new Vector<>();
		//v2에는 String유형만 저장하겠다는 의미. 다른 유형 저장하면 에러 발생함
		for(int i=1;i<6;i++)
			v2.add("Java "+i);
		
		System.out.println("v2.capacity(): "+v2.capacity());
		System.out.println("v2.size(): "+v2.size());
		//v2.add(new Object()); [x]
		v2.add(new String("Bye~~"));
		
		
		String s1=v2.get(5);
		System.out.println(s1);
		
		//v2에 저장된 요소(element)를 for루프이용해서 모두 출력해보세요
		for(int i=0;i<v2.size();i++)
			System.out.println(v2.elementAt(i));
		
		//Generic을 사용하면 Enhanced for루프 사용 가능
		for(String s:v2)
			System.out.println(s.toLowerCase());
		/*[문제] Float유형을 저장할 벡터 v3를 생성하고 
		 * 객체 3개이상 저장하세요.
		 * 그런 뒤 for루프 이용해서 출력하고, 그 합계값과 평균값도 구해 출력하세요
		 * */
		Vector<Float> v3 = new Vector<>();
		v3.add((float) 12.0);//auto boxing: float 자동으로 Float유형으로 변환되어 저장
		v3.add(12.0f);
		v3.add(Float.valueOf(12.1f));
		float sum = 0;
		float avg = 0;
		for(int i = 0; i < v3.size(); i++) {
			System.out.println(i + " : " + v3.get(i));
			sum += v3.get(i);//auto unboxing: Float유형이 float유형으로 자동 변환
		}
		avg = sum / v3.size();
		System.out.println("합계값 : " + sum);
		System.out.println("평균값 : " + avg);

	}

}



