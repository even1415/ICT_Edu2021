package day15_GUIThread;

import java.net.*;
import java.io.*;
import java.util.*;
/*특정 포트로 클라이언트 연결을 무한정 기다린다.
 * 클과 연결이 이뤄지면, 클과 통신을 담당할 스레드(ChatHandler)
 * 를 생성한 후, 스레드를 동작시킨다.
 * 또한 여러 명의 클라이언트와 통신하기 위해 ChatHandler
 * 를 Vector에 저장하여 관리한다.
 * **/

public class MyChatServer extends Thread {
	private ServerSocket server;
	private final int port = 7777;
	Vector<ChatHandler> userV = new Vector<>(5,3);

	public MyChatServer() {
		// TODO Auto-generated constructor stub
		try {
			server = new ServerSocket(port);
			System.out.println("##챗서버 시작되었음##");
			System.out.println("##[" + port + "]번 포트에서 대기중##");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("##챗서버 시작 중 예외 : " + e + "##");
			return;
		}
	}
	
	public void run() {
		while(true) {
			try {
				Socket sock = server.accept();
				System.out.println("[" + sock.getInetAddress() +"] 클라이언트가 접속");
				
				//클라이언트와 통신을 담당할 CharHandler 쓰레드 생성 후 동작
				ChatHandler chat = new ChatHandler(sock, userV);
				chat.start();
				
			} catch (IOException e) {
				// TODO: handle exception
				System.out.println("##클라이언트 소켓 생성 실패 : " + e);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyChatServer().start();
	}

}
