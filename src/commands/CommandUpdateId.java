package src.commands;

import src.collectionClasses.*;
import src.tools.IdChecker;
import src.tools.IdGenerator;
import src.tools.RegexChecker;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandUpdateId {
    public static void execute(String command) {
        int index = IdChecker.check(command);
        if (index == -1) {return;}

        Scanner scanner = new Scanner(System.in);

        String data;

        //имя
        System.out.println("Введите новое имя или просто нажмите 'Enter', чтобы оставить неизменным");
        data = scanner.nextLine();
        if ((!data.matches("\\s*"))) {
                CollectionManager.updateName(index, data);
        }

        //координаты
        System.out.println("Введите новые координаты (два целых числа через пробел) или просто нажмите 'Enter', чтобы оставить неизменным");
        Coordinates coordinates;
        do {
            data = scanner.nextLine();
            coordinates = RegexChecker.coordinatesCheck(data);
            if(coordinates == null && !data.matches("\\s*")) {
                System.out.println("Введите два целых числа через пробел!");
            } else if (coordinates != null){
                CollectionManager.updateCoordinates(index, coordinates);
            }
        } while(coordinates == null && !data.matches("\\s*"));

        //возраст
        System.out.println("Введите новый возраст (целое положительное число) или просто нажмите 'Enter', чтобы оставить неизменным");
        int age;
        do {
            data = scanner.nextLine();
            age = RegexChecker.ageChecker(data);
            if (age == -1 && !data.matches("\\s*")) {
                System.out.println("Введите целое положительное число!");
            } else if (age != -1){
                CollectionManager.updateAge(index, age);
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
                CollectionManager.updateColor(index, color);
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
                CollectionManager.updateType(index, type);
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
                CollectionManager.updateCharacter(index, character);
            }
        } while(character == null && !data.matches("\\s*"));

        //пещера
        System.out.println("Введите новое дробное число через точку или просто нажмите 'Enter', чтобы оставить неизменным");
        DragonCave cave;
        do {
            data = scanner.nextLine();
            cave = RegexChecker.caveChecker(data);
            if(cave == null && !data.matches("\\s*")) {
                System.out.println("Введите дробное число через точку!");
            } else if (cave != null){;
                CollectionManager.updateCave(index, cave);
            }
        } while(cave == null && !data.matches("\\s*"));

        System.out.println("Данные объекта изменены!\n");
    }


    public static void executeWithScript(String command, String name, String coordinates, String age,
                                         String color, String type, String character, String cave) {
        int index = IdChecker.check(command);
        if (index == -1) {
            return;
        }

        if ((!name.matches("\\s*"))) {CollectionManager.updateName(index, name);}

        Coordinates coordinates1 = RegexChecker.coordinatesCheck(coordinates);
        if (coordinates1 != null) {CollectionManager.updateCoordinates(index, coordinates1);}

        int age1 = RegexChecker.ageChecker(age);
        if (age1 != -1) {CollectionManager.updateAge(index, age1);}

        Color color1 = Color.getColorByNumber(color);
        if (color1 != null) {CollectionManager.updateColor(index, color1);}

        DragonType type1 = DragonType.getTypeByNumber(type);
        if (type1 != null) {CollectionManager.updateType(index, type1);}

        DragonCharacter character1 = DragonCharacter.getCharacterByNumber(character);
        if (character1 != null) {CollectionManager.updateCharacter(index, character1);}

        DragonCave cave1 = RegexChecker.caveChecker(cave);
        if (cave1 != null) {CollectionManager.updateCave(index, cave1);}
    }
}
