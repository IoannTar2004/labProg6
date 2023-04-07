package src.server.modules;

import java.net.Socket;

public class ServerSender {
    private String result;
    private String inputManager;

    public ServerSender(String result, String inputManager) {
        this.result = result;
        this.inputManager = inputManager;
    }

    public String getResult() {
        return result;
    }

    public String getInputManager() {
        return inputManager;
    }

    public static void sendToClient(Socket socket) {

    }
}
