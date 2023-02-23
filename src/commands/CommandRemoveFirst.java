package src.commands;

import src.collectionClasses.CollectionManager;

/**
 * Removes the first object in collection.
 */
public class CommandRemoveFirst {
    /**
     * Removes the first object in collection.
     */
    public static void execute() {
        CollectionManager.remove_first();
        System.out.println("Первый объект удалён!\n");
    }
}
