package day07;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.table.*;

public class JTableDemo extends JFrame {
	
	JPanel p;
	JTable table;//View
	DefaultTableModel model;//Model=> �����͸� ���´�
	
	String[][] data= {
			{"1","ȫ�浿","Java��","010-1111-2222"},
			{"2","��浿","C��","010-2111-2222"},
			{"3","ȫö��","Network��","010-3111-2222"},
			{"4","�ڱ泲","Java��","010-4111-2222"},
	};
	
	String[] title= {"�й�","�̸�","�б޸�","����ó"};//���̺� �÷� �������� ���� ������

	public JTableDemo() {
		super("::JTableDemo::");
		Container cp = this.getContentPane();
		p = new JPanel();
		p.setBackground(Color.white);
		cp.add(p, BorderLayout.CENTER);
		
		p.setLayout(new BorderLayout());
		
		table=new JTable();//View
		p.add(new JScrollPane(table));
		
		model=new DefaultTableModel(data, title);//Model
		
		//View�� Model����
		table.setModel(model);
		
		table.setRowHeight(25);
		table.setSelectionBackground(Color.blue);
		table.setSelectionForeground(Color.white);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������----------------

	public static void main(String[] args) {
		JTableDemo my = new JTableDemo();
		my.setSize(500, 500);
		my.setVisible(true);
	}//main()

}//class
