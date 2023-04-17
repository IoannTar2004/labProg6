package src.server.modules;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.List;

public class ServerSender implements Serializable {
    private List<String> result;
    private Object[] arguments;

    public ServerSender(List<String> result) {
        this.result = result;
    }

    public ServerSender(Object[] arguments) {
        this.arguments = arguments;
    }

    public ServerSender(List<String> result, Object[] arguments) {
        this.result = result;
        this.arguments = arguments;
    }

    public List<String> getResult() {
        return result;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public static void send(SelectionKey key, ServerSender serverSender) {
        try {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            serverSender.sendToClient(socketChannel);
            socketChannel.configureBlocking(false);
            socketChannel.register(key.selector(), SelectionKey.OP_READ);
        } catch (Exception e) {e.printStackTrace();}
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
                ", arguments=" + Arrays.toString(arguments) +
                '}';
    }
}