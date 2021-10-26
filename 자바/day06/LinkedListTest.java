package day06;
import java.util.*;
/* ArrayList�� ���������� �����͸� ������ �� ����
 * LinkedList�� �����͸� ������ ���÷� ��ü�� ����,�����ؾ� �� ���
 * ������
 *  LinkedList�� ���� ������ ��ũ�ؼ� ü��ó�� �����Ѵ�.
 *  
 *		����������	�߰�/����	|	�߰��� �߰�/����		|  �˻�	
 *  ArrayList : ������.	|	������.			|  ������
 *  LinkedList: ������.	|   ������.			|   ������. 
 * */

public class LinkedListTest {

	public static void main(String[] args) {
		List<String> list1=new ArrayList<>();
		
		List<String> list2=new LinkedList<>();
		
		long startTime =System.nanoTime();
		for(int i=0;i<1000000;i++)
		{
			//list1.add("Hello"+i);//���������� ������ ���
			list1.add(0,"Hello"+i);// �߰��� ���� add(int index, E e)
		}
		long endTime =System.nanoTime();
		
		long gapTime=endTime-startTime;
		System.out.println("ArrayList�ɸ� �ð�: "+gapTime+"ns");
		System.out.println("list1.size(): "+list1.size());
		System.out.println("****************************");
		
		startTime=System.nanoTime();
		for(int i=0;i<1000000;i++)
		{
			list1.add("Hello"+i);
			//list2.add(0,"Hello"+i);
		}
		endTime=System.nanoTime();
		gapTime=endTime-startTime;
		System.out.println("LinkedList�ɸ� �ð�: "+gapTime+"ns");
		

	}

}



