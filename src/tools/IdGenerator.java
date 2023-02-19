package src.tools;

import src.collectionClasses.CollectionManager;
import src.collectionClasses.Dragon;

public class IdGenerator {
    public static Long generate() {
        Long id = Long.parseLong(String.valueOf(Math.round((Math.random() * Math.pow(10, 12)) + Math.pow(10, 11))));
        for (int i = 0; i < CollectionManager.length(); i++) {
            Dragon dragon = CollectionManager.getDragonByIndex(i);
            if (id == CollectionManager.getId(dragon)) {
                id = Long.parseLong(String.valueOf(Math.round((Math.random() * Math.pow(10, 12)) + Math.pow(10, 11))));
                i = 0;
            }
        }
        return id;
    }
}
