package src.commands;

import src.support.InputManager;
import src.tools.Invoker;
import src.tools.OutputText;
import src.support.Checks;
import src.tools.ScriptReader;
import java.io.File;
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
    public void execute(String mode, String input, String... filename) {
        File file;

        try {
            String filename1 = InputManager.builder(filename);
            file = Checks.fileChecker(filename1);
        } catch (ArrayIndexOutOfBoundsException e){
            OutputText.error("NoFileArgument");
            return;
        }

        if (file != null) {
            List<String> commands = ScriptReader.read(file);
            System.out.println(commands);
            if (commands.size() > 0) {
                int i = 0;
                while(!Objects.equals(commands.get(i), "")) {
                    Invoker.invoke(commands.get(i), "script");
                    i++;
                }
            }
        }
    }
}
