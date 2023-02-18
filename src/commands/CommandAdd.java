package src.commands;

import src.collectionClasses.*;
import src.tools.IdGenerator;
import src.tools.RegexChecker;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            coordinates = RegexChecker.coordinatesCheck(data);
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
