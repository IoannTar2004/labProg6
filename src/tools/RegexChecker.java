package src.tools;

import src.collectionClasses.CollectionManager;
import src.collectionClasses.Coordinates;
import src.collectionClasses.DragonCave;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexChecker {
    public static Long idCheck(String id) {
        String dragon_id;

        Pattern pattern = Pattern.compile("\\s*(\\d{12})\\s*");
        Matcher matcher = pattern.matcher(id);

        Pattern pattern1 = Pattern.compile("\\s*(\\d{1,11}|\\d{13,})\\s*");
        Matcher matcher1 = pattern1.matcher(id);

        Pattern pattern2 = Pattern.compile("\\s*.*\\s*");
        Matcher matcher2 = pattern2.matcher(id);

        Pattern pattern3 = Pattern.compile("\\s*-\\d{12}\\s*");
        Matcher matcher3 = pattern3.matcher(id);

        Pattern pattern4 = Pattern.compile("\\s*-\\d{1,11}|-\\d{13,}\\s*");
        Matcher matcher4 = pattern4.matcher(id);

        Pattern pattern5 = Pattern.compile("\\s*-?\\d*\\.\\d+\\s*");
        Matcher matcher5 = pattern5.matcher(id);

        if (matcher.matches()) {
            return Long.parseLong(id);
        } else if (matcher1.matches()) {
            System.out.print("id должен содержать 12 цифр!");
        } else if (matcher3.matches()) {
            System.out.print("id должен быть положительным!");
        } else if (matcher4.matches()) {
            System.out.print("id должен содержать 12 цифр и быть положительным!");
        } else if (matcher5.matches()) {
            System.out.print("id должен быть целым положительным числом");
        } else if (matcher2.matches()) {
            System.out.print("id должен содержать 12 цифр в десятичной сс!");
        }
        return -1L;
    }

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
        Pattern pattern = Pattern.compile("\\s*(-?\\d+\\.\\d+)\\s*");
        Matcher matcher = pattern.matcher(cave);

        if (matcher.matches()) {
            cave = matcher.group(1);
            DragonCave cave1 = new DragonCave(Double.parseDouble(cave));
            return cave1;
        }
        return null;
    }

    public static int idChecker(String command) {
        String dragon_id;

        Pattern pattern = Pattern.compile("\\s*.*\\s+(\\d{12})\\s*");
        Matcher matcher = pattern.matcher(command);

        Pattern pattern1 = Pattern.compile("\\s*.*\\s+(\\d{1,11}|\\d{13,})\\s*");
        Matcher matcher1 = pattern1.matcher(command);

        Pattern pattern2 = Pattern.compile("\\s*.*\\s+.*");
        Matcher matcher2 = pattern2.matcher(command);

        Pattern pattern3 = Pattern.compile("\\s*.*\\s+-\\d{12}\\s*");
        Matcher matcher3 = pattern3.matcher(command);

        Pattern pattern4 = Pattern.compile("\\s*.*\\s+(-\\d{1,11}|-\\d{13,})\\s*");
        Matcher matcher4 = pattern4.matcher(command);

        Pattern pattern5 = Pattern.compile("\\s*.*\\s+-?\\d*\\.\\d+\\s*");
        Matcher matcher5 = pattern5.matcher(command);

        Pattern pattern_noargument = Pattern.compile("\\s*.*\\s*");
        Matcher matcher_noargument = pattern_noargument.matcher(command);
        if (matcher.matches()) {
            dragon_id = matcher.group(1);
            for(int i = 0; i < CollectionManager.length(); i++) {
                if(Long.parseLong(dragon_id) == CollectionManager.getId(i)) {
                    return i;
                }
            }
            System.out.println("Объекта с таким id не существует!");
        } else if (matcher1.matches()) {
            System.out.println("id должен содержать 12 цифр!");
        } else if (matcher3.matches()) {
            System.out.println("id должен быть положительным!");
        } else if (matcher4.matches()) {
            System.out.println("id должен содержать 12 цифр и быть положительным!");
        } else if (matcher5.matches()) {
            System.out.println("id должен быть целым положительным числом");
        } else if (matcher_noargument.matches()) {
            System.out.println("Команда должна содержать аргумент!");
        } else if (matcher2.matches()) {
            System.out.println("id должен содержать 12 цифр в десятичной сс!");
        }
        return -1;
    }
}
