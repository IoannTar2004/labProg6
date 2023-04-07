package src.server.commands;

import src.manager.ObjectsManager;
import src.support.Checks;
import src.collections.Dragon;
import src.tools.OutputText;

/**
 * Removes object by its ID.
 */
public class RemoveByIdCommand implements Command{
    /**
     * Removes object by its ID.
     */
    @Override
    public String execute(String mode, String[] command, String... args) {
        try {
            //TODO rewrite idChecker
            ObjectsManager objectsManager = new ObjectsManager();
            Dragon dragon = Checks.idChecker(command[1]);
            if (dragon == null) {
                return null;
            }
            objectsManager.remove(dragon);
            OutputText.result("Removed");
        } catch (ArrayIndexOutOfBoundsException e) {
            return OutputText.error("NoIdArgument");
        }
        return null;
    }
}
