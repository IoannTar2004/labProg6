package src.server.modules;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

public class ServerAccepter {
    public static void accept() {
        try(ServerSocketChannel channel = ServerSocketChannel.open()) {
            channel.bind(new InetSocketAddress(3009));
            channel.configureBlocking(false);
        } catch (Exception e) {e.printStackTrace();}
    }
}
