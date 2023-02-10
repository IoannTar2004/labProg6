package src.collectionClasses;

import java.util.Date;

public class Dragon {
    private long id;
    private String name;
    private Coordinates coordinates;
    private java.util.Date creationDate;
    private Integer age;
    private Color color;
    private DragonType type;
    private DragonCharacter character;
    private DragonCave cave;

    public Dragon(int id, String name, Coordinates coordinates, int age, Color color, DragonType type, DragonCharacter character,
                  DragonCave cave, Date date) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = date;
        this.age = age;
        this.color = color;
        this.type = type;
        this.character = character;
        this.cave = cave;
    }

    @Override
    public String toString() {
        return "Dragon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", age=" + age +
                ", color=" + color.getColor() +
                ", type=" + type.getType() +
                ", character=" + character.getCharacter() +
                ", cave=" + cave +
                '}';
    }
}