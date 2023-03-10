package src.commands;

public interface Command {
    void execute(String mode, String[] line, String... args);
}
