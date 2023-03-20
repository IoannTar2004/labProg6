package src.commands;

import src.collectionManager.CollectionManager;
import src.collectionManager.ObjectsGetters;
import src.collectionManager.ObjectsManager;
import src.collections.DragonElements;
import src.tools.OutputText;

/**
 * Prints all objects in collection
 */
public class ShowCommand implements Command {

    /**
     * Prints objects in collection. If arguments are absent it prints all elements.
     * It can print some fields in relation to numbers.
     */
    @Override
    public void execute(String mode, String[] command, String... args) {
        ObjectsManager objectsManager = new ObjectsManager();
        DragonElements dragonElements = new DragonElements();
        ObjectsGetters getters = new ObjectsGetters();

        if (objectsManager.length() > 0) {
            for (int i = 0; i < objectsManager.length(); i++) {
                dragonElements.element(getters.getDragonByIndex(i), command);
            }
        } else {
            OutputText.result("Empty");
        }
    }
}
