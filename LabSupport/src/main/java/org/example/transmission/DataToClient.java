package org.example.transmission;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * General class for connecting client and server. It is used to send reply from server to client.
 */
public class DataToClient implements Serializable {
    private List<String> result;
    private Object[] arguments;

    public DataToClient(List<String> result, Object[] arguments) {
        this.result = result;
        this.arguments = arguments;
    }

    public List<String> getResult() {
        return result;
    }

    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public String toString() {
        return "DataToClient{" +
                "result=" + result +
                ", arguments=" + Arrays.toString(arguments) +
                '}';
    }
}
