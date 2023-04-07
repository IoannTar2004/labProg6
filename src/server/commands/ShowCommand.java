package src.server.commands;

import src.manager.ObjectsCollectionManager;
import src.manager.ObjectsManager;
import src.manager.ObjectsElements;
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
    public Object[] execute(String mode, String[] command, String... args) {
        StringBuilder builder = new StringBuilder();
        ObjectsManager objectsManager = new ObjectsManager();
        ObjectsElements objectsElements = new ObjectsElements();
        ObjectsCollectionManager getters = new ObjectsCollectionManager();

        if (objectsManager.length() > 0) {
            for (int i = 0; i < objectsManager.length(); i++) {
                builder.append(objectsElements.element(getters.getDragonByIndex(i), command)).append("\n");
            }
            return new Object[]{builder + "\n"};
        } else {
            return new Object[]{OutputText.result("Empty")};
        }
    }
}
