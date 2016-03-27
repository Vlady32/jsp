package by.iba.gomel.commands;

import javax.servlet.http.HttpSession;

import by.iba.gomel.Constants;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.managers.ConfigurationManager;

/**
 * This class implements interface IActionCommand and realizes method execute. This class uses for
 * redirecting on main page.
 */
public class ForwardMainPageCommand implements IActionCommand {

    @Override
    public String execute(final SessionRequest request) {
        final HttpSession session = request.getSession();
        request.getRequest().setAttribute(Constants.ATTRIBUTE_NAME_USER,
                session.getAttribute(Constants.ATTRIBUTE_NAME_LOGIN));
        request.getRequest().setAttribute(Constants.ATTRIBUTE_NAME_TYPE,
                session.getAttribute(Constants.ATTRIBUTE_NAME_TYPE));
        final String page = ConfigurationManager.getProperty(Constants.PROPERTY_PATH_MAIN_PAGE);
        return page;
    }

}
