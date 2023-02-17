package src.commands;

import src.tools.ScriptInvoker;
import src.tools.ScriptReader;
import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandExecuteScript {
    public static void execute(String filename) {
        Pattern pattern = Pattern.compile("\\s*execute_script\\s+\"*(.[^\"]*)\"*");
        Matcher matcher = pattern.matcher(filename);

        Pattern pattern_noargument = Pattern.compile("\\s*execute_script\\s*");
        Matcher matcher_noargument = pattern_noargument.matcher(filename);

        if(matcher_noargument.matches()) {
            System.out.println("Команда должна содержать путь до файла в качестве аргумента!");
            return;
        } else if (matcher.matches()) {
            filename = matcher.group(1);
        }
        File file = new File(filename);

        if (file.exists()) {
            List<String> commands = ScriptReader.read(file);
            int i = 0;
            while(i < commands.size()) {
                try {
                    ScriptInvoker.simpleinvoke(commands.get(i), commands.get(i + 1), commands.get(i + 2),
                            commands.get(i + 3), commands.get(i + 4),
                            commands.get(i + 5), commands.get(i + 6), commands.get(i + 7));
                } catch (IndexOutOfBoundsException ignored) {
                    ScriptInvoker.simpleinvoke(commands.get(i));
                }
                i++;
            }
        } else {
            System.out.println("Файл не найден!");
        }
    }
}
