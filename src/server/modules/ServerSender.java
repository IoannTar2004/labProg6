package src.server.modules;

import java.net.Socket;

public class ServerSender {
    private String result;
    private Object[] data;

    public ServerSender(String result, Object... inputManager) {
        this.result = result;
        this.data = inputManager;
    }

    public String getResult() {
        return result;
    }

    public Object[] getData() {
        return data;
    }

    public static void sendToClient(Socket socket) {

    }
}
