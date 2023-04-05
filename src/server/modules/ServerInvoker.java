package src.server.modules;

import src.server.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ServerInvoker {

    private static Map<String, Command> commands = new HashMap<>();
    static {
        commands.put("add", new AddCommand());
        commands.put("add_if_max", new AddIfMaxCommand());
        commands.put("help", new HelpCommand());
        commands.put("clear", new ClearCommand());
        commands.put("head", new HeadCommand());
        commands.put("info", new InfoCommand());
        commands.put("print_descending", new PrintDescendingCommand());
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
     * This method receives entered or read from script command and splits by spaces.
     * It works while command is not "exit".
     */
    public static void invoke(String mode, String input, String... args) {
        String[] line = input.trim().split("\\s+");
        Command command = commands.get(line[0]);
        try {
            command.execute(mode, line, args);
        } catch (NullPointerException e) {
            if (Objects.equals(mode, "user")) {
                System.out.println("Такой команды нет!\n");
            }
        }
    }
}
