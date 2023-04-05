package src.server.modules;

import src.client.CommandSender;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

public class ServerExchanger {
    public static void main(String[] args) {
        try(ServerSocketChannel serverSocket = ServerSocketChannel.open()) {
            serverSocket.bind(new InetSocketAddress(3009));
            while (true) {
                Socket socket = serverSocket.socket().accept();
                CommandSender sender = ServerReader.read(socket);
                ServerInvoker.invoke("user", sender.getCommand());
                socket.close();
            }
        } catch (IOException ignored) {}
    }

}
