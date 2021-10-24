package day02;
/* GUI (Graphic User Interface)=> java.awt, javax.swing패키지
 * 									Button		JButton
 * CLI (Command Line Interface)
 * 
 * Component	: 부품 (JButton, JTextField, JTextArea, JCheckbox,....)
 * 		+----Container : 플랫폼 역할 (부품은 담아주는 역할)
 * 				+----Window계열(독립적)==> JFrame, JDialog,JInternalFrame...
 * 				+----Panel계열 (비독립적)==> JPanel, JApplet
 * */
import javax.swing.*;
import java.awt.*;

public class MyGui extends JFrame 
{
	JButton b1, b2, b3;
	Container cp;
	Icon icon1, icon2, icon3,icon4;
	public MyGui() {
		super("::MyGui::");
		
		//add(b1);//JFrame에 컴포넌트를 부착하되 되지만 권장사항은 아니다.
		//JFrame은 내용물들을 붙이는 Panel이 있는데 ContentPane이라고 한다.
		//컨텐트페인을 얻어와서 여기에 붙여야 한다.
		cp=this.getContentPane();
		cp.setLayout(new FlowLayout());//레이아웃 설정
		
		icon1=new ImageIcon("images/a.png");
		icon2=new ImageIcon("images/b.png");
		icon3=new ImageIcon("images/c.png");
		icon4=new ImageIcon("images/d.png");
		
		b1=new JButton("Login",icon3);//컴포넌트
		b2=new JButton(icon1);
		b3=new JButton("Home",icon2);//String,Icon
		
		cp.add(b1);
		cp.add(b2);
		cp.add(b3);
		
		//text문자열을 아래 중앙에 위치시키자
		b1.setHorizontalTextPosition(JButton.CENTER);
		b1.setVerticalTextPosition(JButton.BOTTOM);
		
		//text문자열을 위 중앙에 위치시키기
		b3.setHorizontalTextPosition(JButton.CENTER);
		b3.setVerticalTextPosition(JButton.TOP);
		b3.setPressedIcon(icon4);
		b3.setRolloverIcon(icon3);
		b3.setMnemonic('H');//단축키 설정 alt+H
		
		//창닫기 할때 프로세스 종료 처리
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자-------------------

	public static void main(String[] args) {
		MyGui my=new MyGui();
		my.setSize(500,500);//width, height
		my.setVisible(true);//true주어야 화면에 나타남
	}
}
