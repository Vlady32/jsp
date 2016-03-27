package by.iba.gomel.commands;

import by.iba.gomel.Constants;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.logicDB.LoginLogic;
import by.iba.gomel.managers.ConfigurationManager;
import by.iba.gomel.managers.MessageManager;

/**
 * This class implements interface IActionCommand and realizes method execute. This class uses for
 * logging user in application.
 */
public class LoginCommand implements IActionCommand {

    @Override
    public String execute(final SessionRequest request) {
        String page = null;
        final String login = request.getRequest().getParameter(Constants.PARAMETER_NAME_LOGIN);
        final String password = request.getRequest()
                .getParameter(Constants.PARAMETER_NAME_PASSWORD);
        String typeUser;
        if ((typeUser = LoginLogic.checkUser(login, password)) != null) {
            request.getRequest().setAttribute(Constants.ATTRIBUTE_NAME_USER, login);
            request.setAttributesSession(Constants.ATTRIBUTE_NAME_LOGIN, login);
            request.setAttributesSession(Constants.ATTRIBUTE_NAME_TYPE, typeUser);
            page = ConfigurationManager.getProperty(Constants.PROPERTY_PATH_MAIN_PAGE);
        } else {
            request.getRequest().setAttribute(Constants.MESSAGE_ERROR_LOGIN_PASS,
                    MessageManager.getProperty(Constants.MESSAGE_LOGIN_ERROR));
            page = ConfigurationManager.getProperty(Constants.PROPERTY_PATH_LOGIN_PAGE);
        }
        return page;
    }

}
