package src.collectionClasses;

import java.util.Date;

/**
 * Class Dragon whose objects stored in Java Collection and xml file
 */
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

    /**
     *
     * @param id "Long"; 12-digit number
     * @param name notNull string
     * @param coordinates {@link Coordinates coordinates (x, y)}
     * @param age integer positive number
     * @param color {@link Color color}
     * @param type {@link DragonType type}
     * @param character {@link DragonCharacter character}
     * @param cave fractional number separated by a dot {@link DragonCave}
     * @param date date of creation
     */
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
        return "Имя: " + this.name + " | " +
                "id: " + this.id + " | " +
                "coordinates: " + this.coordinates.toString() + " | " +
                "возраст: " + this.age + " | " +
                "дата создания: " + this.getCreationDate() + " | " +
                "цвет: " + this.color.getColor() + " | " +
                "тип: " + this.type.getType() + " | " +
                "характер: " + this.character.getCharacter() + " | " +
                "глубина пещеры: " + this.cave.getDepth();
    }

    public String getName() {return name;}
    public long getId() {return id;}

    public String getCoordinates() {
        return coordinates.toString();
    }
    public int getX() {return coordinates.getX();}
    public Long getY() {return coordinates.getY();}
    public Long getSumCoordinate() {return coordinates.getX() + coordinates.getY();}

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
}