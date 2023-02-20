package src.fieldManager;

import src.collectionClasses.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public static void sort(Sort sort) {
        List<Dragon> sortlist = new ArrayList<>(CollectionManager.getAll());
        sortlist.sort((Comparator<? super Dragon>) sort);
        for(int i = sortlist.size() - 1; i >= 0; i--) {
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

    public static class SortByCoodinates extends Sort implements Comparator<Dragon> {
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