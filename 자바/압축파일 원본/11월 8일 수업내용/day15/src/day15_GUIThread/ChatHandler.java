package day15_GUIThread;
import java.net.*;
import java.io.*;
import java.util.*;
/*실질적으로 클라이언트와 메세지를 주고받는 일을 담당하는 스레드
 * */
public class ChatHandler extends Thread {
	private Socket sock;
	private Vector<ChatHandler> userV; //접속자 관리
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private String nick; //클라이언트 닉네임
	
	public ChatHandler(Socket s, Vector<ChatHandler> v) {
		// TODO Auto-generated constructor stub
		this.sock = sock;
		this.userV = v;
		
		try {
			in = new ObjectInputStream(sock.getInputStream());
			out = new ObjectOutputStream(sock.getOutputStream());
		} catch (Exception e) {
			System.out.println("ChatHandler() error : " + e);
		}
	}
	
	public void run() {
		try {
			while (true) {
				Object omsg = in.readObject();
				if(omsg==null) return;
				String msg = omsg.toString();
				System.out.println(msg);
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO: handle exception
		}
	}
}
