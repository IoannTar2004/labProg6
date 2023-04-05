package src.server.modules;

import java.io.Serializable;
import java.util.Arrays;

public class ResultSender<T> implements Serializable {
    private T[] result;

    public ResultSender(T[] result) {
        this.result = result;
    }

    public String getResult() {
        return Arrays.toString(result);
    }
}
