package src;

import src.tools.*;

/**
 * Main class runs two methods: {@link ProgramStart#start()} - explains basic things of this program and requests initial xml file
 * and {@link Invoker#invoke()} which captures entered command and checks it using RegEx.
 * @author Ivan Tarasov
 * @since 1.8
 */

public class Main {
    public static void main(String[] args) {
        ProgramStart.start();
        Invoker.invoke();
    }
}