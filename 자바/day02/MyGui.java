package day02;
/* GUI (Graphic User Interface)=> java.awt, javax.swing��Ű��
 * 									Button		JButton
 * CLI (Command Line Interface)
 * 
 * Component	: ��ǰ (JButton, JTextField, JTextArea, JCheckbox,....)
 * 		+----Container : �÷��� ���� (��ǰ�� ����ִ� ����)
 * 				+----Window�迭(������)==> JFrame, JDialog,JInternalFrame...
 * 				+----Panel�迭 (�񵶸���)==> JPanel, JApplet
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
		
		//add(b1);//JFrame�� ������Ʈ�� �����ϵ� ������ ��������� �ƴϴ�.
		//JFrame�� ���빰���� ���̴� Panel�� �ִµ� ContentPane�̶�� �Ѵ�.
		//����Ʈ������ ���ͼ� ���⿡ �ٿ��� �Ѵ�.
		cp=this.getContentPane();
		cp.setLayout(new FlowLayout());//���̾ƿ� ����
		
		icon1=new ImageIcon("images/a.png");
		icon2=new ImageIcon("images/b.png");
		icon3=new ImageIcon("images/c.png");
		icon4=new ImageIcon("images/d.png");
		
		b1=new JButton("Login",icon3);//������Ʈ
		b2=new JButton(icon1);
		b3=new JButton("Home",icon2);//String,Icon
		
		cp.add(b1);
		cp.add(b2);
		cp.add(b3);
		
		//text���ڿ��� �Ʒ� �߾ӿ� ��ġ��Ű��
		b1.setHorizontalTextPosition(JButton.CENTER);
		b1.setVerticalTextPosition(JButton.BOTTOM);
		
		//text���ڿ��� �� �߾ӿ� ��ġ��Ű��
		b3.setHorizontalTextPosition(JButton.CENTER);
		b3.setVerticalTextPosition(JButton.TOP);
		b3.setPressedIcon(icon4);
		b3.setRolloverIcon(icon3);
		b3.setMnemonic('H');//����Ű ���� alt+H
		
		//â�ݱ� �Ҷ� ���μ��� ���� ó��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������-------------------

	public static void main(String[] args) {
		MyGui my=new MyGui();
		my.setSize(500,500);//width, height
		my.setVisible(true);//true�־�� ȭ�鿡 ��Ÿ��
	}
}
