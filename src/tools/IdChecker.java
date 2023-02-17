package src.tools;

import src.collectionClasses.CollectionManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdChecker {
    public static int check(String command) {
        System.out.println("yes");
        String dragon_id;
        boolean check = false;

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
