package src.client;

import src.collections.Dragon;
import src.collections.DragonFields;
import src.server.modules.Connection;
import src.support.Processing;
import src.support.MaxField;
import src.tools.OutputText;


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
        new Processing().exchange(connection, "script", new String[]{"add"}, args);
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
        new Processing().exchange(connection, "collection", new String[]{"update"}, args);
    }

    /**
     * Triggers when user enters this command to terminal
     */
    public Dragon addIfMax() {
        DragonFields fieldNum;
        Processing manager = new Processing();
        Dragon dragon = new Dragon();

        OutputText.input("FieldInput");
        do {
            String input = manager.scanner();
            fieldNum = DragonFields.getFieldByNumber(input);
        } while (fieldNum == null || !MaxField.existence(fieldNum));

        nextField:
        for (DragonFields fields: DragonFields.values()) {
            Object element;
            OutputText.input(fields.getField() + "Input");
            do {
                String input = manager.scanner();
                element = manager.dragonProcessing(fields, input);
                if (fields == fieldNum && element != null) {
                    if (MaxField.max(fieldNum, element)) {
                        dragon = manager.dragonInput(dragon, fields, element);
                        continue nextField;
                    } else {element = null;}
                }
            } while (element == null);
            dragon = manager.dragonInput(dragon, fields, element);
        }
        return dragon;
    }
    /**
     * Triggers when user enters this command to terminal
     */
    public DragonFields fieldSelection() {
        DragonFields fieldNum;
        Processing manager = new Processing();

        OutputText.input("DescendingInput");
        do {
            String input = manager.scanner();
            fieldNum = DragonFields.getFieldByNumber(input);
        } while (fieldNum == null);
        return fieldNum;
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
