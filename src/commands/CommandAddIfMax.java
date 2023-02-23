package src.commands;

import src.collectionClasses.*;
import src.support.MaxField;
import src.support.Checks;
import src.tools.IdGenerator;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Add object to collection if max value of one field is less than entered value.
 */
public class CommandAddIfMax {

    /**
     * Triggers when user enters this command to terminal
     */
    public static void execute() {
        Scanner scanner = new Scanner(System.in);
        Matcher matcher;
        String data;
        boolean checkField;

        System.out.println("\t\tВведите номер поля, по которому будет производиться проверка\n" +
                "1 - имя\n" +
                "2 - координаты\n" +
                "3 - возраст\n" +
                "4 - цвет\n" +
                "5 - тип\n" +
                "6 - характер\n" +
                "7 - глубина пещеры");
        Pattern pattern = Pattern.compile("\\s*([1-7])\\s*");
        String field;
        do {
            field = scanner.nextLine();
            matcher = pattern.matcher(field);
            checkField = true;

            if(matcher.matches()) {
                field = matcher.group(1);
                MaxField.max(field);
            } else {
                System.out.println("Введите число от 1 до 7!");
                checkField = false;
            }

            if(field.equals("4") && MaxField.maxColor() == 3) {
                System.out.println("В коллекции уже существует объект с максимальным по значению цветом. " +
                        "Объект не будет создан. Введите другое число!");
                checkField = false;
            } else if(field.equals("5") && MaxField.maxType() == 4) {
                System.out.println("В коллекции уже существует объект с максимальным по значению типом. " +
                        "Объект не будет создан. Введите другое число!");
                checkField = false;
            } else if(field.equals("6") && MaxField.maxCharacter() == 3) {
                System.out.println("В коллекции уже существует объект с максимальным по значению характером. " +
                        "Объект не будет создан. Введите другое число!");
                checkField = false;
            }
        } while (!checkField);

        //имя
        System.out.println("Введите имя");
        String name, maxName;
        do {
            data = scanner.nextLine();
            name = Checks.nameCheck(data);
            maxName = MaxField.maxName();
            checkField = true;

            if (name == null) {
                System.out.println("Имя не может быть пустым!");
            } else if (name.compareTo(maxName) < 0 && field.equals("1")) {
                System.out.println("Введенное имя меньше по значению, чем имя \"" + maxName + "\". Объект не будет создан. " +
                        "Введите имя повторно.");
                checkField = false;
            } else if (name.compareTo(maxName) == 0 && field.equals("1")) {
                System.out.println("Введенное имя cовпадает по значению с именем \"" + maxName + "\". Объект не будет создан. " +
                        "Введите имя повторно.");
                checkField = false;
            }
        } while(name == null || !checkField);

        //координаты
        System.out.println("Введите координаты (два целых числа через пробел)");
        Coordinates coordinates;
        Long sumMax;
        do {
            data = scanner.nextLine();
            coordinates = Checks.coordinatesChecker(data);
            sumMax = MaxField.maxSumCoordinates();
            checkField = true;

            if (coordinates == null) {
                System.out.println("Введите два целых числа через пробел!");
            } else if (coordinates.sum().compareTo(sumMax) < 0 && field.equals("2")) {
                System.out.println("Сумма введенных координаты меньше, чем сумма \"" + MaxField.maxCoordinates() + "\". " +
                        "Объект не будет создан. Введите координаты повторно.");
                checkField = false;
            } else if (coordinates.sum().compareTo(sumMax) == 0 && field.equals("2")) {
                System.out.println("Сумма введенных координаты равна сумме [" + MaxField.maxCoordinates() + "]. " +
                        "Объект не будет создан. Введите координаты повторно.");
                checkField = false;
            }
        } while(coordinates == null || !checkField);

        //возраст
        System.out.println("Введите возраст (целое положительное число)");
        int age, maxAge;
        do {
            data = scanner.nextLine();
            age = Checks.ageChecker(data);
            maxAge = MaxField.maxAge();
            checkField = true;

            if (age == -1) {
                System.out.println("Введите целое положительное число!");
            } else if (age < maxAge && field.equals("3")) {
                System.out.println("Введенный возраст меньше " + maxAge +
                        ". Объект не будет создан. Введите возраст повторно.");
                checkField = false;
            } else if (age == maxAge && field.equals("3")) {
                System.out.println("Введенный возраст равен " + maxAge +
                        ". Объект не будет создан. Введите возраст повторно.");
                checkField = false;
            }
        } while(age == -1 || !checkField);

        //цвет
        System.out.println("Введите номер цвета (Чёрный - 1, Синий - 2, Жёлтый - 3)");
        Color color;
        int maxColor;
        do {
            data = scanner.nextLine();
            color = Color.getColorByNumber(data);
            maxColor = MaxField.maxColor();
            checkField = true;

            if (color == null) {
                System.out.println("Введите cоответствующий номер цвета (Чёрный - 1, Синий - 2, Жёлтый - 3)!");
            } else if (color.ordinal()+1 < maxColor && field.equals("4")) {
                System.out.println("Введенный номер цвета по индексу меньше цвета \"" +
                        Color.getColorByNumber(String.valueOf(maxColor)).getColor() + "\". Объект не будет создан. " +
                        "Введите номер цвета повторно.");
                checkField = false;
            } else if (color.ordinal()+1 == maxColor && field.equals("4")) {
                System.out.println("Введенный номер цвета по индексу равен цвету \"" +
                        Color.getColorByNumber(String.valueOf(maxColor)).getColor() + "\". Объект не будет создан. " +
                        "Введите номер цвета повторно.");
                checkField = false;
            }
        } while(color == null || !checkField);

        //тип
        System.out.println("Введите номер типа (Водный - 1, Подземельный - 2, Воздушный - 3, Огненный - 4)");
        DragonType type;
        int maxType;
        do {
            data = scanner.nextLine();
            type = DragonType.getTypeByNumber(data);
            maxType = MaxField.maxType();
            checkField = true;

            if (type == null) {
                System.out.println("Введите соответвующий номер типа (Водный - 1, Подземельный - 2, " +
                        "Воздушный - 3, Огненный - 4)!");
            } else if (type.ordinal()+1 < maxType && field.equals("5")) {
                System.out.println("Введенный номер типа по индексу меньше типа \"" +
                        DragonType.getTypeByNumber(String.valueOf(maxType)).getType() + "\". Объект не будет создан. " +
                        "Введите номер цвета повторно.");
                checkField = false;
            } else if (type.ordinal()+1 == maxType && field.equals("5")) {
                System.out.println("Введенный номер типа по индексу равен типу \"" +
                        DragonType.getTypeByNumber(String.valueOf(maxType)).getType() + "\". Объект не будет создан. " +
                        "Введите номер цвета повторно.");
                checkField = false;
            }
        } while(type == null || !checkField);

        //характер
        System.out.println("Введите номер характера (Хитрый - 1, Злой - 2, Хаотичный - 3)");
        DragonCharacter character;
        int maxCharacter;
        do {
            data = scanner.nextLine();
            character = DragonCharacter.getCharacterByNumber(data);
            maxCharacter = MaxField.maxCharacter();
            checkField = true;
            if (character == null) {
                System.out.println("Введите соответствующий номер характера (Хитрый - 1, Злой - 2, Хаотичный - 3)!");
            } else if (character.ordinal()+1 < maxCharacter && field.equals("6")) {
                System.out.println("Введенный номер характера по индексу меньше характеру \"" +
                        DragonCharacter.getCharacterByNumber(String.valueOf(maxCharacter)).getCharacter() + "\". Объект не будет создан. " +
                        "Введите номер цвета повторно.");
                checkField = false;
            } else if (character.ordinal()+1 == maxCharacter && field.equals("6")) {
                System.out.println("Введенный номер характера по индексу равен характеру \"" +
                        DragonCharacter.getCharacterByNumber(String.valueOf(maxCharacter)).getCharacter() + "\". Объект не будет создан. " +
                        "Введите номер цвета повторно.");
                checkField = false;
            }
        } while(character == null || !checkField);

        //пещера
        System.out.println("Введите дробное число через точку");
        DragonCave cave;
        double maxCave;
        do {
            data = scanner.nextLine();
            cave = Checks.caveChecker(data);
            maxCave = MaxField.maxCave();
            checkField = true;
            if (cave == null) {
                System.out.println("Введите дробное число через точку!");
            } else if (cave.getDepth() < maxCave && field.equals("7")) {
                System.out.println("Введенная глубина пещеры меньше " + maxCave +
                        ". Объект не будет создан. Введите возраст повторно.");
                checkField = false;
            } else if (cave.getDepth() == maxCave && field.equals("7")) {
                System.out.println("Введенная глубина пещеры равна " + maxCave +
                        ". Объект не будет создан. Введите возраст повторно.");
                checkField = false;
            }
        } while(cave == null || !checkField);

        //id
        Long id = IdGenerator.generate();

        //date
        Date date = new Date();
        Dragon dragon = new Dragon(id, name, coordinates, age, color, type, character, cave, date);

        CollectionManager.add(dragon);
        System.out.println("Объект добавлен в коллекцию!\n");
    }

    /**
     * Triggers when command is from script file. Object is not created if at least one of the argument is invalid or less than max.
     * @param field number of field whose value must be greater
     * @param name name
     * @param coordinates two coordinates separated by a space or semicolon
     * @param age age
     * @param color ordinal+1 of color
     * @param type ordinal+1 of type
     * @param character ordinal+1 of character
     * @param cave cave depth
     */
    public static void executeWithScript(String field, String name, String coordinates,
                                         String age, String color, String type, String character,
                                         String cave) {
        int count = 0;

        Pattern pattern = Pattern.compile("\\s*([1-7])\\s*");
        Matcher matcher = pattern.matcher(field);

        if(matcher.matches()) {count++;} else {return;}

        String nameMax = MaxField.maxName();
        if (Checks.nameCheck(name) != null && !field.equals("1")) {count++;}
        else if (name.compareTo(nameMax) > 0 && field.equals("1")) {count++;}
        else {return;}

        Coordinates coordinates1 = Checks.coordinatesChecker(coordinates);
        Long sum = MaxField.maxSumCoordinates();
        if(coordinates1 != null && !field.equals("2")) {count++;}
        else if (coordinates1.sum() > sum && field.equals("2")) {count++;}
        else {return;}

        int age1 = Checks.ageChecker(age);
        int maxAge = MaxField.maxAge();
        if (age1 != -1 && !field.equals("3")){count++;}
        else if (age1 > maxAge && field.equals("3")) {count++;}
        else {return;}

        Color color1 = Color.getColorByNumber(color);
        int maxColor = MaxField.maxColor();
        if (color1 != null && !field.equals("4")){count++;}
        else if (color1.ordinal()+1 > maxColor && field.equals("4")) {count++;}
        else {return;}

        DragonType type1 = DragonType.getTypeByNumber(type);
        int maxType = MaxField.maxType();
        if (type1 != null && !field.equals("5")){count++;}
        else if (type1.ordinal()+1 > maxType && field.equals("5")) {count++;}
        else {return;}

        DragonCharacter character1 = DragonCharacter.getCharacterByNumber(character);
        int maxCharacter = MaxField.maxCharacter();
        if (character1 != null && !field.equals("6")){count++;}
        else if (character1.ordinal()+1 > maxCharacter && field.equals("6")){count++;}
        else {return;}

        DragonCave cave1 = Checks.caveChecker(cave);
        double maxCave = MaxField.maxCave();
        if (cave1 != null && !field.equals("7")){count++;}
        else if (cave1.getDepth() > maxCave && field.equals("7")) {count++;}
        else {return;}

        Long id = IdGenerator.generate();

        //дата
        Date date = new Date();

        if (count == 8) {
            Dragon dragon = new Dragon(id, name, coordinates1, age1, color1, type1, character1, cave1, date);
            CollectionManager.add(dragon);
        }
    }
}
