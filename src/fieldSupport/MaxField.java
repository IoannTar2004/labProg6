package src.fieldSupport;

import src.collectionClasses.Color;

import java.util.Collections;

public class MaxField extends Sort {

    public static void max(String fieldNum) {
        switch (fieldNum) {
            case "1" -> maxName();
            case "2" -> maxSumCoordinates();
            case "3" -> maxAge();
            case "4" -> maxColor();
            case "5" -> maxType();
            case "6" -> maxCharacter();
            case "7" -> maxCave();
        }
    }

    public static String maxName() {
        sortlist.sort(new SortByName());
        Collections.reverse(sortlist);

        return sortlist.get(0).getName();
    }

    public static Long maxSumCoordinates() {
        sortlist.sort(new SortByCoordinates());
        int x = Integer.parseInt(sortlist.get(0).getCoordinates().split("; ")[0]);
        long y = Long.parseLong(sortlist.get(0).getCoordinates().split("; ")[1]);
        Collections.reverse(sortlist);

        return x + y;
    }

    public static String maxCoordinates() {
        sortlist.sort(new SortByCoordinates());
        Collections.reverse(sortlist);

        return sortlist.get(0).getCoordinates();
    }

    public static int maxAge() {
        sortlist.sort(new SortByAge());
        Collections.reverse(sortlist);

        return sortlist.get(0).getAge();
    }

    public static int maxColor() {
        sortlist.sort(new SortByColor());
        Collections.reverse(sortlist);

        return Color.getEnumColor(sortlist.get(0).getColor()).ordinal();
    }

    public static int maxType() {
        sortlist.sort(new SortByType());
        Collections.reverse(sortlist);

        return Color.getEnumColor(sortlist.get(0).getType()).ordinal();
    }

    public static int maxCharacter() {
        sortlist.sort(new SortByCharacter());
        Collections.reverse(sortlist);

        return Color.getEnumColor(sortlist.get(0).getCharacter()).ordinal();
    }

    public static double maxCave() {
        sortlist.sort(new SortByCave());
        Collections.reverse(sortlist);

        return sortlist.get(0).getCave();
    }
}
