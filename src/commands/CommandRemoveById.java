package src.commands;

import src.collectionClasses.CollectionManager;
import src.support.Checks;
import src.collectionClasses.Dragon;

/**
 * Removes object by its ID.
 */
public class CommandRemoveById {
    /**
     * Removes object by its ID.
     * @param command command with ID
     */
    public static void execute(String command) {
        Dragon dragon = Checks.idChecker(command);
        if (dragon == null) {
            return;
        }
        CollectionManager.remove(dragon);
        System.out.println("Объект удалён из коллекции\n");
    }
}
