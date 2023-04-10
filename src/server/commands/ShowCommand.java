package src.server.commands;

import src.manager.ObjectsCollectionManager;
import src.manager.ObjectsManager;
import src.manager.ObjectsElements;
import src.server.modules.ServerSender;
import src.tools.OutputText;

import java.util.ArrayList;
import java.util.List;

/**
 * Prints all objects in collection
 */
public class ShowCommand implements Command {

    /**
     * Prints objects in collection. If arguments are absent it prints all elements.
     * It can print some fields in relation to numbers.
     */
    @Override
    public ServerSender execute(String mode, String[] command, Object... args) {
        List<String> list = new ArrayList<>();
        ObjectsManager objectsManager = new ObjectsManager();
        ObjectsElements objectsElements = new ObjectsElements();
        ObjectsCollectionManager getters = new ObjectsCollectionManager();

        if (objectsManager.length() > 0) {
            for (int i = 0; i < objectsManager.length(); i++) {
                list.add(objectsElements.element(getters.getDragonByIndex(i), command));
            }
            return new ServerSender(list);
        } else {
            return new ServerSender(List.of(OutputText.result("Empty")));
        }
    }
}
