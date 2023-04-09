package src.server.modules;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ServerSender {
    private List<String> result = new LinkedList<>();

    public ServerSender(List<String> result) {
        this.result = result;
    }

    public List<String> getResult() {
        return result;
    }

    public void sendToClient(Socket socket) {
        try (ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
            oos.writeObject(this);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}