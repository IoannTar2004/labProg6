package src.tools;

import src.commands.*;

import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Invoker {
    public static void invoke() {
        CommandInfo.date();
        Scanner scanner = new Scanner(System.in);
        exit:
        {
            while (true) {
                String command = scanner.nextLine();
                if (command.matches("\\s*help\\s*")) {
                    CommandHelp.execute();
                } else if (command.matches("\\s*info\\s*")) {
                    CommandInfo.execute();
                } else if (command.matches("\\s*exit\\s*")) {
                    break exit;
                } else if (command.matches("\\s*show\\s*")) {
                    CommandShow.execute();
                } else if (command.matches("\\s*add\\s*")) {
                    CommandAdd.execute();
                } else if (command.matches("\\s*clear\\s*")) {
                    CommandClear.execute();
                } else if (command.matches("\\s*remove_first\\s*")) {
                    CommandRemoveFirst.execute();
                } else if (command.matches("\\s*head\\s*")) {
                    CommandHead.execute();
                } else if (command.matches("\\s*update\\s*.*")) {
                    CommandUpdateId.preexecute(command);
                } else if (command.matches("\\s*remove_by_id\\s*.*")) {
                    CommandRevoveById.preexecute(command);
                } else if (command.matches("\\s*count_greater_than_age\\s*.*")) {
                    CommandCountGreater.preexecute(command);
                } else if (command.matches("\\s*filter_by_cave\\s*.*")) {
                    CommandFilterByCave.preexecute(command);
                } else {
                    System.out.println("Такой команды нет!");
                }
            }
        }
    }
}
