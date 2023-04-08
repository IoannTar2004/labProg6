package src.server.commands;

import src.manager.ObjectsManager;
import src.support.InitializationDate;
/**
 * Prints information about collection.
 */
public class InfoCommand implements Command {
    /**
     * Prints information about collection.
     */
    @Override
    public Object[] execute(String mode, String[] command, Object... args) {
        ObjectsManager objectsManager = new ObjectsManager();
        return new Object[]{"Тип коллекции: ArrayDeque;\n" +
                "Дата инициализации: " + InitializationDate.getDate() + ";\n" +
                "Количество элементов: " + objectsManager.length() + ".\n"};
    }
}
