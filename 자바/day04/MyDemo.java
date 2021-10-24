package day04;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;//[1]
/* 1. EventSource : 이벤트가 발생된 근원지. 주로 컴포넌트나 컨테이너가 이벤트소스가 된다.(JButton)
 * 2  Event : JVM이 발생시킨다. 이벤트 소스마다 발생되는 이벤트가 다르다.
 * 		ex)JButton => ActionEvent
 *         JCheckBox=> ItemEvent 
 * 3. EventHandler : 이벤트를 처리해주는 객체==>이걸 개발자가 구현해야 함
 * 		XXXListener 인터페이스를 상속받아 구현한다.
 *  JButton => ActionEvent ==>  ActionListener
 *  JCheckBox=> ItemEvent  ==> ItemListener
 *  [1] 이벤트 핸들러를 이벤트소스를 가진 클래스에서 구현하는 방법
 *  [2] 이벤트 핸들러를 이너 클래스로 구현하는 방법 *  
 *  [3] 이벤트핸들러를  외부클래스로 구현하는 방법 
 * */
/*
1> import java.awt.event.*; 
2> XXXListener 인터페이스를 상속 
3> 2번이 가지고 있는 추상 메소드 재정의 
4> 이벤트소스와 핸들러를 연결해줌 
...addXXXListener()메소드로. 
5> 3번에서 재정의한 메소드에 구체적인 
이벤트 처리 코드 구현
* */
public class MyDemo extends JFrame implements ActionListener{
	//2)XXXListener를 implments
	JPanel p;

	JButton b1,b2,b3;
	public MyDemo() {
		super("::MyDemo::");
		Container cp = this.getContentPane();
		p = new JPanel();
		p.setBackground(Color.white);
		cp.add(p, BorderLayout.CENTER);
		
		b1=new JButton("Red");
		b2=new JButton("Green");
		b3=new JButton("Blue");
		p.add(b1);
		p.add(b2);
		p.add(b3);
		//리스너 부착 => 생성자 안에서 해야 함
		b1.addActionListener(this);//[4]
		//public void addActionListener(ActionListener l)
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자----------------
	
	@Override
	public void actionPerformed(ActionEvent e) {//[3]추상메소드 재정의
		Object obj=e.getSource();
		//이벤트가 발생된 이벤트소스 객체를 반환함
		if(obj==b1) {
		//이벤트 처리코드 구현
			p.setBackground(Color.red);
		}else if(obj==b2) {
			p.setBackground(Color.green);
		}else if(obj==b3) {
			p.setBackground(Color.blue);
		}
	}//------------------------------

	public static void main(String[] args) {
		MyDemo my = new MyDemo();
		my.setSize(500, 500);
		my.setVisible(true);
	}//main()

}//class
