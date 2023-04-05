package src.server.modules;

import java.io.Serializable;
import java.util.Arrays;

public class ResultSender implements Serializable {
    private Object[] result;

    public ResultSender(Object[] result) {
        this.result = result;
    }

    public String getResult() {
        return Arrays.toString(result);
    }
}
