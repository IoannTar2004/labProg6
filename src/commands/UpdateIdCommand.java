package src.commands;

import src.tools.OutputText;
import src.collectionClasses.*;
import src.support.Checks;

import java.util.Objects;
import java.util.Scanner;

/**
 * Changes {@link Dragon dragon's fields} by its ID.
 */
public class UpdateIdCommand implements Command {
    /**
     * Changes {@link Dragon dragon's fields} by its ID.
     */
    @Override
    public void execute(String mode, String[] command, String... args) {
        if (Objects.equals(mode, "script")) {
            executeWithScript(command, args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
        } else {update(command);}
    }
    /**
     * Triggers when user enters this command to terminal
     */

    public static void update(String[] line) {
        Dragon dragon = Checks.idChecker(line[1]);
        if (dragon == null) {return;}

        Scanner scanner = new Scanner(System.in);

        String data;

        //имя
        OutputText.input("NewNameInput");
        data = scanner.nextLine();
        if ((!data.matches("\\s*"))) {
            CollectionManager.updateName(dragon, data);
        }

        //координаты
        OutputText.input("NewCoordinatesInput");
        Coordinates coordinates;
        do {
            data = scanner.nextLine();
            coordinates = Checks.coordinatesChecker(data);
            if(coordinates == null && !data.matches("\\s*")) {
                OutputText.error("coordinatesIncorrect");
            } else if (coordinates != null){
                CollectionManager.updateCoordinates(dragon, coordinates);
            }
        } while(coordinates == null && !data.matches("\\s*"));

        //возраст
        OutputText.input("NewAgeInput");
        int age;
        do {
            data = scanner.nextLine();
            age = Checks.ageChecker(data);
            if (age == -1 && !data.matches("\\s*")) {
                OutputText.error("ageIncorrect");
            } else if (age != -1){
                CollectionManager.updateAge(dragon, age);
            }
        } while(age == -1 && !data.matches("\\s*"));

        //цвет
        OutputText.input("NewColorInput");
        Color color;
        do {
            data = scanner.nextLine();
            color = Color.getColorByNumber(data);
            if (color == null && !data.matches("\\s*")) {
                OutputText.error("colorIncorrect");
            } else if (color != null){
                CollectionManager.updateColor(dragon, color);
            }
        } while(color == null && !data.matches("\\s*"));

        //тип
        OutputText.input("NewTypeInput");
        DragonType type;
        do {
            data = scanner.nextLine();
            type = DragonType.getTypeByNumber(data);
            if (type == null && !data.matches("\\s*")) {
                OutputText.error("typeIncorrect");
            } else if (type != null){
                CollectionManager.updateType(dragon, type);
            }
        } while(type == null && !data.matches("\\s*"));

        //характер
        OutputText.input("NewCharacterInput");
        DragonCharacter character;
        do {
            data = scanner.nextLine();
            character = DragonCharacter.getCharacterByNumber(data);
            if (character == null && !data.matches("\\s*")) {
                OutputText.error("characterIncorrect");
            } else if (character != null) {
                CollectionManager.updateCharacter(dragon, character);
            }
        } while(character == null && !data.matches("\\s*"));

        //пещера
        OutputText.input("NewCaveInput");
        DragonCave cave;
        do {
            data = scanner.nextLine();
            cave = Checks.caveChecker(data);
            if(cave == null && !data.matches("\\s*")) {
                OutputText.error("caveIncorrect");
            } else if (cave != null){;
                CollectionManager.updateCave(dragon, cave);
            }
        } while(cave == null && !data.matches("\\s*"));

       OutputText.result("DataChanged");
    }

    /**
     * Triggers when command is from script file. Object is not created if at least one of the argument is invalid.
     * @param command commend "update 'id'"
     * @param name name
     * @param coordinates two coordinates separated by a space or semicolon
     * @param age age
     * @param color ordinal+1 of color
     * @param type ordinal+1 of type
     * @param character ordinal+1 of character
     * @param cave cave depth
     */
    public static void executeWithScript(String[] command, String name, String coordinates, String age,
                                         String color, String type, String character, String cave) {
        Dragon dragon = Checks.idChecker(command[1]);
        if (dragon == null) {return;}

        //имя
        if ((!name.matches("\\s*"))) {CollectionManager.updateName(dragon, name);}

        //координаты
        Coordinates coordinates1 = Checks.coordinatesChecker(coordinates);
        if (coordinates1 != null) {CollectionManager.updateCoordinates(dragon, coordinates1);}

        //возраст
        int age1 = Checks.ageChecker(age);
        if (age1 != -1) {CollectionManager.updateAge(dragon, age1);}

        //цвет
        Color color1 = Color.getColorByNumber(color);
        if (color1 != null) {CollectionManager.updateColor(dragon, color1);}

        //тип
        DragonType type1 = DragonType.getTypeByNumber(type);
        if (type1 != null) {CollectionManager.updateType(dragon, type1);}

        //характер
        DragonCharacter character1 = DragonCharacter.getCharacterByNumber(character);
        if (character1 != null) {CollectionManager.updateCharacter(dragon, character1);}

        //пещера
        DragonCave cave1 = Checks.caveChecker(cave);
        if (cave1 != null) {CollectionManager.updateCave(dragon, cave1);}
    }
}
