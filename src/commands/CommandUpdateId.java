package src.commands;

import src.collectionClasses.*;
import src.fieldSupport.Checks;

import java.util.Scanner;

public class CommandUpdateId {
    public static void execute(String command) {
        Dragon dragon = Checks.idChecker(command);
        if (dragon == null) {return;}

        Scanner scanner = new Scanner(System.in);

        String data;

        //имя
        System.out.println("Введите новое имя или просто нажмите 'Enter', чтобы оставить неизменным");
        data = scanner.nextLine();
        if ((!data.matches("\\s*"))) {
                CollectionManager.updateName(dragon, data);
        }

        //координаты
        System.out.println("Введите новые координаты (два целых числа через пробел) или просто нажмите 'Enter', чтобы оставить неизменным");
        Coordinates coordinates;
        do {
            data = scanner.nextLine();
            coordinates = Checks.coordinatesChecker(data);
            if(coordinates == null && !data.matches("\\s*")) {
                System.out.println("Введите два целых числа через пробел!");
            } else if (coordinates != null){
                CollectionManager.updateCoordinates(dragon, coordinates);
            }
        } while(coordinates == null && !data.matches("\\s*"));

        //возраст
        System.out.println("Введите новый возраст (целое положительное число) или просто нажмите 'Enter', чтобы оставить неизменным");
        int age;
        do {
            data = scanner.nextLine();
            age = Checks.ageChecker(data);
            if (age == -1 && !data.matches("\\s*")) {
                System.out.println("Введите целое положительное число!");
            } else if (age != -1){
                CollectionManager.updateAge(dragon, age);
            }
        } while(age == -1 && !data.matches("\\s*"));

        //цвет
        System.out.println("Введите новый номер цвета (Чёрный - 1, Синий - 2, Жёлтый - 3) или просто нажмите 'Enter', чтобы оставить неизменным");
        Color color;
        do {
            data = scanner.nextLine();
            color = Color.getColorByNumber(data);
            if (color == null && !data.matches("\\s*")) {
                System.out.println("\"Введите cоответствующий номер цвета (Чёрный - 1, Синий - 2, Жёлтый - 3)!\"");
            } else if (color != null){
                CollectionManager.updateColor(dragon, color);
            }
        } while(color == null && !data.matches("\\s*"));

        //тип
        System.out.println("Введите новый номер типа (Водный - 1, Подземельный - 2, Воздушный - 3, Огненный - 4) или просто нажмите 'Enter', чтобы оставить неизменным");
        DragonType type;
        do {
            data = scanner.nextLine();
            type = DragonType.getTypeByNumber(data);
            if (type == null && !data.matches("\\s*")) {
                System.out.println("Введите соответвующий номер типа (Водный - 1, Подземельный - 2, " +
                        "Воздушный - 3, Огненный - 4)!");
            } else if (type != null){
                CollectionManager.updateType(dragon, type);
            }
        } while(type == null && !data.matches("\\s*"));

        //характер
        System.out.println("Введите новый номер характера (Хитрый - 1, Злой - 2, Хаотичный - 3) или просто нажмите 'Enter', чтобы оставить неизменным" );
        DragonCharacter character;
        do {
            data = scanner.nextLine();
            character = DragonCharacter.getCharacterByNumber(data);
            if (character == null && !data.matches("\\s*")) {
                System.out.println("Введите соответствующий номер характера (Хитрый - 1, Злой - 2, Хаотичный - 3)!");
            } else if (character != null){
                CollectionManager.updateCharacter(dragon, character);
            }
        } while(character == null && !data.matches("\\s*"));

        //пещера
        System.out.println("Введите новое дробное число через точку или просто нажмите 'Enter', чтобы оставить неизменным");
        DragonCave cave;
        do {
            data = scanner.nextLine();
            cave = Checks.caveChecker(data);
            if(cave == null && !data.matches("\\s*")) {
                System.out.println("Введите дробное число через точку!");
            } else if (cave != null){;
                CollectionManager.updateCave(dragon, cave);
            }
        } while(cave == null && !data.matches("\\s*"));

        System.out.println("Данные объекта изменены!\n");
    }


    public static void executeWithScript(String command, String name, String coordinates, String age,
                                         String color, String type, String character, String cave) {
        Dragon dragon = Checks.idChecker(command);
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
