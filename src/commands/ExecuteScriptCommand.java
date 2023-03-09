package src.commands;

import src.support.ArgumentManager;
import src.tools.OutputText;
import src.support.Checks;
import src.tools.ScriptInvoker;
import src.tools.ScriptReader;
import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * creates the list of commands received from txt file and runs {@link ScriptInvoker#invoke(List)}
 */
public class ExecuteScriptCommand implements Command{
    /**
     * Creates the list of commands received from txt file and runs {@link ScriptInvoker#invoke(List)}.
     */
    @Override
    public void execute(String... filename) {
        File file;

        try {
            String filename1 = ArgumentManager.builder(filename);
            file = Checks.fileChecker(filename1);
        } catch (ArrayIndexOutOfBoundsException e){
            OutputText.error("NoFileArgument");
            return;
        }

        if (file != null) {
            List<String> commands = ScriptReader.read(file);
            if (commands.size() > 0) {
                ScriptInvoker.invoke(commands);
            }
        }
    }
}
