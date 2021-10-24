package day05;
import java.util.*;
import java.io.*;

public class HashMapTest {
	
	HashMap<String, String> userMap=new HashMap<>();
	
	public void join() {
		//회원 아이디와 비번을 HashMap에 저장
		userMap.put("hong", "123");
		userMap.put("admin", "abc");
		userMap.put("scott", "tiger");
		System.out.println(">>>회원 가입 완료<<< 현재 회원수: "+userMap.size());
	}
	public void loginCheck() {
		//아이디,비번을 키보드 입력 받아 회원이 맞는지 체크해보자
		Console console=System.console();
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.print("아이디: ");
		//	String userid=console.readLine();
			String userid=sc.next();
			System.out.print("비밀번호:");
			//char[] pwd_arr=console.readPassword();
			String pwd=sc.next();
			//String pwd=new String(pwd_arr);
			System.out.println(userid+"/"+pwd);
			//boolean containsKey(K key): 키값들 중에 key가 있으면 true반환
			if(!userMap.containsKey(userid)) {
				System.out.println(userid+"님은 회원이 아닙니다.");
				continue;
			}
			//아이디가 존재한다면
			//비밀번호를 userMap에서 꺼내보자.
			String realPwd=userMap.get(userid);
			if(!pwd.equals(realPwd)) {
				System.out.println("비밀번호가 일치하지 않아요!!");
				continue;
			}
			
			//아이디와 비번이 일치하는 경우
			System.out.println(userid+"님 환영합니다~~^^");
			if(userid.equals("admin")) {
				System.out.println("관리자 모드를 이용할 수 있어요");
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
				System.out.println(userid+"님은 회원이 아닙니다");
				continue;
			}
			//아이디가 맞는 경우
			System.out.println("아이디 맞아요");
			*/
			
		}//while-----
		
	}//loginCheck()---------------------

	public static void main(String[] args) {
		//join()메소드 호출하기
		HashMapTest ht=new HashMapTest();
		ht.join();
		ht.loginCheck();
	}

}
/*[1] 사용자가 입력한 아이디가 userMap에 저장되어 있는지 검사
 *    1) 없다면 => "해당 아이디는 회원이 아닙니다" 출력
 *    2) 있다면 
 *    		=> 해당 아이디의 비밀번호와 사용자가 입력한 비번이 일치하는지 체크
 *   		a) 비번이 일치하면 => "~님 환영합니다!"
 *   				만약 아이디가 admin이라면 "관리자 모드를 이용할 수 있어요"를 함께 출력한다.
 *   
 *   	    b) 비번이 일치하지 않으면 =>"비밀번호가 일치하지 않아요." 			
 * */
