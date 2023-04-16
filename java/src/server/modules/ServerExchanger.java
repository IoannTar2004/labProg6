package src.server.modules;

import org.apache.commons.lang3.SerializationUtils;
import src.client.CommandSender;
import src.manager.ObjectsCollectionManager;
import src.server.commands.ExecuteScriptCommand;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ServerExchanger {
    public static void main(String[] args) {
        foo();
        /*try(ServerSocket serverSocket = new ServerSocket(3009)) {
            while (true) {
                Socket socket = serverSocket.accept();
                try {
                    CommandSender sender = ServerReader.read(socket);
                    System.out.println(sender);
                    ServerSender serverSender = ServerInvoker.invoke(sender.getMode(),
                            sender.getCommand(), sender.getCommandString(), sender.getObjects());
                    serverSender.sendToClient(socket);
                    socket.close();
                } catch (NullPointerException ignored) {
                    ignored.printStackTrace();
                }
            }
        } catch (Exception e) {e.printStackTrace();}*/
    }

    public static void foo() {
        int i = 0;
        CommandSender commandSender = null;
        try(Selector selector = Selector.open(); ServerSocketChannel channel = ServerSocketChannel.open()) {
            channel.bind(new InetSocketAddress(3009));
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_ACCEPT);

            //TODO decompose
            while (true) {
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator;
                for (iterator = keys.iterator(); iterator.hasNext();) {
                    SelectionKey key = iterator.next();
                    if (key.isValid()) {
                        if (key.isAcceptable()) {
                            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(key.selector(), SelectionKey.OP_READ);
                        }
                        if (key.isReadable()) {
                            SocketChannel socketChannel = (SocketChannel) key.channel();
                            commandSender = ServerReader.read(socketChannel);
                            socketChannel.configureBlocking(false);
                            socketChannel.register(key.selector(), SelectionKey.OP_WRITE);
                        }
                        if (key.isWritable()) {
                            SocketChannel socketChannel = (SocketChannel) key.channel();
                            try {
                                ServerSender serverSender = ServerInvoker.invoke(commandSender.getMode(),
                                        commandSender.getCommand(), commandSender.getCommandString(), commandSender.getObjects());
                                serverSender.sendToClient(socketChannel);
                            } catch (NullPointerException e) {
                                new ServerSender("").sendToClient(socketChannel);
                            }
                            socketChannel.configureBlocking(false);
                            socketChannel.register(key.selector(), SelectionKey.OP_READ);
                        }
                        iterator.remove();
                    }
                }
                keys.clear();
            }
        } catch (Exception e) {e.printStackTrace();}
    }

    public static void channelAccept(SelectionKey key) {
        try {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(key.selector(), SelectionKey.OP_READ);
        } catch (IOException ignored) {}
    }
}
