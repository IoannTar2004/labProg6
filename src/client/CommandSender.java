package src.client;

import src.collections.Dragon;
import src.server.commands.*;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandSender implements Serializable {
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
    private Command command;
    private String commandString;
    private String mode;
    private Object[] objects;

    public CommandSender(String mode, String commandString, Object[] objects) {
        try {
            command = commands.get(commandString);
        } catch (NullPointerException ignored) {}
        this.commandString = commandString;
        this.mode = mode;
        this.objects = objects;
    }

    public CommandSender(String mode, String commandString) {
        try {
            command = commands.get(commandString);
        } catch (NullPointerException ignored) {}
        this.mode = mode;
        this.commandString = commandString;
    }

    public String getCommandString() {
        return commandString;
    }

    public Command getCommand() {
        return command;
    }

    public String getMode() {
        return mode;
    }

    public Object[] getObjects() {
        return objects;
    }

    public void sendToServer(Socket socket) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(this);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "CommandSender{" +
                "command=" + command +
                ", commandString='" + commandString + '\'' +
                ", mode='" + mode + '\'' +
                ", objects=" + Arrays.toString(objects) +
                '}';
    }
}
