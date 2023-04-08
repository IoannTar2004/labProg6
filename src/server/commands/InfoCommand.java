package src.server.commands;

import src.manager.ObjectsManager;
import src.support.InitializationDate;

import java.util.List;

/**
 * Prints information about collection.
 */
public class InfoCommand implements Command {
    /**
     * Prints information about collection.
     */
    @Override
    public List<String> execute(String mode, String[] command, Object... args) {
        ObjectsManager objectsManager = new ObjectsManager();
        return List.of("Тип коллекции: ArrayDeque;",
                "Дата инициализации: " + InitializationDate.getDate() + ";",
                "Количество элементов: " + objectsManager.length() + ".");
    }
}
