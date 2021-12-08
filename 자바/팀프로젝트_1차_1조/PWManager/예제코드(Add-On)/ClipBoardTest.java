import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.border.*;

import java.awt.event.*;
import java.io.IOException;
import java.net.*;

public class ClipBoardTest extends JFrame {

	JPanel p;
	JButton button;
	MyHandler handler;
	String uriString; //uri ������ ���ڿ�
	String clipString; //Ŭ�����忡 ������ ���ڿ�

	public ClipBoardTest()  {
		// TODO Auto-generated constructor stub
		super("::ClipBoardTest::");
		Container cp = this.getContentPane();
		p = new JPanel();
		p.setBackground(Color.white);
		cp.add(p, BorderLayout.CENTER);
		
		TestMethod();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void TestMethod() {
		AddButton();
		ClipBoardLink();
		
		handler = new MyHandler();
		button.addActionListener(handler);
	}
	
	public void AddButton() {
		button = new JButton("Ŭ�����忡 ����");
		p.add(button);
	}
	
	public void ClipBoardLink() { //Ŭ�����忡 �ؽ�Ʈ �����ϴ� �޼ҵ�
		clipString = "https://www.naver.com/"; //������ �ؽ�Ʈ

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection strSel = new StringSelection(clipString);
		clipboard.setContents(strSel, null);
	}
	
	public void GotoWebpage() { //�������� �̵��ϴ� �޼ҵ�
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				URI uri = new URI("https://www.naver.com/"); //�̵��� URL
				//���� uriString ������ �����ؼ� ���� ���� �ʿ�
				desktop.browse(uri);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	class MyHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			
			if(obj == button) {
				ClipBoardLink();
				GotoWebpage();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClipBoardTest my = new ClipBoardTest();
		my.setSize(500, 500);
		my.setVisible(true);

	}

}