package src.commands;

import src.collectionClasses.*;
import src.tools.IdGenerator;
import src.checkers.RegexChecker;

import java.util.Date;
import java.util.Scanner;

public class CommandAdd {
    public static void execute() {
        Scanner scanner = new Scanner(System.in);
        String data;

        //имя
        System.out.println("Введите имя");
        String name;
        do {
            data = scanner.nextLine();
            name = data;
            if (RegexChecker.nameCheck(data) == null) {
                System.out.println("Имя не может быть пустым!");
            }
        } while(RegexChecker.nameCheck(data) == null);

        //координаты
        System.out.println("Введите координаты (два целых числа через пробел)");
        Coordinates coordinates;
        do {
            data = scanner.nextLine();
            coordinates = RegexChecker.coordinatesChecker(data);
            if(coordinates == null) {
                System.out.println("Введите два целых числа через пробел!");
            }
        } while(coordinates == null);

        //возраст
        System.out.println("Введите возраст (целое положительное число)");
        int age;
        do {
            data = scanner.nextLine();
            age = RegexChecker.ageChecker(data);
            if (age == -1) {
                System.out.println("Введите целое положительное число!");
            }
        } while(age == -1);

        //цвет
        System.out.println("Введите номер цвета (Чёрный - 1, Синий - 2, Жёлтый - 3)");
        Color color;
        do {
            data = scanner.nextLine();
            color = Color.getColorByNumber(data);
            if (color == null) {
                System.out.println("Введите cоответствующий номер цвета (Чёрный - 1, Синий - 2, Жёлтый - 3)!");
            }
        } while(color == null);

        //тип
        System.out.println("Введите номер типа (Водный - 1, Подземельный - 2, Воздушный - 3, Огненный - 4)");
        DragonType type;
        do {
            data = scanner.nextLine();
            type = DragonType.getTypeByNumber(data);
            if (type == null) {
                System.out.println("Введите соответвующий номер типа (Водный - 1, Подземельный - 2, " +
                        "Воздушный - 3, Огненный - 4)!");
            }
        } while(type == null);

        //характер
        System.out.println("Введите номер характера (Хитрый - 1, Злой - 2, Хаотичный - 3)");
        DragonCharacter character;
        do {
            data = scanner.nextLine();
            character = DragonCharacter.getCharacterByNumber(data);
            if (character == null) {
                System.out.println("Введите соответствующий номер характера (Хитрый - 1, Злой - 2, Хаотичный - 3)!");
            }
        } while(character == null);

        //пещера
        System.out.println("Введите дробное число через точку");
        DragonCave cave;
        do {
            data = scanner.nextLine();
            cave = RegexChecker.caveChecker(data);
            if(cave == null) {
                System.out.println("Введите дробное число через точку!");
            }
        } while(cave == null);

        //id
        Long id = IdGenerator.generate();

        //date
        Date date = new Date();
        Dragon dragon = new Dragon(id, name, coordinates, age, color, type, character, cave, date);

        CollectionManager.add(dragon);
        System.out.println("Объект добавлен в коллекцию!\n");
    }

    public static void executeWithScript(String name, String coordinates, String age, String color, String type, String character,
                                         String cave) {
        int count = 0;

        if (RegexChecker.nameCheck(name) != null) {count++;}
        else {return;}

        Coordinates coordinates1 = RegexChecker.coordinatesChecker(coordinates);
        if(coordinates1 != null) {count++;}
        else {return;}

        int age1 = RegexChecker.ageChecker(age);
        if (age1 != -1){count++;} else {return;}

        Color color1 = Color.getColorByNumber(color);
        if (color1 != null){count++;} else {return;}

        DragonType type1 = DragonType.getTypeByNumber(type);
        if (type1 != null){count++;} else {return;}

        DragonCharacter character1 = DragonCharacter.getCharacterByNumber(character);
        if (character1 != null){count++;} else {return;}

        DragonCave cave1 = RegexChecker.caveChecker(cave);
        if (cave1 != null){count++;} else {return;}

        Long id = IdGenerator.generate();

        //дата
        Date date = new Date();

        if (count == 7) {
            Dragon dragon = new Dragon(id, name, coordinates1, age1, color1, type1, character1, cave1, date);
            CollectionManager.add(dragon);
        }
    }
}
