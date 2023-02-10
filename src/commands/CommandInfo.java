package src.commands;

import src.collectionClasses.CollArrayDeque;

import java.util.Date;

public class CommandInfo implements CollArrayDeque {
    private static String datedisc;

    public static String date() {
        Date date = new Date();
        datedisc = date.getDate() + "." + date.getMonth() + "." + (date.getYear()+1900)
                + " - " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
        return datedisc;
    }
    public static void execute() {
        System.out.println("Тип коллекции: ArrayDeque;\n" +
                "Дата инициализации: " + datedisc + ";\n" +
                "Количество элементов: " + dragons.size() + ".\n");
    }
}
