package by.iba.gomel.factories;

import by.iba.gomel.Constants;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.commands.EmptyCommand;
import by.iba.gomel.enumerations.CommandEnum;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.managers.MessageManager;

/**
 * This class contains method defineCommand that gets object according to command.
 */
public class ActionFactory {

    public IActionCommand defineCommand(final SessionRequest request) {
        IActionCommand current = new EmptyCommand();
        final String action = request.extractCommand();
        if ((action == null) || action.isEmpty()) {
            return current;
        }
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
