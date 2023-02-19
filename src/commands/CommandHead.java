package src.commands;

import src.collectionClasses.CollectionManager;
import src.collectionClasses.Dragon;

public class CommandHead {
    public static void execute() {
        if (CollectionManager.length() > 0) {
            Dragon dragon = (Dragon) CollectionManager.getDragons().toArray()[0];
            CollectionManager.element(dragon);
        } else {
            System.out.println("Коллекция пуста!\n");
        }
    }
}
