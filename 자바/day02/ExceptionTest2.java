package day02;
/*�߻��� ���ܸ� try~catch���� ó���ϵ�
 * 	for���� �ٱ����� ���μ� ó���غ���
 * */
public class ExceptionTest2 {

	public static void main(String[] args) {
		try {
			for(int i=1;i<=5;i++) {
				int x=50/(i-3);
				System.out.println("x: "+x);
			}//for----
		}catch(ArithmeticException e) {
			System.out.println("�и� 0�� �Ǿ �ȵſ�!!");
		}
		
		System.out.println("The End~~~");

	}

}
