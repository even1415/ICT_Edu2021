package day07;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
//C		Swing
//MFC===> JFC
//MVC���� ==> UI Delegation��
/* - M (Model) : �����͸� ������ �ִ� Ŭ����
 * - V (View)  : UI�� �����ϴ� Ŭ����
 * - C (Controller): UI�� Model ���̿��� �����ϴ� Ŭ����
 * 
 * */
public class JListDemo extends JFrame {
	JPanel p;
	
	JList<String> lst; //component==>View
	JComboBox<String> combo;
	//JTable table;
	
	DefaultListModel<String> model1;//JList�� �� Model
	DefaultComboBoxModel<String> model2;
	
	String[] data= {"�質��","���ϱ�","���Ѻ�","����ȫ"};
	
	public JListDemo() {
		super("::JListDemo::");
		Container cp = this.getContentPane();
		p = new JPanel();
		p.setBackground(Color.white);
		cp.add(p, BorderLayout.CENTER);
		//Model����
		model1=new DefaultListModel<>();
		for(String name:data) {
			model1.addElement(name);
		}
		//View����
		lst=new JList<>();
		
		//View�� Model�� �����ؾ� �����Ͱ� View�� ��Ÿ��
		lst.setModel(model1);
		p.setLayout(new BorderLayout());
		p.setBackground(Color.DARK_GRAY);
		p.add(new JScrollPane(lst));
		
		combo=new JComboBox<>();//View
		p.add(combo,BorderLayout.NORTH);
		
		model2=new DefaultComboBoxModel<>(data);//Model
		combo.setModel(model2);//View�� Model�� ����
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������----------------

	public static void main(String[] args) {
		JListDemo my = new JListDemo();
		my.setSize(500, 500);
		my.setVisible(true);
	}//main()

}//class
