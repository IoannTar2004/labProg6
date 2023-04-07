package src.support;

import src.client.CommandSender;
import src.client.ResultReceiver;
import src.collections.Dragon;
import src.collections.DragonFields;
import src.tools.OutputText;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Objects;
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

    /**
     * Method is used for answer the closed questions
     * @return true if input is 'y' (yes), else return false if input is 'n' (no)
     * @throws NoSuchElementException
     */
    public boolean yesNoInput() throws NoSuchElementException {
        InputManager manager = new InputManager();
        String data;
        do {
            data = manager.scanner();
            if(data.equals("y")) {
                return true;
            } else if(data.equals("n")) {
                return false;
            }
            OutputText.startInformation("yes_no");
        } while (true);
    }

    /**
     * Universal method that can run '{@link Checks Check}' methods in relation to {@link DragonFields}.
     * @param fieldName run defined method in relation to this argument
     * @param input it is what you entered
     * @return any object if you write down correctly
     */
    public Object dragonProcessing(DragonFields fieldName, String input) {
        Class<Checks> checksClass = Checks.class;
        Method method;

        Object obj;
        Checks checks = new Checks(input);
        try {
            method = checksClass.getMethod(fieldName.getField() + "Checker");
            obj = method.invoke(checks);
            if (obj != null) {
                return obj;
            }
        } catch (Exception ignored) {}
        return null;
    }

    /**
     * Adds or changes dragon's fields
     * @param dragon that you need to change
     * @param fields which field you want to change
     * @param element value of field
     * @return changed dragon
     */
    public Dragon dragonInput(Dragon dragon, DragonFields fields, Object element) {
        Class<Dragon> dragonClass = Dragon.class;
        try {
            Field field = dragonClass.getDeclaredField(fields.getField());
            field.setAccessible(true);
            field.set(dragon, element);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {}

        return dragon;
    }

    /**
     * Scan entered strings, if user enters ctrl + d the program will be stopped.
     * @return entered string
     */
    public String scanner() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextLine().trim();
        } catch (NoSuchElementException e) {
            System.exit(0);
        }
        return null;
    }

    /**
     * Method reads commands entered by user.
     */
    public static void commandScan() throws IOException {
        String input;
        InputManager manager = new InputManager();
        do {
            input = manager.scanner();
            if (!Objects.equals(input, "exit") && input.length() > 0) {
                CommandSender sender = new CommandSender(input);
                Socket socket = new Socket("localhost", 3009);
                sender.sendToServer(socket);

                ResultReceiver result = ResultReceiver.receive(socket);
            } //TODO временный сокет
        } while (!input.equals("exit"));
    }
}
