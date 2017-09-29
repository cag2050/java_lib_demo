package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

//项目根目录下运行：java nio.TCPServerSelector 2000 2001 2002 2003
public class TCPServerSelector {
    private static final int BUFSIZE = 256;
    private static final int TIMEOUT = 3000;

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            throw new IllegalArgumentException("parameters:<port>...");
        }
        Selector selector = Selector.open();
        for (String arg : args) {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(Integer.parseInt(arg)));
            serverSocketChannel.configureBlocking(false);
            //将选择器注册到各个信道
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        }
        TCPProtocol protocol = new EchoSelectorProtocol(BUFSIZE);
        while (true) {
            if (selector.select(TIMEOUT) == 0) {
                System.out.print(".");
            }
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    protocol.handleAccept(key);
                }
                if (key.isReadable()) {
                    protocol.handleRead(key);
                }
                if (key.isValid() && key.isWritable()) {
                    protocol.handleWrite(key);
                }
                keyIterator.remove();
            }
        }
    }
}
