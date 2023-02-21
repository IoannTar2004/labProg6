package src.commands;

import src.fieldSupport.Checks;
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

        do {
            data = scanner.nextLine();
            file = Checks.fileChecker(data);
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
