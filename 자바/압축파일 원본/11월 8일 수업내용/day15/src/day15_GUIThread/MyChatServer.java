package day15_GUIThread;

import java.net.*;
import java.io.*;
import java.util.*;
/*Ư�� ��Ʈ�� Ŭ���̾�Ʈ ������ ������ ��ٸ���.
 * Ŭ�� ������ �̷�����, Ŭ�� ����� ����� ������(ChatHandler)
 * �� ������ ��, �����带 ���۽�Ų��.
 * ���� ���� ���� Ŭ���̾�Ʈ�� ����ϱ� ���� ChatHandler
 * �� Vector�� �����Ͽ� �����Ѵ�.
 * **/

public class MyChatServer extends Thread {
	private ServerSocket server;
	private final int port = 7777;
	Vector<ChatHandler> userV = new Vector<>(5,3);

	public MyChatServer() {
		// TODO Auto-generated constructor stub
		try {
			server = new ServerSocket(port);
			System.out.println("##ê���� ���۵Ǿ���##");
			System.out.println("##[" + port + "]�� ��Ʈ���� �����##");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("##ê���� ���� �� ���� : " + e + "##");
			return;
		}
	}
	
	public void run() {
		while(true) {
			try {
				Socket sock = server.accept();
				System.out.println("[" + sock.getInetAddress() +"] Ŭ���̾�Ʈ�� ����");
				
				//Ŭ���̾�Ʈ�� ����� ����� CharHandler ������ ���� �� ����
				ChatHandler chat = new ChatHandler(sock, userV);
				chat.start();
				
			} catch (IOException e) {
				// TODO: handle exception
				System.out.println("##Ŭ���̾�Ʈ ���� ���� ���� : " + e);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyChatServer().start();
	}

}
