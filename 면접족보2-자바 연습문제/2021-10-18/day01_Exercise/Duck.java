package day01_Exercise;

public class Duck extends Animal {
	@Override
	public void crySound() {
		System.out.println("�в�~~");
	}
	
	@Override
	public void getBaby(int num) {
		System.out.println(num + "���� ���� ���Ҿ��");
	}
}
