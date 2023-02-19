package src.commands;

import src.collectionClasses.DragonFields;

import java.util.Scanner;

public class CommandAddIfMax {
    public static void execute() {
        Scanner scanner = new Scanner(System.in);
        String data;

        System.out.println("\t\tВведите номер поля Dragon" +
                "1 - имя\n" +
                "2 - координаты\n" +
                "3 - возраст\n" +
                "4 - цвет\n" +
                "5 - тип\n" +
                "6 - характер\n" +
                "7 - глубина пещеры\n");
        DragonFields fields;
        do {
            data = scanner.nextLine();
            fields = DragonFields.getFieldByNumber(data);
            if (fields != null) {

            }
        } while (fields == null);
    }
}
