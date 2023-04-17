package src;

import src.support.InitializationDate;
import src.support.Processing;
import src.tools.ProgramStart;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * Main class runs two methods: {@link ProgramStart#start()} - explains basic things of this program, requests initial xml file
 * and run {@link src.support.Processing#commandScan(SocketChannel)} and
 * {@link InitializationDate#getDate()} that initializes time of program start
 * @author Ivan Tarasov
 * @since 1.8
 */

public class Main {
    public static void main(String[] args) throws IOException {
        InitializationDate.getDate();
        ProgramStart.start();
        //new Processing().commandScan(SocketChannel.open(new InetSocketAddress("localhost", 3009)));
    }
}