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
public class Anonymous extends JFrame implements ActionListener{
	JPanel p;
	JButton[]b;
	String str[]= {"Naver","Google","Daum","Yahoo"};
	Color origin;
	
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
			b[i].addActionListener(this);
			//b[i].setActionCommand(i+"버튼");
		}
		origin=b[0].getBackground();
		//System.out.println(origin);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자----------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		String cmd=e.getActionCommand();//이벤트소스가 가지고 있는 label문자열값을 반환
		
		//이벤트소스(버튼)의 배경색을 얻어오자
		Color cr=((JButton)obj).getBackground();
		if(cr==origin) {
			setTitle(cmd+"버튼을 눌렀군요");
			if(obj==b[0]) {
				b[0].setBackground(Color.green);
			}else if(obj==b[1]) {
				b[1].setBackground(Color.orange);
			}else if(obj==b[2]) {
				b[2].setBackground(Color.magenta);
			}else if(obj==b[3]) {
				b[3].setBackground(Color.cyan);
			}
		}else {
			setTitle("::Anonymous::");
			//원래색과 다르다면 원래색으로 설정
			((JButton)obj).setBackground(origin);
		}
	}

	public static void main(String[] args) {
		Anonymous my = new Anonymous();
		my.setSize(500, 500);
		my.setVisible(true);
	}//main()---------------

	
}//class/////////////////////////////////////

