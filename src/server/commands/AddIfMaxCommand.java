package src.server.commands;

import src.manager.ObjectsManager;
import src.collections.Dragon;
import src.collections.DragonFields;
import src.server.modules.ServerSender;
import src.support.Processing;
import src.support.MaxField;
import src.tools.IdGenerator;
import src.tools.OutputText;

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
            Dragon dragon = MaxField.max((DragonFields) args[0]);
            return new ServerSender(dragon);
        } else if (Objects.equals(mode, "server2")) {
            System.out.println("ld,kdm");
            new ObjectsManager().add(args);
            return new ServerSender(List.of(OutputText.result("Added")));
        }
        else {
           return new ServerSender("addIfMaxDragon");
        }
    }
}
