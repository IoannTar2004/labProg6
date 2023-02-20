package src.commands;

import src.collectionClasses.*;
import src.fieldSupport.RegexChecker;
import src.tools.IdGenerator;

import java.util.Date;
import java.util.Scanner;

public class CommandAddIfMax {
    public static void execute() {
        Scanner scanner = new Scanner(System.in);
        String data;

        System.out.println("\t\tВведите номер поля, по которому будет производиться проверка\n" +
                "1 - имя\n" +
                "2 - координаты\n" +
                "3 - возраст\n" +
                "4 - цвет\n" +
                "5 - тип\n" +
                "6 - характер\n" +
                "7 - глубина пещеры");
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
    }
}
