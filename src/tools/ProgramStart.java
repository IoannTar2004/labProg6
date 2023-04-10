package src.tools;

import src.support.Checks;
import src.support.FileManager;
import src.support.Processing;

import java.io.File;

public class ProgramStart {
    /**
     * This method runs at the beginning. It explains basic things of this program and requests initial xml file.
     */
    public static void start() {
        Processing processing = new Processing();

        OutputText.startInformation("CorrectXmlFile");
        String data;
        if (processing.yesNoInput()) {
            OutputText.startInformation("Example");
        }

        OutputText.startInformation("EnvVar");
        File file;
        do {
            data = processing.scanner();
            file = Checks.fileChecker(data);
            FileManager.setCurrentFile(file);
        } while (file == null);

        OutputText.startInformation("ReadFile");
        if (processing.yesNoInput()) {
            if (FileManager.isNotEmpty(file)) {
                XMLReader.parse(file);
            }
        }

        OutputText.startInformation("ProgramReady");
    }
}
