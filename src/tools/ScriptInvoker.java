package src.tools;

import src.commands.*;

import java.util.Scanner;

public abstract class ScriptInvoker {
    public static void invoke(String command) {
        if (command.matches("\\s*help\\s*")) {
            CommandHelp.execute();
        } else if (command.matches("\\s*info\\s*")) {
            CommandInfo.execute();
        } else if (command.matches("\\s*show\\s*")) {
            CommandShow.execute();
        } else if (command.matches("\\s*clear\\s*")) {
            CommandClear.execute();
        } else if (command.matches("\\s*remove_first\\s*")) {
            CommandRemoveFirst.execute();
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
