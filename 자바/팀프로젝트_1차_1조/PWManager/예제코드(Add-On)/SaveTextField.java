import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.Scanner;

public class SaveTextField extends JFrame implements ActionListener {

	JPanel p;
	JTextField tf;
	String str;
	String[] IdList;

	public SaveTextField() {
		// TODO Auto-generated constructor stub
		super("::SaveTextField::");
		Container cp = this.getContentPane();
		p = new JPanel();
		p.setBackground(Color.white);
		cp.add(p, BorderLayout.CENTER);
		p.setLayout(new BorderLayout());
		
		setTextMsg();
		
		tf = new JTextField();
		p.add(tf, BorderLayout.NORTH);
		tf.addActionListener(this);
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setTextMsg() {
		str = new String("Molang");
		System.out.println("Before : " + str);
		
		IdList = new String[3];
		
		for(int i=0; i<3; i++) {
			System.out.print((i+1) + "번째 id목록 입력 : ");
			Scanner sc = new Scanner(System.in);
			IdList[i] = sc.next();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		if(obj==tf) {
			str = tf.getText();
			System.out.println("After : " + str);
			
			for(int i=0; i<3; i++) {
				if(str.equals(IdList[i])) {
					System.out.println("[SYSTEM]로그인 실패.");
					break;
				}
			}
		}
		
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SaveTextField my = new SaveTextField();
		my.setSize(500, 500);
		my.setVisible(true);

	}

}