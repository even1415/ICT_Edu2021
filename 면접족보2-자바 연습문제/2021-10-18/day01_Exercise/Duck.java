package day01_Exercise;

public class Duck extends Animal {
	@Override
	public void crySound() {
		System.out.println("²Ð²Ð~~");
	}
	
	@Override
	public void getBaby(int num) {
		System.out.println(num + "°³ÀÇ ¾ËÀ» ³º¾Ò¾î¿ä");
	}
}
