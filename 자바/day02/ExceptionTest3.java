package day02;
/*�߻��� ���ܸ� try~catch���� ó���ϵ�
 * 	for���� �ȿ��� ���μ� ó���غ���
 * */
public class ExceptionTest3 {

	public static void main(String[] args) {

		for(int i=1;i<=5;i++) {
			try {
				int x=50/(i-3);
				System.out.println("x: "+x);
			}catch(ArithmeticException e) {
				System.out.println("�и� 0�̾ �ȵſ�~");
			}
			
		}//for----
		
		System.out.println("The End~~~");

	}

}
