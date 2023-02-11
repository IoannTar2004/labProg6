package src.commands;

import src.collectionClasses.CollectionManager;

public class CommandShow {
    public static void execute() {
        for(int i = 0; i < CollectionManager.length(); i++) {
            System.out.println("Имя:" + CollectionManager.getName(i));
        }
    }
}
