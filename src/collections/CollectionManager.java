package src.collections;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Controls the collection
 */
public class CollectionManager {
    private static Deque<Dragon> dragons = new ArrayDeque<>();

    public static void add(Dragon dragon) {
        dragons.add(dragon);
    }
    public static int length() {
        return dragons.size();
    }
    public static void remove(Dragon dragon) {
        dragons.remove(dragon);
    }
    public static void clear() {dragons.clear();}
    public static void remove_first() {
        dragons.removeFirst();
    }

    public static void element(Dragon dragon) {
        System.out.println(dragon.toString());
    }

    //getters
    public static Dragon getDragonById(Long id) {
        for (int i = 0; i < dragons.size(); i++) {
            Dragon dragon = (Dragon) dragons.toArray()[i];
            if (id == dragon.getId()) {
                return dragon;
            }
        }
        return null;
    }

    public static Dragon getDragonByIndex(int index) {return (Dragon) dragons.toArray()[index];}
    public static Deque<Dragon> getAll() {return dragons;}

    public static String getName(Dragon dragon) {
        return dragon.getName();
    }
    public static Long getId(Dragon dragon) {
        return dragon.getId();
    }
    public static String getCoordinates(Dragon dragon) {
        return dragon.getCoordinates();
    }
    public static String getColor(Dragon dragon) {
        return dragon.getColor();
    }
    public static String getCharacter(Dragon dragon) {
        return dragon.getCharacter();
    }
    public static double getCave(Dragon dragon) {
        return dragon.getCave();
    }
    public static Integer getAge(Dragon dragon) {
        return dragon.getAge();
    }
    public static String getType(Dragon dragon) {
        return dragon.getType();
    }
}
