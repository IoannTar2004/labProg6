package src.server.commands;

import src.support.FileManager;
import src.support.InputManager;
import src.tools.Invoker;
import src.tools.OutputText;
import src.support.Checks;
import src.tools.ScriptReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;

/**
 * creates the list of commands received from txt file and runs.
 */
public class ExecuteScriptCommand implements Command{
    /**
     * Creates the list of commands received from txt file and runs.
     */
    @Override
    public void execute(String mode, String[] command, String... filename) {
        File file;

        try {
            String filename1 = InputManager.builder(command);
            file = Checks.fileChecker(filename1);
        } catch (ArrayIndexOutOfBoundsException e){
            OutputText.error("NoFileArgument");
            return;
        }
        List<String> commands;
        if (file != null) {
            try {
                commands = ScriptReader.read(file);
                if (commands.size() > 0 && FileManager.addFileToStack(file)) {
                    int i = 0;
                    while (!Objects.equals(commands.get(i), null)) {
                        Invoker.invoke("script", commands.get(i), commands.get(i + 1), commands.get(i + 2), commands.get(i + 3),
                                commands.get(i + 4), commands.get(i + 5), commands.get(i + 6), commands.get(i + 7), commands.get(i + 8));
                        i++;
                    }
                    FileManager.removeFromStack(file);
                }
            } catch (FileNotFoundException e) {
                OutputText.error("FileNotFound");
            }

        }
    }
}
