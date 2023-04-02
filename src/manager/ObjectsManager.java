package src.manager;

import src.collections.Dragon;
import java.util.Date;

public class ObjectsManager extends CollectionManager {
    public ObjectsManager() {
    }

    public void add(Dragon dragon) {
        dragon.setCreationDate(new Date());
        dragons.add(dragon);
    }

    public int length() {
        return dragons.size();
    }
    public void remove(Dragon dragon) {
        dragons.remove(dragon);
    }
    public void clear() {dragons.clear();}
    public void remove_first() {dragons.removeFirst();
    }
}
