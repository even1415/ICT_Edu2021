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
	String uriString; //uri 저장할 문자열
	String clipString; //클립보드에 저장할 문자열

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
		button = new JButton("클립보드에 저장");
		p.add(button);
	}
	
	public void ClipBoardLink() { //클립보드에 텍스트 저장하는 메소드
		clipString = "https://www.naver.com/"; //저장할 텍스트

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection strSel = new StringSelection(clipString);
		clipboard.setContents(strSel, null);
	}
	
	public void GotoWebpage() { //웹페이지 이동하는 메소드
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				URI uri = new URI("https://www.naver.com/"); //이동할 URL
				//차후 uriString 변수에 저장해서 가변 삽입 필요
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