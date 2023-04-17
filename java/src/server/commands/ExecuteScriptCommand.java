package src.server.commands;

import src.client.CommandSender;
import src.server.modules.ServerInvoker;
import src.server.modules.ServerSender;
import src.support.FileManager;
import src.support.Processing;
import src.tools.OutputText;
import src.support.Checks;
import src.tools.ScriptReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * creates the list of commands received from txt file and runs.
 */
public class ExecuteScriptCommand implements Command{

    public ExecuteScriptCommand(){}

    /**
     * Creates the list of commands received from txt file and runs.
     */
    @Override
    public ServerSender execute(String mode, String[] command, Object... args) {
        if (Objects.equals(mode, "script")) {
            List<String> commands = (List<String>) args[0];
            List<String> result = new LinkedList<>();
            int i = 0;
            while (!Objects.equals(commands.get(i), null)) {
                CommandSender commandIn = new CommandSender("script", commands.get(i).split("\\s+"));//TODO
                ServerSender sender = ServerInvoker.invoke(commandIn.getMode(), commandIn.getCommand(), commandIn.getCommandString(),
                        commands.get(i + 1), commands.get(i + 2),
                        commands.get(i + 3), commands.get(i + 4),
                        commands.get(i + 5), commands.get(i + 6),
                        commands.get(i + 7), commands.get(i + 8));
                if (sender != null) {
                    result.addAll(sender.getResult());
                }
                i++;
            }
            return new ServerSender(result);
        }
        return new ServerSender(new Object[]{"scriptParse"});
    }

    public ServerSender foo(String mode, String[] command, Object... args) {
        return null;
    }
}
