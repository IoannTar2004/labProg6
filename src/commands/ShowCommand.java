package src.commands;

import src.collections.CollectionManager;
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
        if (CollectionManager.length() > 0) {
            for (int i = 0; i < CollectionManager.length(); i++) {
                DragonElements.element(CollectionManager.getDragonByIndex(i), command);
            }
        } else {
            OutputText.result("Empty");
        }
    }
}
