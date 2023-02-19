package src.checkers;

import src.collectionClasses.CollectionManager;
import src.collectionClasses.Dragon;

import java.util.Comparator;

public class SortClasses {
    public static class SortByName extends SortClasses implements Comparator<Dragon>{
        @Override
        public int compare(Dragon d1, Dragon d2) {
            return CollectionManager.getName(d1).compareTo(CollectionManager.getName(d2));
        }
    }
}