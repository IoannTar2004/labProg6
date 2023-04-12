package src.server.modules;

import java.net.Socket;

public class Connection {
    private String host;
    private int port;
    private Socket socket;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Connection(Socket socket) {
        this.socket = socket;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public Socket getSocket() {
        return socket;
    }
}
