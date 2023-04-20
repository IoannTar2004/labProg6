package src.client;

import src.collections.Dragon;
import src.support.Checks;
import src.support.OutputText;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.nio.channels.UnresolvedAddressException;
import java.util.List;

public class ProgramStart {
    /**
     * This method runs at the beginning. It explains basic things of this program and requests initial xml file.
     */
    public static void start() {
        SocketChannel channel = connectionToServer();
        Validation validation = new Validation();
        Processing processing = new Processing();
        try {
            System.out.println(OutputText.startInformation("CorrectXmlFile"));
            String data;
            if (validation.yesNoInput()) {
                System.out.println(OutputText.startInformation("Example"));
            }

            System.out.println(OutputText.startInformation("EnvVar"));
            File file = null;
            do {
                data = new Processing().scanner();
                try {
                    file = new Checks(data).fileChecker();
                } catch (FileNotFoundException e) {
                    System.out.println(OutputText.error("FileNotFound"));
                }
                if (file != null) {
                    List<Dragon> list = XMLReader.parse(file);
                    processing.exchange(channel, "xml", new String[]{"add"}, new Object[]{list, file});
                }
            } while (file == null);

            System.out.println(OutputText.startInformation("ProgramReady"));
            processing.commandScan(channel);
            channel.close();

        } catch (Exception e) {e.printStackTrace();}
    }

    /**
     * Method processes input of server host and port
     * @return socket
     */
    private static SocketChannel connectionToServer() {
        Processing processing = new Processing();
        System.out.println(OutputText.startInformation("ServerInfo"));
        do {
            String host = processing.scanner();

            System.out.println(OutputText.startInformation("EnterPort"));
            do {
                try {
                    int port = Integer.parseInt(processing.scanner());
                    return SocketChannel.open(new InetSocketAddress(host, port));
                } catch (UnknownHostException | UnresolvedAddressException e) {
                    System.out.println(OutputText.serverError("UnknownHost"));
                    break;
                } catch (ConnectException | NullPointerException e) {
                    System.out.println(OutputText.serverError("CheckPort"));
                } catch (NumberFormatException e) {
                    System.out.println(OutputText.serverError("PortIsInt"));
                }
                catch (Exception ignored) {}
            } while (true);
        } while (true);
    }
}
