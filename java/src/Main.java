package src;

import src.client.InitializationDate;
import src.client.Processing;
import src.client.ProgramStart;

import java.nio.channels.SocketChannel;

/**
 * Main class runs two methods: {@link ProgramStart#start()} - explains basic things of this program, requests initial xml file
 * and run {@link Processing#commandScan(SocketChannel)} and
 * {@link InitializationDate#getDate()} that initializes time of program start
 * @author Ivan Tarasov
 * @since 1.8
 */

public class Main {
    public static void main(String[] args) {
        InitializationDate.getDate();
        ProgramStart.start();
    }
}