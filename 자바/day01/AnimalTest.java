package day01;
import javax.swing.*;
public class AnimalTest {

	public static void main(String[] args) {
		String type=JOptionPane.showInputDialog("���� ������ �Է��ϼ���");
		if(type==null) return;
		String num=JOptionPane.showInputDialog("�������� �Է��ϼ���");
		if(num==null) return;
		//String�� int��ȯ�ϰ��� �� ��
		//java.lang.IntegerŬ���� 
		//public static int parseInt(String str)
		int n=Integer.parseInt(num);
		//�Է°��� �˸´� ��ü�� �����ؼ�
		System.out.println("����: "+type);
		System.out.println("������: "+num);
		//�������(==):
		//�⺻�ڷ���: ���� ��
		//������ : �ּҰ��� ��
		//String���� ���ڿ� �����: public boolean equals(Object o)		
		Animal anim=null;
		if(type.equals("������")) {
			anim=new Dog();
		}else if(type.equals("�����")) {
			anim=new Cat();
		}else if(type.equals("����")) {
			anim=new Duck();
		}else {
			System.out.println("�׷� ���� ��Ű����~");
			return;
		}
		anim.crySound();
		anim.getBaby(n);
	}
}
