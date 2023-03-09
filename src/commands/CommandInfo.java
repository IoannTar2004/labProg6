package src.commands;

import src.collectionClasses.CollectionManager;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Prints information about collection.
 */
public class CommandInfo{
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy - HH:mm:ss");

    /**
     * Forms a normal view of initialization date.
     * @return formed date
     */
    public static String date() {
        Date date = new Date();
        return formatter.format(date);
    }
    /**
     * Prints information about collection.
     */
    public static void execute() {
        System.out.println("Тип коллекции: ArrayDeque;\n" +
                "Дата инициализации: " + date() + ";\n" +
                "Количество элементов: " + CollectionManager.length() + ".\n");
    }
}
