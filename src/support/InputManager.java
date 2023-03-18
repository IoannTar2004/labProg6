package src.support;

import src.annotations.Validation;
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

    @Validation("\\S*")
    private String name;

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

    public <T> T dragonProcessing(DragonFields fieldName)
            throws NoSuchFieldException, IllegalAccessException {
        Class<InputManager> managerClass = InputManager.class;
        Field field = managerClass.getDeclaredField(fieldName.getField());
        Method method;
        Scanner scanner = new Scanner(System.in);

        String regex = field.getAnnotation(Validation.class).value();
        Object obj;
        Checks checks = new Checks();

        do {
            String input = scanner.nextLine().trim();
            try {
                method = managerClass.getMethod(fieldName.getField() + "Checker");
                obj = method.invoke(checks);
            } catch (NoSuchMethodException | InvocationTargetException e) {
                obj = input;
            }
            if (input.matches(regex)) {
                return (T) obj;
            }
            OutputText.
        } while (true);
    }
}
