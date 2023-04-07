package src.server.commands;

import src.manager.ObjectsCollectionManager;
import src.manager.ObjectsManager;
import src.collections.DragonCave;
import src.manager.ObjectsElements;
import src.support.Checks;
import src.tools.OutputText;
import src.collections.Dragon;

/**
 * Prints objects if they have a same cave depth
 */
public class FilterByCaveCommand implements Command {
    /**
     * Prints objects if they have a same cave depth.
     */
    @Override
    public Object[] execute(String mode, String[] command, String... args) {
        boolean check = false;
        StringBuilder dragonsList = new StringBuilder();

        try {
            Checks checks = new Checks(command[1]);
            DragonCave cave1 = checks.caveChecker();
            ObjectsManager objectsManager = new ObjectsManager();
            ObjectsCollectionManager getters = new ObjectsCollectionManager();

            if (cave1 != null) {
                for (int i = 0; i < objectsManager.length(); i++) {
                    Dragon dragon = getters.getDragonByIndex(i);
                    if (getters.getCave(dragon) == cave1.getDepth()) {
                        dragonsList.append(dragon).append("\n");
                        check = true;
                    }
                }
                if (!check) {
                    return new Object[]{OutputText.error("ObjectsNotFound")};
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return new Object[]{OutputText.error("NoCaveArgument")};
        }
        return new Object[]{dragonsList};
    }
}
