package src.commands;

import src.tools.OutputText;
import src.collectionClasses.CollectionManager;
import src.collectionClasses.Dragon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Prints objects if they have a same cave depth
 */
public class FilterByCaveCommand implements Command {
    /**
     * Method checks if the cave depth entered correctly then runs {@link FilterByCaveCommand#execute(String...)}.
     * If this is not the case print mistake messages.
     * @param command command with argument as dragon's cave depth
     */
    public static void preexecute(String command) {
        String cave;
        Pattern pattern = Pattern.compile("\\s*filter_by_cave\\s*(-?(\\d+\\.\\d*)|(\\d+))\\s*");
        Matcher matcher = pattern.matcher(command);

        Pattern pattern1 = Pattern.compile("\\s*filter_by_cave\\s+(-?\\d+\\.-\\d+)\\s*");
        Matcher matcher1 = pattern1.matcher(command);

        Pattern pattern2 = Pattern.compile("\\s*filter_by_cave\\s*");
        Matcher matcher2 = pattern2.matcher(command);

        if (matcher.matches()) {
            cave = matcher.group(1);
            //execute(cave);
        } else if (matcher1.matches()) {
            System.out.println("Дробное часть числа не может быть отрицательной!");
        } else if (matcher2.matches()) {
            OutputText.error("NoCaveArgument");
        } else {
            System.out.println("Глубина пещеры - дробное число через точку!");
        }
    }

    /**
     * Prints objects if they have a same cave depth.
     */
    @Override
    public void execute(String... cave) {
        boolean check = false;
        for (int i = 0; i < CollectionManager.length(); i++) {
            Dragon dragon = CollectionManager.getDragonByIndex(i);
            if (CollectionManager.getCave(dragon) == Double.parseDouble(cave[0])) {
                CollectionManager.element(dragon);
                check = true;
            }
        }
        if (!check) {
            OutputText.error("ObjectsNotFound");
        }
    }
}
