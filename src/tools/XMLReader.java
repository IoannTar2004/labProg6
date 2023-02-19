package src.tools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import src.checkers.RegexChecker;
import src.collectionClasses.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class XMLReader {
    public static void parse(String path) throws ParserConfigurationException, IOException, SAXException {
        boolean start = true;

        File xml = new File(path);
        DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = dbfact.newDocumentBuilder();
        Document document = null;

        try {
            document = dbuilder.parse(xml);
        } catch (SAXParseException e) {
            System.out.println("XML-файл не валиден! Проверьте теги!");
            System.exit(0);
        }
        NodeList nodeList = document.getElementsByTagName("object");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node obj = nodeList.item(i);
            Element element = (Element) obj;
            boolean create = true;
            String error = " - ошибка в \"object id: " + element.getAttribute("id") + "\"";

            Long id = RegexChecker.idChecker(element.getAttribute("id"));
            if (id == -1) {
                System.out.println(error);
                create = false;
                start = false;
            }

            String name = RegexChecker.nameCheck(element.getElementsByTagName("name").item(0).getTextContent());
            if (name == null) {
                System.out.println("Имя не может быть пустым!" + error);
                create = false;
                start = false;
            }

            Coordinates coordinates = RegexChecker.coordinatesChecker(element.getElementsByTagName("coordinates").item(0).getTextContent());
            if (coordinates == null) {
                System.out.println("Координаты должны быть записаны в виде двух чисел через пробел или точку с запятой" +
                        error);
                create = false;
                start = false;
            }

            int age = RegexChecker.ageChecker(element.getElementsByTagName("age").item(0).getTextContent());
            if (age == -1) {
                System.out.println("Возраст должен быть целым положительным числом!" + error);
                create = false;
                start = false;
            }

            Color color = Color.getEnumColor(element.getElementsByTagName("color").item(0).getTextContent());
            if (color == null) {
                System.out.println("Такого цвета нет!"+error);
                create = false;
                start = false;
            }

            DragonType type = DragonType.getEnumType(element.getElementsByTagName("type").item(0).getTextContent());
            if (type == null) {
                System.out.println("Такого типа нет!"+error);
                create = false;
                start = false;
            }

            DragonCharacter character = DragonCharacter.getEnumCharacter(element.getElementsByTagName("character").item(0).getTextContent());
            if (character == null) {
                System.out.println("Такого характера нет!"+error);
                create = false;
                start = false;
            }

            DragonCave cave = new DragonCave(Double.parseDouble(element.getElementsByTagName("cavedepth").item(0).getTextContent()));
            if (cave == null) {
                System.out.println("Глубина пещеры должна быть записана в виде дробного числа через точку!" + error);
            }

            Date date = new Date();

            if (create) {
                Dragon dragon = new Dragon(id, name, coordinates, age, color, type, character, cave, date);
                CollectionManager.add(dragon);
            }
        }
        if (!start) {
            System.exit(0);
        }
    }
}
