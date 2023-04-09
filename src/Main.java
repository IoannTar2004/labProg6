package src;

import src.support.InitializationDate;
import src.support.InputManager;
import src.tools.*;

import java.io.IOException;

/**
 * Main class runs three methods: {@link ProgramStart#start()} - explains basic things of this program and requests initial xml file,
 * {@link InitializationDate#getDate()} initializes time of program start
 * and {@link Invoker#invoke(String, String, String...)} which captures entered command and checks it using RegEx.
 * @author Ivan Tarasov
 * @since 1.8
 */

public class Main {
    public static void main(String[] args) throws IOException {
        //ProgramStart.start();
        InitializationDate.getDate();
        InputManager.commandScan();
    }
}