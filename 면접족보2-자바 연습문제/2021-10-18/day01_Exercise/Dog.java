package day01_Exercise;

public class Dog extends Animal {
	@Override
	public void crySound() {
		System.out.println("¸Û¸Û~~");
	}
	
	@Override
	public void getBaby(int num) {
		System.out.println(num + "¸¶¸®ÀÇ »õ³¢¸¦ ³º¾Ò¾î¿ä");
	}
}
