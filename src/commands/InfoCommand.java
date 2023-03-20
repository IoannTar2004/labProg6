package src.commands;

import src.collectionManager.CollectionManager;
import src.support.InitializationDate;
/**
 * Prints information about collection.
 */
public class InfoCommand implements Command {
    /**
     * Prints information about collection.
     */
    @Override
    public void execute(String mode, String[] command, String... args) {
        System.out.println("Тип коллекции: ArrayDeque;\n" +
                "Дата инициализации: " + InitializationDate.getDate() + ";\n" +
                "Количество элементов: " + CollectionManager.length() + ".\n");
    }
}
