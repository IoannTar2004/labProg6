package src.commands;

import src.collectionClasses.CollectionManager;

/**
 * Clears collection.
 */
public class CommandClear {
    /**
     * Clears collection.
     */
    public static void execute() {
        CollectionManager.clear();
        System.out.println("Коллекция очищена!");
    }
}
