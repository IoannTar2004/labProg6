package src.commands;

import src.collectionClasses.CollectionManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandRevoveById {
    public static void preexecute(String command) {
        String dragon_id;
        boolean check = false;

        Pattern pattern = Pattern.compile("\\s*remove_by_id\\s+(\\d{12})\\s*");
        Matcher matcher = pattern.matcher(command);

        Pattern pattern1 = Pattern.compile("\\s*remove_by_id\\s+(\\d{1,11}|\\d{13,})\\s*");
        Matcher matcher1 = pattern1.matcher(command);

        Pattern pattern2 = Pattern.compile("\\s*remove_by_id\\s+(.[^0-9]*)");
        Matcher matcher2 = pattern2.matcher(command);

        Pattern pattern3 = Pattern.compile("\\s*remove_by_id\\s+(-\\d{12})\\s*");
        Matcher matcher3 = pattern3.matcher(command);

        Pattern pattern4 = Pattern.compile("\\s*remove_by_id\\s+(-\\d{1,11}|-\\d{13,})\\s*");
        Matcher matcher4 = pattern4.matcher(command);

        if (matcher.matches()) {
            dragon_id = matcher.group(1);
            for(int i = 0; i < CollectionManager.length(); i++) {
                if(Long.parseLong(dragon_id) == CollectionManager.getId(i)) {
                    execute(i);
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println("Объекта с таким id не существует!");
            }
        } else if (matcher1.matches()) {
            System.out.println("id должен содержать 12 цифр!");
        } else if (matcher3.matches()) {
            System.out.println("id должен быть положительным!");
        } else if (matcher2.matches()) {
            System.out.println("id должен содержать 12 цифр в десятичной сс!");
        } else if (matcher4.matches()) {
            System.out.println("id должен содержать 12 цифр и быть положительным!");
        }
    }

    private static void execute(int i) {
        CollectionManager.remove(i);
        System.out.println("Объект удалён из коллекции\n");
    }
}
