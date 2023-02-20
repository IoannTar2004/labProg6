package src.tools;

import src.commands.*;

import java.util.List;
import java.util.Objects;

public abstract class ScriptInvoker {
    public static void invoke(List<String> commands) {
        int i = 0;
        while(!Objects.equals(commands.get(i), "")) {
            if (commands.get(i).matches("\\s*help\\s*")) {
                CommandHelp.execute();
            } else if (commands.get(i).matches("\\s*info\\s*")) {
                CommandInfo.execute();
            } else if (commands.get(i).matches("\\s*show\\s*")) {
                CommandShow.execute();
            } else if (commands.get(i).matches("\\s*clear\\s*")) {
                CommandClear.execute();
            }else if (commands.get(i).matches("\\s*add\\s*")) {
                CommandAdd.executeWithScript(commands.get(i+1), commands.get(i+2), commands.get(i+3), commands.get(i+4),
                        commands.get(i+5), commands.get(i+6), commands.get(i+7));

            } else if (commands.get(i).matches("\\s*remove_first\\s*")) {
                CommandRemoveFirst.execute();
            } else if (commands.get(i).matches("\\s*update\\s*.*")) {
                CommandUpdateId.executeWithScript(commands.get(i), commands.get(i+1), commands.get(i+2), commands.get(i+3),
                        commands.get(i+4), commands.get(i+5), commands.get(i+6), commands.get(i+7));

            } else if (commands.get(i).matches("\\s*head\\s*")) {
                CommandHead.execute();
            } else if (commands.get(i).matches("\\s*remove_by_id\\s*.*")) {
                CommandRemoveById.execute(commands.get(i));
            } else if (commands.get(i).matches("\\s*count_greater_than_age\\s*.*")) {
                CommandCountGreater.preexecute(commands.get(i));
            } else if (commands.get(i).matches("\\s*filter_by_cave\\s*.*")) {
                CommandFilterByCave.preexecute(commands.get(i));
            } else if (commands.get(i).matches("\\s*execute_script\\s*.*")) {
                CommandExecuteScript.execute(commands.get(i));
            } else if (commands.get(i).matches("\\s*exit\\s*")) {
                System.exit(0);
            } else if (commands.get(i).matches("\\s*print_descending\\s*.*")) {
                CommandPrintDescending.executeWithScript(commands.get(i+1));
            }

            i++;
        }
    }
}
