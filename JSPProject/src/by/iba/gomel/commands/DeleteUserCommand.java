package by.iba.gomel.commands;

import by.iba.gomel.Constants;
import by.iba.gomel.SessionRequest;
import by.iba.gomel.interfaces.IActionCommand;
import by.iba.gomel.logicdb.DeleteUserLogic;
import by.iba.gomel.managers.ConfigurationManager;
import by.iba.gomel.managers.MessageManager;

/**
 * This class implements interface IActionCommand and realizes method execute. This class uses for
 * deleting user from db.
 */
public class DeleteUserCommand implements IActionCommand {

    @Override
    public String execute(final SessionRequest request) {
        if (request.isUser()) {
            return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_LOGIN_PAGE);
        }
        final String userName = request.getRequest().getParameter(Constants.PARAMETER_USER_NAME);
        if (DeleteUserLogic.deleteUser(userName)) {
            new ControlCommand().execute(request);
            request.getRequest().setAttribute(Constants.MESSAGE_SUCCESS_VIEW,
                    MessageManager.getProperty(Constants.MESSAGE_DELETING_USER_SUCCESS));
        } else {
            request.getRequest().setAttribute(Constants.MESSAGE_ERROR_VIEW,
                    MessageManager.getProperty(Constants.MESSAGE_DELETING_USER_ERROR));
        }
        return ConfigurationManager.getProperty(Constants.PROPERTY_PATH_CONTROL_PAGE);
    }

}
