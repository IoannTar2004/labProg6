package src.fieldSupport;

import src.collectionClasses.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List<Dragon> sortlist = new ArrayList<>(CollectionManager.getAll());
        sortlist.sort(new SortByName());
        Collections.reverse(sortlist);

        return sortlist.size() > 0 ? sortlist.get(0).getName() : " ";
    }

    public static Long maxSumCoordinates() {
        List<Dragon> sortlist = new ArrayList<>(CollectionManager.getAll());
        sortlist.sort(new SortByCoordinates());
        if (sortlist.size() == 0) {return Long.MIN_VALUE;}

        int x = Integer.parseInt(sortlist.get(0).getCoordinates().split("; ")[0]);
        long y = Long.parseLong(sortlist.get(0).getCoordinates().split("; ")[1]);
        Collections.reverse(sortlist);

        return x + y;
    }

    public static String maxCoordinates() {
        List<Dragon> sortlist = new ArrayList<>(CollectionManager.getAll());
        sortlist.sort(new SortByCoordinates());
        Collections.reverse(sortlist);

        return sortlist.size() > 0 ? sortlist.get(0).getCoordinates() : "";
    }

    public static int maxAge() {
        List<Dragon> sortlist = new ArrayList<>(CollectionManager.getAll());
        sortlist.sort(new SortByAge());
        Collections.reverse(sortlist);

        return sortlist.size() > 0 ? sortlist.get(0).getAge() : Integer.MIN_VALUE;
    }

    public static int maxColor() {
        List<Dragon> sortlist = new ArrayList<>(CollectionManager.getAll());
        sortlist.sort(new SortByColor());
        Collections.reverse(sortlist);

        return sortlist.size() > 0 ? Color.getEnumColor(sortlist.get(0).getColor()).ordinal() + 1 : 0;
    }

    public static int maxType() {
        List<Dragon> sortlist = new ArrayList<>(CollectionManager.getAll());
        sortlist.sort(new SortByType());
        Collections.reverse(sortlist);

        return sortlist.size() > 0 ? DragonType.getEnumType(sortlist.get(0).getType()).ordinal() + 1 : 0;
    }

    public static int maxCharacter() {
        List<Dragon> sortlist = new ArrayList<>(CollectionManager.getAll());
        sortlist.sort(new SortByCharacter());
        Collections.reverse(sortlist);

        return sortlist.size() > 0 ? DragonCharacter.getEnumCharacter(sortlist.get(0).getCharacter()).ordinal() + 1 : 0;
    }

    public static double maxCave() {
        List<Dragon> sortlist = new ArrayList<>(CollectionManager.getAll());
        sortlist.sort(new SortByCave());

        return sortlist.size() > 0 ? sortlist.get(0).getCave() : Double.MIN_VALUE;
    }
}
