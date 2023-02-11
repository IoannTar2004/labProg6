package src.commands;

import src.collectionClasses.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CommandAdd {
    public static void execute() {
        Scanner scanner = new Scanner(System.in);
        Dragon dragon = new Dragon();
        System.out.println("Введите имя");

        String data = null;
        //имя
        do {
            data = scanner.nextLine();
            if (data == "") {
                System.out.println("Имя не может быть пустым!");
            } else {
                dragon.setName(data);
            }
        } while(data == null || data == "");

        //координаты
        System.out.println("Введите координаты (два числа через пробел)");
        String[] coordinates;
        do {
            data = scanner.nextLine();
            if(!Pattern.matches("-?\\d+\\s+-?\\d+", data)) {
                System.out.println("Введите два числа через пробел!");
            } else {
                coordinates = data.split("\\s+");
                dragon.setCoordinates(new Coordinates(Integer.parseInt(coordinates[0]), Long.parseLong(coordinates[1])));
            }
        } while(!Pattern.matches("-?\\d+\\s+-?\\d+", data));

        //возраст
        System.out.println("Введите возраст (целое неотрицательное число)");
        do {
            data = scanner.nextLine();
            if (!Pattern.matches("\\d+", data)) {
                System.out.println("Введите целое неотрицательное число!");
            } else {
                dragon.setAge(Integer.parseInt(data));
            }
        } while(!Pattern.matches("\\d+", data));

        //цвет
        System.out.println("Введите номер цвета (Чёрный - 1, Синий - 2, Жёлтый - 3)");
        do {
            data = scanner.nextLine();
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
        } while(!Pattern.matches("[123]", data));

        //тип
        System.out.println("Введите номер типа (Водный - 1, Подземельный - 2, Воздушный - 3, Огненный - 4)");
        do {
            data = scanner.nextLine();
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
        } while(!Pattern.matches("[1-4]", data));

        //характер
        System.out.println("Введите номер характера (Хитрый - 1, Злой - 2, Хаотичный - 3)");
        do {
            data = scanner.nextLine();
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
        } while(!Pattern.matches("[123]", data));

        //пещера
        System.out.println("Введите дробное число вида 'число.число'");
        do {
            data = scanner.nextLine();
            if(!Pattern.matches("-?\\d+\\.\\d+", data)) {
                System.out.println("Введите дробное число вида 'число.число'!");
            } else {
                coordinates = data.split("\\s+");
                dragon.setCave(new DragonCave(Double.parseDouble(data)));
            }
        } while(!Pattern.matches("-?\\d+\\.\\d+", data));

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
}
