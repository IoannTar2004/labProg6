package src.commands;

import src.collectionClasses.CollectionManager;

public class CommandHead {
    public static void execute() {
        if (CollectionManager.length() > 0) {
            CollectionManager.element(0);
            System.out.println();
        } else {
            System.out.println("Коллекция пуста!\n");
        }
    }
}
