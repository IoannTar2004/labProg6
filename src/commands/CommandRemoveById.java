package src.commands;

import src.collectionClasses.CollectionManager;
import src.fieldSupport.Checks;
import src.collectionClasses.Dragon;

public class CommandRemoveById {
    public static void execute(String command) {
        Dragon dragon = Checks.idChecker(command);
        if (dragon == null) {
            return;
        }
        CollectionManager.remove(dragon);
        System.out.println("Объект удалён из коллекции\n");
    }
}
