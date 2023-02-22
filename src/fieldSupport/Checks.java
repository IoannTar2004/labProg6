package src.fieldSupport;

import src.collectionClasses.*;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Checks {

    public static String nameCheck(String name) {
        if (name.matches("\\s*")) {
            return null;
        }
        return name;
    }

    public static Coordinates coordinatesChecker(String coor) {
        Pattern pattern = Pattern.compile("\\s*(-?\\d+((\\s*;\\s*)|(\\s+))-?\\d+)\\s*");
        Matcher matcher = pattern.matcher(coor);
        int x; Long y;

        if (matcher.matches()) {
            String[] coordinates = matcher.group(1).split("(\\s*;\\s*)|(\\s+)");
            try {
                x = Integer.parseInt(coordinates[0]);
            } catch (NumberFormatException e) {
                System.out.println("Превышен формат числа x: введите число меньше 2 147 483 648");
                return null;
            }

            try {
                y = Long.parseLong(coordinates[1]);
            } catch (NumberFormatException e) {
                System.out.println("Превышен формат числа y: введите число меньше " + Long.MAX_VALUE + " + 1");
                return null;
            }
            Coordinates coordinates1 = new Coordinates(x, y);
            return coordinates1;
        }
        return null;
    }

    public static int ageChecker(String age) {
        Pattern pattern = Pattern.compile("\\s*([1-9][0-9]*)\\s*");
        Matcher matcher = pattern.matcher(age);

        if(matcher.matches()) {
            age = matcher.group(1);
            try {
                return Integer.parseInt(age);
            } catch (NumberFormatException e) {
                System.out.println("Превышен формат числа: введите число меньше 2 147 483 648");
                return -2;
            }
        }
        return -1;
    }

    public static DragonCave caveChecker(String cave) {
        Pattern pattern = Pattern.compile("\\s*(-?(\\d+\\.\\d*)|(\\d+))\\s*");
        Matcher matcher = pattern.matcher(cave);

        if (matcher.matches()) {
            cave = matcher.group(1);
            try {
                DragonCave cave1 = new DragonCave(Double.parseDouble(cave));
                return cave1;
            } catch (NumberFormatException e) {
                System.out.println("Превышен формат числа: введите число меньше " + Double.MAX_VALUE);
            }
        }
        return null;
    }

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
                    System.out.println("Объекта с таким id не существует!");
                }
            }

        } else {
            System.out.println("Команда должна содеражть аргумент в виде id!");
        }
        return null;
    }

    public static File fileChecker(String filename) {
        Pattern pattern = Pattern.compile("\\s*(\\S.*)\\s*");
        Matcher matcher = pattern.matcher(filename);
        if (matcher.matches()) {filename = matcher.group(1);}
        try {
            File file = new File(System.getenv(filename));
            if (file.exists()) {return file;}
        } catch (NullPointerException ignored) {}
        System.out.println("Файл не найден!");
        return null;
    }
}