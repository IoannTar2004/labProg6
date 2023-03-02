package resources;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * class to output texts from .properties files. Contains of temporary methods.
 */
public class OutputText {
    private static final Locale locale = new Locale("ru", "RU");
    private static final ResourceBundle startInfo = ResourceBundle.getBundle("resources.StartInfo", locale);
    public static void startInformation(String info) {
        System.out.println(startInfo.getString(info));
    }

    public static void error(String error) {
        switch (error) {
            case "FileNotFound" -> System.out.println("Файл не найден! Проверьте путь до файла или его права.");

            case "EmptyName" -> System.out.println("Имя не может быть пустым!");

            case "CoordinatesIncorrect" -> System.out.println("Введите два целых числа через пробел!");

            case "AgeIncorrect" -> System.out.println("Введите целое положительное число!");

            case "ColorIncorrect" -> System.out.println("Введите соответствующий номер цвета " +
                    "(Чёрный - 1, Синий - 2, Жёлтый - 3)!");

            case "TypeIncorrect" -> System.out.println("Введите соответствующий номер типа " +
                    "(Водный - 1, Подземельный - 2, Воздушный - 3, Огненный - 4)!");

            case "CharacterIncorrect" -> System.out.println("Введите соответствующий номер характера " +
                    "(Хитрый - 1, Злой - 2, Хаотичный - 3)!");

            case "CaveIncorrect" -> System.out.println("Введите дробное число через точку!");

            case "IdIncorrect1" -> System.out.println("id должен содержать 12 цифр!");
            case "IdIncorrect2" -> System.out.println("id должен быть положительным!");
            case "IdIncorrect3" -> System.out.println("id должен содержать 12 цифр и быть положительным!");
            case "IdIncorrect4" -> System.out.println("id должен быть целым положительным числом");
            case "IdIncorrect5" -> System.out.println("id должен содержать 12 цифр в десятичной сс!");

            case "DragonDoesNotExist" -> System.out.println("Объекта с таким id не существует!");
            case "NoArgument" -> System.out.println("Команда должна содержать аргумент в виде id!");
            case "NoFileArgument" -> System.out.println("Команда должна содержать путь до файла в качестве аргумента!");
        }
    }

    public static void input(String input) {
        switch (input) {
            case "NameInput" -> System.out.println("Введите имя");
            case "CoordinatesInput" -> System.out.println("Введите координаты (два целых числа через пробел)");
            case "AgeInput" -> System.out.println("Введите возраст (целое положительное число)");
            case "ColorInput" -> System.out.println("Введите номер цвета (Чёрный - 1, Синий - 2, Жёлтый - 3)");
            case "TypeInput" -> System.out.println("Введите номер типа (Водный - 1, Подземельный - 2, Воздушный - 3, Огненный - 4)");
            case "CharacterInput" -> System.out.println("Введите номер характера (Хитрый - 1, Злой - 2, Хаотичный - 3)");
            case "CaveInput" -> System.out.println("Введите дробное число через точку");

            case "FieldInput" -> System.out.println("\t\tВведите номер поля, по которому будет производиться проверка\n" +
                    "1 - имя\n" +
                    "2 - координаты\n" +
                    "3 - возраст\n" +
                    "4 - цвет\n" +
                    "5 - тип\n" +
                    "6 - характер\n" +
                    "7 - глубина пещеры");

            case "newNameInput" -> System.out.println("Введите новое имя или просто нажмите 'Enter', чтобы оставить неизменным");
            case "newCoordinatesInput" -> System.out.println("Введите новые координаты (два целых числа через пробел) " +
                    "или просто нажмите 'Enter', чтобы оставить неизменным");
            case "newAgeInput" -> System.out.println("Введите новый возраст (целое положительное число) или просто " +
                    "нажмите 'Enter', чтобы оставить неизменным");
            case "newColorInput" -> System.out.println("Введите новый номер цвета (Чёрный - 1, Синий - 2, Жёлтый - 3) " +
                    "или просто нажмите 'Enter', чтобы оставить неизменным");
            case "newTypeInput" -> System.out.println("Введите новый номер типа (Водный - 1, Подземельный - 2, Воздушный - 3, " +
                    "Огненный - 4) или просто нажмите 'Enter', чтобы оставить неизменным");
            case "newCharacterInput" -> System.out.println("Введите новый номер характера (Хитрый - 1, Злой - 2, Хаотичный - 3)" +
                    " или просто нажмите 'Enter', чтобы оставить неизменным" );
            case "newCaveInput" -> System.out.println("Введите новое дробное число через точку или просто нажмите 'Enter', " +
                    "чтобы оставить неизменным");
        }
    }
}
