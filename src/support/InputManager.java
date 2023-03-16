package src.support;

import src.tools.OutputText;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * class for processing inputs
 */
public class InputManager {
    /**
     * Method builds argument that was separated by a space in {@link src.tools.Invoker#invoke(String, String, String...)}
     * @param arg - command
     * @return
     */
    public static String builder(String[] arg) {
        String line = arg[1];
        for (int i = 2; i < arg.length; i++) {
            line = line + " " + arg[i];
        }
        return line;
    }

    public static boolean yesNoInput() throws NoSuchElementException {
        Scanner scanner = new Scanner(System.in);
        String data;
        do {
            data = scanner.nextLine();
            if(data.equals("y")) {
                return true;
            } else if(data.equals("n")) {
                return false;
            }
            OutputText.startInformation("yes_no");
        } while (true);
    }
}
