package src.server.modules;

import src.client.CommandSender;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ServerExchanger {
    public static void main(String[] args) {
        CommandSender commandSender = null;
        try(Selector selector = Selector.open(); ServerSocketChannel channel = ServerSocketChannel.open()) {
            channel.bind(new InetSocketAddress(3009));
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_ACCEPT);

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
                            commandSender = ServerReader.read(key);
                        }
                        if (key.isWritable()) {
                            ServerSender serverSender = ServerInvoker.invoke(commandSender.getMode(),
                                    commandSender.getCommand(), commandSender.getCommandString(), commandSender.getObjects());
                            ServerSender.send(key, serverSender);
                        }
                        iterator.remove();
                    }
                }
                keys.clear();
            }
        } catch (Exception e) {e.printStackTrace();}
    }
}
