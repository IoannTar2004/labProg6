package server;

import server.modules.ServerAccepter;
import server.modules.ServerInvoker;
import server.modules.ServerReader;
import server.modules.ServerSender;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ServerExchanger {
    public static void main(String[] args) {
        //TODO serializationException
        ServerReader reader = new ServerReader();
        try(Selector selector = Selector.open(); ServerSocketChannel channel = ServerSocketChannel.open()) {
            channel.bind(new InetSocketAddress(30094));
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_ACCEPT);

            connect:
            while (true) {
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator;
                for (iterator = keys.iterator(); iterator.hasNext();) {
                    SelectionKey key = iterator.next();
                    if (key.isValid()) {
                        if (key.isAcceptable()) {
                            ServerAccepter.accept(key);
                        }
                        if (key.isReadable()) {
                            if (!reader.read(key)) {
                                continue connect;
                            }
                        }
                        if (key.isWritable()) {
                            try {
                                ServerSender serverSender = ServerInvoker.invoke(reader.getCommand(), reader.getMode(),
                                        reader.getCommandString(), reader.getObjects());
                                serverSender.send(key);
                            } catch (NullPointerException ignored) {}
                        }
                        iterator.remove();
                    }
                }
                keys.clear();
            }
        } catch (Exception e) {e.printStackTrace();}
    }
}
