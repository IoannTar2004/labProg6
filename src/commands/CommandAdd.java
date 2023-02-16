package src.commands;

import src.collectionClasses.*;
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
        Long id = Long.parseLong(String.valueOf(Math.round((Math.random() * Math.pow(10, 11)) + Math.pow(10, 11))));
        for (int i = 0; i < CollectionManager.length(); i++) {
            if (id == CollectionManager.getId(i)) {
                id = Long.parseLong(String.valueOf(Math.round((Math.random() * Math.pow(10, 11)) + Math.pow(10, 11))));
                i = 0;
            }
        }
        dragon.setId(id);

        //date
        Date date = new Date();
        dragon.setCreationDate(date);

        CollectionManager.add(dragon);
        System.out.println("Объект добавлен в коллекцию!\n");
    }

    public static void addscript() {

    }
}
