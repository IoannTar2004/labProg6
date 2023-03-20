package src.collectionManager;

import src.collections.Dragon;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Controls the collection
 */
public abstract class CollectionManager {
   static Deque<Dragon> dragons = new ArrayDeque<>();
}
