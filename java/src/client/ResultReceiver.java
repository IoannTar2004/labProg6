package src.client;

import src.server.modules.ServerSender;
import src.tools.OutputText;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ResultReceiver {
    private List<String> result = new LinkedList<>();
    private Object extraData;

    public ResultReceiver(Socket socket) {
        try {
            ObjectInputStream stream = new ObjectInputStream(socket.getInputStream());
            ServerSender sender = (ServerSender) stream.readObject();

            this.result = sender.getResult();
            this.extraData = sender.getExtraData();
            stream.close();
        } catch (IOException e) {
            OutputText.error("Connection");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> getResult() {
        return result;
    }

    public Object getExtraData() {
        return extraData;
    }
}
