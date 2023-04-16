package src.server.modules;

import org.apache.commons.lang3.SerializationUtils;
import src.client.CommandSender;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class ServerReader {

    public static CommandSender read(SocketChannel socketChannel) {
        ByteBuffer buffer = ByteBuffer.allocate(100000);
        try {
            socketChannel.read(buffer);
            CommandSender commandSender = SerializationUtils.deserialize(buffer.array());
            System.out.println(commandSender);

            return commandSender;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
