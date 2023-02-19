package src.checkers;

import src.checkers.IdChecker;
import src.collectionClasses.Coordinates;
import src.collectionClasses.DragonCave;

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

    public static Long idChecker(String command) {
        String id = IdChecker.check(command, "id");
        if (id != null) {
            return Long.parseLong(id);
        }
        return -1L;
    }

    public static int idIndexChecker(String command) {
        String id = IdChecker.check(command, "index");
        if (id != null) {
            return Integer.parseInt(id);
        }
        return -1;
    }
}
