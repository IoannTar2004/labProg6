package src.commands;

import src.collectionClasses.CollectionManager;
import src.collectionClasses.Dragon;

public class CommandShow {
    public static void execute() {
        if (CollectionManager.length() > 0) {
            for (int i = 0; i < CollectionManager.length(); i++) {
                CollectionManager.element(CollectionManager.getDragonByIndex(i));
            }
        } else {
            System.out.println("Коллекция пуста.");
        }
        System.out.println();
    }
}
