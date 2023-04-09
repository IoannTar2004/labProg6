package src.server.commands;

import src.support.Checks;
import src.support.FileManager;
import src.support.InputManager;
import src.tools.OutputText;
import src.tools.XMLWriteParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Saves collection to entered xml file.
 */
public class SaveCommand implements Command {
    /**
     * Saves collection to entered xml file.
     */
    @Override
    public List<String> execute(String mode, String[] command, Object... args){
        File file;
        String data;
        InputManager inputManager = new InputManager();

        System.out.println("Введите название переменной окружения, " +
                "куда вы хотите сохранить или нажмите 'Enter', если хотите сохранить в текущий файл.");

        do {
            data = inputManager.scanner();
            if (data.length() > 0) {
                file = Checks.fileChecker(data);
            } else {
                file = FileManager.getCurrentFile();
            }
        } while (file == null);

        try {
            String path = file.getAbsolutePath();
            PrintWriter writer = new PrintWriter(new FileWriter(path));

            writer.write(XMLWriteParser.parse());
            writer.flush();
            writer.close();

            OutputText.result("Saved");
        } catch (IOException ignored) {
            OutputText.error("FileNotFound");
        }
        return List.of("");
    }
}
