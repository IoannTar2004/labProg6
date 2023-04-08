package src.server.commands;

import src.manager.ObjectsManager;
import src.collections.Dragon;
import src.collections.DragonFields;
import src.support.InputManager;
import src.support.MaxField;
import src.tools.IdGenerator;
import src.tools.OutputText;

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
    public Object[] execute(String mode, String[] command, Object... args) {
       if (Objects.equals(mode, "script")) {
            addIfMaxWithScript((String) args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7]);
       } else if (Objects.equals(mode, "server")) {
           ObjectsManager manager = new ObjectsManager();
           manager.add((Dragon) args[0]);
           return new Object[]{OutputText.result("Added")};
       }
       else {
           return new Object[]{"","addIfMaxDragon"};
        }
       return null;
    }

    /**
     * Triggers when command is from script file. Object is not created if at least one of the argument is invalid or less than max.
     * @param field number of field whose value must be greater
     * @param args elements of dragon which written in script
     */
    public static void addIfMaxWithScript(String field, Object... args) {
        DragonFields fieldNum = DragonFields.getFieldByNumber(field);
        if (fieldNum == null || !MaxField.existence(fieldNum)) {return;}

        InputManager manager = new InputManager();
        Dragon dragon = new Dragon();
        ObjectsManager objectsManager = new ObjectsManager();

        for (DragonFields fields: DragonFields.values()) {
            Object element;
            element = manager.dragonProcessing(fields, (String) args[fields.ordinal()]);
            if (fields == fieldNum && element != null) {
                if (MaxField.max(fieldNum, element)) {
                    dragon = manager.dragonInput(dragon, fields, element);
                } else {return;}
            } else if (element == null) {return;}
            dragon = manager.dragonInput(dragon, fields, element);
        }
        dragon.setId(IdGenerator.generate());
        objectsManager.add(dragon);
    }
}
