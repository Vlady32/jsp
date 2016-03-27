package by.iba.gomel.commands;

import by.iba.gomel.Constants;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.managers.ConfigurationManager;

/**
 * This class implements interface IActionCommand and realizes method execute. This class uses if
 * client haven't sent command.
 */
public class EmptyCommand implements IActionCommand {

    @Override
    public String execute(final SessionRequest request) {
        final String page = ConfigurationManager.getProperty(Constants.PROPERTY_PATH_LOGIN_PAGE);
        return page;
    }

}
