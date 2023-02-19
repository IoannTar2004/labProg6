package src.commands;

import src.collectionClasses.CollectionManager;
import src.collectionClasses.Dragon;

public class CommandHead {
    public static void execute() {
        if (CollectionManager.length() > 0) {
            CollectionManager.element(CollectionManager.getDragonByIndex(0));
        } else {
            System.out.println("Коллекция пуста!\n");
        }
    }
}
