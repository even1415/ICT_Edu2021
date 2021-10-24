package day01;
import javax.swing.*;
public class AnimalTest {

	public static void main(String[] args) {
		String type=JOptionPane.showInputDialog("동물 종류를 입력하세요");
		if(type==null) return;
		String num=JOptionPane.showInputDialog("마리수를 입력하세요");
		if(num==null) return;
		//String을 int변환하고자 할 때
		//java.lang.Integer클래스 
		//public static int parseInt(String str)
		int n=Integer.parseInt(num);
		//입력값에 알맞는 객체를 생성해서
		System.out.println("동물: "+type);
		System.out.println("마리수: "+num);
		//등가연산자(==):
		//기본자료형: 값을 비교
		//참조형 : 주소값을 비교
		//String에서 문자열 내용비교: public boolean equals(Object o)		
		Animal anim=null;
		if(type.equals("강아지")) {
			anim=new Dog();
		}else if(type.equals("고양이")) {
			anim=new Cat();
		}else if(type.equals("오리")) {
			anim=new Duck();
		}else {
			System.out.println("그런 동물 안키워요~");
			return;
		}
		anim.crySound();
		anim.getBaby(n);
	}
}
