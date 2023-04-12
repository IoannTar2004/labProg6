package src.server.modules;

import src.client.CommandSender;
import src.manager.ObjectsCollectionManager;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class ServerExchanger {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(3009)) {
            while (true) {
                Socket socket = serverSocket.accept();
                CommandSender sender = ServerReader.read(socket);
                try {
                    ServerSender serverSender = ServerInvoker.invoke(sender.getMode(),
                            sender.getCommand(), sender.getCommandString(), sender.getObjects());
                    System.out.println(sender);
                    serverSender.sendToClient(socket);
                    socket.close();
                } catch (NullPointerException ignored) {ignored.printStackTrace();}
            }
        } catch (Exception e) {e.printStackTrace();}
    }

}
