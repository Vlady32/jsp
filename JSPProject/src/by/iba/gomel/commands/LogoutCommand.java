package by.iba.gomel.commands;

import by.iba.gomel.Constants;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.managers.ConfigurationManager;

/**
 * This class implements interface IActionCommand and realizes method execute. This class uses for
 * output user from application.
 */
public class LogoutCommand implements IActionCommand {

    @Override
    public String execute(final SessionRequest request) {
        request.getSession().invalidate();
        return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_INDEX_PAGE);
    }

}
