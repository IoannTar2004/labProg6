package src.commands;

import src.fieldSupport.RegexChecker;
import src.tools.ScriptInvoker;
import src.tools.ScriptReader;
import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandExecuteScript {
    public static void execute(String filename) {
        File file = RegexChecker.fileChecker(filename);

        if (file != null) {
            List<String> commands = ScriptReader.read(file);
            ScriptInvoker.invoke(commands);
        }
    }
}
