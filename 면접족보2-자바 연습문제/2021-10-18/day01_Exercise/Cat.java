package day01_Exercise;

public class Cat extends Animal {
	@Override
	public void crySound() {
		System.out.println("�߿� �߿�~~");
	}
	
	@Override
	public void getBaby(int num) {
		System.out.println(num + "������ ������ ���Ҿ��");
	}
}
