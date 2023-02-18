package src.tools;

import src.collectionClasses.CollectionManager;
import src.collectionClasses.Color;
import src.collectionClasses.DragonCharacter;
import src.collectionClasses.DragonType;

import java.io.IOException;

public class XMLWriteParser {
    public static String parse() throws IOException {
        String data = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";

        data = data + "<root>\n";
        for (int i = 0; i < CollectionManager.length(); i++) {
            data = data + "\t<object id = " + "\"" + CollectionManager.getId(i) + "\">\n";

            data = data + "\t\t<name>" + CollectionManager.getName(i) + "</name>\n";
            data = data + "\t\t<coordinates>" + CollectionManager.getCoordinates(i) + "</coordinates>\n";
            data = data + "\t\t<age>" + CollectionManager.getAge(i) + "</age>\n";
            data = data + "\t\t<color>" + CollectionManager.getColor(i) + "</color>\n";
            data = data + "\t\t<type>" + CollectionManager.getType(i) + "</type>\n";
            data = data + "\t\t<character>" + CollectionManager.getCharacter(i) + "</character>\n";
            data = data + "\t\t<cavedepth>" + CollectionManager.getCave(i) + "</cavedepth>\n";

            data = data + "\t</object>\n";
        }
        data = data + "</root>";

        return data;
    }
}
