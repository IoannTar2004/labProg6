package src.client;

import src.server.modules.ServerSender;
import src.tools.OutputText;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ResultReceiver {
    private String result;
    private String inputManager;

    public static ResultReceiver receive(Socket socket) {
        try {
            ObjectInputStream stream = new ObjectInputStream(socket.getInputStream());
            ServerSender sender = (ServerSender) stream.readObject();

            ResultReceiver resultReceiver = new ResultReceiver();
            resultReceiver.result = sender.getResult();
            resultReceiver.inputManager = sender.getInputManager();

            return resultReceiver;
        } catch (IOException e) {
            OutputText.error("Connection");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
