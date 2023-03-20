package src.commands;

import src.collections.CollectionManager;
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
        if (CollectionManager.length() > 0) {
            CollectionManager.element(CollectionManager.getDragonByIndex(0));
        } else {
            OutputText.result("Empty");
        }
    }
}
