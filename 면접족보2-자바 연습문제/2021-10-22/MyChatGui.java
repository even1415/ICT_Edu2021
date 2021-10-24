package day05_ExerciseGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import day03_ExerciseGUI.MyJPanel;

public class MyChatGui extends JFrame implements ActionListener {

	JPanel p, p1, p2, p3, p4;
	JButton b;
	JTextField inputTextField;
	JTextArea chatTextField;
	String inputstr;
	ArrayList<String> chatlog;

	public MyChatGui() {
		// TODO Auto-generated constructor stub
		super("::MyChatGui::");
		Container cp = this.getContentPane();
		p = new MyJPanel(20,20,20,20);
		p.setBackground(Color.white);
		p.setLayout(new BorderLayout(10,10));
		cp.add(p, BorderLayout.CENTER);
		
		//상단 패널
		p1 = new MyJPanel(5,5,5,5);
		p1.setBackground(Color.lightGray);
		p1.setLayout(new BorderLayout(5,5));
		p.add(p1, BorderLayout.NORTH);
		
		p2 = new MyJPanel(5,5,5,5);
		p2.setBackground(Color.lightGray);
		p2.setLayout(new BorderLayout(5,5));
		p1.add(p2, BorderLayout.CENTER);
		
		p3 = new MyJPanel(5,5,5,5);
		p3.setBackground(Color.lightGray);
		p3.setLayout(new BorderLayout(5,5));
		p1.add(p3, BorderLayout.EAST);
		
		//상단 UI
		inputTextField = new JTextField();
		p2.add(inputTextField);
		inputTextField.addActionListener(this);
		
		b = new JButton("입력");
		p3.add(b);
		b.addActionListener(this);
		
		
		//하단 패널
		p4 = new MyJPanel(5,5,5,5);
		p4.setBackground(Color.white);
		p4.setLayout(new BorderLayout(10,10));
		p.add(p4, BorderLayout.CENTER);
		
		//하단 UI
		chatTextField = new JTextArea();
		chatTextField.setEditable(false);
		p4.add(chatTextField);
		
		chatlog = new ArrayList<String>();
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyChatGui my = new MyChatGui();
		my.setSize(500, 500);
		my.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		String str1 = new String();
		StringBuilder str2 = new StringBuilder();
		
		if(obj==b || obj==inputTextField) {
			inputstr = inputTextField.getText();
			
			chatlog.add(inputstr);
			Iterator<String> it = chatlog.iterator();
			
			while(it.hasNext()) {
				str1 = it.next();
				if(str1.indexOf("콩")!=-1) str2.append("대화내용 중 [콩]이란 글자가 들어가면 안되요!");
				else str2.append(str1);
				str2.append("\n");
			}
			chatTextField.setText(str2.toString());
			inputTextField.setText("");
			
		}
	}

}