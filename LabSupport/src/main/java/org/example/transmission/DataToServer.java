package org.example.transmission;

import java.io.Serializable;
import java.util.Arrays;

/**
 * General class for connecting client and server. It is used to send request from client to server.
 */
public class DataToServer implements Serializable {
    private String[] commandString;
    private String mode;
    private Object[] objects;

    public DataToServer(String[] commandString, String mode, Object... objects) {
        this.commandString = commandString;
        this.mode = mode;
        this.objects = objects;
    }

    public String[] getCommandString() {
        return commandString;
    }

    public String getMode() {
        return mode;
    }

    public Object[] getObjects() {
        return objects;
    }

    @Override
    public String toString() {
        return "DataToServer{" +
                "commandString=" + Arrays.toString(commandString) +
                ", mode='" + mode + '\'' +
                ", objects=" + Arrays.toString(objects) +
                '}';
    }
}
