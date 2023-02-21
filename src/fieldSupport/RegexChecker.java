package src.fieldSupport;

import src.collectionClasses.*;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexChecker {

    public static String nameCheck(String name) {
        if (name.matches("\\s*")) {
            return null;
        }
        return name;
    }

    public static Coordinates coordinatesChecker(String coor) {
        Pattern pattern = Pattern.compile("\\s*(-?\\d+((\\s*;\\s*)|(\\s+))-?\\d+)\\s*");
        Matcher matcher = pattern.matcher(coor);

        if (matcher.matches()) {
            String[] coordinates = matcher.group(1).split("(\\s*;\\s*)|(\\s+)");
            Coordinates coordinates1 = new Coordinates(Integer.parseInt(coordinates[0]), Long.parseLong(coordinates[1]));
            return coordinates1;
        }
        return null;
    }

    public static int ageChecker(String age) {
        Pattern pattern = Pattern.compile("\\s*([1-9][0-9]*)\\s*");
        Matcher matcher = pattern.matcher(age);

        if(matcher.matches()) {
            age = matcher.group(1);
            return Integer.parseInt(age);
        }
        return -1;
    }

    public static DragonCave caveChecker(String cave) {
        Pattern pattern = Pattern.compile("\\s*(-?(\\d+\\.\\d*)|(\\d+))\\s*");
        Matcher matcher = pattern.matcher(cave);

        if (matcher.matches()) {
            cave = matcher.group(1);
            DragonCave cave1 = new DragonCave(Double.parseDouble(cave));
            return cave1;
        }
        return null;
    }

    public static Dragon idChecker(String command) {
        Long id = IdChecker.check(command);
        if (id != -1) {
            for (int i = 0; i < CollectionManager.length(); i++) {
                Dragon dragon = CollectionManager.getDragonById(id);

                if (dragon != null) {return dragon;}
            }
            System.out.println("Объекта с таким id не существует!");
        }
        return null;
    }

    public static File fileChecker(String filename) {
        Pattern pattern = Pattern.compile("\\s*.\\S*\\s+\"*(.[^\"]*)\"*");
        Matcher matcher = pattern.matcher(filename);

        Pattern pattern_noargument = Pattern.compile("\\s*.\\S*\\s*");
        Matcher matcher_noargument = pattern_noargument.matcher(filename);

        if(matcher.matches()) {
            filename = matcher.group(1);
            File file = new File(filename);
            if (file.exists()) {
                return file;
            } else {System.out.println("Файл не найден!");}
        } else if (matcher_noargument.matches()) {
            System.out.println("Команда должна содержать путь до файла в качестве аргумента!");
        }
        return null;
    }
}
