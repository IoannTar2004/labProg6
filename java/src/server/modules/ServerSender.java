package src.server.modules;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.List;

public class ServerSender implements Serializable {
    private List<String> result;
    private Object extraData;

    public ServerSender(List<String> result) {
        this.result = result;
    }

    public ServerSender(Object extraData) {
        this.extraData = extraData;
    }

    public List<String> getResult() {
        return result;
    }

    public Object getExtraData() {
        return extraData;
    }

    public void sendToClient(SocketChannel socketChannel) {
        try {
            byte[] bytes = SerializationUtils.serialize(this);
            socketChannel.write(ByteBuffer.wrap(bytes));
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ServerSender{" +
                "result=" + result +
                ", extraData=" + extraData +
                '}';
    }
}