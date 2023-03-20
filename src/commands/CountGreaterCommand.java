package src.commands;

import src.support.Checks;
import src.tools.OutputText;
import src.collections.CollectionManager;
import src.collections.Dragon;

/**
 * Count amount of objects which have greater age than entered.
 */
public class CountGreaterCommand implements Command {
    /**
     * Count amount of objects which have greater age than entered.
     */
    @Override
    public void execute(String mode, String[] command, String... args) {
        try {
            Checks checks = new Checks(command[1]);
            Integer age1 = checks.ageChecker();

            if (age1 != null) {
                int count = 0;
                for (int i = 0; i < CollectionManager.length(); i++) {
                    Dragon dragon = CollectionManager.getDragonByIndex(i);
                    if (CollectionManager.getAge(dragon) > age1) {
                        count++;
                    }
                }
                System.out.println(count);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            OutputText.error("NoAgeArgument");
        }
    }
}
