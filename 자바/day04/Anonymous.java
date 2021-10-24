package day04;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

//Anonymous클래스 (이름없는 이너 클래스)
//객체를 생성하는 코드 뒤에 { }를 붙여서 구성한다.
//ActionListener a=new ActionListener(){...추상메소드 재정의};
//{}는 ActionListener인터페이스를 상속받는 자식 클래스가 된다.
//객체 생성은 1번만 가능함=> 1회용
public class Anonymous extends JFrame {
	JPanel p;
	JButton[]b;
	String str[]= {"Naver","Google","Daum","Yahoo"};
	public Anonymous() {
		super("::Anonymous::");
		Container cp = this.getContentPane();
		//{}=>JPanel을 상속받는 이름없는 클래스
		p = new JPanel() {
			@Override
			public Insets getInsets() {
				return new Insets(20,20,20,20);
			}
		};
		p.setBackground(Color.white);
		cp.add(p, BorderLayout.CENTER);
		
		//2행2열 형태로 버튼 4개 p에 부착하세요. hgap 10, vgap 10
		//버튼에 올라갈 문자열은 Naver, Google, Daum, Yahoo
		p.setLayout(new GridLayout(2,2,10,10));
		b=new JButton[4];
		for(int i=0;i<b.length;i++) {
			b[i]=new JButton(str[i]);
			p.add(b[i]);
		}

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자----------------

	public static void main(String[] args) {
		Anonymous my = new Anonymous();
		my.setSize(500, 500);
		my.setVisible(true);
	}//main()---------------
}//class/////////////////////////////////////

