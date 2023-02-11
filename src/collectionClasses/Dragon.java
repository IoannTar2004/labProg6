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

    public Dragon() {}
    public Dragon(Long id, String name, Coordinates coordinates, int age, Color color, DragonType type, DragonCharacter character,
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
                ", creationDate=" + creationDate.getDate() + "." + creationDate.getMonth() + "." + (creationDate.getYear()+1900)
                + " - " + creationDate.getHours() + ":" + creationDate.getMinutes() + ":" + creationDate.getSeconds() +
                ", age=" + age +
                ", color=" + color.getColor() +
                ", type=" + type.getType() +
                ", character=" + character.getCharacter() +
                ", cave=" + cave +
                '}';
    }

    public String getName() {
        return name;
    }
    public long getId() {
        return id;
    }
    public String getCoordinates() {
        return coordinates.toString();
    }
    public Integer getAge() {
        return age;
    }
    public String getCreationDate() {
        return creationDate.getDate() + "." + creationDate.getMonth() + "." + (creationDate.getYear()+1900)
                + " - " + creationDate.getHours() + ":" + creationDate.getMinutes() + ":" + creationDate.getSeconds();
    }
    public String getColor() {
        return color.getColor();
    }
    public String getType() {
        return type.getType();
    }
    public String getCharacter() {
        return character.getCharacter();
    }
    public double getCave() {
        return cave.getDepth();
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setType(DragonType type) {
        this.type = type;
    }
    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }
    public void setCave(DragonCave cave) {
        this.cave = cave;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}