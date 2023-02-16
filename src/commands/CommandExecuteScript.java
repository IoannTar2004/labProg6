package src.commands;

import src.tools.ScriptReader;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandExecuteScript {
    public static void execute(String filename) {
        Pattern pattern = Pattern.compile("\\s*execute_script\\s+\"?(.*)\"?");
        Matcher matcher = pattern.matcher(filename);

        if(matcher.matches()) {
            filename = matcher.group(1);
        }
        File file = new File(filename);

        if (file.exists()) {
            ScriptReader.read(file);
        } else {
            System.out.println("Файл не найден!");
        }
    }
}
