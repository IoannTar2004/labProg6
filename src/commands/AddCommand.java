package src.commands;

import src.tools.OutputText;
import src.collectionClasses.*;
import src.tools.IdGenerator;
import src.support.Checks;

import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

/**
 * Add object to collection.
 */
public class AddCommand implements Command {

    /**
     * Add object to collection.
     *
     * @param mode
     * @param command
     * @param args
     */
    @Override
    public void execute(String mode, String[] command, String... args) {
        if (Objects.equals(mode, "script")) {
            executeWithScript(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
        } else {add();}
    }

    /**
     * Triggers when user enters this command to terminal
     */
    public static void add() {
        Scanner scanner = new Scanner(System.in);
        String data;

        //имя
        OutputText.input("NameInput");
        String name;
        do {
            data = scanner.nextLine();
            name = Checks.nameCheck(data);
            if (name == null) {
                OutputText.error("EmptyName");
            }
        } while(name == null);

        //координаты
        OutputText.input("CoordinatesInput");
        Coordinates coordinates;
        do {
            data = scanner.nextLine();
            coordinates = Checks.coordinatesChecker(data);
            if(coordinates == null) {
                OutputText.error("CoordinatesIncorrect");
            }
        } while(coordinates == null);

        //возраст
        OutputText.input("AgeInput");
        int age;
        do {
            data = scanner.nextLine();
            age = Checks.ageChecker(data);
            if (age == -1) {
                OutputText.error("AgeIncorrect");
            }
        } while(age <= -1);

        //цвет
        OutputText.input("ColorInput");
        Color color;
        do {
            data = scanner.nextLine();
            color = Color.getColorByNumber(data);
            if (color == null) {
                OutputText.error("ColorIncorrect");
            }
        } while(color == null);

        //тип
        OutputText.input("TypeInput");
        DragonType type;
        do {
            data = scanner.nextLine();
            type = DragonType.getTypeByNumber(data);
            if (type == null) {
                OutputText.error("TypeIncorrect");
            }
        } while(type == null);

        //характер
        OutputText.input("CharacterInput");
        DragonCharacter character;
        do {
            data = scanner.nextLine();
            character = DragonCharacter.getCharacterByNumber(data);
            if (character == null) {
                OutputText.error("CharacterIncorrect");
            }
        } while(character == null);

        //пещера
        OutputText.input("CaveInput");
        DragonCave cave;
        do {
            data = scanner.nextLine();
            cave = Checks.caveChecker(data);
            if(cave == null) {
                OutputText.error("CaveIncorrect");
            }
        } while(cave == null);

        //id
        Long id = IdGenerator.generate();

        Dragon dragon = new Dragon(id, name, coordinates, age, color, type, character, cave, new Date());

        CollectionManager.add(dragon);
        OutputText.result("Added");
    }

    /**
     * Triggers when command is from script file. Object is not created if at least one of the argument is invalid.
     * @param name name
     * @param coordinates two coordinates separated by a space or semicolon
     * @param age age
     * @param color ordinal+1 of color
     * @param type ordinal+1 of type
     * @param character ordinal+1 of character
     * @param cave cave depth
     */
    public static void executeWithScript(String name, String coordinates, String age, String color, String type, String character,
                                         String cave) {
        int count = 0;

        if (Checks.nameCheck(name) != null) {count++;}
        else {return;}

        Coordinates coordinates1 = Checks.coordinatesChecker(coordinates);
        if(coordinates1 != null) {count++;}
        else {return;}

        int age1 = Checks.ageChecker(age);
        if (age1 != -1){count++;} else {return;}

        Color color1 = Color.getColorByNumber(color);
        if (color1 != null){count++;} else {return;}

        DragonType type1 = DragonType.getTypeByNumber(type);
        if (type1 != null){count++;} else {return;}

        DragonCharacter character1 = DragonCharacter.getCharacterByNumber(character);
        if (character1 != null){count++;} else {return;}

        DragonCave cave1 = Checks.caveChecker(cave);
        if (cave1 != null){count++;} else {return;}

        Long id = IdGenerator.generate();

        if (count == 7) {
            Dragon dragon = new Dragon(id, name, coordinates1, age1, color1, type1, character1, cave1, new Date());
            CollectionManager.add(dragon);
        }
    }
}
