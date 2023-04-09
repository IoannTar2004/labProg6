package src.server.modules;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.List;

public class ServerSender implements Serializable {
    private List<String> result;

    public ServerSender(List<String> result) {
        this.result = result;
    }

    public List<String> getResult() {
        return result;
    }

    public void sendToClient(Socket socket) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(this);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}