package src.collectionClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class Dragon whose objects stored in Java Collection and xml file
 */
public class Dragon {
    private long id;
    private String name;
    private Coordinates coordinates;
    private Date creationDate;
    private Integer age;
    private Color color;
    private DragonType type;
    private DragonCharacter character;
    private DragonCave cave;

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy - HH:mm:ss");

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

    public Dragon() {}

    @Override
    public String toString() {
        return "| Имя: " + this.name + " | " +
                "id: " + this.id + " | " +
                "координаты: " + this.coordinates.toString() + " | " +
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
    public Long getSumCoordinate() {
        try {
            return coordinates.getX() + coordinates.getY();
        } catch (NumberFormatException e) {
            return Long.MAX_VALUE;
        }
    }

    public Integer getAge() {
        return age;
    }

    public String getCreationDate() {return formatter.format(creationDate);}

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