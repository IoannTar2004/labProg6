package src.checkers;

import src.collectionClasses.CollectionManager;
import src.collectionClasses.Dragon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public static  void sort(Sort sort) {
        List<Dragon> sortlist = new ArrayList<>(CollectionManager.getAll());
        sortlist.sort((Comparator<? super Dragon>) sort);
        for(int i = sortlist.size() - 1; i >= 0; i--) {
            CollectionManager.element(sortlist.get(i));
        }
    }

    public static class SortByName extends Sort implements Comparator<Dragon>{
        @Override
        public int compare(Dragon d1, Dragon d2) {
            System.out.println(CollectionManager.getName(d1).compareTo(CollectionManager.getName(d2)));
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
}