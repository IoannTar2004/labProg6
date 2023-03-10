package src.commands;

import src.support.Checks;
import src.support.FileManager;
import src.tools.OutputText;
import src.tools.XMLWriteParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Saves collection to entered xml file.
 */
public class SaveCommand implements Command {
    /**
     * Saves collection to entered xml file.
     */
    @Override
    public void execute(String mode, String... args){
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

            OutputText.result("Saved");
        } catch (IOException ignored) {}
    }
}
