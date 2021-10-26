package day06;

import java.awt.*;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import day03.NotSupportedNameException;


/*�̺�Ʈ �ҽ�  : ��ư, JTextField
* �̺�Ʈ     : ActionEvent
* �̺�Ʈ �ڵ鷯: ActionListener �������̽��� ���
* �̺�Ʈ ó�� ������ ���� �����ϰ�
*=> ��ư ������ setTitle("��ư Ŭ��")
*[1] tf�� �Է��� �� ������ 
*[2] ta�� ���� ���� ���̱�
* */
public class MyChatGui extends JFrame {
    
   JTextField tf;
   JButton bt;
   JTextArea ta;
   JPanel p;
   
   public MyChatGui() {
      super("::MyChatGui::");
      p=new JPanel();
      add(p,"North");
      ta=new JTextArea();
      add(new JScrollPane(ta),"Center");
      
      tf=new JTextField(20);
      bt=new JButton("�Է�");
      
      p.setLayout(new BorderLayout(10,10));
      p.add(tf,"Center");
      p.add(bt,"East");
      
      setBackground(Color.DARK_GRAY);
      //������ ����
      MyEventHandler handler=new MyEventHandler();
      bt.addActionListener(handler);
      tf.addActionListener(handler);
      
      //ta�� �������� ���ϵ���
      ta.setEditable(false);
      
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }//������------
   
   class MyEventHandler implements ActionListener
   {
	   @Override
	   public void actionPerformed(ActionEvent e) 	   
	   {
		   //setTitle("###");
		   Object obj=e.getSource();
		   if(obj==bt || obj==tf) {
			   //tf�� �Է��� �� ������
			   String input=tf.getText();
			   //String=> int indexOf(char ch) : Ư�� ���ڰ� �ִ� ���� �ε��� ��ȣ�� ��ȯ�Ѵ�.
			   //				�˻��ϴ� ���ڰ� ������ -1�� ��ȯ�Ѵ�.
			   int index=input.indexOf('��');
			   setTitle("index: "+index);
			   try {
				   if(index>-1) {
					   throw new NotSupportedNameException("�޽��� �߿� '��'�̶� ���ڰ� ������ �ȵſ�!!");
				   }
				   ta.append(input+"\n");
				   //ta.setText(input);
				   //ta�� ��ȭ���� �����̱� void append(String str)
			   }catch(NotSupportedNameException ex) {
				   ta.append(ex.getMessage()+"\n");
				   return;
			   }finally {
				   tf.setText("");
			   }
		   }
		   
	   }
	   
   }//inner class/////////////
   
   
   public static void main(String[] args) {
      MyChatGui my = new MyChatGui();
      my.setSize(500, 500);
      my.setVisible(true);
   }

}