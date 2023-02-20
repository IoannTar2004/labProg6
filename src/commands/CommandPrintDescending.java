package src.commands;

import src.checkers.Sort;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandPrintDescending {
    public static void execute() {
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
                switch (field) {
                    case "1" -> Sort.sort(new Sort.SortByName());
                    case "2" -> Sort.sort(new Sort.SortByCoodinates());
                    case "3" -> Sort.sort(new Sort.SortByAge());
                    case "4" -> Sort.sort(new Sort.SortByColor());
                    case "5" -> Sort.sort(new Sort.SortByType());
                    case "6" -> Sort.sort(new Sort.SortByCharacter());
                    case "7" -> Sort.sort(new Sort.SortByCave());
                }
            }
        } while (!matcher.matches());
    }
}
