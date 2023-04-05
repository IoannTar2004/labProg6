package src.server.modules;

import src.client.CommandSender;
import src.tools.OutputText;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerReader {
    public static CommandSender read(Socket socket) {
        try(ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
            return (CommandSender) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            OutputText.error("Connection");
        }
        return null;
    }
}
