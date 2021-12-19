import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

import java.awt.event.*;

public class ButtonChangeImage extends JFrame {

	JPanel p;
	JButton button;

	public ButtonChangeImage() {
		// TODO Auto-generated constructor stub
		super("::ButtonChangeImage::");
		Container cp = this.getContentPane();
		p = new JPanel();
		p.setBackground(Color.white);
		cp.add(p, BorderLayout.CENTER);
		customcursor();
		
		button = new JButton();
		
		MyHandler handler = new MyHandler();
		button.addActionListener(handler);
		
		//String iconfilePath = this.getClass().getClassLoader().getResource("a.png").getFile();
		String iconfilePath = "src/a.png";
		//String iconfilePath = new javax.swing.ImageIcon("src/Logo.PNG");
		button.setIcon(new ImageIcon(iconfilePath));
		button.setBounds(10, 438, 39, 31);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		button.setFocusable(false);
		
		p.add(button);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void customcursor(){
		/*커서 이미지 배치*/
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image cursorimage=tk.getImage("src/mouseMolang.png");
		Point point=new Point(20,20);
		Cursor cursor=tk.createCustomCursor(cursorimage, point, "haha");
		p.setCursor(cursor); 
	}
	
	class MyHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("clicked");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ButtonChangeImage my = new ButtonChangeImage();
		my.setSize(500, 500);
		my.setVisible(true);

	}

}