package src.tools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import src.collectionManager.ObjectsGetters;
import src.collectionManager.ObjectsManager;
import src.collections.*;
import src.support.Checks;
import src.support.IdChecker;
import src.support.InputManager;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class XMLReader {
    /**
     * Reads initial xml file during {@link ProgramStart#start() programm start}. Method can print mistakes pointing to the object.
     * @param xml xml file
     */
    public static void parse(File xml) {
        NodeList nodeList = domParse(xml);

        nextObject:
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node obj = nodeList.item(i);
            Element element = (Element) obj;
            String error = " - ошибка в \"object id: " + element.getElementsByTagName("id").item(0).getTextContent()
                    + "\"\n";

            Long id = idParse(element.getElementsByTagName("id").item(0).getTextContent(), element);
            if (id == -1) {
                System.out.println(error);
                continue;
            }
            Dragon dragon = new Dragon();
            ObjectsManager objectsManager = new ObjectsManager();
            InputManager manager = new InputManager();

            for (DragonFields fields : DragonFields.values()) {
                String input = element.getElementsByTagName(fields.getField()).item(0).getTextContent().trim();
                input = getEnumStringByNumber(fields, input);

                Object object = manager.dragonProcessing(fields, input);
                if (object != null) {
                    dragon = manager.dragonInput(dragon, fields, object);
                } else {
                    System.out.println(error);
                    continue nextObject;
                }
            }
            dragon.setId(id);
            dragon.setCreationDate(new Date());
            objectsManager.add(dragon);
        }

    }

    private static String getEnumStringByNumber(DragonFields fields, String input) {
        switch (fields) {
            case COLOR -> {return String.valueOf(Color.getEnumColor(input).ordinal()+1);}
            case TYPE -> {return String.valueOf(DragonType.getEnumType(input).ordinal()+1);}
            case CHARACTER -> {return String.valueOf(DragonCharacter.getEnumCharacter(input).ordinal()+1);}
            default -> {return input;}
        }
    }

    private static Long idParse(String id, Element element) {
        ObjectsGetters getters = new ObjectsGetters();
        Long id1 = IdChecker.check(element.getElementsByTagName("id").item(0).getTextContent());
        if (id1 == -1) {
            return -1L;
        } else {
            Dragon dragon = getters.getDragonById(id1);
            if (dragon != null) {
                System.out.println("Объект с id: \"" + element.getElementsByTagName("id").item(0).getTextContent()
                        + "\" уже существует");
                return -1L;
            }
        }
        return id1;
    }

    private static NodeList domParse(File xml) {
        DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            DocumentBuilder dbuilder = dbfact.newDocumentBuilder();
            document = dbuilder.parse(xml);
        } catch (SAXException | ParserConfigurationException e) {
            System.out.println("XML-файл не валиден! Проверьте теги!");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Файл куда-то пропал или были изменены его права!");
            System.exit(0);
        }
        return document.getElementsByTagName("object");
    }
}
