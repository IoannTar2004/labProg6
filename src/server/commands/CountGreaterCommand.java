package src.server.commands;

import src.manager.ObjectsCollectionManager;
import src.manager.ObjectsManager;
import src.support.Checks;
import src.tools.OutputText;
import src.collections.Dragon;

/**
 * Count amount of objects which have greater age than entered.
 */
public class CountGreaterCommand implements Command {
    /**
     * Count amount of objects which have greater age than entered.
     */
    @Override
    public String execute(String mode, String[] command, String... args) {
        try {
            ObjectsManager objectsManager = new ObjectsManager();
            ObjectsCollectionManager getters = new ObjectsCollectionManager();
            Checks checks = new Checks(command[1]);
            Integer age1 = checks.ageChecker();

            if (age1 != null) {
                int count = 0;
                for (int i = 0; i < objectsManager.length(); i++) {
                    Dragon dragon = getters.getDragonByIndex(i);
                    if (getters.getAge(dragon) > age1) {
                        count++;
                    }
                }
                return String.valueOf(count);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return OutputText.error("NoAgeArgument");
        }
        return null;
    }
}
