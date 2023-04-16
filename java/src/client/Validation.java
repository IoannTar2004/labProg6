package src.client;

import src.collections.Dragon;
import src.collections.DragonFields;
import src.server.modules.Connection;
import src.support.Checks;
import src.support.FileManager;
import src.support.Processing;
import src.support.MaxField;
import src.tools.OutputText;
import src.tools.ScriptReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Validation {

    public void addDragon(Connection connection) {
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
        //new Processing().exchange(connection, "collection", new String[]{"add"}, args);
    }

    /**
     * Triggers when user enters command "update" to terminal
     */
    public void updateDragon(Connection connection) {
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
        //new Processing().exchange(connection, "collection", new String[]{"update"}, args);
    }

    /**
     * Triggers when user enters command "add_if_max" to terminal
     */
    public void addIfMaxDragon(Connection connection) {
        DragonFields fieldNum;
        Processing manager = new Processing();
        Object[] args = new Object[7];
        String input;

        System.out.println(OutputText.input("FieldInput"));
        do {
            input = manager.scanner();
            fieldNum = DragonFields.getFieldByNumber(input);
        } while (fieldNum == null);
        Dragon dragon = null; //manager.<Dragon>exchange(connection, "server1", new String[]{"add_if_max"}, new Object[]{fieldNum});
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
        //new Processing().exchange(connection, "server2", new String[]{"add_if_max"}, args);
    }
    /**
     * Triggers when user enters this command to terminal
     */
    public void fieldSelection(Connection connection) {
        DragonFields fieldNum;
        Processing manager = new Processing();

        System.out.println(OutputText.input("DescendingInput"));
        do {
            String input = manager.scanner();
            fieldNum = DragonFields.getFieldByNumber(input);
        } while (fieldNum == null);
        //new Processing().exchange(connection, "collection", new String[]{"print_descending"}, new Object[]{fieldNum});
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
            OutputText.startInformation("yes_no");
        } while (true);
    }

}
