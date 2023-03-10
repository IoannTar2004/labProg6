package src.commands;

import src.collectionClasses.DragonCave;
import src.support.Checks;
import src.tools.OutputText;
import src.collectionClasses.CollectionManager;
import src.collectionClasses.Dragon;

/**
 * Prints objects if they have a same cave depth
 */
public class FilterByCaveCommand implements Command {
    /**
     * Prints objects if they have a same cave depth.
     */
    @Override
    public void execute(String... cave) {
        boolean check = false;
        try {
            DragonCave cave1 = Checks.caveChecker(cave[1]);
            if (cave1 != null) {
                for (int i = 0; i < CollectionManager.length(); i++) {
                    Dragon dragon = CollectionManager.getDragonByIndex(i);
                    if (CollectionManager.getCave(dragon) == cave1.getDepth()) {
                        CollectionManager.element(dragon);
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
