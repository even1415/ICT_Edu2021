package day04;
import java.util.*;
public class VectorTest2 {

	public static void main(String[] args) {
		//[1] Person��ü�� 3�� �����ϱ�(�̸�,���� �� �Ҵ�)
		Person person1 = new Person("ȫ�浿", 20);
		Person person2 = new Person("��ö��", 22);
		Person person3 = new Person("�ڿ���", 30);

		
		//[2] Person��ü�� ������ Vector�����ϱ�=>v
		//[3] v�� [1]���� ������ ��ü 3�� �����ϱ�
		Vector<Person> v=new Vector<>();
		v.add(person1);
		v.add(person2);
		v.add(person3);
		
		
		//[4] for���� �̿��ؼ� v�� ����� Person�� �̸��� ���̸� ����ϼ���
		for(int i=0;i<v.size();i++) {
			Person p=v.get(i);
			System.out.println(p.getName()+": "+p.getAge()+"��");
		}
		//Enumeration<E>	elements()
		Enumeration<Person> en = v.elements();
		
		while(en.hasMoreElements()) {
			Person p=en.nextElement();
			System.out.println(p.getName()+"#"+p.getAge());
		}
		
		
		//Iterator<E>	iterator()
		
		/* 
		 * Enumeration�̳� Iterator ���� ��ü���� ����ü�� �������ִ� �������̽��̴�.
		 *   �̵� �������̽����� ������ ��ü���� �� ������ �ϳ��� ó���� �� �ִ� �޼ҵ带 �����Ѵ�.
		 *   (���� Ŀ���� �����Ͽ� Ŀ���� �̵��ϸ鼭 �����͸� ������ �� �ִ�.)
		 *   -���� Ŀ���� ù��° ��� ����(before First)�� ��ġ�Ѵ�.
		 *   1. Enumeration�� �ֿ� �޼ҵ�
		 *   	- boolean hasMoreElements(): ���� Ŀ���� ��ġ�ϴ� �� ���Ŀ� ��ҵ��� �ִ���
		 *   			���θ� ���´�. ��ҵ��� ������ true�� ��ȯ�ϰ� ������ false�� ��ȯ�Ѵ�.
		 *      - E  nextElement() : ���� Ŀ���� �������� �̵���Ű�� ����Ű�� �ִ� ������ ��Ҹ�
		 *      			��ȯ�Ѵ�.
		 *  2.  Iterator �ֿ� �޼ҵ�
		 *     - boolean hasNext()
		 *     - E next();  
		 *    
		 * */
		//iterator()�޼ҵ带 �̿��ؼ� v�� ����� ��ҵ��� �̸��� �Ѳ����� ����ϼ���
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
		//void	copyInto(Object[] anArray):���Ϳ� ����� ��ҵ��� �迭�� ī�����ִ� ���
		//v�� ����� ��ҵ��� 1���� �迭�� ī���� �ڿ� Ȯ��for���� �̿��ؼ� "�̸�@����" ����ϼ���
		
		Person[] arr=new Person[v.size()];
		v.copyInto(arr);
		
		for(Person pe:arr)
			System.out.println(pe.getName()+"@"+pe.getAge());
	}
}
//List�迭
//ArrayList : ����ȭ(synchronized)�� �Ǿ� ���� ����
//Vector : ����ȭ�� �����Ǿ� ����
//Map�迭, Set�迭

