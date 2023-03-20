package src.support;

import src.collectionManager.ObjectsCollectionManager;
import src.collections.*;
import src.tools.OutputText;

import java.util.Collections;

/**
 * this class has a similar destiny to {@link Sort} but it is used to get max values.
 */
public class MaxField extends Sort {
    /**
     * Combines other methods in this class to call defined method.
     * @param fields enum of {@link Dragon} field which includes in {@link DragonFields}.
     * @param element that add to collection
     * @return true if element is greater than max element in collection
     */
    public static boolean max(DragonFields fields, Object element) {
        int max = -1;
        Object maxValue = null;
        switch (fields) {
            case NAME -> {
                max = ((String) element).compareTo(maxName());
                maxValue = maxName();
                }
            case COORDINATES -> {
                max = ((Coordinates) element).sum().compareTo(maxSumCoordinates());
                maxValue = maxCoordinates();
            }
            case AGE -> {
                max = ((int) element) - maxAge();
                maxValue = maxAge();
            }
            case COLOR -> {
                max = (((Color) element).ordinal() + 1) - maxColor();
                System.out.println(element);
                maxValue = new Checks(String.valueOf(maxColor())).colorChecker();
            }
            case TYPE -> {
                max = (((DragonType) element).ordinal() + 1) - maxType();
                maxValue = new Checks(String.valueOf(maxType())).typeChecker();
            }
            case CHARACTER -> {
                max = (((DragonCharacter) element).ordinal() + 1) - maxCharacter();
                maxValue = new Checks(String.valueOf(maxCharacter())).characterChecker();
            }
            case CAVE -> {
                max = ((DragonCave) element).getDepth().compareTo(maxCave());
                maxValue = maxCave();
            }
        }
        if (max < 0) {
            OutputText.errorWithArgs(fields.getField() + "Less", maxValue);
            return false;
        } else if (max == 0) {
            OutputText.errorWithArgs(fields.getField() + "Equal", maxValue);
            return false;
        }
        return true;
    }

    /**
     *
     * @return max value of {@link Dragon#getName()} name if collection is not empty.
     */
    public static String maxName() {
        ObjectsCollectionManager getters = new ObjectsCollectionManager();

        sortlist.clear();
        sortlist.addAll(getters.getAll());
        sortlist.sort(new SortByName());
        Collections.reverse(sortlist);

        return sortlist.size() > 0 ? sortlist.get(0).getName() : " ";
    }

    /**
     *
     * @return max sum of {@link Coordinates coordinates} (x + y) if collection is not empty.
     */
    public static Long maxSumCoordinates() {
        ObjectsCollectionManager getters = new ObjectsCollectionManager();

        sortlist.clear();
        sortlist.addAll(getters.getAll());
        sortlist.sort(new SortByCoordinates());
        if (sortlist.size() == 0) {return Long.MIN_VALUE;}

        Collections.reverse(sortlist);
        return sortlist.get(0).getSumCoordinate();
    }

    /**
     *
     * @return x coordinate of the object which has max sum coordinates.
     */
    public static int maxX() {
        ObjectsCollectionManager getters = new ObjectsCollectionManager();

        sortlist.clear();
        sortlist.addAll(getters.getAll());
        sortlist.sort(new SortByCoordinates());

        Collections.reverse(sortlist);
        return sortlist.get(0).getX();
    }

    /**
     *
     * @return y coordinate of the object which has max sum coordinates.
     */
    public static Long maxY() {
        ObjectsCollectionManager getters = new ObjectsCollectionManager();

        sortlist.clear();
        sortlist.addAll(getters.getAll());
        sortlist.sort(new SortByCoordinates());

        Collections.reverse(sortlist);
        return sortlist.get(0).getY();
    }

    /**
     *
     * @return string of the form {@link Dragon#getCoordinates() 'x; y'} (where x + y is max) if collection is not empty
     */
    public static String maxCoordinates() {
        ObjectsCollectionManager getters = new ObjectsCollectionManager();

        sortlist.clear();
        sortlist.addAll(getters.getAll());
        sortlist.sort(new SortByCoordinates());
        Collections.reverse(sortlist);

        return sortlist.size() > 0 ? sortlist.get(0).getCoordinates() : "";
    }

    /**
     *
     * @return max {@link Dragon#getAge() age} if collection is not empty.
     */
    public static int maxAge() {
        ObjectsCollectionManager getters = new ObjectsCollectionManager();

        sortlist.clear();
        sortlist.addAll(getters.getAll());
        sortlist.sort(new SortByAge());
        Collections.reverse(sortlist);

        return sortlist.size() > 0 ? sortlist.get(0).getAge() : Integer.MIN_VALUE;
    }

    /**
     *
     * @return max ordinal+1 of {@link Color} if collection is not empty.
     */
    public static int maxColor() {
        ObjectsCollectionManager getters = new ObjectsCollectionManager();

        sortlist.clear();
        sortlist.addAll(getters.getAll());
        sortlist.sort(new SortByColor());
        Collections.reverse(sortlist);

        return sortlist.size() > 0 ? Color.getEnumColor(sortlist.get(0).getColor()).ordinal() + 1 : 0;
    }

    /**
     *
     * @return max ordinal+1 of {@link DragonType} if collection is not empty.
     */
    public static int maxType() {
        ObjectsCollectionManager getters = new ObjectsCollectionManager();

        sortlist.clear();
        sortlist.addAll(getters.getAll());
        sortlist.sort(new SortByType());
        Collections.reverse(sortlist);

        return sortlist.size() > 0 ? DragonType.getEnumType(sortlist.get(0).getType()).ordinal() + 1 : 0;
    }

    /**
     *
     * @return max ordinal+1 of {@link DragonCharacter} if collection is not empty.
     */
    public static int maxCharacter() {
        ObjectsCollectionManager getters = new ObjectsCollectionManager();

        sortlist.clear();
        sortlist.addAll(getters.getAll());
        sortlist.sort(new SortByCharacter());
        Collections.reverse(sortlist);

        return sortlist.size() > 0 ? DragonCharacter.getEnumCharacter(sortlist.get(0).getCharacter()).ordinal() + 1 : 0;
    }

    /**
     *
     * @return max {@link Dragon#getCave()} cave depth if collection is not empty.
     */
    public static double maxCave() {
        ObjectsCollectionManager getters = new ObjectsCollectionManager();

        sortlist.clear();
        sortlist.addAll(getters.getAll());
        sortlist.sort(new SortByCave());

        Collections.reverse(sortlist);
        return sortlist.size() > 0 ? sortlist.get(0).getCave() : Double.MIN_VALUE;
    }

    /**
     * This method checks that dragon's field does not have max format value.
     * @param fields //TODO
     * @return
     */
    public static boolean existence(DragonFields fields) {
        if(fields == DragonFields.COORDINATES && (maxX() == Integer.MAX_VALUE || maxY() == Long.MAX_VALUE)) {
            OutputText.maxValues("MaxCoordinates");
            return false;
        } else if (fields == DragonFields.AGE && maxAge() == Integer.MAX_VALUE) {
            OutputText.maxValues("MaxAge");
            return false;
        } else if(fields == DragonFields.COLOR && maxColor() == 3) {
            OutputText.maxValues("MaxColor");
            return false;
        } else if(fields == DragonFields.TYPE && maxType() == 4) {
            OutputText.maxValues("MaxType");
            return false;
        } else if(fields == DragonFields.CHARACTER && maxCharacter() == 3) {
            OutputText.maxValues("MaxCharacter");
            return false;
        } else if(fields == DragonFields.CAVE && maxCave() == Double.MAX_VALUE) {
            OutputText.maxValues("MaxCave");
            return false;
        }
        return true;
    }
}
