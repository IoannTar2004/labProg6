package src.tools;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ProgramStart {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        String data;

        System.out.println("Данная программа работает с коллекции типа ArrayDeque. " +
                "Cчитывает и записывает данные в xml файл. Вывести пример правильного xml-файла?" +
                "(y - да, n - нет)");

        do {
            data = scanner.nextLine();
            if(data.matches("\\s*y\\s*")) {
                System.out.println("<root>\n" +
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
            } else if(data.matches("\\s*n\\s*")) {break;}
            else {System.out.println("(y - да, n - нет)");}
        } while (true);

        System.out.println("Имена файлов, с которыми работает эта программа, передаются ей через переменную окружения. " +
                "Введите название переменной, значение которой содержит полный путь до xml-файла.");
        File file;
        do {
            data = scanner.nextLine();
            file = new File(data);
            if(!file.exists()) {System.out.println("Файл не наден!");}
        } while (!file.exists());
    }
}
