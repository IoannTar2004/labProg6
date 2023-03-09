package src.tools;

import src.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * command selection
 */

public abstract class Invoker {
    private static Map<String, Command> commands = new HashMap<>();
    static {
        commands.put("add", new AddCommand());
        commands.put("add_if_max", new AddIfMaxCommand());
        commands.put("help", new HelpCommand());
        commands.put("exit", new ExitCommand());
        commands.put("clear", new ClearCommand());
        commands.put("head", new HeadCommand());
        commands.put("info", new InfoCommand());
        commands.put("remove_first", new RemoveFirstCommand());
        commands.put("save", new SaveCommand());
        commands.put("show", new ShowCommand());

        commands.put("count_greater_than_age", new CountGreaterCommand());
        commands.put("execute_script", new ExecuteScriptCommand());
        commands.put("filter_by_cave", new FilterByCaveCommand());
        commands.put("remove_by_id", new RemoveByIdCommand());
        commands.put("update", new UpdateIdCommand());
    }

    /**
     * This method captures entered command and checks it using RegEx. It works while user enters command "exit".
     */
    public static void invoke(Command command, String[] line) {
        try {
            if (line.length == 1) {
                command.execute();
            } else if (line.length > 1) {
                command.execute(line);
            }
        } catch (NullPointerException e) {
            System.out.println("Такой команды нет!\n");
        }
    }

    public static void commandScan() {
        InfoCommand.date();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            String[] line = input.trim().split("\\s+");
            Command command = commands.get(line[0]);

            invoke(command, line);
        }
    }
}
