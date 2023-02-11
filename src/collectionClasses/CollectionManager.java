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
    public static Long getId(int i) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        return dragon.getId();
    }
    public static String getCoordinates(int i) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        return dragon.getCoordinates();
    }
    public static String getColor(int i) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        return dragon.getColor();
    }
    public static String getCharacter(int i) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        return dragon.getCharacter();
    }
    public static double getCave(int i) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        return dragon.getCave();
    }
    public static String getCreationDate(int i) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        return dragon.getCreationDate();
    }
    public static Integer getAge(int i) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        return dragon.getAge();
    }
    public static String getType(int i) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        return dragon.getType();
    }
}
