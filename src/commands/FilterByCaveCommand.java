package src.commands;

import src.collectionManager.ObjectsGetters;
import src.collectionManager.ObjectsManager;
import src.collections.DragonCave;
import src.collections.DragonElements;
import src.support.Checks;
import src.tools.OutputText;
import src.collectionManager.CollectionManager;
import src.collections.Dragon;

/**
 * Prints objects if they have a same cave depth
 */
public class FilterByCaveCommand implements Command {
    /**
     * Prints objects if they have a same cave depth.
     */
    @Override
    public void execute(String mode, String[] command, String... args) {
        boolean check = false;

        try {
            Checks checks = new Checks(command[1]);
            DragonCave cave1 = checks.caveChecker();
            ObjectsManager objectsManager = new ObjectsManager();
            DragonElements dragonElements = new DragonElements();
            ObjectsGetters getters = new ObjectsGetters();

            if (cave1 != null) {
                for (int i = 0; i < objectsManager.length(); i++) {
                    Dragon dragon = getters.getDragonByIndex(i);
                    if (getters.getCave(dragon) == cave1.getDepth()) {
                        dragonElements.element(dragon);
                        check = true;
                    }
                }
                if (!check) {
                    OutputText.error("ObjectsNotFound");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            OutputText.error("NoCaveArgument");
        }
    }
}
