package src.commands;

public interface Command {
    void execute(String mode, String[] command, String... args);
}
