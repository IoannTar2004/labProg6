package src;

import org.xml.sax.SAXException;
import src.tools.*;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ProgramStart.start();
        Invoker.invoke();
    }
}

