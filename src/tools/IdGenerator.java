package src.tools;

import src.collectionClasses.CollectionManager;

public class IdGenerator {
    public static Long generate() {
        Long id = Long.parseLong(String.valueOf(Math.round((Math.random() * Math.pow(10, 11)) + Math.pow(10, 11))));
        for (int i = 0; i < CollectionManager.length(); i++) {
            if (id == CollectionManager.getId(i)) {
                id = Long.parseLong(String.valueOf(Math.round((Math.random() * Math.pow(10, 11)) + Math.pow(10, 11))));
                i = 0;
            }
        }
        return id;
    }
}
