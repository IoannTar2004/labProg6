package resources;

public class OutputText {
    public static void startInformation(String info) {
        switch (info) {
            case "CorrectXmlFile" -> System.out.println("Данная программа работает с коллекции типа ArrayDeque. " +
                    "Cчитывает и записывает данные в xml файл. " +
                    "Вывести пример правильного xml-файла? (y - да, n - нет)");

            case "Example" ->  System.out.println("<root>\n" +
                    "\t<object id = \"274726478289\">\n" +
                    "\t\t<name>Ivan</name>\n" +
                    "\t\t<coordinates>55; 746</coordinates>\n" +
                    "\t\t<age>3</age>\n" +
                    "\t\t<color>Чёрный</color>\n" +
                    "\t\t<type>Воздушный</type>\n" +
                    "\t\t<character>Злой</character>\n" +
                    "\t\t<cavedepth>3.04</cavedepth>\n" +
                    "\t</object>\n" +
                    "</root>\n");

            case "EnvVar" -> System.out.println("Имена файлов, с которыми работает эта программа, " +
                    "передаются ей через переменную окружения." +
                    "Введите название переменной, значение которой содержит полный путь до xml-файла.");

            case "ReadFile" -> System.out.println("Считать данные из файла? (y - да, n - нет)");

            case "ProgramReady" -> System.out.println("\nПрограмма готова к работе. " +
                    "Введите команду help, чтобы посмотреть все команды.\n");

            case "yes_no" -> System.out.println("(y - да, n - нет)");

        }
    }

    public static void error(String error) {
        switch (error) {
            case "FileNotFound" -> System.out.println("Файл не найден! Проверьте путь до файла или его права.");

            case "EmptyName" -> System.out.println("Имя не может быть пустым!");

            case "CoordinatesIncorrect" -> System.out.println("Введите два целых числа через пробел!");

            case "AgeIncorrect" -> System.out.println("Введите целое положительное число!");

            case "ColorIncorrect" -> System.out.println("Введите cоответствующий номер цвета " +
                    "(Чёрный - 1, Синий - 2, Жёлтый - 3)!");

            case "TypeIncorrect" -> System.out.println("Введите соответвующий номер типа " +
                    "(Водный - 1, Подземельный - 2, Воздушный - 3, Огненный - 4)!");

            case "CharacterIncorrect" -> System.out.println("Введите соответствующий номер характера " +
                    "(Хитрый - 1, Злой - 2, Хаотичный - 3)!");

            case "CaveIncorrect" -> System.out.println("Введите дробное число через точку!");
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
