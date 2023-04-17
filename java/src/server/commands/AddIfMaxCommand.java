package src.server.commands;

import src.server.manager.ObjectsManager;
import src.collections.Dragon;
import src.collections.DragonFields;
import src.server.modules.ServerSender;
import src.support.MaxField;
import src.support.OutputText;

import java.util.List;
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
    public ServerSender execute(String mode, String[] command, Object... args) {
        if (Objects.equals(mode, "server1")) {
            DragonFields fields = (DragonFields) args[0];
            Dragon dragon = MaxField.max(fields);
            if (!MaxField.existence(fields, dragon)) {
                return new ServerSender(List.of(OutputText.maxValues("Max_" + fields.getField())), new Object[]{null});
            }
            return new ServerSender(new Object[]{dragon});
        } else if (Objects.equals(mode, "server2")) {
            new ObjectsManager().add(args);
            return new ServerSender(List.of(OutputText.result("Added")));
        }
        else {
           return new ServerSender(new Object[]{"addIfMaxDragon"});
        }
    }
}
