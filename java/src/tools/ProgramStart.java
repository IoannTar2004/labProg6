package src.tools;

import src.client.Validation;
import src.collections.Dragon;
import src.server.modules.Connection;
import src.support.Checks;
import src.support.FileManager;
import src.support.Processing;

import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class ProgramStart {
    /**
     * This method runs at the beginning. It explains basic things of this program and requests initial xml file.
     */
    public static void start() throws IOException {
        Connection connection = connectionToServer();
        Validation validation = new Validation();

        System.out.println(OutputText.startInformation("CorrectXmlFile"));
        String data;
        if (validation.yesNoInput()) {
            OutputText.startInformation("Example");
        }

        System.out.println(OutputText.startInformation("EnvVar"));
        File file;
        do {
            data = new Processing().scanner();
            file = Checks.fileChecker(data);
            List<Dragon> list = XMLReader.parse(file);
            new Processing().exchange(connection, "xml", new String[]{"add"}, new Object[]{list, file});
        } while (file == null);

        System.out.println(OutputText.startInformation("ProgramReady"));
        Processing.commandScan(connection);
    }

    /**
     * Method processes input of server host and port
     * @return socket
     */
    private static Connection connectionToServer() {
        Processing processing = new Processing();
        System.out.println("Программа работает с коллекцией и вызывает команды на сервере. Введите имя хоста.");
        do {
            String host = processing.scanner();

            System.out.println("Введите номер порта");
            do {
                try {
                    int port = Integer.parseInt(processing.scanner());
                    Socket socket = new Socket(host, port);
                    socket.close();
                    return new Connection(host, port);
                } catch (NumberFormatException e) {
                    System.out.println("Порт - целое положительное число");
                } catch (UnknownHostException e) {
                    System.out.println("Неизвестный хост");
                    break;
                } catch (ConnectException e) {
                    System.out.println("Программа не смогла подключиться к серверу. Проверьте порт!");
                } catch (Exception e) {e.printStackTrace();}
            } while (true);
        } while (true);
    }
}
