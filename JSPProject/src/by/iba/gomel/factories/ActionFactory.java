package by.iba.gomel.factories;

import by.iba.gomel.Constants;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.commands.EmptyCommand;
import by.iba.gomel.enumerations.CommandEnum;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.managers.MessageManager;

public class ActionFactory {

    public ActionFactory() {
        System.err.println("Constructor");
    }

    public IActionCommand defineCommand(final SessionRequest request) {
        System.err.println("HERE");
        IActionCommand current = new EmptyCommand();
        final String action = request.extractCommand();
        System.err.println("\nAction command" + action);
        if ((action == null) || action.isEmpty()) {
            return current;
        }
        // To get object according to command.
        try {
            final CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCommand();
        } catch (final IllegalArgumentException e) {
            request.insertAttribute(Constants.PARAMETER_WRONG_ACTION,
                    action + MessageManager.getProperty(Constants.MESSAGE_WRONG_ACTION));
        }
        return current;
    }

}
