package src.server.modules;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSender {
    private Object[] result;

    public ServerSender(Object[] result) {
        this.result = result;
    }

    public Object[] getResult() {
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
