package day05;
import java.util.*;
/*Map�迭
 * - Hashtable, HashMap
 * - Object������ ������ �� �ִ�
 * - key�� value���� �����Ͽ� �����Ѵ�.
 * - key���� �ߺ��� ������� ����
 * - ������
 * - �����Ͱ� 75%���� �ڵ����� ���念���� Ȯ���Ѵ�.
 * - ������ ����: Object put(Object key, Object value)
 * - ������ ������: Object get(Object key)
 * 
 * */
public class HashtableTest {

	public static void main(String[] args) {
		Hashtable h=new Hashtable(20, 0.9f);
		//�ʱ�뷮: 20, 90%�� ���� �ڵ����� ���� ������ Ȯ��
		h.put("�ϳ�", Integer.valueOf(1));
		h.put("��", 2);
		h.put("����", "Red");
		h.put("�Ķ�", java.awt.Color.blue);
		System.out.println(h.size()+"�� ����");
		
		Integer i=(Integer)h.get("�ϳ�");
		System.out.println(i);
		
		java.awt.Color cr=(java.awt.Color)h.get("�Ķ�");
		System.out.println(cr);
		System.out.println("------------------");
		//Generic��� <Key���� ����, Value���� ����>
		Hashtable<String, Integer> h2=new Hashtable<>();
		h2.put("����", 2000);
		h2.put("����", 21);
		h2.put("����", Integer.valueOf(5000));
		//h2.put("����", 33);
		//key���� �ߺ��� ������� ����. ���߿� ������ ������ ����� ��
		System.out.println("h2.size(): "+h2.size());
		System.out.println(h2.get("����"));
		
		//key���鸸 ����
		//Enumeration<K>	keys()
		System.out.println(h2.keys());
		//Set<K>	keySet()
		//key���鸸 ����غ�����
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
		
		//value���鸸 ����
		//Collection<V>	values()
		//Enumeration<V> elements()
		//value���鸸 ����غ�����
		Collection<Integer> col=h2.values();
		for(Integer val:col)
			System.out.println(val);
	}

}




