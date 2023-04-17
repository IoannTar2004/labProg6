package src.server.commands;

import src.server.modules.ServerSender;
import src.support.FileManager;
import src.support.Processing;
import src.tools.OutputText;
import src.tools.XMLWriteParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Saves collection to entered xml file.
 */
public class ExitCommand implements Command {
    /**
     * Saves collection to entered xml file.
     */
    @Override
    public ServerSender execute(String mode, String[] command, Object... args){
        File file = FileManager.getCurrentFile();
        Processing processing = new Processing();

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file.getAbsolutePath()));

            writer.write(XMLWriteParser.parse());
            writer.flush();
            writer.close();

            return new ServerSender(List.of(OutputText.result("Saved")), new Object[]{"exit"});
        } catch (IOException ignored) {
            return new ServerSender(List.of(OutputText.error("FileNotFound")), new Object[]{"exit"});
        }
    }
}
