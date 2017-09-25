package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientSocketDemo {
//	net目录下，执行：javac -encoding utf-8 ClientSocketDemo.java
//	java_lib_demo目录下，执行：java -Dfile.encoding=utf-8 net.ClientSocketDemo localhost 6066
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String serverName = args[0];
		int port = Integer.parseInt(args[1]);
		try {
			System.out.println("连接到远程主机的名称：");
			System.out.println(serverName);
			System.out.println("连接到远程主机的端口号：");
			System.out.println(port);
			Socket clientSocket = new Socket(serverName, port);
			System.out.println("远程主机地址：");
			System.out.println(clientSocket.getRemoteSocketAddress());
			OutputStream outputStream = clientSocket.getOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			dataOutputStream.writeUTF("hello from client:" + clientSocket.getLocalSocketAddress());
			InputStream inputStream = clientSocket.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			System.out.println("服务器响应:");
			System.out.println(dataInputStream.readUTF());
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
