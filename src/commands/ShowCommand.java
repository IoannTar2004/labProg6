package src.commands;

import src.collectionClasses.CollectionManager;
import src.collectionClasses.DragonElements;
import src.tools.OutputText;

import java.util.Arrays;

/**
 * Prints all objects in collection
 */
public class ShowCommand implements Command {

    /**
     * Prints objects in collection. If arguments are absent it print all elements.
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
        System.out.println();
    }
}
