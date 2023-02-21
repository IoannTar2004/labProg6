package src.commands;

import src.fieldSupport.Checks;
import src.fieldSupport.FileManager;
import src.tools.XMLWriteParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CommandSave {
    public static void execute(){
        Scanner scanner = new Scanner(System.in);
        File file;
        String data;

        System.out.println("Введите название переменной окружения, " +
                "куда вы хотите сохранить или нажмите 'Enter', если хотите сохранить в текущий файл.");

        do {
            data = scanner.nextLine();
            if (!data.matches("\\s*")) {
                file = Checks.fileChecker(data);
            } else {
                file = FileManager.getFile();
            }
        } while (file == null);

        try {
            String path = file.getAbsolutePath();
            PrintWriter writer = new PrintWriter(new FileWriter(path));

            writer.write(XMLWriteParser.parse());

            writer.flush();
            writer.close();

            System.out.println("Сохранено!");
        } catch (IOException ignored) {}
    }
}
