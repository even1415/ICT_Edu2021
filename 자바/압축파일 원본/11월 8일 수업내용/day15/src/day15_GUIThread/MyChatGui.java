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
		btEnter = new JButton("�� ��");
		btExit = new JButton("�� ��");
		
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
		
		//����Ű ����
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
		//host, nickname �� �޾ƿ���
		String host = tfHost.getText();
		String nick = tfNick.getText();
		
		if(host==null || nick==null || host.trim().isBlank() || nick.trim().isBlank()) {
			showMsg("ȣ��Ʈ��� �г����� �Է��ϼ���");
			
			return;
		}
		//������ ����
		try {
			sock = new Socket(host, port);
			ta.setText("##ä�� ������ ����Ǿ����ϴ�.##\n");
			out = new ObjectOutputStream(sock.getOutputStream());
			in = new ObjectInputStream(sock.getInputStream());
			//ObjectOutputStream��ObjectInputStream�� �����ϴ� ������ ������ �����ؾ� ��
			//���⼭ out�� ���� �����ϸ� �����ܿ����� �ݴ��� in�� ���� �����ؾ� �Ѵ�.
	    	//������ �������� �޽����� ��� ������ ����
			//MyChatGui r = new MyChatGui();
			Thread listener = new Thread(this);
			listener.start();
			
			//����޼����� ������ ����, "100#�г���" => ��������
			//����޼��� "900#�г���"
			//�Ϲݴ�ȭ �޼��� "400#�г���#�޼���"
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
