package src;

import org.xml.sax.SAXException;
import src.tools.*;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        ProgramStart.start();
        //XMLReader.parse(new File("D:\\Program Files\\IntelliJ IDEA 2022.2.3\\PROJECTS\\laba5\\src\\src\\objects.xml"));
        Invoker.invoke();
    }
}

