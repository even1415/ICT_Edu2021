package day15_GUIThread;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class MyChatGui extends JFrame implements Runnable {
	
	JPanel p;
	JTextArea ta;
	JTextField tfNick, tfHost, tfInput;
	JButton btEnter, btExit;
	
	Socket sock;
	final int port = 7777;
	ObjectOutputStream out;
	ObjectInputStream in;
	
	public MyChatGui() {
		super("::MyChatGui v1.1::");
		Container cp = this.getContentPane();
		p = new JPanel();
		cp.add(p, BorderLayout.NORTH);
		ta = new JTextArea("::Welcome to MyChat::\n");
		cp.add(new JScrollPane(ta), BorderLayout.CENTER);
		
		ta.setFont(new Font("sans-serif", Font.BOLD, 18));
		ta.setBackground(Color.black);
		ta.setForeground(Color.yellow);
		ta.setEditable(false);
		
		tfInput = new JTextField();
		cp.add(tfInput, BorderLayout.SOUTH);
		tfInput.setBorder(new LineBorder(Color.magenta, 3));
		
		tfHost = new JTextField("192.168.0.15");
		tfNick = new JTextField("ict16");
		btEnter = new JButton("접 속");
		btExit = new JButton("퇴 장");
		
		p.setLayout(new GridLayout(1,4));
		p.add(tfHost);
		p.add(tfNick);
		p.add(btEnter);
		p.add(btExit);
		
		tfInput.setEditable(false);
		MyHandler handler = new MyHandler();
		btEnter.addActionListener(handler);
		btExit.addActionListener(handler);
		tfInput.addActionListener(handler);
		
		//단축키 설정
		btEnter.setMnemonic('C'); //Alt+c
		btExit.setMnemonic('X'); //Alt+X
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class MyHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			
			if(obj==btEnter) {
				chatEnter();
			}
			else if(obj==btExit) {
				
			}
			else if(obj==tfInput) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		MyChatGui my = new MyChatGui();
		my.setSize(500,700);
		my.setVisible(true);
	}

	public void chatEnter() {
		//host, nickname 값 받아오기
		String host = tfHost.getText();
		String nick = tfNick.getText();
		
		if(host==null || nick==null || host.trim().isBlank() || nick.trim().isBlank()) {
			showMsg("호스트명과 닉네임을 입력하세요");
			
			return;
		}
		//서버에 접속
		try {
			sock = new Socket(host, port);
			ta.setText("##채팅 서버와 연결되었습니다.##\n");
			out = new ObjectOutputStream(sock.getOutputStream());
			in = new ObjectInputStream(sock.getInputStream());
			//ObjectOutputStream과ObjectInputStream은 생성하는 순서를 서버와 맞춰해야 함
			//여기서 out을 먼저 생성하면 서버단에서는 반대인 in을 먼저 생성해야 한다.
	    	//서버가 보내오는 메시지를 듣는 스레드 동작
			//MyChatGui r = new MyChatGui();
			Thread listener = new Thread(this);
			listener.start();
			
			//입장메세지를 서버에 전송, "100#닉네임" => 프로토콜
			//퇴장메세지 "900#닉네임"
			//일반대화 메세지 "400#닉네임#메세지"
			out.writeObject("100#" + nick);
			out.flush();

		} catch (UnknownHostException e) {
			System.out.println("chatEnter error : " + e);
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("chatEnter error : " + e);
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

	private void showMsg(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(ta, string);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
