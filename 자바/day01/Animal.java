package day01;
public abstract class Animal {
	abstract void getBaby(int num);
	abstract void crySound();

}///////////////
//������
class Dog extends Animal {
	public void crySound() {
		System.out.println("�۸�~~");
	}

	protected void getBaby(int a) {
		System.out.println(a + "������ ������ ���Ҿ��~~");
	}

}///////////////////////

//�����
class Cat extends Animal {
	void crySound() {
		System.out.println("�߿� �߿�~~");
	}

	void getBaby(int n) {
		System.out.println(n + "������ ������ ���Ҿ��~~");
	}

}//////////////////////////

//����
class Duck extends Animal {
	void crySound() {
		System.out.println("�в�~~");
	}

	void getBaby(int n) {
		System.out.println(n + "���� ���� ���Ҿ��~~");
	}

}