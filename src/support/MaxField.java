package src.support;

import src.collectionClasses.*;
import src.tools.OutputText;

import java.util.Collections;

/**
 * this class has a similar destiny to {@link Sort} but it is used to get max values.
 */
public class MaxField extends Sort {
    /**
     * Combines other methods in this class to call defined method.
     * @param fieldNum number of {@link Dragon} field (1 - name, 2 - coordinates, 3 - age, etc).
     */
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

    /**
     *
     * @return max value of {@link Dragon#getName()} name if collection is not empty.
     */
    public static String maxName() {
        sortlist.clear();
        sortlist.addAll(CollectionManager.getAll());
        sortlist.sort(new SortByName());
        Collections.reverse(sortlist);

        return sortlist.size() > 0 ? sortlist.get(0).getName() : " ";
    }

    /**
     *
     * @return max sum of {@link Coordinates coordinates} (x + y) if collection is not empty.
     */
    public static Long maxSumCoordinates() {
        sortlist.clear();
        sortlist.addAll(CollectionManager.getAll());
        sortlist.sort(new SortByCoordinates());
        if (sortlist.size() == 0) {return Long.MIN_VALUE;}

        Collections.reverse(sortlist);
        return sortlist.get(0).getSumCoordinate();
    }

    public static int maxX() {
        sortlist.clear();
        sortlist.addAll(CollectionManager.getAll());
        sortlist.sort(new SortByCoordinates());

        Collections.reverse(sortlist);
        return sortlist.get(0).getX();
    }

    public static Long maxY() {
        sortlist.clear();
        sortlist.addAll(CollectionManager.getAll());
        sortlist.sort(new SortByCoordinates());

        Collections.reverse(sortlist);
        return sortlist.get(0).getY();
    }

    /**
     *
     * @return string of the form {@link Dragon#getCoordinates() 'x; y'} (where x + y is max) if collection is not empty
     */
    public static String maxCoordinates() {
        sortlist.clear();
        sortlist.addAll(CollectionManager.getAll());
        sortlist.sort(new SortByCoordinates());
        Collections.reverse(sortlist);

        return sortlist.size() > 0 ? sortlist.get(0).getCoordinates() : "";
    }

    /**
     *
     * @return max {@link Dragon#getAge() age} if collection is not empty.
     */
    public static int maxAge() {
        sortlist.clear();
        sortlist.addAll(CollectionManager.getAll());
        sortlist.sort(new SortByAge());
        Collections.reverse(sortlist);

        return sortlist.size() > 0 ? sortlist.get(0).getAge() : Integer.MIN_VALUE;
    }

    /**
     *
     * @return max ordinal+1 of {@link Color} if collection is not empty.
     */
    public static int maxColor() {
        sortlist.clear();
        sortlist.addAll(CollectionManager.getAll());
        sortlist.sort(new SortByColor());
        Collections.reverse(sortlist);

        return sortlist.size() > 0 ? Color.getEnumColor(sortlist.get(0).getColor()).ordinal() + 1 : 0;
    }

    /**
     *
     * @return max ordinal+1 of {@link DragonType} if collection is not empty.
     */
    public static int maxType() {
        sortlist.clear();
        sortlist.addAll(CollectionManager.getAll());
        sortlist.sort(new SortByType());
        Collections.reverse(sortlist);

        return sortlist.size() > 0 ? DragonType.getEnumType(sortlist.get(0).getType()).ordinal() + 1 : 0;
    }

    /**
     *
     * @return max ordinal+1 of {@link DragonCharacter} if collection is not empty.
     */
    public static int maxCharacter() {
        sortlist.clear();
        sortlist.addAll(CollectionManager.getAll());
        sortlist.sort(new SortByCharacter());
        Collections.reverse(sortlist);

        return sortlist.size() > 0 ? DragonCharacter.getEnumCharacter(sortlist.get(0).getCharacter()).ordinal() + 1 : 0;
    }

    /**
     *
     * @return max {@link Dragon#getCave()} cave depth if collection is not empty.
     */
    public static double maxCave() {
        sortlist.clear();
        sortlist.addAll(CollectionManager.getAll());
        sortlist.sort(new SortByCave());

        Collections.reverse(sortlist);
        return sortlist.size() > 0 ? sortlist.get(0).getCave() : Double.MIN_VALUE;
    }

    public static boolean existence(String field) {
        if(field.equals("2") && (maxX() == Integer.MAX_VALUE || maxY() == Long.MAX_VALUE)) {
            OutputText.maxValues("MaxCoordinates");
            return false;
        } else if (field.equals("3") && maxAge() == Integer.MAX_VALUE) {
            OutputText.maxValues("MaxAge");
            return false;
        } else if(field.equals("4") && maxColor() == 3) {
            OutputText.maxValues("MaxColor");
            return false;
        } else if(field.equals("5") && maxType() == 4) {
            OutputText.maxValues("MaxType");
            return false;
        } else if(field.equals("6") && maxCharacter() == 3) {
            OutputText.maxValues("MaxCharacter");
            return false;
        } else if(field.equals("7") && maxCave() == Double.MAX_VALUE) {
            OutputText.maxValues("MaxCave");
            return false;
        }
        return true;
    }
}
