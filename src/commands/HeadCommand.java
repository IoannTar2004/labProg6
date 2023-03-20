package src.commands;

import src.collectionManager.ObjectsGetters;
import src.collectionManager.ObjectsManager;
import src.collectionManager.ObjectsElements;
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
        ObjectsElements objectsElements = new ObjectsElements();
        ObjectsGetters getters = new ObjectsGetters();

        if (objectsManager.length() > 0) {
            objectsElements.element(getters.getDragonByIndex(0), command);
        } else {
            OutputText.result("Empty");
        }
    }
}
