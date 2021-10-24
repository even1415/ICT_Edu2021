package day01_Exercise;
import javax.swing.*;

public class AnimalTest2 {

	public static void main(String[] args) {
		String type = JOptionPane.showInputDialog("동물 종류를 입력하세요");
		if(type==null) return;
		
		String num = JOptionPane.showInputDialog("마리수를 입력하세요");
		if(num==null) return;
		
		//입력값에 따라 알맞은 객체 생성
		switch(type) {
		case "고양이" :
			Cat cat = new Cat();
			cat.crySound();
			cat.getBaby(Integer.parseInt(num));
			break;
		case "강아지" :
			Dog dog = new Dog();
			dog.crySound();
			dog.getBaby(Integer.parseInt(num));
			break;
		case "오리" :
			Duck duck = new Duck();
			duck.crySound();
			duck.getBaby(Integer.parseInt(num));
			break;
		default :
			System.out.println("지정된 동물이 아닙니다.");
			break;
		}
		
		/*
		Animal anim = null;
		
		if(type.equals("강아지")) {
			anim = new Dog();
		}else if(type.equals("고양이")) {
			anim = new Cat();
		}else if(type.equals("오리")){
			anim = new Duck();
		}else {
			System.out.println("그런 동물 안 키워요~");
			return;
		}
		anim.crySound();
		anim.getBaby(n);

		*/
	}

}
