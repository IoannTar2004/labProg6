package src.commands;

import src.collectionClasses.CollectionManager;
import src.collectionClasses.Dragon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandFilterByCave {
    public static void preexecute(String command) {
        String cave;
        Pattern pattern = Pattern.compile("\\s*filter_by_cave\\s+(-?\\d+\\.\\d+)\\s*");
        Matcher matcher = pattern.matcher(command);

        Pattern pattern1 = Pattern.compile("\\s*filter_by_cave\\s+(-?\\d+\\.-\\d+)\\s*");
        Matcher matcher1 = pattern1.matcher(command);

        Pattern pattern2 = Pattern.compile("\\s*filter_by_cave\\s*");
        Matcher matcher2 = pattern2.matcher(command);

        if (matcher.matches()) {
            cave = matcher.group(1);
            execute(Double.parseDouble(cave));
        } else if (matcher1.matches()) {
            System.out.println("Дробное часть числа не может быть отрицательной!");
        } else if (matcher2.matches()) {
            System.out.println("Команда должна содержать аргумент!");
        } else {
            System.out.println("Глубина пещеры - дробное число черех точку!");
        }
    }

    private static void execute(double cave) {
        boolean check = false;
        for (int i = 0; i < CollectionManager.length(); i++) {
            Dragon dragon = CollectionManager.getDragonByIndex(i);
            if (CollectionManager.getCave(dragon) == cave) {
                CollectionManager.element(dragon);
                check = true;
            }
        }
        if (!check) {
            System.out.println("Объекты не найдены!");
        }
    }
}
