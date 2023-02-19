package src.commands;

import src.collectionClasses.CollectionManager;
import src.checkers.RegexChecker;

public class CommandRemoveById {
    public static void execute(String command) {
        int index = RegexChecker.idIndexChecker(command);
        if (index == -1) {return;}

        CollectionManager.remove(index);
        System.out.println("Объект удалён из коллекции\n");
    }
}
