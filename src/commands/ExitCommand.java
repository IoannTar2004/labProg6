package src.commands;

public class ExitCommand implements Command {
    @Override
    public void execute(String mode, String input, String... args) {
        System.exit(0);
    }
}