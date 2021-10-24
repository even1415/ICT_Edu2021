package day01_Exercise;

public class AnimalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();
		Cat cat = new Cat();
		Duck duck = new Duck();
		Animal[] animals = new Animal[3];
		
		animals[0] = dog;
		animals[1] = cat;
		animals[2] = duck;
		
//		dog.crySound();
//		dog.getBaby(3);
//		
//		cat.crySound();
//		cat.getBaby(3);
//		
//		duck.crySound();
//		duck.getBaby(3);
		
		for(int i=0; i<3; i++) {
			if(animals[i] instanceof Dog) {
				((Dog)animals[i]).crySound();
				((Dog)animals[i]).getBaby(3);
			}
			else if(animals[i] instanceof Cat) {
				((Cat)animals[i]).crySound();
				((Cat)animals[i]).getBaby(3);
			}
			else if(animals[i] instanceof Duck) {
				((Duck)animals[i]).crySound();
				((Duck)animals[i]).getBaby(3);
			}
			else {
				System.out.println("지정된 동물 아님");
			}
		}
	}

}
