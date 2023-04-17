package src.support;

import org.apache.commons.lang3.SerializationUtils;
import src.client.CommandSender;
import src.client.Validation;
import src.collections.Dragon;
import src.collections.DragonFields;
import src.server.modules.ServerSender;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * class for processing inputs
 */
public class Processing {
    /**
     * Method builds argument that was separated by a space in {@link src.tools.Invoker#invoke(String, String, String...)}
     * @param arg - command
     * @return
     */
    public static String builder(String[] arg) {
        String line = arg[1];
        for (int i = 2; i < arg.length; i++) {
            line = line + " " + arg[i];
        }
        return line;
    }

    /**
     * Universal method that can run '{@link Checks Check}' methods in relation to {@link DragonFields}.
     * @param fieldName run defined method in relation to this argument
     * @param input it is what you entered
     * @return any object if you write down correctly
     */
    public Object dragonProcessing(DragonFields fieldName, String input) {
        Class<Checks> checksClass = Checks.class;
        Method method;

        Object obj;
        Checks checks = new Checks(input);
        try {
            method = checksClass.getMethod(fieldName.getField() + "Checker");
            obj = method.invoke(checks);
            if (obj != null) {
                return obj;
            }
        } catch (Exception ignored) {}
        return null;
    }

    /**
     * Adds or changes dragon's fields
     * @param dragon that you need to change
     * @param fields which field you want to change
     * @param element value of field
     * @return changed dragon
     */
    public Dragon dragonInput(Dragon dragon, DragonFields fields, Object element) {
        Class<Dragon> dragonClass = Dragon.class;
        try {
            Field field = dragonClass.getDeclaredField(fields.getField());
            field.setAccessible(true);
            field.set(dragon, element);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {}
        return dragon;
    }

    /**
     * Scan entered strings, if user enters ctrl + d the program will be stopped.
     * @return entered string
     */
    public String scanner() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextLine().trim();
        } catch (NoSuchElementException e) {
            System.exit(0);
        }
        return null;
    }

    /**
     * Method reads commands entered by user.
     */
    public void commandScan(SocketChannel channel) {
        String input;
        Processing manager = new Processing();
        do {
            input = manager.scanner();
            if (input.length() > 0) {
                Object[] arguments = new Processing().<String>exchange(channel, "user", input.split("\\s+"),
                        null);
                try {
                    Class<Validation> valid = Validation.class;
                    Method method = valid.getDeclaredMethod((String) arguments[0], SocketChannel.class, Object[].class);
                    method.invoke(new Validation(), channel, arguments);
                } catch (Exception ignored) {}
            } //TODO временный сокет
        } while (!input.equals("exit"));
    }

    public Object[] exchange(SocketChannel channel, String mode, String[] input, Object[] objects) {
        ByteBuffer buffer = ByteBuffer.allocate(100000);
        try {
            CommandSender sender = new CommandSender(mode, input, objects);
            byte[] bytes = SerializationUtils.serialize(sender);
            channel.write(ByteBuffer.wrap(bytes));

            channel.read(buffer);
            ServerSender result = SerializationUtils.deserialize(buffer.array());
            try {
                result.getResult().forEach(System.out::println);
            } catch (Exception ignored) {}

            return result.getArguments();

        } catch (Exception ignored) {}
        return null;
    }
}
