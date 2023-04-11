package src.manager;

import src.collections.*;
import src.support.Processing;

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

    public void replace(Long id, Object... args) {
        Dragon dragon = new ObjectsCollectionManager().getDragonById(id);
        for(DragonFields fields: DragonFields.values()) {
            if (args[fields.ordinal()] != null) {
                dragon = new Processing().dragonInput(dragon, fields, args[fields.ordinal()]);
            }
        }
    }
}
