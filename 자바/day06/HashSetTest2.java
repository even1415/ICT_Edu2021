package day06;
import java.util.*;
/*MemberŬ������ ��ü : VO, DTO,  ������(domain) ��ü
 * ==> HashSet�� ���� 
 * 		"ȫ�浿", 22
 * 		"��浿", 23
 * 		"ȫ�浿", 23
 *      "ȫ�浿", 22
 *      
 *  - �ؽü��� ��ü�� �����ϱ� ���� ��ü�� hashCode()�� ȣ���ؼ�
 *   �ؽ��ڵ带 ����. �׸��� �̹� ����Ǿ� �ִ� ��ü���� �ؽ��ڵ��
 *   ���Ѵ�. ���� ������ �ؽ��ڵ尡 �ִٸ� �ٽ� equals()�޼ҵ��
 *   �� ��ü�� ���ؼ� true�� ������ ������ ��ü�� �Ǵ��ϰ�
 *   �ߺ� ������ ���� �ʴ´�
 * */

public class HashSetTest2 {

	public static void main(String[] args) {
		// Member��ü 4�� �����ؼ� HashSet�� �����ϼ���
		Member m1=new Member("ȫ�浿",22);
		Member m2=new Member("��浿",23);
		Member m3=new Member("ȫ�浿",25);
		Member m4=new Member("ȫ�浿",22);
		// HashSet�� ����� ȸ���� �̸�, ���̸� �Ѳ����� ����ϼ���
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
