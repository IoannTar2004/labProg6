package src.client;

import src.collections.Dragon;
import src.tools.OutputText;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class CommandSender implements Serializable {
    private String command;
    private Dragon dragonObject;

    public CommandSender(String command, Dragon dragonObject) {
        this.command = command;
        this.dragonObject = dragonObject;
    }

    public CommandSender(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public Dragon getDragonObject() {
        return dragonObject;
    }

    public void sendToServer(Socket socket) {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
            outputStream.writeObject(this);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "CommandSender{" +
                "command='" + command + '\'' +
                ", dragonObject=" + dragonObject +
                '}';
    }
}
