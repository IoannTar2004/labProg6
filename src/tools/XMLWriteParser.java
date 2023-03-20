package src.tools;

import src.collectionManager.CollectionManager;
import src.collections.*;

public class XMLWriteParser {
    /**
     * It forms xml strings reading collection of {@link Dragon dragons}.
     * @return The finished xml String.
     */
    public static String parse() {
        /*String data = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";

        data = data + "<root>\n";
        for (int i = 0; i < CollectionManager.length(); i++) {
            Dragon dragon = CollectionManager.getDragonByIndex(i);
            data = data + "\t<object id = " + "\"" + CollectionManager.getId(dragon) + "\">\n";

            data = data + "\t\t<name>" + CollectionManager.getName(dragon) + "</name>\n";
            data = data + "\t\t<coordinates>" + CollectionManager.getCoordinates(dragon) + "</coordinates>\n";
            data = data + "\t\t<age>" + CollectionManager.getAge(dragon) + "</age>\n";
            data = data + "\t\t<color>" + CollectionManager.getColor(dragon) + "</color>\n";
            data = data + "\t\t<type>" + CollectionManager.getType(dragon) + "</type>\n";
            data = data + "\t\t<character>" + CollectionManager.getCharacter(dragon) + "</character>\n";
            data = data + "\t\t<cavedepth>" + CollectionManager.getCave(dragon) + "</cavedepth>\n";

            data = data + "\t</object>\n";
        }
        data = data + "</root>";
*/
        return null;
    }
}
