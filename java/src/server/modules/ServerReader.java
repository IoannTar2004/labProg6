package src.server.modules;

import org.apache.commons.lang3.SerializationUtils;
import src.client.CommandSender;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class ServerReader {

    public static CommandSender read(SelectionKey key) {
        ByteBuffer buffer = ByteBuffer.allocate(100000);
        SocketChannel socketChannel = null;
        try {
            socketChannel = (SocketChannel) key.channel();
            socketChannel.read(buffer);
            CommandSender commandSender = SerializationUtils.deserialize(buffer.array());
            System.out.println(commandSender);

            socketChannel.configureBlocking(false);
            socketChannel.register(key.selector(), SelectionKey.OP_WRITE);

            return commandSender;
        } catch (Exception e) {
            try {
                socketChannel.close();
            } catch (IOException ignored) {}
            return null;
        }
    }
}
