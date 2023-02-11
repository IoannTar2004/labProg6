package src.collectionClasses;

import java.util.ArrayDeque;
import java.util.Deque;

public class CollectionManager {
    private static Deque<Dragon> dragons = new ArrayDeque<>();
    public static void add(Dragon dragon) {
        dragons.add(dragon);
    }
    public static int length() {
        return dragons.size();
    }
    public static String getName(int i) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        return dragon.getName();
    }

}
