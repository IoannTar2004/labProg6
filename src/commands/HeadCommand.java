package src.commands;

import src.collectionManager.CollectionManager;
import src.collectionManager.ObjectsGetters;
import src.collectionManager.ObjectsManager;
import src.collections.DragonElements;
import src.tools.OutputText;

/**
 * Prints the first object in collection if it is not empty.
 */
public class HeadCommand implements Command {

    /**
     * Prints the first object in collection if it is not empty.
     */
    @Override
    public void execute(String mode, String[] command, String... args) {
        ObjectsManager objectsManager = new ObjectsManager();
        DragonElements dragonElements = new DragonElements();
        ObjectsGetters getters = new ObjectsGetters();

        if (objectsManager.length() > 0) {
            dragonElements.element(getters.getDragonByIndex(0));
        } else {
            OutputText.result("Empty");
        }
    }
}
