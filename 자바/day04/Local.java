package day04;
//Local Inner class : �޼ҵ� ���ο� Ŭ������ ������ ���
// [1] �̸� �ִ� ���� �̳� Ŭ����
// [2] �̸� ���� ���� �̳� Ŭ���� (Anonymous class)
public class Local {
	
	String str="�������~~";
	
	public void sub() {
		int num=100;//��������(local����)
		System.out.println("str: "+str);
		System.out.println("num: "+num);
		class LocalInner{
			String lstr="�����̳� �������##";
			void demo() {
				System.out.println("---demo()--------");
				//str
				System.out.println("str: "+str);
				//lstr
				System.out.println("lstr: "+lstr);
				//num
				System.out.println("num: "+num);
				//�����̳� Ŭ���������� final�� �ƴ� ���������� ���� �Ұ��� (java7���� ����)
			}
		}//LocalInner//////////
		LocalInner li=new LocalInner();
		li.demo();
	}//sub()----------------------
	
	public void test() {
		class LocalInner{
			
		}
	}
	
	public static void main(String[] args) {
		//sub()�޼ҵ� ȣ���ϼ���
		Local lc=new Local();
		lc.sub();
		//�����̳� Ŭ������ �ڱⰡ ���� �޼ҵ� �ȿ����� ��ü ������ �ؾ� ��
		//���� Ŭ������ ������ ���Ŀ� ��ü ������ �����ϴ�.
		//LocalInner li=new LocalInner();//[x]
	}//main()-------------------------
}///////////////////////////////////
