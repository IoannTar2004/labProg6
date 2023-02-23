package src.tools;

import src.collectionClasses.CollectionManager;
import src.collectionClasses.Dragon;

/**
 * class for id generate
 */
public class IdGenerator {
    /**
     * generate 12-digit id. It is guaranteed that object will have unique id.
     * @return id
     */
    public static Long generate() {
        Long id = Long.parseLong(String.valueOf(Math.round((Math.random() * Math.pow(10, 11)) + 9*Math.pow(10, 11)-1)));
        for (int i = 0; i < CollectionManager.length(); i++) {
            Dragon dragon = CollectionManager.getDragonByIndex(i);
            if (id == CollectionManager.getId(dragon)) {
                id = Long.parseLong(String.valueOf(Math.round((Math.random() * Math.pow(10, 11)) + 9*Math.pow(10, 11)-1)));
                i = 0;
            }
        }
        return id;
    }
}
