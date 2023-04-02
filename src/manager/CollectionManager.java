package src.manager;

import src.collections.Dragon;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Controls the collection
 */
public abstract class CollectionManager {
   Deque<Dragon> dragons = new ArrayDeque<>();
}
