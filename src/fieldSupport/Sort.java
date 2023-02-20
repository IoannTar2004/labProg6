package src.fieldSupport;

import src.collectionClasses.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
    static List<Dragon> sortlist = new ArrayList<>(CollectionManager.getAll());

    public static void sort(String fieldNum) {
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
            int d1x = Integer.parseInt(d1.getCoordinates().split("; ")[0]);
            int d1y = Integer.parseInt(d1.getCoordinates().split("; ")[1]);
            int d2x = Integer.parseInt(d2.getCoordinates().split("; ")[0]);
            int d2y = Integer.parseInt(d1.getCoordinates().split("; ")[1]);

            return d2x + d2y - d1x + d1y;
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