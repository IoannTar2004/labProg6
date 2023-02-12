package src.commands;

import src.collectionClasses.CollectionManager;

public class CommandRemoveFirst {
    public static void execute() {
        CollectionManager.remove_first();
        System.out.println("Первый объект удалён!");
    }
}
