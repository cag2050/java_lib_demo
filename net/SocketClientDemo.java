package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClientDemo {
//	java -Dfile.encoding=utf-8 net.SocketClientDemo localhost 6066
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String serverName = args[0];
		int port = Integer.parseInt(args[1]);
		try {
			System.out.println("连接到主机：" + serverName + " ,端口号：" + port);
			Socket clientSocket = new Socket(serverName, port);
			System.out.println("远程主机地址：" + clientSocket.getRemoteSocketAddress());
			OutputStream outputStream = clientSocket.getOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			dataOutputStream.writeUTF("hello from:" + clientSocket.getLocalSocketAddress());
			InputStream inputStream = clientSocket.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			System.out.println("服务器响应:" + dataInputStream.readUTF());
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
