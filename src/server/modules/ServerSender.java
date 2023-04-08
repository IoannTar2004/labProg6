package src.server.modules;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ServerSender {
    private List<Object> result = new LinkedList<>();

    public ServerSender(List<Object> result) {
        this.result = result;
    }

    public List<Object> getResult() {
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
