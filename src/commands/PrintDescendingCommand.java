package src.commands;

import src.support.Sort;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Prints objects in descending order by its value of field.
 */
public class PrintDescendingCommand implements Command {
    /**
     * Triggers when user enters this command to terminal
     */
    @Override
    public void execute(String mode, String input, String... args) {
        Scanner scanner = new Scanner(System.in);
        Matcher matcher;

        System.out.println("\t\tВведите номер поля, по которому будет производиться сортировка\n" +
                "1 - имя\n" +
                "2 - координаты\n" +
                "3 - возраст\n" +
                "4 - цвет\n" +
                "5 - тип\n" +
                "6 - характер\n" +
                "7 - глубина пещеры");
        Pattern pattern = Pattern.compile("\\s*([1-7])\\s*");
        do {
            String field = scanner.nextLine();
            matcher = pattern.matcher(field);

            if(matcher.matches()) {
                field = matcher.group(1);
                Sort.sort(field);
            } else {System.out.println("Введите число от 1 до 7!");}

        } while (!matcher.matches());
    }

    /**
     * Triggers when command is from script file. Object is not created if at least one of the argument is invalid.
     * @param arg number of field
     */
    public static void executeWithScript(String arg) {
        Pattern pattern = Pattern.compile("\\s*([1-7])\\s*");
        Matcher matcher;
        matcher = pattern.matcher(arg);

        if(matcher.matches()) {
            arg = matcher.group(1);
            Sort.sort(arg);
        }
    }
}
