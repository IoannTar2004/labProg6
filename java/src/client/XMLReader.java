package src.client;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import src.client.ProgramStart;
import src.server.manager.ObjectsManager;
import src.collections.*;
import src.client.FileManager;
import src.support.IdChecker;
import src.client.Processing;
import src.support.OutputText;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class XMLReader {
    /**
     * Reads initial xml file during {@link ProgramStart#start() programm start}. Method can print mistakes pointing to the object.
     * @param xml xml file
     */
    public static List<Dragon> parse(File xml) {
        NodeList nodeList = domParse(xml);
        if (nodeList == null) {
            return new LinkedList<>();
        }

        List<Dragon> list = new LinkedList<>();
        nextObject:
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node obj = nodeList.item(i);
            Element element = (Element) obj;
            Dragon dragon = new Dragon();
            String id;
            id = readTag("id", element) != null ? readTag("id", element) : null;
            id = idParse(id, element);
            if (id == null) {
                continue;
            }

            Processing manager = new Processing();
            String input;

            for (DragonFields fields : DragonFields.values()) {
                input = readTag(fields.getField(), element);
                if (input == null) {continue nextObject;}
                input = getEnumStringByNumber(fields, input);

                Object object = manager.dragonProcessing(fields, input);
                if (object != null) {
                    dragon = manager.dragonInput(dragon, fields, object);
                } else {
                    continue nextObject;
                }
            }
            dragon.setId(Long.parseLong(id));
            dragon.setCreationDate(new Date());
            new ObjectsManager().add(dragon);
            list.add(dragon);
        }
        return list;
    }

    /**
     * Processes enum fields. Transfers enums in russian to numbers
     * @param fields field of enums
     * @param input text in xml
     * @return number in String type
     */
    private static String getEnumStringByNumber(DragonFields fields, String input) {
        switch (fields) {
            case COLOR -> {return String.valueOf(Color.getEnumColor(input).ordinal()+1);}
            case TYPE -> {return String.valueOf(DragonType.getEnumType(input).ordinal()+1);}
            case CHARACTER -> {return String.valueOf(DragonCharacter.getEnumCharacter(input).ordinal()+1);}
            default -> {return input;}
        }
    }

    /**
     * Сhecks the id for correctness
     * @param id id in xml
     * @param element org.w3c.dom.Element
     * @return id in Long type
     */
    private static String idParse(String id, Element element) {
        if (IdChecker.check(String.valueOf(id)).equals(OutputText.error("DragonDoesNotExist"))) {
            return id;
        } else if (IdChecker.check(String.valueOf(id)).equals("Existed")) {
            System.out.println("Объект с id \"" + element.getElementsByTagName("id").item(0).getTextContent()
                    + "\" уже существует");
        } else {
            System.out.println(IdChecker.check(id));
        }
        return null;
    }

    /**
     * Checks the xml file for validation
     * @param xml file
     * @return list of objects
     */
    private static NodeList domParse(File xml) {
        DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();
        if (!FileManager.isNotEmpty(xml)) {
            return null;
        }
        try {
            DocumentBuilder dbuilder = dbfact.newDocumentBuilder();
            Document document = dbuilder.parse(xml);
            return document.getElementsByTagName("object");
        } catch (SAXException | ParserConfigurationException e) {
            System.out.println("XML-файл не валиден! Проверьте теги!");
        } catch (Exception ignored) {}
        return null;
    }

    /**
     * reads tags of object
     * @param field tag
     * @param element org.w3c.dom.Element
     * @return
     */
    private static String readTag(String field, Element element) {
        String input;
        try {
            input = element.getElementsByTagName(field).item(0).getTextContent().trim();
        } catch (NullPointerException e) {
            System.out.println(OutputText.error(field + "MissingTag"));
            return null;
        }
        return input;
    }
}
