package day02;
/* 여러 개의 예외가 발생할 경우
 * try절은 1개에 catch절은 여러 개 올 수 있다.
 * try{
 * 
 * }catch(A a){
 * 
 * }catch(B b){
 * 
 * }finally{
 * 		finally블럭은 반드시 한번은 수행하는 블럭이다.
 * 		앞에 return문이 있더라도 반드시 수행하고 제어권을 넘긴다.
 * 		단, 예외가 있다. System.exit(0)시스템 종료코드가 앞에 있을 경우에는
 * 		수행되지 않는다.
 * }
 * 이 때 주의 사항
 * Exception이 부모, 자식의 상속관계가 있을 경우
 * 자식 예외를 먼저  catch하고 부모 예외를 나중에  catch한다.
 * */
import javax.swing.*;
public class ExceptionTest4 {

	public static void main(String[] args) {
		String str=JOptionPane.showInputDialog("정수를 입력하세요");
		System.out.println("str: "+str);
		try {
			//정수로 변환하기
			int num=Integer.parseInt(str);
			int x=50/num;
			System.out.println("x: "+x);
			
			//"Hello"
			String str2=null;
			char ch=str2.charAt(0);
			System.out.println(ch);
			
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력하세요!");
			return;
		}catch(ArithmeticException e) {
			System.out.println("0을 입력하면 안돼요!!");
			System.exit(-1);//시스템 종료
		}catch(Exception e) {
			System.out.println("기타 예상치 못한 예외 발생: "+e);
		}finally {
			System.out.println("##반드시 수행해야 할 코드####");
		}
		System.out.println("~~~The End ~~~~~");
	}
}




