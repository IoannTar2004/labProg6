package src.commands;

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
        Pattern pattern = Pattern.compile("\\s*execute_script\\s+(\\S.*)\\s*");
        Matcher matcher = pattern.matcher(filename[0]);

        File file;

        if(matcher.matches()) {
            filename[0] = matcher.group(1);
            file = Checks.fileChecker(filename[0]);
        } else {
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