package day06;
/*- HashSet
 *  Set�迭
 *   - ������ ������� ����
 *   - ������ �ߺ��� ������� ����
 *   - �ؽü��� ��ü�� �����ϱ� ���� ��ü�� hashCode()�� ȣ���ؼ�
 *   �ؽ��ڵ带 ����. �׸��� �̹� ����Ǿ� �ִ� ��ü���� �ؽ��ڵ��
 *   ���Ѵ�. ���� ������ �ؽ��ڵ尡 �ִٸ� �ٽ� equals()�޼ҵ��
 *   �� ��ü�� ���ؼ� true�� ������ ������ ��ü�� �Ǵ��ϰ�
 *   �ߺ� ������ ���� �ʴ´�.
 * */
import java.util.*;
public class HashSetTest {

	public static void main(String[] args) {
		HashSet<String> set=new HashSet<>();
		//add() : ������ ����
		set.add("Java");
		set.add("SQL");
		set.add("JDBC");
		set.add("JSP");
		//size(): ����� ������ ��
		System.out.println("set.size(): "+set.size());
		set.add("Java");
		System.out.println("set.size() 2: "+set.size());
		
		//iterator()�̿��ؼ� set�� ����� ���� �Ѳ����� ����ϱ�
		Iterator<String> it=set.iterator();
		while(it.hasNext()) {
			String str=it.next();
			System.out.println(str);
		}
		
		//remove(E e) :  ����
		set.remove("JDBC");
		System.out.println("--------------");
		//for each������ �̿��ؼ� ����غ���
		for(String s:set)
			System.out.println(s);
		System.out.println("***************");
		set.clear();//removeAll()
		System.out.println("set.size() 3: "+set.size());
		if(set.isEmpty())
			System.out.println("��� �־��");
		
		Object o=new Object();
		System.out.println(o);
	}

}
