package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TCPEchoClientNonblocking {

	//项目根目录下运行：java nio.TCPEchoClientNonblocking localhost nihaopengyou 2002
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if (args.length < 2 || args.length > 3) {
			throw new IllegalArgumentException("参数不正确");
		}
		String server = args[0];
		byte[] argument = args[1].getBytes();
		int servPort = args.length == 3 ? Integer.parseInt(args[2]) : 7;
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);
		if (!socketChannel.connect(new InetSocketAddress(server, servPort))) {
			while (!socketChannel.finishConnect()) {
				System.out.print(".");
			}
		}
		System.out.println();
		ByteBuffer writeByteBuffer = ByteBuffer.wrap(argument);
		ByteBuffer readByteBuffer = ByteBuffer.allocate(argument.length);
		int totalBytesReceived = 0;
		int bytesReceived;
		while (totalBytesReceived < argument.length) {
			if (writeByteBuffer.hasRemaining()) {
				socketChannel.write(writeByteBuffer);
			}
			if ((bytesReceived = socketChannel.read(readByteBuffer)) == -1) {
				throw new SocketException("Connection colsed prematurely");
			}
			totalBytesReceived += bytesReceived;
			System.out.print(".");
		}
		System.out.println("Received: " + new String(readByteBuffer.array(), 0, totalBytesReceived));
		socketChannel.close();
	}

}
