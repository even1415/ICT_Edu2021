package day02;
/* ���� ���� ���ܰ� �߻��� ���
 * try���� 1���� catch���� ���� �� �� �� �ִ�.
 * try{
 * 
 * }catch(A a){
 * 
 * }catch(B b){
 * 
 * }finally{
 * 		finally���� �ݵ�� �ѹ��� �����ϴ� ���̴�.
 * 		�տ� return���� �ִ��� �ݵ�� �����ϰ� ������� �ѱ��.
 * 		��, ���ܰ� �ִ�. System.exit(0)�ý��� �����ڵ尡 �տ� ���� ��쿡��
 * 		������� �ʴ´�.
 * }
 * �� �� ���� ����
 * Exception�� �θ�, �ڽ��� ��Ӱ��谡 ���� ���
 * �ڽ� ���ܸ� ����  catch�ϰ� �θ� ���ܸ� ���߿�  catch�Ѵ�.
 * */
import javax.swing.*;
public class ExceptionTest4 {

	public static void main(String[] args) {
		String str=JOptionPane.showInputDialog("������ �Է��ϼ���");
		System.out.println("str: "+str);
		try {
			//������ ��ȯ�ϱ�
			int num=Integer.parseInt(str);
			int x=50/num;
			System.out.println("x: "+x);
			
			//"Hello"
			String str2=null;
			char ch=str2.charAt(0);
			System.out.println(ch);
			
		}catch(NumberFormatException e) {
			System.out.println("���ڸ� �Է��ϼ���!");
			return;
		}catch(ArithmeticException e) {
			System.out.println("0�� �Է��ϸ� �ȵſ�!!");
			System.exit(-1);//�ý��� ����
		}catch(Exception e) {
			System.out.println("��Ÿ ����ġ ���� ���� �߻�: "+e);
		}finally {
			System.out.println("##�ݵ�� �����ؾ� �� �ڵ�####");
		}
		System.out.println("~~~The End ~~~~~");
	}
}




