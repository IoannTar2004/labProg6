package src.tools;

import src.commands.CommandHelp;
import src.commands.CommandInfo;
import src.commands.CommandShow;

import java.util.Scanner;

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
                }
            }
        }
    }
}
