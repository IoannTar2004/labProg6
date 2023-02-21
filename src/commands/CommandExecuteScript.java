package src.commands;

import src.fieldSupport.Checks;
import src.tools.ScriptInvoker;
import src.tools.ScriptReader;
import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandExecuteScript {
    public static void execute(String filename) {
        Pattern pattern = Pattern.compile("\\s*execute_script\\s+(\\S.*)\\s*");
        Matcher matcher = pattern.matcher(filename);


        File file = null;

        if(matcher.matches()) {
            filename = matcher.group(1);
            System.out.println(filename);
            file = Checks.fileChecker(filename);
        } else {System.out.println("Команда должна содержать путь до файла в качестве аргумента!");}

        if (file != null) {
            List<String> commands = ScriptReader.read(file);
            ScriptInvoker.invoke(commands);
        }
    }
}
