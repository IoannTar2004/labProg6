package src.commands;

import src.collections.CollectionManager;
import src.collections.Dragon;
import src.collections.DragonFields;
import src.support.InputManager;
import src.support.MaxField;
import src.tools.IdGenerator;
import src.tools.OutputText;

import java.util.Date;
import java.util.Objects;

/**
 * Add object to collection if max value of one field is less than entered value.
 */
public class AddIfMaxCommand implements Command {

    /**
     * Add object to collection if max value of one field is less than entered value.
     *
     * @param mode
     * @param command
     * @param args
     */
    @Override
    public void execute(String mode, String[] command, String... args) {
       if (Objects.equals(mode, "script")) {
            executeWithScript(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7]);
        } else {addIfMax();}
    }

    /**
     * Triggers when user enters this command to terminal
     */
    public static void addIfMax() {
        DragonFields fieldNum;
        InputManager manager = new InputManager();
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
        dragon.setId(IdGenerator.generate());
        dragon.setCreationDate(new Date());
        CollectionManager.add(dragon);
        OutputText.result("Added");
    }

    /**
     * Triggers when command is from script file. Object is not created if at least one of the argument is invalid or less than max.
     * @param field number of field whose value must be greater
     * @param args elements of dragon which written in script
     */
    public static void executeWithScript(String field, String... args) {
        DragonFields fieldNum = DragonFields.getFieldByNumber(field);
        if (fieldNum == null || !MaxField.existence(fieldNum)) {return;}

        InputManager manager = new InputManager();
        Dragon dragon = new Dragon();

        for (DragonFields fields: DragonFields.values()) {
            Object element;
            element = manager.dragonProcessing(fields, args[fields.ordinal()]);
            if (fields == fieldNum && element != null) {
                if (MaxField.max(fieldNum, element)) {
                    dragon = manager.dragonInput(dragon, fields, element);
                } else {return;}
            } else if (element == null) {return;}
            dragon = manager.dragonInput(dragon, fields, element);
        }
        dragon.setId(IdGenerator.generate());
        dragon.setCreationDate(new Date());
        CollectionManager.add(dragon);
    }
}
