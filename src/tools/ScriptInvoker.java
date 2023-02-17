package src.tools;

import src.commands.*;

public abstract class ScriptInvoker {
    public static void simpleinvoke(String command, String... args) {
        if (command.matches("\\s*help\\s*")) {
            CommandHelp.execute();
        } else if (command.matches("\\s*info\\s*")) {
            CommandInfo.execute();
        } else if (command.matches("\\s*show\\s*")) {
            CommandShow.execute();
        } else if (command.matches("\\s*clear\\s*")) {
            CommandClear.execute();
        } if (command.matches("\\s*add\\s*")) {
            CommandAdd.addWithScript(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
        } else if (command.matches("\\s*remove_first\\s*")) {
            CommandRemoveFirst.execute();
        } else if (command.matches("\\s*update\\s*.*")) {
            CommandUpdateId.preexecute(command, 1);
        } else if (command.matches("\\s*head\\s*")) {
            CommandHead.execute();
        } else if (command.matches("\\s*remove_by_id\\s*.*")) {
            CommandRevoveById.preexecute(command);
        } else if (command.matches("\\s*count_greater_than_age\\s*.*")) {
            CommandCountGreater.preexecute(command);
        } else if (command.matches("\\s*filter_by_cave\\s*.*")) {
            CommandFilterByCave.preexecute(command);
        } else if (command.matches("\\s*execute_script\\s*.*")) {
            CommandExecuteScript.execute(command);
        } else if (command.matches("\\s*exit\\s*")) {
            System.exit(0);
        }
    }
}
