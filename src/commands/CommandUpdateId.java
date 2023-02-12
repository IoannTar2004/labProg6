package src.commands;

import src.collectionClasses.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandUpdateId {
    public static void preexecute(String command) {
        String dragon_id;
        boolean check = false;

        Pattern pattern = Pattern.compile("\\s*update\\s+(\\d{12})\\s*");
        Matcher matcher = pattern.matcher(command);

        Pattern pattern1 = Pattern.compile("\\s*update\\s+(\\d{1,11}|\\d{13,})\\s*");
        Matcher matcher1 = pattern1.matcher(command);

        Pattern pattern2 = Pattern.compile("\\s*update\\s+(.[^0-9]*)");
        Matcher matcher2 = pattern2.matcher(command);

        Pattern pattern3 = Pattern.compile("\\s*update\\s+(-\\d{12})\\s*");
        Matcher matcher3 = pattern3.matcher(command);

        Pattern pattern4 = Pattern.compile("\\s*update\\s+(-\\d{1,11}|-\\d{13,})\\s*");
        Matcher matcher4 = pattern4.matcher(command);

        if (matcher.matches()) {
            dragon_id = matcher.group(1);
            for(int i = 0; i < CollectionManager.length(); i++) {
                if(Long.parseLong(dragon_id) == CollectionManager.getId(i)) {
                    execute(i);
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println("Объекта с таким id не существует!");
            }
        } else if (matcher1.matches()) {
            System.out.println("id должен содержать 12 цифр!");
        } else if (matcher3.matches()) {
            System.out.println("id должен быть положительным!");
        } else if (matcher2.matches()) {
            System.out.println("id должен содержать 12 цифр в десятичной сс!");
        } else if (matcher4.matches()) {
            System.out.println("id должен содержать 12 цифр и быть положительным!");
        }
    }

    private static void execute(int index) {
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
        System.out.println("Введите новые координаты (два числа через пробел) или просто нажмите 'Enter', чтобы оставить неизменным");
        String[] coordinates;
        Pattern pattern = Pattern.compile("\\s*(-?\\d+\\s+-?\\d+)\\s*");
        do {
            data = scanner.nextLine();
            matcher = pattern.matcher(data);
            if(!matcher.matches() && !data.matches("\\s*")) {
                System.out.println("Введите два числа через пробел!");
            } else if (matcher.matches()){
                data = matcher.group(1);
                coordinates = data.split("\\s+");
                CollectionManager.updateCoordinates(index, new Coordinates(Integer.parseInt(coordinates[0]),
                        Long.parseLong(coordinates[1])));
            }
        } while(!matcher.matches() && !data.matches("\\s*"));

        //возраст
        pattern = Pattern.compile("\\s*(\\d+)\\s*");
        System.out.println("Введите новый возраст (целое неотрицательное число) или просто нажмите 'Enter', чтобы оставить неизменным");
        do {
            data = scanner.nextLine();
            matcher = pattern.matcher(data);
            if (!matcher.matches() && !data.matches("\\s*")) {
                System.out.println("Введите целое неотрицательное число!");
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
        System.out.println("Введите новое дробное число вида 'число.число' или просто нажмите 'Enter', чтобы оставить неизменным");
        pattern = Pattern.compile("\\s*(-?\\d+\\.\\d+)\\s*");
        do {
            data = scanner.nextLine();
            matcher = pattern.matcher(data);
            if(!matcher.matches() && !data.matches("\\s*")) {
                System.out.println("Введите дробное число вида 'число.число'!");
            } else if (matcher.matches()){
                data = matcher.group(1);
                CollectionManager.updateCave(index, new DragonCave(Double.parseDouble(data)));
            }
        } while(!matcher.matches() && !data.matches("\\s*"));

        System.out.println("Данные объекта изменены!\n");
    }
}
