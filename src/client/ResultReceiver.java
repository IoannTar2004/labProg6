package src.client;

import src.server.modules.ServerSender;
import src.tools.OutputText;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ResultReceiver {
    private List<Object> result = new LinkedList<>();

    public static ResultReceiver receive(Socket socket) {
        try {
            ObjectInputStream stream = new ObjectInputStream(socket.getInputStream());
            ServerSender sender = (ServerSender) stream.readObject();

            ResultReceiver resultReceiver = new ResultReceiver();
            resultReceiver.result = sender.getResult();

            return resultReceiver;
        } catch (IOException e) {
            OutputText.error("Connection");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getResult(int index) {
        return result.get(index);
    }

}
