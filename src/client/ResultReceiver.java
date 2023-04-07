package src.client;

import src.server.modules.ServerSender;
import src.tools.OutputText;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ResultReceiver{
    private String result;
    private Object[] data;

    public static ResultReceiver receive(Socket socket) {
        try {
            ObjectInputStream stream = new ObjectInputStream(socket.getInputStream());
            ServerSender sender = (ServerSender) stream.readObject();

            ResultReceiver resultReceiver = new ResultReceiver();
            resultReceiver.result = sender.getResult();
            resultReceiver.data = sender.getData();

            return resultReceiver;
        } catch (IOException e) {
            OutputText.error("Connection");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getResult() {
        return result;
    }

    public Object getData(int index) {
        return data[index];
    }
}
