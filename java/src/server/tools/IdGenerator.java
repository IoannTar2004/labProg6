package src.server.tools;

import src.server.manager.ObjectsCollectionManager;
import src.server.manager.ObjectsManager;
import src.collections.Dragon;

/**
 * class for id generate
 */
public class IdGenerator {
    /**
     * generate 12-digit id. It is guaranteed that object will have unique id.
     * @return id
     */
    public static Long generate() {
        ObjectsManager objectsManager = new ObjectsManager();
        ObjectsCollectionManager getters = new ObjectsCollectionManager();
        Long id = Long.parseLong(String.valueOf(Math.round((Math.random() * Math.pow(10, 11)) + 9*Math.pow(10, 11)-1)));

        for (int i = 0; i < objectsManager.length(); i++) {
            Dragon dragon = getters.getDragonByIndex(i);
            if (id == getters.getId(dragon)) {
                id = generate();
                i = 0;
            }
        }
        return id;
    }
}
