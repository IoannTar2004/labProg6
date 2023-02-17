package src.commands;

import src.collectionClasses.*;
import src.tools.IdGenerator;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandAdd {
    public static void execute() {
        Scanner scanner = new Scanner(System.in);
        Dragon dragon = new Dragon();
        Matcher matcher;
        String data;

        //имя
        System.out.println("Введите имя");
        do {
            data = scanner.nextLine();
            if (data.matches("\\s*")) {
                System.out.println("Имя не может быть пустым!");
            } else {
                dragon.setName(data);
            }
        } while(data.matches("\\s*"));

        //координаты
        System.out.println("Введите координаты (два целых числа через пробел)");
        String[] coordinates;
        Pattern pattern = Pattern.compile("\\s*(-?\\d+\\s+-?\\d+)\\s*");
        do {
            data = scanner.nextLine();
            matcher = pattern.matcher(data);
            data = matcher.matches() ? matcher.group(1) : "?";
            if(!matcher.matches()) {
                System.out.println("Введите два целых числа через пробел!");
            } else {
                coordinates = data.split("\\s+");
                dragon.setCoordinates(new Coordinates(Integer.parseInt(coordinates[0]), Long.parseLong(coordinates[1])));
            }
        } while(!matcher.matches());

        //возраст
        pattern = Pattern.compile("\\s*([1-9][0-9]*)\\s*");
        System.out.println("Введите возраст (целое положительное число)");
        do {
            data = scanner.nextLine();
            matcher = pattern.matcher(data);
            data = matcher.matches() ? matcher.group(1) : "-1";
            if (!matcher.matches()) {
                System.out.println("Введите целое положительное число!");
            } else {
                dragon.setAge(Integer.parseInt(data));
            }
        } while(!matcher.matches());

        //цвет
        System.out.println("Введите номер цвета (Чёрный - 1, Синий - 2, Жёлтый - 3)");
        pattern = Pattern.compile("\\s*([123])\\s*");
        do {
            data = scanner.nextLine();
            matcher = pattern.matcher(data);
            data = matcher.matches() ? matcher.group(1) : "0";
            switch (data) {
                case "1":
                    dragon.setColor(Color.BLACK);
                    break;
                case "2":
                    dragon.setColor(Color.BLUE);
                    break;
                case "3":
                    dragon.setColor(Color.YELLOW);
                    break;
                default:
                    System.out.println("Введите cоответствующий номер цвета (Чёрный - 1, Синий - 2, Жёлтый - 3)!");
                    break;
            }
        } while(!matcher.matches());

        //тип
        System.out.println("Введите номер типа (Водный - 1, Подземельный - 2, Воздушный - 3, Огненный - 4)");
        pattern = Pattern.compile("\\s*([1-4])\\s*");
        do {
            data = scanner.nextLine();
            matcher = pattern.matcher(data);
            data = matcher.matches() ? matcher.group(1) : "0";
            switch (data) {
                case "1":
                    dragon.setType(DragonType.WATER);
                    break;
                case "2":
                    dragon.setType(DragonType.UNDERGROUND);
                    break;
                case "3":
                    dragon.setType(DragonType.AIR);
                    break;
                case "4":
                    dragon.setType(DragonType.FIRE);
                    break;
                default:
                    System.out.println("Введите соответвующий номер типа (Водный - 1, Подземельный - 2, " +
                            "Воздушный - 3, Огненный - 4)!");
                    break;
            }
        } while(!matcher.matches());

        //характер
        System.out.println("Введите номер характера (Хитрый - 1, Злой - 2, Хаотичный - 3)");
        pattern = Pattern.compile("\\s*([123])\\s*");
        do {
            data = scanner.nextLine();
            matcher = pattern.matcher(data);
            data = matcher.matches() ? matcher.group(1) : "0";
            switch (data) {
                case "1":
                    dragon.setCharacter(DragonCharacter.CUNNING);
                    break;
                case "2":
                    dragon.setCharacter(DragonCharacter.EVIL);
                    break;
                case "3":
                    dragon.setCharacter(DragonCharacter.CHAOTIC);
                    break;
                default:
                    System.out.println("Введите соответствующий номер характера (Хитрый - 1, Злой - 2, Хаотичный - 3)!");
                    break;
            }
        } while(!matcher.matches());

        //пещера
        System.out.println("Введите дробное число через точку");
        pattern = Pattern.compile("\\s*(-?\\d+\\.\\d+)\\s*");
        do {
            data = scanner.nextLine();
            matcher = pattern.matcher(data);
            data = matcher.matches() ? matcher.group(1) : "0";
            if(!matcher.matches()) {
                System.out.println("Введите дробное число через точку!");
            } else {
                dragon.setCave(new DragonCave(Double.parseDouble(data)));
            }
        } while(!matcher.matches());

        //id
        dragon.setId(IdGenerator.generate());

        //date
        Date date = new Date();
        dragon.setCreationDate(date);

        CollectionManager.add(dragon);
        System.out.println("Объект добавлен в коллекцию!\n");
    }

    public static void executeWithScript(String name, String coordinates, String age, String color, String type, String character,
                                         String cave) {
        Pattern pattern;
        Matcher matcher;
        int count = 0;
        Dragon dragon = new Dragon();
        if (name.matches("\\s*")) {
            return;
        } else {
            dragon.setName(name);
            count++;
        }

        pattern = Pattern.compile("\\s*(-?\\d+\\s+-?\\d+)\\s*");
        matcher = pattern.matcher(coordinates);
        if(matcher.matches()) {
            coordinates = matcher.group(1);
            String[] coordinates1 = coordinates.split("\\s+");
            dragon.setCoordinates(new Coordinates(Integer.parseInt(coordinates1[0]), Long.parseLong(coordinates1[1])));
            count++;
        } else {
            return;
        }

        pattern = Pattern.compile("\\s*([1-9][0-9]*)\\s*");
        matcher = pattern.matcher(age);
        if (matcher.matches()){
            age = matcher.group(1);
            dragon.setAge(Integer.parseInt(age));
            count++;
        } else {
            return;
        }

        pattern = Pattern.compile("\\s*([123])\\s*");
        matcher = pattern.matcher(color);
        if (matcher.matches()) {
            color = matcher.group(1);
            switch (color) {
                case "1" -> dragon.setColor(Color.BLACK);
                case "2" -> dragon.setColor(Color.BLUE);
                case "3" -> dragon.setColor(Color.YELLOW);
            }
            count++;
        } else {
            return;
        }

        pattern = Pattern.compile("\\s*([1-4])\\s*");
        matcher = pattern.matcher(color);
        if (matcher.matches()) {
            type = matcher.group(1);
            switch (type) {
                case "1" -> dragon.setType(DragonType.WATER);
                case "2" -> dragon.setType(DragonType.UNDERGROUND);
                case "3" -> dragon.setType(DragonType.AIR);
                case "4" -> dragon.setType(DragonType.FIRE);
            }
            count++;
        } else {
            return;
        }

        pattern = Pattern.compile("\\s*([123])\\s*");
        matcher = pattern.matcher(color);
        if(matcher.matches()) {
            character = matcher.group(1);
            switch (character) {
                case "1" -> dragon.setCharacter(DragonCharacter.CUNNING);
                case "2" -> dragon.setCharacter(DragonCharacter.EVIL);
                case "3" -> dragon.setCharacter(DragonCharacter.CHAOTIC);
            }
            count++;
        } else {
            return;
        }

        pattern = Pattern.compile("\\s*(-?\\d+\\.\\d+)\\s*");
        matcher = pattern.matcher(cave);
        if(matcher.matches()) {
            cave = matcher.group(1);
            dragon.setCave(new DragonCave(Double.parseDouble(cave)));
            count++;
        } else {
            return;
        }

        dragon.setId(IdGenerator.generate());

        //date
        Date date = new Date();
        dragon.setCreationDate(date);
        if (count == 7) {
            CollectionManager.add(dragon);
        }
    }
}
