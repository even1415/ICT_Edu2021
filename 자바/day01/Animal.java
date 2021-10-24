package day01;
public abstract class Animal {
	abstract void getBaby(int num);
	abstract void crySound();

}///////////////
//°­¾ÆÁö
class Dog extends Animal {
	public void crySound() {
		System.out.println("¸Û¸Û~~");
	}

	protected void getBaby(int a) {
		System.out.println(a + "¸¶¸®ÀÇ »õ³¢¸¦ ³º¾Ò¾î¿ä~~");
	}

}///////////////////////

//°í¾çÀÌ
class Cat extends Animal {
	void crySound() {
		System.out.println("¾ß¿Ë ¾ß¿Ë~~");
	}

	void getBaby(int n) {
		System.out.println(n + "¸¶¸®ÀÇ »õ³¢¸¦ ³º¾Ò¾î¿ä~~");
	}

}//////////////////////////

//¿À¸®
class Duck extends Animal {
	void crySound() {
		System.out.println("²Ð²Ð~~");
	}

	void getBaby(int n) {
		System.out.println(n + "°³ÀÇ ¾ËÀ» ³º¾Ò¾î¿ä~~");
	}

}