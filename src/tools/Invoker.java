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

        commands.put("remove_by_id", new RemoveByIdCommand());
        commands.put("update", new UpdateIdCommand());
    }

    /**
     * This method captures entered command and checks it using RegEx. It works while user enters command "exit".
     */
    public static void invoke() {
        InfoCommand.date();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            String[] line = input.trim().split("\\s+");
            Command command = commands.get(line[0]);

            try {
                if (line.length == 1) {
                    command.execute();
                } else if (line.length > 1) {
                    command.execute(line[1]);
                }
            } catch (NullPointerException e) {
                System.out.println("Такой команды нет!\n");
            }
            /*if (input.matches("\\s*help\\s*")) {
                CommandHelp.execute();
            } else if (input.matches("\\s*exit\\s*")) {
                System.exit(0);
            } else if (input.matches("\\s*info\\s*")) {
                CommandInfo.execute();
            } else if (input.matches("\\s*show\\s*")) {
                CommandShow.execute();
            } else if (input.matches("\\s*add\\s*")) {
                CommandAdd.execute();
            } else if (input.matches("\\s*clear\\s*")) {
                CommandClear.execute();
            } else if (input.matches("\\s*remove_first\\s*")) {
                CommandRemoveFirst.execute();
            } else if (input.matches("\\s*head\\s*")) {
                CommandHead.execute();
            } else if (input.matches("\\s*update\\s*.*")) {
                CommandUpdateId.execute(input);
            } else if (input.matches("\\s*remove_by_id\\s*.*")) {
                CommandRemoveById.execute(input);
            } else if (input.matches("\\s*count_greater_than_age\\s*.*")) {
                CommandCountGreater.preexecute(input);
            } else if (input.matches("\\s*filter_by_cave\\s*.*")) {
                CommandFilterByCave.preexecute(input);
            } else if (input.matches("\\s*execute_script\\s*.*")) {
                CommandExecuteScript.execute(input);
            } else if (input.matches("\\s*save\\s*")) {
                CommandSave.execute();
            } else if (input.matches("\\s*print_descending\\s*")) {
                CommandPrintDescending.execute();
            } else if (input.matches("\\s*add_if_max\\s*")) {
                CommandAddIfMax.execute();
            }
            else {
                System.out.println("Такой команды нет!");
            }*/
        }
    }
}
