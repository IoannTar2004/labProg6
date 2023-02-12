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
                switch (command) {
                    case "help":
                        CommandHelp.execute();
                        break;
                    case "info":
                        CommandInfo.execute();
                        break;
                    case "exit":
                        break exit;
                    case "show":
                        CommandShow.execute();
                        break;
                    case "add":
                        CommandAdd.execute();
                        break;
                    case "clear":
                        CommandClear.execute();
                        break;
                    default:
                        if (command.matches("\\s*update\\s+.*")) {
                            CommandUpdateId.preexecute(command);
                        } else if (command.matches("\\s*remove_by_id\\s+.*")) {
                            CommandRevoveById.preexecute(command);
                        } else {
                            System.out.println("Такой команды нет!");
                        }
                }
            }
        }
    }
}
