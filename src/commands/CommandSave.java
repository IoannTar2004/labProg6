package src.commands;

import src.tools.XMLWriteParser;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CommandSave {
    public static void execute(){
        try {
            String path = "D:\\Program Files\\IntelliJ IDEA 2022.2.3\\PROJECTS\\laba5\\src\\src\\objects.xml";
            PrintWriter writer = new PrintWriter(new FileWriter(path));

            writer.write(XMLWriteParser.parse());

            writer.flush();
            writer.close();

            System.out.println("Сохранено!");
        } catch (IOException ignored) {}
    }
}
