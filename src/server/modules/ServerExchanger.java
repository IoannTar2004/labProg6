package src.server.modules;

import src.client.CommandSender;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.util.List;

public class ServerExchanger {
    public static void main(String[] args) {
        try(ServerSocketChannel serverSocket = ServerSocketChannel.open()) {
            serverSocket.bind(new InetSocketAddress(3009));
            while (true) {
                Socket socket = serverSocket.socket().accept();
                CommandSender sender = ServerReader.read(socket);
                List<String> result = ServerInvoker.invoke("user", sender.getCommand(), sender.getCommandString());

                ServerSender serverSender = new ServerSender(result);
                serverSender.sendToClient(socket);
                socket.close();
            }
        } catch (IOException ignored) {}
    }

}
