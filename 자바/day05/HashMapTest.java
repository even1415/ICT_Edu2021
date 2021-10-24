package day05;
import java.util.*;
import java.io.*;

public class HashMapTest {
	
	HashMap<String, String> userMap=new HashMap<>();
	
	public void join() {
		//ȸ�� ���̵�� ����� HashMap�� ����
		userMap.put("hong", "123");
		userMap.put("admin", "abc");
		userMap.put("scott", "tiger");
		System.out.println(">>>ȸ�� ���� �Ϸ�<<< ���� ȸ����: "+userMap.size());
	}
	public void loginCheck() {
		//���̵�,����� Ű���� �Է� �޾� ȸ���� �´��� üũ�غ���
		Console console=System.console();
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.print("���̵�: ");
		//	String userid=console.readLine();
			String userid=sc.next();
			System.out.print("��й�ȣ:");
			//char[] pwd_arr=console.readPassword();
			String pwd=sc.next();
			//String pwd=new String(pwd_arr);
			System.out.println(userid+"/"+pwd);
			//boolean containsKey(K key): Ű���� �߿� key�� ������ true��ȯ
			if(!userMap.containsKey(userid)) {
				System.out.println(userid+"���� ȸ���� �ƴմϴ�.");
				continue;
			}
			//���̵� �����Ѵٸ�
			//��й�ȣ�� userMap���� ��������.
			String realPwd=userMap.get(userid);
			if(!pwd.equals(realPwd)) {
				System.out.println("��й�ȣ�� ��ġ���� �ʾƿ�!!");
				continue;
			}
			
			//���̵�� ����� ��ġ�ϴ� ���
			System.out.println(userid+"�� ȯ���մϴ�~~^^");
			if(userid.equals("admin")) {
				System.out.println("������ ��带 �̿��� �� �־��");
			}
			break;
			/*Set<String> idSet=userMap.keySet();
			boolean flag=false;
			for(String id:idSet) {
				if(id.equals(userid)) {
					flag=true;
					break;
				}
			}//for-----
			if(!flag) {
				System.out.println(userid+"���� ȸ���� �ƴմϴ�");
				continue;
			}
			//���̵� �´� ���
			System.out.println("���̵� �¾ƿ�");
			*/
			
		}//while-----
		
	}//loginCheck()---------------------

	public static void main(String[] args) {
		//join()�޼ҵ� ȣ���ϱ�
		HashMapTest ht=new HashMapTest();
		ht.join();
		ht.loginCheck();
	}

}
/*[1] ����ڰ� �Է��� ���̵� userMap�� ����Ǿ� �ִ��� �˻�
 *    1) ���ٸ� => "�ش� ���̵�� ȸ���� �ƴմϴ�" ���
 *    2) �ִٸ� 
 *    		=> �ش� ���̵��� ��й�ȣ�� ����ڰ� �Է��� ����� ��ġ�ϴ��� üũ
 *   		a) ����� ��ġ�ϸ� => "~�� ȯ���մϴ�!"
 *   				���� ���̵� admin�̶�� "������ ��带 �̿��� �� �־��"�� �Բ� ����Ѵ�.
 *   
 *   	    b) ����� ��ġ���� ������ =>"��й�ȣ�� ��ġ���� �ʾƿ�." 			
 * */
