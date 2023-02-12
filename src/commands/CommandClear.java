package src.commands;

import src.collectionClasses.CollectionManager;

public class CommandClear {
    public static void execute() {
        CollectionManager.removeAll();
        System.out.println("Коллекция очищена!");
    }
}
