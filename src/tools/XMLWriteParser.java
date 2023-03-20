package src.tools;

import src.collectionManager.ObjectsGetters;
import src.collectionManager.ObjectsManager;
import src.collections.*;

public class XMLWriteParser {
    /**
     * It forms xml strings reading collection of {@link Dragon dragons}.
     * @return The finished xml String.
     */
    public static String parse() {
        ObjectsManager objectsManager = new ObjectsManager();
        ObjectsGetters getters = new ObjectsGetters();
        String data = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";

        data = data + "<root>\n";
        for (int i = 0; i < objectsManager.length(); i++) {
            Dragon dragon = getters.getDragonByIndex(i);
            data = data + "\t<object>\n";

            data = data + "\t\t<id>" + getters.getId(dragon) + "</id>\n";
            data = data + "\t\t<name>" + getters.getName(dragon) + "</name>\n";
            data = data + "\t\t<coordinates>" + getters.getCoordinates(dragon) + "</coordinates>\n";
            data = data + "\t\t<age>" + getters.getAge(dragon) + "</age>\n";
            data = data + "\t\t<color>" + getters.getColor(dragon) + "</color>\n";
            data = data + "\t\t<type>" + getters.getType(dragon) + "</type>\n";
            data = data + "\t\t<character>" + getters.getCharacter(dragon) + "</character>\n";
            data = data + "\t\t<cave>" + getters.getCave(dragon) + "</cave>\n";

            data = data + "\t</object>\n";
        }
        data = data + "</root>";
        return data;
    }
}
