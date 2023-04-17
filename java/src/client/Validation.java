package src.client;

import src.collections.Dragon;
import src.collections.DragonFields;
import src.server.modules.ServerSender;
import src.support.Checks;
import src.support.FileManager;
import src.support.Processing;
import src.support.MaxField;
import src.tools.OutputText;
import src.tools.ScriptReader;

import java.io.File;
import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Validation {

    /**
     * Triggers when user enters command "add" to terminal
     */
    public void addDragon(SocketChannel channel, Object... data) {
        Processing manager = new Processing();
        Object[] args = new Object[7];
        for (DragonFields fields: DragonFields.values()) {
            Object element;
            System.out.println(OutputText.input(fields.getField() + "Input"));
            do {
                String input = manager.scanner();
                element = manager.dragonProcessing(fields, input);
            } while (element == null);
            args[fields.ordinal()] = element;
        }
        new Processing().exchange(channel, "collection", new String[]{"add"}, args);
    }

    /**
     * Triggers when user enters command "update" to terminal
     */
    public void updateDragon(SocketChannel channel, Object... data) {
        Processing manager = new Processing();
        Object[] args = new Object[7];
        nextField:
        for (DragonFields fields: DragonFields.values()) {
            Object element;
            System.out.println(OutputText.input(fields.getField() + "NewInput"));
            do {
                String input = manager.scanner();
                if (input.length() == 0) {
                    args[fields.ordinal()] = null;
                    continue nextField;
                }

                element = manager.dragonProcessing(fields, input);
            } while (element == null);
            args[fields.ordinal()] = element;
        }
        new Processing().exchange(channel, "collection", new String[]{"update"}, args);
    }

    /**
     * Triggers when user enters command "add_if_max" to terminal
     */
    public void addIfMaxDragon(SocketChannel channel, Object... data) {
        DragonFields fieldNum;
        Dragon dragon;
        Processing manager = new Processing();
        Object[] args = new Object[7];
        String input;

        System.out.println(OutputText.input("FieldInput"));
        do {
            input = manager.scanner();
            fieldNum = DragonFields.getFieldByNumber(input);
            dragon = (Dragon) manager.exchange(channel, "server1", new String[]{"add_if_max"}, new Object[]{fieldNum})[0];
        } while (fieldNum == null || dragon == null);

        nextField:
        for (DragonFields fields: DragonFields.values()) {
            Object element;
            System.out.println(OutputText.input(fields.getField() + "Input"));
            do {
                input = manager.scanner();
                element = manager.dragonProcessing(fields, input);
                if (fields == fieldNum && element != null) {
                    if (MaxField.compare(dragon, fields, element)) {
                        args[fields.ordinal()] = element;
                        continue nextField;
                    } else {
                        element = null;
                    }
                }
            } while (element == null);
            args[fields.ordinal()] = element;
        }
        new Processing().exchange(channel, "server2", new String[]{"add_if_max"}, args);
    }
    /**
     * Triggers when user enters command "print_descending" to terminal
     */
    public void fieldSelection(SocketChannel channel, Object... data) {
        DragonFields fieldNum;
        Processing manager = new Processing();

        System.out.println(OutputText.input("DescendingInput"));
        do {
            String input = manager.scanner();
            fieldNum = DragonFields.getFieldByNumber(input);
        } while (fieldNum == null);
        new Processing().exchange(channel, "collection", new String[]{"print_descending"}, new Object[]{fieldNum});
    }

    /**
     * Method is used for answer the closed questions
     * @return true if input is 'y' (yes), else return false if input is 'n' (no)
     */
    public boolean yesNoInput() {
        Processing manager = new Processing();
        String data;
        do {
            data = manager.scanner();
            if(data.equals("y")) {
                return true;
            } else if(data.equals("n")) {
                return false;
            }
            System.out.println(OutputText.startInformation("yes_no"));
        } while (true);
    }

    public void scriptParse(SocketChannel channel, Object... data) {
        List<String> commands;
        FileManager.addFileToStack((File) data[1]);
        commands = ScriptReader.read((File) data[1]);
        if (commands.size() > 0) {
            Object[] args = new Processing().exchange(channel, "script", new String[]{"execute_script"}, new Object[]{commands});
            if(Arrays.binarySearch(args, "exit") >= 0) {
                try {
                    channel.close();
                } catch (IOException ignored) {}
                System.exit(0);
            }
        }
        FileManager.clear();
    }
}
