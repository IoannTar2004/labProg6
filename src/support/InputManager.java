package src.support;

import src.collectionClasses.Dragon;
import src.collectionClasses.DragonFields;
import src.tools.OutputText;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
        Scanner scanner = new Scanner(System.in);
        String data;
        do {
            data = scanner.nextLine().trim();
            if(data.equals("y")) {
                return true;
            } else if(data.equals("n")) {
                return false;
            }
            OutputText.startInformation("yes_no");
        } while (true);
    }

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

    public Dragon dragonInput(Dragon dragon, DragonFields fields, Object element) {
        Class<Dragon> dragonClass = Dragon.class;
        try {
            Field field = dragonClass.getDeclaredField(fields.getField());
            field.setAccessible(true);
            field.set(dragon, element);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {}

        return dragon;
    }
}
