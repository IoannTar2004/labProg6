package src.support;

import src.collectionClasses.*;

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
    public static void sort(String fieldNum) {
        sortlist.clear();
        sortlist.addAll(CollectionManager.getAll());
        switch (fieldNum) {
            case "1" -> sortlist.sort(new SortByName());
            case "2" -> sortlist.sort(new SortByCoordinates());
            case "3" -> sortlist.sort(new SortByAge());
            case "4" -> sortlist.sort(new SortByColor());
            case "5" -> sortlist.sort(new SortByType());
            case "6" -> sortlist.sort(new SortByCharacter());
            case "7" -> sortlist.sort(new SortByCave());
            default -> {
                return;
            }
        }
        Collections.reverse(sortlist);
        for(int i = 0; i < sortlist.size(); i++) {
            CollectionManager.element(sortlist.get(i));
        }
        System.out.println();
        sortlist.clear();
    }


    public static class SortByName extends Sort implements Comparator<Dragon>{
        @Override
        public int compare(Dragon d1, Dragon d2) {
            return CollectionManager.getName(d1).compareTo(CollectionManager.getName(d2));
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