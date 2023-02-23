package src.commands;

import src.collectionClasses.CollectionManager;
import java.util.Date;

/**
 * Prints information about collection.
 */
public class CommandInfo{
    private static String datedisc;

    /**
     * Forms a normal view of initialization date.
     * @return formed date
     */
    public static String date() {
        Date date = new Date();
        datedisc = date.getDate() + "." + date.getMonth() + "." + (date.getYear()+1900)
                + " - " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
        return datedisc;
    }
    /**
     * Prints information about collection.
     */
    public static void execute() {
        System.out.println("Тип коллекции: ArrayDeque;\n" +
                "Дата инициализации: " + datedisc + ";\n" +
                "Количество элементов: " + CollectionManager.length() + ".\n");
    }
}
