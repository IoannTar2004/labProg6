package src.support;

import src.collectionManager.CollectionManager;
import src.collectionManager.ObjectsGetters;
import src.tools.OutputText;
import src.collections.*;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static src.collections.Color.*;
import static src.collections.DragonCharacter.*;
import static src.collections.DragonType.*;

/**
 * Consists of methods which check entered data, formats them and return finished values. Some of them can be saved to object fields.
 */
public class Checks {

    private String input;
    //TODO javadoc
    public Checks(String input) {
        this.input = input;
    }

    /**
     *
     * @return name or null in case of empty string
     */
    public String nameChecker() {
        if (input.matches("\\s*")) {
            OutputText.error("nameIncorrect");
            return null;
        }
        return input;
    }

    /**
     *
     * @return new {@link Coordinates} or null in case of invalid input or exceeding the max value.
     */
    public Coordinates coordinatesChecker() {
        Pattern pattern = Pattern.compile("\\s*(-?\\d+((\\s*;\\s*)|(\\s+))-?\\d+)\\s*");
        Matcher matcher = pattern.matcher(input);
        int x; long y;

        if (matcher.matches()) {
            String[] coordinates = matcher.group(1).split("(\\s*;\\s*)|(\\s+)");
            try {
                x = Integer.parseInt(coordinates[0]);
            } catch (NumberFormatException e) {
                OutputText.errorWithArgs("X_IntegerFormatExceeded", Integer.MAX_VALUE);
                return null;
            }

            try {
                y = Long.parseLong(coordinates[1]);
            } catch (NumberFormatException e) {
                OutputText.errorWithArgs("Y_LongFormatExceeded", Long.MAX_VALUE);
                return null;
            }
            return new Coordinates(x, y);
        }
        OutputText.error("coordinatesIncorrect");
        return null;
    }

    /**
     *
     * @return 'int input' if entered input is a positive integer number; -2 in case of exceeding Integer.MAX_VALUE; -1 in other cases.
     */
    public Integer ageChecker() {
        Matcher matcher = Pattern.compile("[1-9][0-9]*").matcher(input);
        Matcher matcher1 = Pattern.compile("-\\d+|0").matcher(input);
        Matcher matcher2 = Pattern.compile("-?\\d+\\.\\d+").matcher(input);

        if (matcher.matches()) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                OutputText.errorWithArgs("IntegerFormatExceeded", Integer.MAX_VALUE);
                return null;
            }
        } else if (matcher1.matches()) {
            System.out.println("Возраст - положительное число!");
        } else if (matcher2.matches()) {
            System.out.println("Возраст - целое положительное число!");
        } else {
            System.out.println("Возраст должен быть положительным целым числом в 10 сс!");
        }
        return null;
    }
    //TODO javadoc
    public Color colorChecker() {
        if (input.matches("\\s*1\\s*")) {return BLACK;}
        else if (input.matches("\\s*2\\s*")) {return BLUE;}
        else if (input.matches("\\s*3\\s*")) {return YELLOW;}

        OutputText.error("colorIncorrect");
        return null;
    }

    public DragonType typeChecker() {
        if (input.matches("\\s*1\\s*")) {return WATER;}
        else if (input.matches("\\s*2\\s*")) {return UNDERGROUND;}
        else if (input.matches("\\s*3\\s*")) {return AIR;}
        else if (input.matches("\\s*4\\s*")) {return FIRE;}

        OutputText.error("typeIncorrect");
        return null;
    }

    public DragonCharacter characterChecker() {
        if (input.matches("\\s*1\\s*")) {return CUNNING;}
        else if (input.matches("\\s*2\\s*")) {return EVIL;}
        else if (input.matches("\\s*3\\s*")) {return CHAOTIC;}

        OutputText.error("characterIncorrect");
        return null;
    }

    /**
     *
     * @return new {@link DragonCave} or null in case of invalid input or exceeding Double.MAX_VALUE.
     */
    public DragonCave caveChecker() {
        Matcher matcher = Pattern.compile("-?(\\d+\\.\\d*)|(\\d+)").matcher(input);
        Matcher matcher1 = Pattern.compile("-?\\d+\\.-\\d+").matcher(input);

        if (matcher.matches()) {
            try {
                return new DragonCave(Double.parseDouble(input));
            } catch (NumberFormatException e) {
                OutputText.errorWithArgs("DoubleFormatExceeded", Double.MAX_VALUE);
            }
        } else if (matcher1.matches()) {
            System.out.println("Дробное часть числа не может быть отрицательной!");
        } else {
            System.out.println("Глубина пещеры - дробное число через точку!");
        }

        return null;
    }

    /**
     * Method processes commands with argument as dragon ID.
     * @param command commands with argument as dragon's ID
     * @return {@link Dragon} if collection includes dragon with this ID, else null.
     */
    public static Dragon idChecker(String command) {
        Long id = IdChecker.check(command);
        ObjectsGetters getters = new ObjectsGetters();
        if (id != -1) {
            Dragon dragon = getters.getDragonById(id);
            if (dragon != null) {
                return dragon;
            } else {
                OutputText.error("DragonDoesNotExist");
            }
        }
        return null;
    }

    /**
     * Method checks existence of file.
     * @param filename environment variable whose value is absolute path to file.
     * @return new {@link File} or null in case of absence.
     */
    public static File fileChecker(String filename) {
        Pattern pattern = Pattern.compile("\\s*(\\S.*)\\s*");
        Matcher matcher = pattern.matcher(filename);

        if (matcher.matches()) {filename = matcher.group(1);}
        try {
            filename = filename.replaceAll("\\s*~\\s*",System.getProperty("user.home"));
            File file = new File(System.getenv(filename));
            if (file.exists()) {return file;}
        } catch (NullPointerException ignored) {}

        OutputText.error("FileNotFound");
        return null;
    }
}