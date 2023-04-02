package src.support;

import src.manager.ObjectsElements;
import src.manager.ObjectsCollectionManager;
import src.collections.*;

import java.util.*;

/**
 * class for sort objects in collection
 */
public class Sort {

    protected static List<Dragon> sortlist = new ArrayList<>();
    /**
     * Sort elements in collection using inner classes which implement Comparator interface and print them.
     * @param fieldNum number of {@link Dragon} field (1 - name, 2 - coordinates, 3 - age, etc).
     */
    public static void sort(DragonFields fieldNum, String... args) {
        ObjectsCollectionManager getters = new ObjectsCollectionManager();

        sortlist.clear();
        sortlist.addAll(getters.getAll());
        switch (fieldNum) {
            case NAME -> sortlist.sort(new SortByName());
            case COORDINATES -> sortlist.sort(new SortByCoordinates());
            case AGE -> sortlist.sort(new SortByAge());
            case COLOR -> sortlist.sort(new SortByColor());
            case TYPE -> sortlist.sort(new SortByType());
            case CHARACTER -> sortlist.sort(new SortByCharacter());
            case CAVE -> sortlist.sort(new SortByCave());
            default -> {
                return;
            }
        }
        Collections.reverse(sortlist);
        for(int i = 0; i < sortlist.size(); i++) {
            ObjectsElements objectsElements = new ObjectsElements();
            objectsElements.element(sortlist.get(i), args);
        }
        System.out.println();
        sortlist.clear();
    }


    public static class SortByName extends Sort implements Comparator<Dragon>{
        @Override
        public int compare(Dragon d1, Dragon d2) {
            ObjectsCollectionManager getters = new ObjectsCollectionManager();

            return d1.getName().compareTo(d2.getName());
        }
    }
    public static class SortByCoordinates extends Sort implements Comparator<Dragon> {
        @Override
        public int compare(Dragon d1, Dragon d2) {
            return d1.getSumCoordinate().compareTo(d2.getSumCoordinate());
        }
    }

    public static class SortByAge extends Sort implements Comparator<Dragon> {
        @Override
        public int compare(Dragon d1, Dragon d2) {
            return d1.getAge().compareTo(d2.getAge());
        }
    }

    public static class SortByColor extends Sort implements Comparator<Dragon> {
        @Override
        public int compare(Dragon d1, Dragon d2) {
            int x = Color.getEnumColor(d1.getColor()).ordinal();
            int y = Color.getEnumColor(d2.getColor()).ordinal();
            return x - y;
        }
    }

    public static class SortByType extends Sort implements Comparator<Dragon> {
        @Override
        public int compare(Dragon d1, Dragon d2) {
            int x = DragonType.getEnumType(d1.getType()).ordinal();
            int y = DragonType.getEnumType(d2.getType()).ordinal();;
            return x - y;
        }
    }

    public static class SortByCharacter extends Sort implements Comparator<Dragon> {
        @Override
        public int compare(Dragon d1, Dragon d2) {
            int x = DragonCharacter.getEnumCharacter(d1.getCharacter()).ordinal();
            int y = DragonCharacter.getEnumCharacter(d2.getCharacter()).ordinal();
            return x - y;
        }
    }

    public static class SortByCave extends Sort implements Comparator<Dragon>{
        @Override
        public int compare(Dragon d1, Dragon d2) {
            return (int) (d1.getCave()-d2.getCave());
        }
    }
}