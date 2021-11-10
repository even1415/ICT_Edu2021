package day15;

import java.awt.*;
import javax.swing.*;

public class Snail extends JPanel implements Runnable {
	
	boolean isStop = false;
	JLabel lb;
	ImageIcon icon;

	public Snail() {
		setLayout(new BorderLayout());
		icon = new ImageIcon("images/T0.gif");
		lb = new JLabel(icon);
		add(lb, BorderLayout.CENTER);
		setBackground(Color.white);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; (!isStop) ; i++) {
			if(i>13) i=0;
			//System.out.println("¸ô¶ûÀÌ°¡ ±¼·¯°¡¿ä");
			icon = new ImageIcon("images/T" + i + ".gif");
			lb.setIcon(icon);
			
			int sec = (int)(Math.random()*25);
			
			try {
				Thread.sleep(sec);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
				break; //for¹® Áß´Ü
			}
			
		}
	}

}
