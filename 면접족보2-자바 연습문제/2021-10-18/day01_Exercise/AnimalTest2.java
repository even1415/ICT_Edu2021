package day01_Exercise;
import javax.swing.*;

public class AnimalTest2 {

	public static void main(String[] args) {
		String type = JOptionPane.showInputDialog("���� ������ �Է��ϼ���");
		if(type==null) return;
		
		String num = JOptionPane.showInputDialog("�������� �Է��ϼ���");
		if(num==null) return;
		
		//�Է°��� ���� �˸��� ��ü ����
		switch(type) {
		case "�����" :
			Cat cat = new Cat();
			cat.crySound();
			cat.getBaby(Integer.parseInt(num));
			break;
		case "������" :
			Dog dog = new Dog();
			dog.crySound();
			dog.getBaby(Integer.parseInt(num));
			break;
		case "����" :
			Duck duck = new Duck();
			duck.crySound();
			duck.getBaby(Integer.parseInt(num));
			break;
		default :
			System.out.println("������ ������ �ƴմϴ�.");
			break;
		}
		
		/*
		Animal anim = null;
		
		if(type.equals("������")) {
			anim = new Dog();
		}else if(type.equals("�����")) {
			anim = new Cat();
		}else if(type.equals("����")){
			anim = new Duck();
		}else {
			System.out.println("�׷� ���� �� Ű����~");
			return;
		}
		anim.crySound();
		anim.getBaby(n);

		*/
	}

}
