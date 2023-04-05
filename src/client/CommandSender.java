package src.client;

import src.collections.Dragon;

public class CommandSender {
    private String command;
    private Dragon dragonObject;

    public CommandSender(String command, Dragon dragonObject) {
        this.command = command;
        this.dragonObject = dragonObject;
    }

    public CommandSender(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public Dragon getDragonObject() {
        return dragonObject;
    }
}
