package day01;

import javax.swing.JOptionPane;

public class AnimalTest2 {

	public static void main(String[] args) {
		String type = JOptionPane.showInputDialog("동물 종류를 입력하세요");
		String num = JOptionPane.showInputDialog("몇 마리의 새끼를 낳았는지 입력하세요");
		int n = Integer.parseInt(num);// 정수로 변환
		System.out.println("동물: " + type);
		System.out.println("몇마리(개): " + num);

		Animal a = null;
		if (type.equals("강아지")) {
			a = new Dog();
		} else if (type.equals("고양이")) {
			a = new Cat();
		} else if (type.equals("오리")) {
			a = new Duck();
		} else {
			System.out.println("그런 동물 안키워!!");
			return;
		}
		a.crySound();
		a.getBaby(n);

	}

}
