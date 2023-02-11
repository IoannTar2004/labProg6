package src.commands;

import src.collectionClasses.Coordinates;
import src.collectionClasses.Dragon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CommandAdd {
    public static void execute() {
        Scanner scanner = new Scanner(System.in);
        Dragon dragon = new Dragon();
        System.out.println("Введите имя");

        String data = null;

        while(data == null || data == "") {
            data = scanner.nextLine();
            if (data == "") {
                System.out.println("Имя не может быть пустым!");
            } else {
                dragon.setName(data);
            }
        }

        System.out.println("Введите координаты (два числа через пробел)");

        String[] coordinates;
        while(!Pattern.matches("\\d+\\s+\\d+", data)) {
            data = scanner.nextLine();
            if(!Pattern.matches("\\d+\\s+\\d+", data)) {
                System.out.println("Введите два числа через пробел!");
            } else {
                coordinates = data.split("\\s+");
                dragon.setCoordinates(new Coordinates(Integer.parseInt(coordinates[0]), Long.parseLong(coordinates[1])));
            }
        }

        System.out.println("Введите возраст (целое неотрицательное число)");
        while(!Pattern.matches("\\d+", data)) {
            data = scanner.nextLine();
            if (!Pattern.matches("\\d+", data)) {
                System.out.println("Введите целое неотрицательное число!");
            } else {
                dragon.setAge(Integer.parseInt(data));
            }
        }

    }
}
