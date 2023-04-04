package src.server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerExchanger {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3009);
        } catch (IOException ignored) {}
    }
}
