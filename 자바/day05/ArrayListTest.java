package day05;
import java.util.*;
/*ArrayList
 *  - java.util.List�迭
 *  - Vector�� ����� ����
 *  - �� ���ʹ� �޼ҵ���� ����ȭ�� ������ �ݸ�
 *    ArrayList�� ����ȭ�Ǿ� ���� ����=> ������ ���� ����
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
		//iterator()�޼ҵ� �̿��ؼ� arrList�� ����� ��ҵ��� �Ѳ����� ����ϼ���
		Iterator<String> it=arrList.iterator();
		while(it.hasNext()) {
			String str2=it.next();
			System.out.println(str2);
		}
		
		System.out.println("arrList.size(): "+arrList.size());
		

	}

}
