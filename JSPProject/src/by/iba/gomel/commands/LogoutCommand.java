package by.iba.gomel.commands;

import by.iba.gomel.Constants;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.managers.ConfigurationManager;

public class LogoutCommand implements IActionCommand {

    @Override
    public String execute(final SessionRequest request) {
        final String page = ConfigurationManager.getProperty(Constants.PROPERTY_PATH_INDEX_PAGE);
        request.getSession().invalidate();
        return page;
    }

}
