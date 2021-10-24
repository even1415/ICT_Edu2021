package day04;
import java.util.*;
/*java.util.VectorŬ����
 * - Collection�߿��� List�迭
 * - Ư¡: index��ȣ�� �ٿ��� �����͸� ������
 *        ����Ǵ� �������� ������ �����
 *        �ߺ� ������ ���� ����
 * - �����Ͱ� �� ���� �������� ���� ������ �ø���.
 *   cf>�迭=> ���� ũ�� => ���念�� �Ѿ�� ���� �߻�
 * - ������ ����: add(Object o)
 * - ������ ������ : Object get(int index), Object elementAt(int index)  
 * */
public class VectorTest {

	public static void main(String[] args) {
		//java 5���� ����=> Generic �̿�  
		//5���� ����
		Vector v=new Vector(5, 3);//�ʱ� �뷮: 5, ����ġ: 3
		System.out.println("v.capacity(): "+v.capacity());
		System.out.println("v.size(): "+v.size());
		
		v.add("Hello");
		v.add(new Object());
		v.add(new Outer());
		v.add(10);//int������ ����Ǵ� ���� �ƴ϶� Integer��ü�� ��ȯ�Ǿ� ���� (auto boxing)
		v.add(Integer.valueOf(200));
		
		System.out.println("v.capacity() 2: "+v.capacity());
		System.out.println("v.size() 2: "+v.size());
		
		v.add(new String("Hi"));
		System.out.println("v.capacity() 3: "+v.capacity());
		System.out.println("v.size() 3: "+v.size());
		
		//Object get(int i) //�ε�����ȣ�� 0���� ����
		String obj=(String)v.get(0);
		System.out.println(obj);
		//��� �빮�ڷ� �ٲپ� ����ϱ�
		//toUpperCase()/toLowerCase()
		System.out.println(obj.toUpperCase());
		System.out.println(obj.toLowerCase());
		
		Outer ot=(Outer)v.get(2);
		System.out.println(ot.a);
		
		//Outer obj2=(Outer)v.get(0);
		//System.out.println(obj2);//[x] String����ȯ�ؾ� ��
		System.out.println("---------------------");
		//5.0���� Generic�� �̿�
		//Vector<E>
		Vector<String> v2=new Vector<>();
		//v2���� String������ �����ϰڴٴ� �ǹ�. �ٸ� ���� �����ϸ� ���� �߻���
		for(int i=1;i<6;i++)
			v2.add("Java "+i);
		
		System.out.println("v2.capacity(): "+v2.capacity());
		System.out.println("v2.size(): "+v2.size());
		//v2.add(new Object()); [x]
		v2.add(new String("Bye~~"));
		
		
		String s1=v2.get(5);
		System.out.println(s1);
		
		//v2�� ����� ���(element)�� for�����̿��ؼ� ��� ����غ�����
		for(int i=0;i<v2.size();i++)
			System.out.println(v2.elementAt(i));
		
		//Generic�� ����ϸ� Enhanced for���� ��� ����
		for(String s:v2)
			System.out.println(s.toLowerCase());
		/*[����] Float������ ������ ���� v3�� �����ϰ� 
		 * ��ü 3���̻� �����ϼ���.
		 * �׷� �� for���� �̿��ؼ� ����ϰ�, �� �հ谪�� ��հ��� ���� ����ϼ���
		 * */
		Vector<Float> v3 = new Vector<>();
		v3.add((float) 12.0);//auto boxing: float �ڵ����� Float�������� ��ȯ�Ǿ� ����
		v3.add(12.0f);
		v3.add(Float.valueOf(12.1f));
		float sum = 0;
		float avg = 0;
		for(int i = 0; i < v3.size(); i++) {
			System.out.println(i + " : " + v3.get(i));
			sum += v3.get(i);//auto unboxing: Float������ float�������� �ڵ� ��ȯ
		}
		avg = sum / v3.size();
		System.out.println("�հ谪 : " + sum);
		System.out.println("��հ� : " + avg);

	}

}



