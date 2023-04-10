package src.server.commands;

import src.manager.ObjectsManager;
import src.server.modules.ServerSender;
import src.support.Checks;
import src.collections.Dragon;
import src.tools.OutputText;

import java.util.List;

/**
 * Removes object by its ID.
 */
public class RemoveByIdCommand implements Command {
    /**
     * Removes object by its ID.
     */
    @Override
    public ServerSender execute(String mode, String[] command, Object... args) {
        try {
            //TODO rewrite idChecker
            ObjectsManager objectsManager = new ObjectsManager();
            Dragon dragon = Checks.idChecker(command[1]);
            if (dragon == null) {
                return null;
            }
            objectsManager.remove(dragon);
            return new ServerSender(List.of(OutputText.result("Removed")));
        } catch (ArrayIndexOutOfBoundsException e) {
            return new ServerSender(List.of(OutputText.error("NoIdArgument")));
        }
    }
}
