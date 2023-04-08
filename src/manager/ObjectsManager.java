package src.manager;

import src.collections.*;

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

    public void replace(Long id, Dragon newDragon) {
        Dragon dragon = new ObjectsCollectionManager().getDragonById(id);

        dragon.setName(newDragon.getName());
        dragon.setCoordinates(new Coordinates(newDragon.getX(), newDragon.getY()));
        dragon.setAge(newDragon.getAge());
        dragon.setColor(Color.getEnumColor(newDragon.getColor()));
        dragon.setType(DragonType.getEnumType(newDragon.getType()));
        dragon.setCharacter(DragonCharacter.getEnumCharacter(newDragon.getCharacter()));
        dragon.setCave(new DragonCave(dragon.getCave()));
    }
}
