package src.commands;

import src.collectionClasses.CollectionManager;
import src.support.Checks;
import src.collectionClasses.Dragon;
import src.tools.OutputText;

/**
 * Removes object by its ID.
 */
public class RemoveByIdCommand implements Command{
    /**
     * Removes object by its ID.
     *
     * @param mode
     * @param line
     * @param command command with ID
     */
    @Override
    public void execute(String mode, String[] line, String... command) {
        try {
            Dragon dragon = Checks.idChecker(command[1]);
            if (dragon == null) {
                return;
            }
            CollectionManager.remove(dragon);
            OutputText.result("Removed");
        } catch (ArrayIndexOutOfBoundsException e) {
            OutputText.error("NoIdArgument");
        }
    }
}
