package src.support;

import src.annotations.Validation;
import src.collectionClasses.Dragon;
import src.collectionClasses.DragonFields;
import src.tools.OutputText;

import java.lang.reflect.Field;
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

    public Dragon dragonProcessing(Dragon dragon, DragonFields fieldName, String input)
            throws NoSuchFieldException, IllegalAccessException {
        Class<Dragon> dragonClass = Dragon.class;
        Field field = dragonClass.getDeclaredField(fieldName.name());
        String regex = field.getAnnotation(Validation.class).value();

        if (input.matches(regex)) {
            if (!Objects.equals(String.valueOf(field.getType()), "class java.lang.String")) {
                Method method = dragonClass.getMethod()
            }
            field.setAccessible(true);
            field.set(dragon, input);
        }
    }
}
