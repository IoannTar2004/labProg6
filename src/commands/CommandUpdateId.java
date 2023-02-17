package src.commands;

import src.collectionClasses.*;
import src.tools.IdChecker;
import src.tools.IdGenerator;

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
        Dragon dragon = new Dragon();
        Matcher matcher;

        String data;

        //имя
        System.out.println("Введите новое имя или просто нажмите 'Enter', чтобы оставить неизменным");
        data = scanner.nextLine();
        if ((!data.matches("\\s*"))) {
                CollectionManager.updateName(index, data);
        }

        //координаты
        System.out.println("Введите новые координаты (два целых числа через пробел) или просто нажмите 'Enter', чтобы оставить неизменным");
        String[] coordinates;
        Pattern pattern = Pattern.compile("\\s*(-?\\d+\\s+-?\\d+)\\s*");
        do {
            data = scanner.nextLine();
            matcher = pattern.matcher(data);
            if(!matcher.matches() && !data.matches("\\s*")) {
                System.out.println("Введите два целых числа через пробел!");
            } else if (matcher.matches()){
                data = matcher.group(1);
                coordinates = data.split("\\s+");
                CollectionManager.updateCoordinates(index, new Coordinates(Integer.parseInt(coordinates[0]),
                        Long.parseLong(coordinates[1])));
            }
        } while(!matcher.matches() && !data.matches("\\s*"));

        //возраст
        pattern = Pattern.compile("\\s*([1-9][0-9]*)\\s*");
        System.out.println("Введите новый возраст (целое положительное число) или просто нажмите 'Enter', чтобы оставить неизменным");
        do {
            data = scanner.nextLine();
            matcher = pattern.matcher(data);
            if (!matcher.matches() && !data.matches("\\s*")) {
                System.out.println("Введите целое положительное число!");
            } else if (matcher.matches()){
                data = matcher.group(1);
                CollectionManager.updateAge(index, Integer.parseInt(data));
            }
        } while(!matcher.matches() && !data.matches("\\s*"));

        //цвет
        System.out.println("Введите новый номер цвета (Чёрный - 1, Синий - 2, Жёлтый - 3) или просто нажмите 'Enter', чтобы оставить неизменным");
        pattern = Pattern.compile("\\s*([123])\\s*");
        do {
            data = scanner.nextLine();
            matcher = pattern.matcher(data);
            data = matcher.matches() ? matcher.group(1) : data;
            switch (data) {
                case "1":
                    CollectionManager.updateColor(index, Color.BLACK);
                    break;
                case "2":
                    CollectionManager.updateColor(index, Color.BLUE);
                    break;
                case "3":
                    CollectionManager.updateColor(index, Color.YELLOW);
                    break;
                default:
                    if (data.matches("\\s*")) {
                        break;
                    } else {
                        System.out.println("Введите cоответствующий номер цвета (Чёрный - 1, Синий - 2, Жёлтый - 3)!");
                    }
            }
        } while(!matcher.matches() && !data.matches("\\s*"));

        //тип
        System.out.println("Введите новый номер типа (Водный - 1, Подземельный - 2, Воздушный - 3, Огненный - 4) или просто нажмите 'Enter', чтобы оставить неизменным");
        pattern = Pattern.compile("\\s*([1-4])\\s*");
        do {
            data = scanner.nextLine();
            matcher = pattern.matcher(data);
            data = matcher.matches() ? matcher.group(1) : data;
            switch (data) {
                case "1":
                    CollectionManager.updateType(index, DragonType.WATER);
                    break;
                case "2":
                    CollectionManager.updateType(index, DragonType.UNDERGROUND);
                    break;
                case "3":
                    CollectionManager.updateType(index, DragonType.AIR);
                    break;
                case "4":
                    CollectionManager.updateType(index, DragonType.FIRE);
                    break;
                default:
                    if (data.matches("\\s*")) {
                        break;
                    } else {
                        System.out.println("Введите соответвующий номер типа (Водный - 1, Подземельный - 2, " +
                                "Воздушный - 3, Огненный - 4)!");
                    }
            }
        } while(!matcher.matches() && !data.matches("\\s*"));

        //характер
        System.out.println("Введите новый номер характера (Хитрый - 1, Злой - 2, Хаотичный - 3) или просто нажмите 'Enter', чтобы оставить неизменным" );
        pattern = Pattern.compile("\\s*([123])\\s*");
        do {
            data = scanner.nextLine();
            matcher = pattern.matcher(data);
            data = matcher.matches() ? matcher.group(1) : data;
            switch (data) {
                case "1":
                    CollectionManager.updateCharacter(index, DragonCharacter.CUNNING);
                    break;
                case "2":
                    CollectionManager.updateCharacter(index, DragonCharacter.EVIL);
                    break;
                case "3":
                    CollectionManager.updateCharacter(index, DragonCharacter.CHAOTIC);
                    break;
                default:
                    if (data.matches("\\s*")){
                        break;
                    } else {
                        System.out.println("Введите соответствующий номер характера (Хитрый - 1, Злой - 2, Хаотичный - 3)!");
                    }
            }
        } while(!matcher.matches() && !data.matches("\\s*"));

        //пещера
        System.out.println("Введите новое дробное число через точку или просто нажмите 'Enter', чтобы оставить неизменным");
        pattern = Pattern.compile("\\s*(-?\\d+\\.\\d+)\\s*");
        do {
            data = scanner.nextLine();
            matcher = pattern.matcher(data);
            if(!matcher.matches() && !data.matches("\\s*")) {
                System.out.println("Введите дробное число через точку!");
            } else if (matcher.matches()){
                data = matcher.group(1);
                CollectionManager.updateCave(index, new DragonCave(Double.parseDouble(data)));
            }
        } while(!matcher.matches() && !data.matches("\\s*"));

        System.out.println("Данные объекта изменены!\n");
    }


    public static void executeWithScript(String command, String name, String coordinates, String age,
                                         String color, String type, String character, String cave) {
        int index = IdChecker.check(command);
        if (index == -1) {return;}

        Pattern pattern;
        Matcher matcher;
        Dragon dragon = new Dragon();

        //имя
        if (!name.matches("\\s*")) {
            CollectionManager.updateName(index, name);
        }

        //координаты
        pattern = Pattern.compile("\\s*(-?\\d+\\s+-?\\d+)\\s*");
        matcher = pattern.matcher(coordinates);
        if(matcher.matches()) {
            coordinates = matcher.group(1);
            String[] coordinates1 = coordinates.split("\\s+");
            CollectionManager.updateCoordinates(index, new Coordinates(Integer.parseInt(coordinates1[0]),
                    Long.parseLong(coordinates1[1])));
        }

        //возраст
        pattern = Pattern.compile("\\s*([1-9][0-9]*)\\s*");
        matcher = pattern.matcher(age);
        if (matcher.matches()) {
            age = matcher.group(1);
            CollectionManager.updateAge(index, Integer.parseInt(age));
        }
        //цвет
        pattern = Pattern.compile("\\s*([123])\\s*");
        matcher = pattern.matcher(color);
        if (matcher.matches()) {
            color = matcher.group(1);
            switch (color) {
                case "1" -> CollectionManager.updateColor(index, Color.BLACK);
                case "2" -> CollectionManager.updateColor(index, Color.BLUE);
                case "3" -> CollectionManager.updateColor(index, Color.YELLOW);
            }
        }
        //тип
        pattern = Pattern.compile("\\s*([1-4])\\s*");
        matcher = pattern.matcher(color);
        if (matcher.matches()) {
            type = matcher.group(1);
            switch (type) {
                case "1" -> CollectionManager.updateType(index, DragonType.WATER);
                case "2" -> CollectionManager.updateType(index, DragonType.UNDERGROUND);
                case "3" -> CollectionManager.updateType(index, DragonType.AIR);
                case "4" -> CollectionManager.updateType(index, DragonType.FIRE);
            }
        }
        //характер
        pattern = Pattern.compile("\\s*([123])\\s*");
        matcher = pattern.matcher(color);
        if(matcher.matches()) {
            character = matcher.group(1);
            switch (character) {
                case "1" -> CollectionManager.updateCharacter(index, DragonCharacter.CUNNING);
                case "2" -> CollectionManager.updateCharacter(index, DragonCharacter.EVIL);
                case "3" -> CollectionManager.updateCharacter(index, DragonCharacter.CHAOTIC);
            }
        }
        //пещера
        pattern = Pattern.compile("\\s*(-?\\d+\\.\\d+)\\s*");
        matcher = pattern.matcher(cave);
        if(matcher.matches()) {
            cave = matcher.group(1);
            CollectionManager.updateCave(index, new DragonCave(Double.parseDouble(cave)));
        }
    }
}
