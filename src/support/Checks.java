package src.support;

import src.tools.OutputText;
import src.collectionClasses.*;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Consists of methods which check entered data, formats them and return finished values. Some of them can be saved to object fields.
 */
public class Checks {
    /**
     *
     * @param name entered dragon's name
     * @return name or null in case of empty string
     */
    public static String nameCheck(String name) {
        Pattern pattern = Pattern.compile("\\s*(\\S.*)\\s*");
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            name = matcher.group(1);
            return name;
        }
        return null;
    }

    /**
     *
     * @param coor two coordinates separated by a space or semicolon.
     * @return new {@link Coordinates} or null in case of invalid input or exceeding the max value.
     */
    public static Coordinates coordinatesChecker(String coor) {
        Pattern pattern = Pattern.compile("\\s*(-?\\d+((\\s*;\\s*)|(\\s+))-?\\d+)\\s*");
        Matcher matcher = pattern.matcher(coor);
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
        return null;
    }

    /**
     *
     * @param age entered dragon's age
     * @return 'int age' if entered age is a positive integer number; -2 in case of exceeding Integer.MAX_VALUE; -1 in other cases.
     */
    public static int ageChecker(String age) {
        Pattern pattern = Pattern.compile("\\s*([1-9][0-9]*)\\s*");
        Matcher matcher = pattern.matcher(age);

        if(matcher.matches()) {
            age = matcher.group(1);
            try {
                return Integer.parseInt(age);
            } catch (NumberFormatException e) {
                OutputText.errorWithArgs("IntegerFormatExceeded", Integer.MAX_VALUE);
                return -2;
            }
        }
        return -1;
    }

    /**
     *
     * @param cave fractional number separated by a dot.
     * @return new {@link DragonCave} or null in case of invalid input or exceeding Double.MAX_VALUE.
     */
    public static DragonCave caveChecker(String cave) {
        Pattern pattern = Pattern.compile("\\s*(-?(\\d+\\.\\d*)|(\\d+))\\s*");
        Matcher matcher = pattern.matcher(cave);

        if (matcher.matches()) {
            cave = matcher.group(1);
            try {
                return new DragonCave(Double.parseDouble(cave));
            } catch (NumberFormatException e) {
                OutputText.errorWithArgs("DoubleFormatExceeded", Double.MAX_VALUE);
            }
        }
        return null;
    }

    /**
     * Method processes commands with argument as dragon ID.
     * @param command commands with argument as dragon's ID
     * @return {@link Dragon} if collection includes dragon with this ID, else null.
     */
    public static Dragon idChecker(String command) {
        Pattern pattern = Pattern.compile("\\s*.\\S*\\s+(-?\\d+)\\s*");
        Matcher matcher = pattern.matcher(command);

        if(matcher.matches()) {
            command = matcher.group(1);
            Long id = IdChecker.check(command);
            if (id != -1) {
                Dragon dragon = CollectionManager.getDragonById(id);
                if (dragon != null) {
                    return dragon;
                } else {
                    OutputText.error("DragonDoesNotExist");
                }
            }

        } else {
            OutputText.error("NoArgument");
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
            File file = new File(System.getenv(filename));
            if (file.exists()) {return file;}
        } catch (NullPointerException ignored) {}

        OutputText.error("FileNotFound");
        return null;
    }
}