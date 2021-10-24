package day02;
import javax.swing.*;
import java.awt.*;

public class MyComponent extends JFrame{

	JButton b1;
	JTextField tf1, tf2;
	JPasswordField tfPwd;
	JLabel lb1, lb2, lb3;
	JCheckBox ck1,ck2,ck3;
	JRadioButton rb1, rb2;
	JTextArea ta1, ta2;
	
	public MyComponent() {
		super("::MyComponent::");
		Container cp=this.getContentPane();
		cp.setLayout(new FlowLayout());
		b1=new JButton("Home");
		cp.add(b1);
		b1.setBackground(Color.red);//배경색
		b1.setForeground(Color.white);//글자색
		//tf1, tf2생성해서 붙이기
		tf1=new JTextField(20);
		tf2=new JTextField("Hello",30);
		cp.add(tf1);
		cp.add(tf2);
		
		tfPwd=new JPasswordField(20);
		cp.add(tfPwd);
		
		//ck1,ck2,ck3 : 독서, 음악감상, 영화감상
		//다중 체크가 가능
		ck1=new JCheckBox("독서");
		ck2=new JCheckBox("음악감상", true);
		ck3=new JCheckBox("영화감상", false);
		cp.add(ck1);
		cp.add(ck2);
		cp.add(ck3);
		
		//JRadioButton: 단일 선택할 때 사용.
		//ButtonGroup과 함께 사용
		//rb1, rb2 : 남자, 여자
		rb1=new JRadioButton("남자");
		rb2=new JRadioButton("여자", true);
		cp.add(rb1);
		cp.add(rb2);
		
		ButtonGroup group=new ButtonGroup();
		group.add(rb1);
		group.add(rb2);
		//같은 그룹 내에 한개만 선택가능
		
		lb1=new JLabel("이  름: ");
		lb2=new JLabel("아이디: ");
		lb3=new JLabel("비밀번호: ");
		cp.add(lb1);
		cp.add(lb2);
		cp.add(lb3);
		
		lb1.setOpaque(true);
		lb2.setOpaque(true);
		lb3.setOpaque(true);
		
		lb1.setBackground(Color.yellow);
		lb2.setBackground(Color.LIGHT_GRAY);
		lb3.setBackground(Color.cyan);
		
		//JTextArea: 멀티라인을 입력 할 수 있다.
		//다만, 스크롤바가 자동으로 붙지 않기 때문에 JScrollPane에 붙여서 사용해야 함
		ta1=new JTextArea("Hello",5,20);
		//cp.add(ta1);[x]
		cp.add(new JScrollPane(ta1));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MyComponent my=new MyComponent();
		my.setSize(500,500);
		my.setVisible(true);

	}

}
