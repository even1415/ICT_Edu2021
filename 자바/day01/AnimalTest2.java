package day01;

import javax.swing.JOptionPane;

public class AnimalTest2 {

	public static void main(String[] args) {
		String type = JOptionPane.showInputDialog("���� ������ �Է��ϼ���");
		String num = JOptionPane.showInputDialog("�� ������ ������ ���Ҵ��� �Է��ϼ���");
		int n = Integer.parseInt(num);// ������ ��ȯ
		System.out.println("����: " + type);
		System.out.println("���(��): " + num);

		Animal a = null;
		if (type.equals("������")) {
			a = new Dog();
		} else if (type.equals("�����")) {
			a = new Cat();
		} else if (type.equals("����")) {
			a = new Duck();
		} else {
			System.out.println("�׷� ���� ��Ű��!!");
			return;
		}
		a.crySound();
		a.getBaby(n);

	}

}
