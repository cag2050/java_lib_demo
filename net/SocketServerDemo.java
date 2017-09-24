package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class SocketServerDemo extends Thread {

	private ServerSocket serverSocket;

	public SocketServerDemo(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}

	public void run() {
		while (true) {
			try {
				System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort());
				Socket server = serverSocket.accept();
				System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
				DataInputStream dataInputStream = new DataInputStream(server.getInputStream());
				System.out.println(dataInputStream.readUTF());
				DataOutputStream dataOutputStream = new DataOutputStream(server.getOutputStream());
				dataOutputStream.writeUTF("谢谢连接我：" + server.getLocalSocketAddress());
				server.close();
			} catch (SocketTimeoutException e) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		java -Dfile.encoding=utf-8 net.SocketServerDemo 6066
		int port = Integer.parseInt(args[0]);
		try {
			Thread thread = new SocketServerDemo(port);
			thread.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
